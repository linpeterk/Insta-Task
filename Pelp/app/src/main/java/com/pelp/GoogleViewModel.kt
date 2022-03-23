package com.pelp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GoogleViewModel: ViewModel() {


    
    
}

/*

class RSSViewModel : ViewModel() {
    var RSS by mutableStateOf(listOf</*Add Type Here*/>()) // could be val as well
        private set // No external modifications to protect from side-effects

    init {
        viewModelScope.launch { // Pre-defined Coroutine Scope
            RSS =
                RSSFetcher.fetchRSS() // You could also extract the logic into a method for on-demand initialisation
        }
    }

    fun refreshRSS() { // This is what I was talking about above. On-demand
        viewModelScope.launch { 
            RSS =
                RSSFetcher.fetchRSS()
        }
    }
}
 */