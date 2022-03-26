package com.example.instatask.viewmodel

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.instatask.R
import com.example.instatask.model.Categories
import kotlinx.coroutines.launch


class TheViewModel(application: Application) : AndroidViewModel(application) {

    var count by mutableStateOf(0)

    var categories: List<Categories> = mutableStateListOf()

    init{
         categories = listOf(
            Categories("Pets", R.drawable.petcategory),
            Categories("Garden", R.drawable.farming),
            Categories("House", R.drawable.house),
            Categories("Deliver", R.drawable.deliveryman),
            Categories("Trade", R.drawable.trading),
            Categories("Labor", R.drawable.workinprogress),
        )
    }

    fun up(value: Int) {
        count+=value
    }

    fun getCategoriesCount(): List<Categories>{
        return  categories
    }
}

/*
    private val customerRepository:CustomerRepository=CustomerRepository(application)

    fun fetchAllCustomer():
            LiveData<List<Customer>> {
        return customerRepository.readAllCustomers
    }

    fun insertCustomer(customer:Customer){
        viewModelScope.launch{
            customerRepository.insertCustomer(customer=customer)
        }

    }

    fun deleteCustomerById(id:Int){
        viewModelScope.launch{
            customerRepository.deleteCustomerById(id)
        }

    }

    fun deleteAll() {
        viewModelScope.launch {
            customerRepository.deleteAll()
        }
    }
    */