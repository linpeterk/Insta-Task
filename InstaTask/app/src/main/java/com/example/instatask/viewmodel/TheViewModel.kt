package com.example.instatask.viewmodel

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.instatask.R
import com.example.instatask.model.*
import kotlinx.coroutines.launch


class TheViewModel(application: Application) : AndroidViewModel(application) {


    var count by mutableStateOf(0)

    var categoriesTask: List<Categories> = mutableStateListOf()

   var categoriesSkill: List<Categories> = mutableStateListOf()

   // var taskList: MutableList<JobCreator> = mutableStateListOf() // DOES NOT WORK

    var taskList by mutableStateOf(jobCreators) // WORKS

    /* mutable
    mutableStateOf parameters is prefered used for immutable lists, primitives, simple datatypes
     when list change it will recompose

    mutableStateListOf() is used for mutable lists or arrays, where adding will cause recomposition
    Does not count when entire list is replaced
     */
    init{
        categoriesTask = listOf(
             Categories("Post Task", R.drawable.more),
            Categories("Pets", R.drawable.petcategory, jobCreators1),
            Categories("Garden", R.drawable.farming, jobCreators2),
            Categories("Home", R.drawable.renovation, jobCreators3),
            Categories("Delivery", R.drawable.deliveryman, jobCreators4),
            Categories("Trade", R.drawable.trading, jobCreators5),
            Categories("Labor", R.drawable.workinprogress, jobCreators),
        )

        categoriesSkill = listOf(
            Categories("Post Skill", R.drawable.more),
            Categories("Pets", R.drawable.petcategory, jobCreators1),
            Categories("Repair", R.drawable.housemaintenance, jobCreators2),
            Categories("Cleaning", R.drawable.cleaner, jobCreators3),
            Categories("Auto", R.drawable.technician, jobCreators4),
            Categories("Plumbing", R.drawable.workinprogress, jobCreators5),
            Categories("Gardener", R.drawable.farming, jobCreators),
        )

      //  loadTasks(jobCreators)
    }

    fun up(value: Int) {
        count+=value
    }

    fun getCategoryTask(): List<Categories>{
        return  categoriesTask
    }

    fun getCategorySkill(): List<Categories>{
        return  categoriesSkill
    }

    fun getTasklist(): List<JobCreator>{
        return  taskList
    }

//    fun addTest(): List<JobCreator>{
//        taskList.add(JobCreator(0, "", "abc", R.drawable.ic_sea_icon))
//    }


    fun loadTasks(list:List<JobCreator>){
        viewModelScope.launch {
            taskList = list
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