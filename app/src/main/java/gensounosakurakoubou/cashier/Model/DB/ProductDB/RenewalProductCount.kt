package gensounosakurakoubou.cashier.Model.DB.ProductDB

import gensounosakurakoubou.cashier.Model.DB.Product
import io.realm.Realm

class RenewalProductCount {
    lateinit var realm: Realm
    fun renewalProductCount(name: String, addCount: Int) {
        realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            val newProductCount = realm.where(Product::class.java)
                    .equalTo("productName", name)
                    .findFirst()

            val oldCount = realm.where(Product::class.java)
                    .equalTo("productName", name)
                    .findFirst()

            val count = oldCount!!.productCount + addCount

            if (newProductCount != null) {
                newProductCount.productCount = count
            }
        }
    }
}