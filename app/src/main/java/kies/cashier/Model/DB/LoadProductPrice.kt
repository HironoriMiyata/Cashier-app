package kies.cashier.Model.DB

import io.realm.Realm

class LoadProductPrice() {
    lateinit var realm: Realm
    fun loadProductPrice(name: String): Int {
        realm = Realm.getDefaultInstance()
        var productPrice = realm.where(Product::class.java)
                .equalTo("productName", name)
                .findAll()
                .map { it.productPrice }
        realm.close()
        var price = productPrice[0]
        return price
    }
}