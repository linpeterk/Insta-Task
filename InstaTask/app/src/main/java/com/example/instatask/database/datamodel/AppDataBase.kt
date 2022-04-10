package com.example.instatask.database.datamodel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.instatask.database.dao.TaskData
import com.example.instatask.database.dao.UserInfoDao
import com.example.instatask.viewmodel.TheViewModel

@Database(entities = [Task::class, UserRow::class], version =4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskData
    abstract fun UserInfoDao():UserInfoDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase?=null;

        fun getDatabase(context: Context):AppDatabase{

            val tempInstance = INSTANCE
            if (tempInstance!= null)
            {
                return tempInstance
            }

            synchronized(this)
            {
                var instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "peter")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE  = instance
                return instance
            }
        }
    }
}

fun deleteDB(vModel:TheViewModel){
    vModel.deleteALL()

}

/*
Warnings do not run or modify this function
 */

fun initDatabase(vModel: TheViewModel){

      // vModel.deleteALL()

    vModel.insertTask(
        Task(
            categories = 1,
            task_name = "Dog walk",
            person_name = "Peter",
            description = "Got a  dog that needs walking",
            hourly_rate = 15,
            datetime = "4/2/2022",
            imageId = "petcategory",
            address = "67 Sanctuary, Irvine, CA 92620",
            lat = 37.4242 ,
            lng = -122.0813
        ))

    vModel.insertTask(
        Task(
            categories = 1,
            task_name = "Cat sitting",
            person_name = "Carlos",
            description = "Working overtime tonight, need someone to take care of my cats",
            hourly_rate = 20,
            datetime = "4/3/2022",
            imageId = "petcategory",
            address = "52 Fanlight, Irvine, CA 92620",
            lat = 37.4302 ,
            lng = -122.08561
        ))

    vModel.insertTask(
        Task(
            categories = 1,
            task_name = "Feeding Fish",
            person_name = "Adama",
            datetime = "4/5/2022",
            description = "Out of town for 2 weeks, looking for someone to feed my fish every day",
            hourly_rate = 20,
            imageId = "petcategory",
            address = "6222 Irvine Blvd, Irvine, CA 92620",
            lat = 37.4174 ,
            lng = -122.0919
        ))

    vModel.insertTask(
        Task(
            categories = 1,
            task_name = "Grooming pitbull",
            person_name = "Chinchu",
            datetime = "4/4/2022",
            description = "I got a nice pitbull that needs a haircut",
            hourly_rate = 35,
            imageId = "petcategory",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.4129 ,
            lng = -122.0904
        ))

    vModel.insertTask(
        Task(
            categories = 1,
            task_name = "Water plants",
            person_name = "Peter",
            description = "2 vines and advocado trees that need to be watered",
            hourly_rate = 25,
            datetime = "4/9/2022",
            imageId = "petcategory",
            address = "71 Interlude, Irvine, CA 92620",
            lat = 37.4074 ,
            lng = -122.0881
        ))

    vModel.insertTask(
        Task(
            categories = 1,
            task_name = "Dog Walking - Maltease",
            person_name = "Peter",
            description = "Looking for dog walker",
            hourly_rate = 15,
            datetime = "4/8/2022",
            imageId = "petcategory",
            address = "109 Tidal Line, Irvine, CA 92620",
            lat = 37.4067 ,
            lng = -122.0743
        ))

    ////////////////////////////////

    vModel.insertTask(
        Task(
            categories = 2,
            task_name = "Looking for Cutter",
            person_name = "Dan",
            datetime = "4/1/2022",
            description = "Large amount of vines around the fence that needs to be cut off, good tips",
            hourly_rate = 45,
            imageId = "farming",
            address = "67 Sanctuary, Irvine, CA 92620",
            lat = 37.4242 ,
            lng = -122.0813
        ))

    vModel.insertTask(
        Task(
            categories = 2,
            task_name = "Planting Trees",
            person_name = "Shady",
            datetime = "4/2/2022",
            description = "Need a helping hand on planting a dozen avocado trees.",
            hourly_rate = 20,
            imageId = "farming",
            address = "52 Fanlight, Irvine, CA 92620",
            lat = 37.4137 ,
            lng = -122.05284619973649
        ))

    vModel.insertTask(
        Task(
            categories = 2,
            task_name = "Weed Killer",
            person_name = "Joe",
            datetime = "4/4/2022",
            description = "Help me kill weeds, no chemicals",
            hourly_rate = 20,
            imageId = "farming",
            address = "6222 Irvine Blvd, Irvine, CA 92620",
            lat = 37.3591 ,
            lng = -122.0754
        ))

    vModel.insertTask(
        Task(
            categories = 2,
            task_name = "Water Service",
            person_name = "Skippy",
            datetime = "4/3/2022",
            description = "Sprinkler broke down, need long term caretaker for my garden",
            hourly_rate = 35,
            imageId = "farming",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.3796 ,
            lng = -122.0813
        ))

    vModel.insertTask(
        Task(
            categories = 2,
            task_name = "Watering plants",
            person_name = "Notbob",
            description = "2 vines and advocado trees that need to be watered",
            hourly_rate = 25,
            datetime = "4/9/2022",
            imageId = "farming",
            address = "71 Interlude, Irvine, CA 92620",
            lat =  37.4006 ,
            lng = -122.1049
        ))

    //////
    vModel.insertTask(
        Task(
            categories = 3,
            task_name = "Chimney Sweeps",
            person_name = "Happy",
            description = "Looking for a Chimney Sweeper, must have the proper equipment",
            hourly_rate = 20,
            datetime = "4/3/2022",
            imageId = "renovation",
            address = "6222 Irvine Blvd, Irvine, CA 92620",
            lat = 37.3796 ,
            lng = -122.04147
        ))

    vModel.insertTask(
        Task(
            categories = 3,
            task_name = "Painter needed",
            person_name = "Bob",
            datetime = "4/7/2022",
            description = "Need a painter for my fence, about 200 yards",
            hourly_rate = 35,
            imageId = "renovation",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.3569 ,
            lng = -122.0040
        ))

    vModel.insertTask(
        Task(
            categories = 3,
            task_name = "House sitter",
            person_name = "Charles",
            datetime = "4/4/2022",
            description = "Someone to watch the house for a month",
            hourly_rate = 15,
            imageId = "renovation",
            address = "71 Interlude, Irvine, CA 92620",
            lat = 37.4242 ,
            lng = -122.0813
        ))
    /////////////////////////////

    vModel.insertTask(
        Task(
            categories = 4,
            task_name = "PS5 for sale",
            person_name = "Nancy",
            datetime = "4/2/2022",
            description = "Only used for 1 month for sale",
            hourly_rate = 500,
            imageId = "trading",
            address = "6222 Irvine Blvd, Irvine, CA 92620",
            lat = 37.3569 ,
            lng = -122.0040
        ))

    vModel.insertTask(
        Task(
            categories = 4,
            task_name = "Mountain Bike",
            person_name = "Rob",
            datetime = "4/9/2022",
            description = "Brand new, got it from a raffle",
            hourly_rate = 35,
            imageId = "trading",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.3948 ,
            lng = -122.0789
        ))

    vModel.insertTask(
        Task(
            categories = 4,
            task_name = "Some Cards",
            person_name = "Mary",
            datetime = "4/5/2022",
            description = "Found bunch of my kids cards in attic, no idea what they are all for $20",
            hourly_rate = 20,
            imageId = "trading",
            address = "71 Interlude, Irvine, CA 92620",
            lat = 37.3781 ,
            lng = -122.0708
        ))

    vModel.insertTask(
        Task(
            categories = 4,
            task_name = "Monitors",
            person_name = "Thomas",
            datetime = "4/1/2022",
            description = "Office leftover inventories, in good condition",
            hourly_rate = 200,
            imageId = "trading",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.3909 ,
            lng = -122.1083
        ))

    vModel.insertTask(
        Task(
            categories = 4,
            task_name = "Silver bullions",
            person_name = "Peter",
            datetime = "4/7/2022",
            description = "Silver eagles and bars for sales",
            hourly_rate = 15,
            imageId = "trading",
            address = "71 Interlude, Irvine, CA 92620",
            lat = 37.3696 ,
            lng = -122.0699
        ))

    ///////////////////////

    vModel.insertTask(
        Task(
            categories = 5,
            task_name = "Tustin to Anaheim",
            person_name = "Addstore",
            datetime = "4/2/2022",
            description = "Need this box delivered for his Birthday",
            hourly_rate = 35,
            imageId = "deliveryman",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.43295 ,
            lng = -122.133199
        ))

    vModel.insertTask(
        Task(
            categories = 5,
            task_name = "Chipotle Culver City",
            person_name = "Iky",
            datetime = "4/5/2022",
            description = "WTB chipotle delivery chipotle for lunch, good tips",
            hourly_rate = 20,
            imageId = "deliveryman",
            address = "71 Interlude, Irvine, CA 92620",
            lat = 37.4015 ,
            lng = -122.1023
        ))

    vModel.insertTask(
        Task(
            categories = 5,
            task_name = "Along Technology Drive",
            person_name = "Jenny",
            datetime = "4/3/2022",
            description = "Letter to be sent down the block to 200 technology Dr",
            hourly_rate = 20,
            imageId = "deliveryman",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.4006 ,
            lng = -122.1049
        ))

    vModel.insertTask(
        Task(
            categories = 5,
            task_name = "Mcdonalds",
            person_name = "Peter",
            datetime = "4/9/2022",
            description = "Hungry for mcdonalds",
            hourly_rate = 15,
            imageId = "deliveryman",
            address = "71 Interlude, Irvine, CA 92620",
            lat = 37.3815 ,
            lng = -122.0454
        ))

    /////////////////////////////

    vModel.insertTask(
        Task(
            categories = 6,
            task_name = "Construction",
            person_name = "Albert",
            description = "Looking for temporary worker",
            hourly_rate = 35,
            datetime = "4/2/2022",
            imageId = "workinprogress",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.39741 ,
            lng = -122.09653
        ))

    vModel.insertTask(
        Task(
            categories = 6,
            task_name = "Lifters",
            person_name = "Sam",
            datetime = "4/5/2022",
            description = "Just moved here, need a pair of strong hands",
            hourly_rate = 30,
            imageId = "workinprogress",
            address = "71 Interlude, Irvine, CA 92620",
            lat = 37.4242 ,
            lng = -122.0813
        ))

    vModel.insertTask(
        Task(
            categories = 6,
            task_name = "Plucking strawberries",
            person_name = "Jennifer",
            datetime = "4/8/2022",
            description = "Need temporary workers for strawberry field",
            hourly_rate = 34,
            imageId = "workinprogress",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.41599 ,
            lng = -122.05207
        ))

    vModel.insertTask(
        Task(
            categories = 6,
            task_name = "General Labor",
            person_name = "Peter",
            datetime = "4/5/2022",
            description = "Driver needed for a day, must be willing to lift stuff",
            hourly_rate = 25,
            imageId = "workinprogress",
            address = "71 Interlude, Irvine, CA 92620",
            lat = 37.38365 ,
            lng = -122.04168
        ))
    vModel.insertTask(
        Task(
            categories = 6,
            task_name = "House cleaning",
            person_name = "Addstore",
            datetime = "4/1/2022",
            description = "Dirty house needs a clean",
            hourly_rate = 35,
            imageId = "workinprogress",
            address = "36 Lyndhurst, Irvine, CA 92620",
            lat = 37.35084 ,
            lng = -122.073149
        ))


    // vModel.deleteALL()
}