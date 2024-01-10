package com.example.roomexample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Sinh_vien_DAO {
    @Query("SELECT * FROM SV")
    fun getAll(): LiveData<List<Sinh_vien>>

    @Query("SELECT * FROM SV WHERE mssv IN (:MSSV)")
    fun loadAllByIds(MSSV: IntArray): LiveData<List<Sinh_vien>>

    @Query("SELECT * FROM SV WHERE name LIKE :Name ")
    fun findByName(Name: String): LiveData<List<Sinh_vien>>

    @Insert
    suspend fun insert(sv: Sinh_vien)

    @Delete
    fun delete(sv: Sinh_vien)
}