package com.example.retrofitwithmvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.repository.Response
import com.example.retrofitwithmvvm.viewmodels.MainViewModel
import com.example.retrofitwithmvvm.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, {
            when(it){
                is Response.Loading -> {}
                is Response.Success -> {
                    it.data?.let {
                        Toast.makeText(this@MainActivity, it.results.size.toString(), Toast.LENGTH_LONG).show()
                    }
                }
                is Response.Error -> {
                    Toast.makeText(this@MainActivity, it.errorMsg.toString(), Toast.LENGTH_LONG).show()
                }
            }

        })
    }
}