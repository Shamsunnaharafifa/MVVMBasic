package com.example.afifa123.mvvmbasic.data

import kotlin.jvm.Synchronized as Synchronized1


//FakeQuoteDao must be passed in - it is a dependency
//you could also instantiate the Dao right inside the class without the fuss, right?
//No, this will break testability - you need to be able to be passed a Mock version of a Dao
//to the repository (e.g one that upon calling getQuotes() returns a dummy list of quotes for testing)
//this is the core idea behind the DEPENDENCY INJECTION -making things completely modular and independent.

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

     //This may be seem redundant
    //Imagine a code which also updates and check the backend
    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }
    fun getQuotes() = quoteDao.getQuotes()
    companion object{
        //singleton instantiation you already know and love
        @Volatile private var instance : QuoteRepository? = null
        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this){
                instance ?: QuoteRepository(quoteDao).also { instance = it }
        }



    }
    
}