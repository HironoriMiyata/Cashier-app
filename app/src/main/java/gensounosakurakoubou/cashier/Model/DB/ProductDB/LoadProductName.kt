package gensounosakurakoubou.cashier.Model.DB.ProductDB

import io.realm.Realm

class LoadProductName() {
    lateinit var realm: Realm
    fun loadProductName(): MutableList<String> {
        realm = Realm.getDefaultInstance()

        var nameList = mutableListOf<String>()

        val productName = realm.where(Product::class.java).findAll()
        for (id in productName) {
            nameList.add(id.productName)
        }

        realm.close()
        nameList.sorted()
        return nameList
    }
}