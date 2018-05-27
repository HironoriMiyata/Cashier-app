package kies.cashier

import android.content.Context
import android.support.v7.app.AppCompatActivity
import org.json.JSONArray
class  CerateProduct: AppCompatActivity(){
fun saveList(key: String, arrayList: ArrayList<String>) {

    val shardPreferences = this.getPreferences(Context.MODE_PRIVATE)
    val shardPrefEditor = shardPreferences.edit()

    val jsonArray = JSONArray(arrayList)
    shardPrefEditor.putString(key, jsonArray.toString())
    shardPrefEditor.apply()
}
}