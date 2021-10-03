package com.example.retrofitwithmvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.retrofitwithmvvm.model.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quote: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes(): List<Result>
}