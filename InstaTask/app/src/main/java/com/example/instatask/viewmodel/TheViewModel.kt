package com.example.instatask.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.instatask.R
import com.example.instatask.model.*
import com.example.instatask.network.GetCatBody
import com.example.instatask.network.ResponseTokenSkill1
import com.example.instatask.network.ResponseSkillType
import com.example.instatask.network.repository.AuthAPIService
import com.example.instatask.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TheViewModel(application: Application) : AndroidViewModel(application) {


    var count by mutableStateOf(0)

    var categoriesTask: List<Categories> = mutableStateListOf()

   var categoriesSkill: List<Categories> = mutableStateListOf()

   // var taskList: MutableList<JobCreator> = mutableStateListOf() // DOES NOT WORK

    var taskList by mutableStateOf(jobCreators) // works


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
            Categories("Cleaning", R.drawable.cleaning, jobCreators3),
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

    ////////////////API ONLY////////////////////////////////////// API ONLY /////////////////////

    private val loginRequestLiveData = MutableLiveData<Boolean>()

    var responseList  = mutableStateListOf<ResponseTokenSkill1>()

    var list: List<ResponseSkillType> by mutableStateOf(listOf(ResponseSkillType()))
  //  var name:ResponseTokenSkills = ResponseTokenSkills(name="Peter")

    fun catlist(category:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.getCatBody(GetCatBody(1))



                if(responseService.isSuccessful){
                    responseService.body()?.let{

                        Log.d("Logging success", "Response token $it")
                        list  = it.list

                    }


                } else{
                    responseService.errorBody()?.let{

                        Log.d("Logging error", "response token $it")
                        it.close()
                    }

                }
               // loginRequestLiveData.postValue(responseService.isSuccessful)

            }catch (e:Exception){
                Log.d("Network logging", "Exceptions in networking $e")

            }

        }

    }

}




/* ROOM DATABASE   ROOM DATABASE    ROOM DATABASE          ROOM DATABASE
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