package com.example.retrofitwithmvvm.repository

//sealed class Response(){
//    class Loading: Response()
//    class Success(val quoteList: QuoteList): Response()
//    class Error(val errorMsg: String): Response()
//}

//sealed class Response(val data: QuoteList? = null, val errorMsg: String? = null){
//    class Loading: Response()
//    class Success(quoteList: QuoteList): Response(data = quoteList)
//    class Error(errorMsg: String): Response(errorMsg = errorMsg)
//}

//generic class implementation
sealed class Response<T>(val data: T? = null, val errorMsg: String? = null){
    class Loading<T>: Response<T>()
    class Success<T>(data: T? = null): Response<T>(data = data)
    class Error<T>(errorMsg: String): Response<T>(errorMsg = errorMsg)
}