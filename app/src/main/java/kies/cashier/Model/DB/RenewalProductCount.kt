package kies.cashier.Model.DB

import io.realm.Realm

class RenewalProductCount() {
    lateinit var realm: Realm
    fun renewalProductCount(name: String,addCount:Int) {
        realm = Realm.getDefaultInstance()
        val productCount = realm.where(Product::class.java)
                .equalTo("productName", name)
                .findFirst()
        val oldCount = realm.where(Product::class.java)
                .equalTo("productName", name)
                .findAll()
                .map { it.productCount }
        var count = oldCount[0] + addCount
        realm.executeTransaction {
            if (productCount != null) {
                productCount.productCount = count
            }
        }
    }
}