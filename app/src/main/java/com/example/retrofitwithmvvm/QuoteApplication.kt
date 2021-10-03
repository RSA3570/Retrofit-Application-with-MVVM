package com.example.retrofitwithmvvm

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.retrofitwithmvvm.api.QuoteService
import com.example.retrofitwithmvvm.api.RetrofitHelper
import com.example.retrofitwithmvvm.db.QuoteDatabase
import com.example.retrofitwithmvvm.repository.QuoteRepository
import com.example.retrofitwithmvvm.worker.QuoteWorker
import java.util.concurrent.TimeUnit

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
        setupWorker()
    }

    private fun setupWorker() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerRequest = PeriodicWorkRequest.Builder(QuoteWorker::class.java, 2, TimeUnit.MINUTES)
            .setConstraints(constraint)
            .build()
        WorkManager.getInstance(this).enqueue(workerRequest)
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, quoteDatabase, applicationContext)
    }
}