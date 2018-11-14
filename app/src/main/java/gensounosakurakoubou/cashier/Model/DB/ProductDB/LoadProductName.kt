package gensounosakurakoubou.cashier.Model.DB.ProductDB

import gensounosakurakoubou.cashier.Model.DB.Product
import io.realm.Realm

class LoadProductName {
    fun loadProductName(): MutableList<String> {
        val realm = Realm.getDefaultInstance()
        val nameList = mutableListOf<String>()
        val productName = realm.where(Product::class.java).findAll()
        for (id in productName) {
            nameList.add(id.productName)
        }
        realm.close()
        nameList.sorted()
        return nameList
    }
}