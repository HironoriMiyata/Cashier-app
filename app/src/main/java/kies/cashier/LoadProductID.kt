package kies.cashier

import io.realm.Realm
import io.realm.RealmResults


lateinit var realm: Realm

class  LoadProductID(){
    fun  loadProductID():Int{
        realm = Realm.getDefaultInstance()
        var id = 0
        val  productID = realm.where(Product::class.java)
                .findAll()
                .map { it.productId }
        productID.sorted()
        while (productID[id] ==id ){
            id++
        }
        realm.close()
        return id
    }
}

