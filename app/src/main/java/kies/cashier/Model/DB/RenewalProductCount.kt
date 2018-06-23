package kies.cashier.Model.DB

import io.realm.Realm

class RenewalProductCount() {
    lateinit var realm: Realm
    fun renewalProductCount(name: String) {
        realm = Realm.getDefaultInstance()
        val productCount = realm.where(Product::class.java)
                .equalTo("productName", name)
                .findAll()
                .map { it.productCount }
        val count = productCount[0]
        realm.beginTransaction()
        
        realm.commitTransaction()
    }
}