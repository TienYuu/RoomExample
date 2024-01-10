package com.example.roomexample.fragments.add

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomexample.R
import com.example.roomexample.Sinh_vien
import com.example.roomexample.Sinh_vien_ViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class AddFragment : Fragment() {
    private lateinit var mSVM : Sinh_vien_ViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        mSVM = ViewModelProvider(this).get(Sinh_vien_ViewModel::class.java)

        val save = view.findViewById<Button>(R.id.button)
        val tinhthanh = resources.getStringArray(R.array.tinhthanh)
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,tinhthanh)
        val quequan = view.findViewById<AutoCompleteTextView>(R.id.quequan)
        quequan.setAdapter(adapter)
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val ngaysinh = view.findViewById<EditText>(R.id.ngaysinh)
        val datePickerDialog = DatePickerDialog(requireContext(),
            { DatePicker, year:Int, month:Int, dayOfMonth:Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year,month,dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                ngaysinh.text = Editable.Factory.getInstance().newEditable(formattedDate)

            }, year, month, day)
        ngaysinh.setOnClickListener {
            datePickerDialog.show()
        }
        view.setOnClickListener {
            insertData()
        }
        return view;
    }
private fun insertData () {
 val name = view?.findViewById<EditText>(R.id.ten)!!.text.toString()
    val mssv = view?.findViewById<EditText>(R.id.mssv)!!.text.toString()
    val ngaysinh = view?.findViewById<EditText>(R.id.ngaysinh)!!.text.toString()
    val quequan = view?.findViewById<AutoCompleteTextView>(R.id.quequan)!!.text.toString()
    var email = (name.substring(4)+mssv.substring(6)+"@sis.hust.edu.vn").toLowerCase()
    if (inputcheck(name,mssv,ngaysinh,quequan)) {
         val sv = Sinh_vien(mssv,name,ngaysinh,quequan,email)
        mSVM.addSv(sv)
        Toast.makeText(requireContext(),"Thanh cong",Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    } else {
        Toast.makeText(requireContext(),"Nhap tat ca cac truong",Toast.LENGTH_LONG).show()
    }
}
private fun inputcheck(name:String,ngaysinh:String,quequan:String,mssv:String): Boolean{
    return !(TextUtils.isEmpty(name)) && !(TextUtils.isEmpty(mssv)) && !(TextUtils.isEmpty(quequan)) && !(TextUtils.isEmpty(ngaysinh))

}
}