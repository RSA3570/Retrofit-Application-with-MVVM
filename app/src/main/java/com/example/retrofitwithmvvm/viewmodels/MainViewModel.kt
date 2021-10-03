package com.example.retrofitwithmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithmvvm.model.QuoteList
import com.example.retrofitwithmvvm.repository.QuoteRepository
import com.example.retrofitwithmvvm.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
        }
    }

    val quotes: LiveData<Response<QuoteList>>
    get() = repository.quotes
}