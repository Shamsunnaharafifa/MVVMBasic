package com.example.afifa123.mvvmbasic.data

class FakeDatabase  private constructor(){
    //All the DOA's go here!
    var quoteDao = FakeQuoteDao()
        private set
    companion object{

        //@volatile writes this property are immediately visible to other threads
        @Volatile private var instance : FakeDatabase? = null

        //The only way to get hold the FakeDatabase
        fun getInstance() =
        //Already instantiated? - return the instance
            //Otherwise instantiated in a thread manner
            instance ?: synchronized(this) {

                instance ?: FakeDatabase().also { instance = it }
            }

}