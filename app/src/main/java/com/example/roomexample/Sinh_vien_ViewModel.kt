package com.example.roomexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Sinh_vien_ViewModel (application: Application): AndroidViewModel(application) {
    public val readData: LiveData<List<Sinh_vien>>
    public val repo: Sinh_vien_Repo
    init{
        var svDao = Sinh_vien_Database.getDatabase(application).svDao()
        repo = Sinh_vien_Repo(svDao)
        readData = repo.readAllData
    }
   fun addSv(sv:Sinh_vien) {
       viewModelScope.launch(Dispatchers.IO) {
           repo.addSv(sv)
       }
   }
}