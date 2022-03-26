package com.example.instatask.viewmodel

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.instatask.R
import com.example.instatask.model.Categories
import com.example.instatask.ui.app.Components.JobCreator
import com.example.instatask.ui.app.Components.jobCreators
import kotlinx.coroutines.launch


class TheViewModel(application: Application) : AndroidViewModel(application) {

    var count by mutableStateOf(0)

    var categories: List<Categories> = mutableStateListOf()

    var taskList: List<JobCreator> = mutableStateListOf()

    init{
         categories = listOf(
             Categories("Post job", R.drawable.more),
            Categories("Pets", R.drawable.petcategory),
            Categories("Garden", R.drawable.farming),
            Categories("Home", R.drawable.renovation),
            Categories("Delivery", R.drawable.deliveryman),
            Categories("Trade", R.drawable.trading),
            Categories("Labor", R.drawable.workinprogress),
        )
        loadTasks()
    }

    fun up(value: Int) {
        count+=value
    }

    fun getCategory(): List<Categories>{
        return  categories
    }

    fun getFakeTasklist(): List<JobCreator>{
        return  taskList
    }

     fun loadTasks(){
        viewModelScope.launch {
            taskList = jobCreators
        }
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