package gensounosakurakoubou.cashier.Model.DB.AccountingDB

import gensounosakurakoubou.cashier.Model.DB.ProductDB.Product
import io.realm.Realm

class Cost {

    fun addCost(productName: String): Int {
        var cost = findCost(productName)
        return cost
    }

    fun subtractionCost(productName: String): Int {
        var cost = findCost(productName)
        return cost
    }

    fun getCost(productName: String): Int {
        return findCost(productName)
    }

    private fun findCost(productName: String): Int {
        var realm = Realm.getDefaultInstance()
        val cost = realm.where(Product::class.java)
                .equalTo("productName", productName)
                .findFirst()
        val productCost = cost!!.productCost
        realm.close()
        return productCost
    }
}