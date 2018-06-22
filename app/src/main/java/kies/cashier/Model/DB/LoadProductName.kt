package kies.cashier.Model.DB

import io.realm.Realm
import io.realm.RealmResults

class LoadProductName(){
    lateinit var realm: Realm
    fun loadProductNmae():MutableList<String>{
        realm = Realm.getDefaultInstance()

        var nameList = mutableListOf<String>()

        val  productName = realm.where(Product::class.java).findAll()
        for (id in productName){
            nameList.add(id.productName)
        }
        realm.close()
        nameList.sorted()
        return nameList
    }
}