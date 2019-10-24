package com.example.afifa123.mvvmbasic.ui.quotes

class QuotesViewModel(private val quoteRepository : QuoteRepository)
    : ViewModel() {
    fun getQuotes() = quoteRepository.getQuote()
    fun addQuote(quote : Quote) = quoteRepository.addQuote(quote)

}