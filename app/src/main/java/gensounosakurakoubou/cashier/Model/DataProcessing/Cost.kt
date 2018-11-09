package gensounosakurakoubou.cashier.Model.DataProcessing

import gensounosakurakoubou.cashier.Model.DB.Product
import io.realm.Realm

class Cost {

    fun addCost(productName: String, v: Int): Int {
        //下手にレコードをいじらないようにするための措置
        if(v == 0) return 0
        val cost = findCost(productName) * v
        return cost
    }

    fun subtractionCost(productName: String, v: Int): Int {
        if(v == 0) return 0
        val cost = findCost(productName) * v
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