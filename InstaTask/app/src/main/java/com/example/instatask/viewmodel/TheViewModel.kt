package com.example.instatask.viewmodel

import android.R.attr.data
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.instatask.R
import com.example.instatask.model.*
import com.example.instatask.network.GetCatBody
import com.example.instatask.network.ResponseSkillType
import com.example.instatask.network.ResponseTokenSkill
import com.example.instatask.network.baseList
import com.example.instatask.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class TheViewModel(application: Application) : AndroidViewModel(application) {


    var count by mutableStateOf(0)

    var categoriesTask: List<Categories> = mutableStateListOf()

   var categoriesSkill: List<Categories> = mutableStateListOf()

   // var taskList: MutableList<JobCreator> = mutableStateListOf() // DOES NOT WORK

   // var currentDisplayedList: List<JobCreator> by mutableStateOf(jobCreators) // works

    /* THIS IS BEING DISPLAYED On THE TASKBOARD/SKILLBOARD WHEN UPDATED*/
    var currentList: List<ResponseSkillType> by mutableStateOf(listOf(ResponseSkillType()))


    /* mutable
    mutableStateOf parameters is prefered used for immutable lists, primitives, simple datatypes
     when list change it will recompose

    mutableStateListOf() is used for mutable lists or arrays, where adding will cause recomposition
    Does not count when entire list is replaced
     */
    init{
        categoriesTask = listOf(
             Categories(0,"Post Task", R.drawable.more),
            Categories(1,"Pets", R.drawable.petcategory, jobCreators1),
            Categories(2,"Garden", R.drawable.farming, jobCreators2),
            Categories(3,"Home", R.drawable.renovation, jobCreators3),
            Categories(4,"Trade", R.drawable.trading, jobCreators4),
            Categories(5,"Delivery", R.drawable.deliveryman, jobCreators5),
            Categories(6,"Labor", R.drawable.workinprogress, jobCreators),
        )

        categoriesSkill = listOf(
            Categories(0,"Post Skill", R.drawable.more),
            Categories(1,"Pets", R.drawable.petcategory),
            Categories(2,"Repair", R.drawable.housemaintenance),
            Categories(3,"Cleaning", R.drawable.cleaning),
            Categories(4,"Auto", R.drawable.technician),
            Categories(5,"Plumbing", R.drawable.workinprogress),
            Categories(6,"Gardener", R.drawable.farming),
        )

      //  loadTasks(jobCreators)
    }

    //Get the image ID given image string name
    fun getImageId(context: Context, imageName:String):Int{
        var imageID = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName())
        Log.d("Image IDV", "$imageID")

        if(imageID == 0){
            imageID = R.drawable.workinprogress
        }
        return imageID
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

    fun getTasklist(): List<ResponseSkillType>{
        return  currentList
    }

//    fun addTest(): List<JobCreator>{
//        taskList.add(JobCreator(0, "", "abc", R.drawable.ic_sea_icon))
//    }


//    fun loadTasks(list:List<JobCreator>){
//        viewModelScope.launch {
//            currentDisplayedList = list
//        }
//    }

    ////////////////API ONLY////////////////////////////////////// API ONLY /////////////////////

    private val loginRequestLiveData = MutableLiveData<Boolean>()

   // var responseList  = mutableStateListOf<ResponseTokenSkill1>()


  //  var name:ResponseTokenSkills = ResponseTokenSkills(name="Peter")

    val authService = RetrofitHelper.getAuthService()

    //callBack: AuthAPIService.()-> Response<ResponseTokenSkill1>
    var flag:Boolean by mutableStateOf(false)

    //API get category list for skill and job board, parameter int for category number
    fun getCatlist(category:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
          //      val authService = RetrofitHelper.getAuthService()
                val responseService: Response<ResponseTokenSkill>
                   when(category) {
                       0-> responseService = authService.getCat1(GetCatBody(1))
                       1-> responseService = authService.getCat1(GetCatBody(1))
                       2-> responseService = authService.getCat2(GetCatBody(2))
                       else->responseService = authService.getCat1(GetCatBody(1))
                   }
               // val responseService = authService.callBack()
                if(responseService.isSuccessful){
                    responseService.body()?.let{

                        Log.d("Logging success", "Response token $it")
                        currentList  = it.list
                    }
                } else{
                    responseService.errorBody()?.let{

                        Log.d("Logging error", "response token $it")
                        it.close()
                    }
                }
               // loginRequestLiveData.postValue(responseService.isSuccessful)

            }catch (e:Exception){
                Log.d("Network logging", "Exceptions in networking Displaying Old Data$e")
                currentList = baseList.list
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