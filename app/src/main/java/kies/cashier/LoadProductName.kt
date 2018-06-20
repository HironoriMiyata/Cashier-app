package kies.cashier

import io.realm.Realm

class LoadProductName(){
    lateinit var realm: Realm
    fun loadProductNmae():List<String>{
        realm = Realm.getDefaultInstance()

        val  productName = realm.where(Product::class.java)
                .findAll()
                .map { it.productName }
        productName.sorted()

        realm.close()
        return productName
    }
}