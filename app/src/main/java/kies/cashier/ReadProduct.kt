package kies.cashier

import android.app.Activity
import io.realm.Realm
import io.realm.RealmResults
lateinit var  getProduct : RealmResults<Product>
class ReadProduct : Activity() {
    fun readProduct(){
     val realm = Realm.getDefaultInstance()
         getProduct = realm
            .where(Product::class.java)
            .findAll()
            .sort("id")

    }

    fun getProductName():String {
        readProduct()
        if (getProduct.size > 0) {
            val addName: String = getProduct.first()!!.productnName
            return addName
        } else {
            return "Add  New Item"
        }
    }
}
