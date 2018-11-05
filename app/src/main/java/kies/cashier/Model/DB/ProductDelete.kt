package kies.cashier.Model.DB

import io.realm.Realm


class ProductDelete(){
    lateinit var realm: Realm
    fun productDelete(name:String){
        realm = Realm.getDefaultInstance()
        val selectedDB = realm.where(Product::class.java).equalTo("productName",name).findAll()
        realm.beginTransaction()
        selectedDB.deleteAllFromRealm()
        realm.commitTransaction()
        
    }
}