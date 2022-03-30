package com.example.instatask.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.instatask.R
import com.example.instatask.database.datamodel.Task
import com.example.instatask.database.repository.TaskRepository
import com.example.instatask.model.*
import com.example.instatask.network.*
import com.example.instatask.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

// var taskList: MutableList<JobCreator> = mutableStateListOf() // DOES NOT WORK, won't update screen

// var currentDisplayedList: List<JobCreator> by mutableStateOf(jobCreators) // works

/*
    KuangCheng (Peter) Lin
    Viewmodel for view updating, API calls/retrieving , and room database
 */
class TheViewModel(application: Application) : AndroidViewModel(application) {

    var categoriesTask: List<Categories> = mutableStateListOf()

    var categoriesSkill: List<Categories> = mutableStateListOf()

    /* THIS IS BEING DISPLAYED On THE TASKBOARD/SKILLBOARD WHEN UPDATED*/
    var currentSkillList: List<ResponseSkillType> by mutableStateOf(listOf(ResponseSkillType()))

    var currentReviews: List<ResponseReviewType> by mutableStateOf(listOf(ResponseReviewType()))

      var currentTaskList : List<Task> by  mutableStateOf(listOf(Task()))

    private val TaskRepository: TaskRepository = TaskRepository(application = application)

    /* mutable
    mutableStateOf parameters is prefered used for immutable lists, primitives, simple datatypes
     when list change it will recompose

    mutableStateListOf() is used for mutable lists or arrays, where adding will cause recomposition
    Does not count when entire list is replaced
     */
    //init some categories list
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
            Categories(2,"Garden", R.drawable.farming),
            Categories(3,"Cleaning", R.drawable.cleaning_peter),
            Categories(4,"Auto", R.drawable.technician),
            Categories(5,"Plumbing", R.drawable.workinprogress),
            Categories(6,"Repair", R.drawable.repair),
        )
    fetchCategory(1)
    }

    /*

   View updating functions

     */

    //Get the image ID given image string name
    fun getImageId(context: Context, imageName:String):Int{
        var imageID = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName())
        Log.d("Image IDV", "$imageID")

        if(imageID == 0){
            imageID = R.drawable.workinprogress
        }
        return imageID
    }

    fun getCategoryTask(): List<Categories>{
        return  categoriesTask
    }

    fun getCategorySkill(): List<Categories>{
        return  categoriesSkill
    }

    fun getTasklist(): List<ResponseSkillType>{
        return  currentSkillList
    }



    /*
 API Below
 API Below ***********************************************************************************************
 API Below
  */

     val loginRequestLiveData = MutableLiveData<Boolean>() //currently not in use

   // var responseList  = mutableStateListOf<ResponseTokenSkill1>()
  //  var name:ResponseTokenSkills = ResponseTokenSkills(name="Peter")
   // loginRequestLiveData.postValue(responseService.isSuccessful)
    val authService = RetrofitHelper.getAuthService()

    //API get category list for skill and job board, parameter int for category number
    fun getCatlist(category:Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
          //      val authService = RetrofitHelper.getAuthService()
                val responseService: Response<ResponseTokenSkill>
                   when(category) {
                       0-> responseService = authService.getCat1(GetCatBody(1)) //load default, this is for post skill
                       1-> responseService = authService.getCat1(GetCatBody(1))
                       2-> responseService = authService.getCat2(GetCatBody(2))
                       3-> responseService = authService.getCat3(GetCatBody(3))
                       4-> responseService = authService.getCat4(GetCatBody(4))
                       5-> responseService = authService.getCat5(GetCatBody(5))
                       6-> responseService = authService.getCat6(GetCatBody(6))
                       else->responseService = authService.getCat1(GetCatBody(1))
                   }
                if(responseService.isSuccessful){
                    responseService.body()?.let{

                        Log.d("Logging success", "Response token $it")
                        currentSkillList  = it.list
                    }
                } else{
                    responseService.errorBody()?.let{

                        Log.d("Logging error", "response token $it")
                        it.close()
                    }
                }


            }catch (e:Exception){
                Log.d("Network logging", "Exceptions in networking Displaying Old Data$e")
                currentSkillList = baseList.list
            }
        }
    }

    fun getReviews(id:Int, review: Int){
        viewModelScope.launch (Dispatchers.IO){
            try{
                //      val authService = RetrofitHelper.getAuthService()
                val responseService: Response<ResponseTokenReview>


                    responseService = authService.getReviews(GetReviewBody(2, 2))


                if(responseService.isSuccessful){
                    responseService.body()?.let{ review ->

                        Log.d("Logging success", "Response token $review") //it is response token review
                        currentReviews  = review.list
                    }
                } else{
                    responseService.errorBody()?.let{

                        Log.d("Logging error", "response token $review")
                        it.close()
                    }
                }
                // loginRequestLiveData.postValue(responseService.isSuccessful)

            }catch (e:Exception){
                Log.d("Network logging", "Exceptions in networking Displaying Old Data$e")
                currentSkillList = baseList.list
            }
        }
    }

    /*
        API Above
        API Above  ***********************************************************************************************
        API Above
    */



    /*
    Column
    Task ID~ / Task categories~ /  Task  description ~/ Task  Name~ / Person name~ / Hour rate ~/ imageID / ADDRESS

    Row
    Each entry is a Task

    ROOM DATABASE Below
    ROOM DATABASE Below  ***********************************************************************************************
    ROOM DATABASE Below
     */
   // val taskList = fetchAllTask().observeAsState(arrayListOf())



//    fun fetchAllTask(): LiveData<List<Task>>{
//        return TaskRepository.readAllTasks
//    }





    fun insertCustomer(task: Task)
    {
        viewModelScope.launch{
            TaskRepository.insertCustomer(task=task)
        }

    }

    fun deleteTaskById(id: Int)
    {
        viewModelScope.launch{
            TaskRepository.deleteTaskById(id)
        }
    }
    fun fetchCategory(id: Int)
    {
      //  loginRequestLiveData.postValue(true)
        Log.d("Category Testing", "$id")
        viewModelScope.launch{
            currentTaskList = TaskRepository.fetchCategory(id)
        }
    }

    fun deleteALL(){
        viewModelScope.launch {

            TaskRepository.deleteAll()
        }
    }

    /*
   ROOM DATABASE Above
   ROOM DATABASE Above  ***********************************************************************************************
   ROOM DATABASE Above
    */

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