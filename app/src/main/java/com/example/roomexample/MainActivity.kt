package com.example.roomexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
/*
Lập trình ứng dụng Quản lý sinh viên với các yêu cầu sau:
+ Thiết lập sử dụng thư viện Room để quản lý sinh viên với các thông tin bao gồm MSSV, Họ tên, Ngày sinh, Quê quán
+ Sử dụng Recycler View để hiển thị danh sách sinh viên ở màn hình chính, mỗi sinh viên hiển thị MSSV, Họ tên, Email (Email SIS được tạo từ MSSV và Họ tên)
+ Sử dụng menu để chuyển đến màn hình thêm sinh viên, nhập các thông tin MSSV, Họ tên từ EditText, Ngày sinh nhập từ Date picker dialog, Quê quán nhập từ AutoCompleteTextView (dữ liệu tỉnh thành được nhập từ file text nhúng trong resource). Khi nhập xong, quay trở lại màn hình danh sách thì cần cập nhật danh sách.
+ Khi nhấn vào sinh viên thì mở màn hình hiển thị thông tin chi tiết của sinh viên, trên màn hình này có các nút cho phép cập nhật hoặc xóa sinh viên. Khi quay trở lại cũng cần cập nhật danh sách.

Yêu cầu nộp bài:
+ Link GitHub chứa mã nguồn
+ Ảnh chụp chạy thử các chức năng
+ Thời gian nộp bài: đến hết ngày 10/01/2024
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

