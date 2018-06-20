package kies.cashier.Model.DB

import io.realm.Realm


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

