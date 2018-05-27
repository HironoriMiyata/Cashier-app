package kies.cashier

import android.content.Context
import android.support.v7.app.AppCompatActivity

import org.json.JSONArray

lateinit var ProductList : MutableList<String>

class ReadProdcut() : AppCompatActivity() {

    fun readProduct(key: String) :MutableList<String>{

        val shardPreferences = this.getPreferences(Context.MODE_PRIVATE)

        val jsonArray = JSONArray(shardPreferences.getString(key, "[]"));
        if(jsonArray.length() >0) {
            for (i in 0 until jsonArray.length()) {
                ProductList.add(jsonArray.getString(i))
            }
        } else {
            ProductList.add("Add New item")
        }
        return ProductList
    }

}