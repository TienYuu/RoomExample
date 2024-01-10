package com.example.roomexample

import androidx.lifecycle.LiveData

class Sinh_vien_Repo (private var svDao: Sinh_vien_DAO) {
    val readAllData : LiveData<List<Sinh_vien>> = svDao.getAll()
    suspend fun addSv(sv:Sinh_vien) {
        svDao.insert(sv)
    }
}