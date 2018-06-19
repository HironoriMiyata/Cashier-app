package kies.cashier

import io.realm.Realm
import io.realm.RealmResults


lateinit var realm: Realm

class  LoadProductID(){
    fun  loadProductID():List<Int>{
        realm = Realm.getDefaultInstance()

        val  productID = realm.where(Product::class.java)
                .findAll()
                .map { it.productId }
        productID.sorted()

        realm.close()
        return productID
    }

    fun findLoadProductID():Int{
        var id = 0
        var productID  = loadProductID()
        while (productID[id] ==id ){
            id++
        }
        return id
    }
}

