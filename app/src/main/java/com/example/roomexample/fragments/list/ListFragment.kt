package com.example.roomexample.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexample.ListAdapter
import com.example.roomexample.R
import com.example.roomexample.Sinh_vien_ViewModel


class ListFragment : Fragment() {
  private lateinit var mSVM:Sinh_vien_ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val adapter = ListAdapter()
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerview)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        mSVM = ViewModelProvider(this).get(Sinh_vien_ViewModel::class.java)
        mSVM.readData.observe(viewLifecycleOwner, Observer {sv -> adapter.setData(sv) })
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add ->{
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }

        }
        return true;
    }
}