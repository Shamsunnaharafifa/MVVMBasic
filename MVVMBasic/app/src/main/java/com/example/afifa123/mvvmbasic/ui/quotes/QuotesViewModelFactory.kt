package com.example.afifa123.mvvmbasic.ui.quotes

class QuotesViewModelFactory(private val quoteRepository : QuoteRepository)
    : ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}