package com.pelp.model.data
import android.R.attr.data
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.LatLng
import com.pelp.Database
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.*
import java.io.Serializable

@Composable
fun writeFile(){
var context = LocalContext.current
    val file = File(context.getFilesDir(), "userBase.txt")
    val fileOutputStream = FileOutputStream(file)
    val outputStreamWriter = OutputStreamWriter(fileOutputStream)
    val bufferedWriter = BufferedWriter(outputStreamWriter)
    bufferedWriter.write("Hello World")
}









object Serialize : Serializable{
    var ub = "./com.pelp/Userbase.txt"
    var db = "C:/Users/User/Desktop/Github/Pelpers/Pelpers/Pelp/app/src/main/java/com/pelp/model/data/Database.ser"



    fun serializeOut(obj: Any?, path: String? = ub) {
        try {
            val fileOut = FileOutputStream(
                ub
            )
            val out = ObjectOutputStream(fileOut)
//            out.writeObject(obj as LinkedHashMap<*, *>?)
            var a: String="Hello World"
            out.writeObject(a)
            out.close()
            fileOut.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /*

    var dataBase: LinkedHashMap<LatLng, Location_Restroom> = LinkedHashMap()
        var userBase:LinkedHashMap<String, Person> = LinkedHashMap()
     */
    fun serializeDatabase() {
        var map: LinkedHashMap<LatLng, Location_Restroom> = LinkedHashMap<LatLng, Location_Restroom>()
        try {
            val fileIn = FileInputStream(
                db
            )
            var incoming = ObjectInputStream(fileIn)
            map = incoming.readObject() as LinkedHashMap<LatLng, Location_Restroom>
            Database.dataBase.putAll(map)

            //	System.out.println("Customers size = " + map.size());
            //Database.currentCustomers = map;
            incoming.close()
            fileIn.close()
        } catch (e: IOException) {
            if (e is IOException) {
                //do nothing
                return
            }
            e.printStackTrace()
        } catch (e1: ClassNotFoundException) {
            // TODO Auto-generated catch block
            e1.printStackTrace()
        }
    }


    fun serializeUserbase() {
        var map: LinkedHashMap<String, Person> = LinkedHashMap<String, Person>()
        try {
            val fileIn = FileInputStream(
                ub
            )
            var incoming = ObjectInputStream(fileIn)
            map = incoming.readObject() as LinkedHashMap<String, Person>
            Database.userBase.putAll(map)

            //	System.out.println("Customers size = " + map.size());
            //Database.currentCustomers = map;
            incoming.close()
            fileIn.close()
        } catch (e: IOException) {
            if (e is IOException) {
                //do nothing
                return
            }
            e.printStackTrace()
        } catch (e1: ClassNotFoundException) {
            // TODO Auto-generated catch block
            e1.printStackTrace()
        }
    }

}
