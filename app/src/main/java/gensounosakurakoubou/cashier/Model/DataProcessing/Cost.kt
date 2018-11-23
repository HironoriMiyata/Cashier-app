package gensounosakurakoubou.cashier.Model.DataProcessing

import gensounosakurakoubou.cashier.Model.DB.Accounting
import gensounosakurakoubou.cashier.Model.DB.Product
import io.realm.Realm
import java.util.*

class Cost {

    fun addCost(productName: String, v: Int): Int {
        //下手にレコードをいじらないようにするための措置
        if (v == 0 || productName == "Noitem") return 0
        val cost = findCost(productName) * v
        //changeCost(cost)
        return cost
    }

    fun subtractionCost(productName: String, v: Int): Int {
        if (v == 0 || productName == "Noitem") return 0
        val cost = findCost(productName) * v
        //changeCost(cost * (-1))
        return cost
    }

    fun getCost(productName: String): Int {
        return findCost(productName)
    }

    private fun findCost(productName: String): Int {
        val realm = Realm.getDefaultInstance()
        val cost = realm.where(Product::class.java)
                .equalTo("productName", productName)
                .findFirst()
        val productCost = cost!!.productCost
        realm.close()
        return productCost
    }

    private fun changeCost(getCost: Int) {
        val getToday = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN)
        val realm = Realm.getDefaultInstance()
        val day = Integer.toString(getToday.get(Calendar.DAY_OF_YEAR))
        val findCost = realm.where(Accounting::class.java)
                .equalTo("day", day)
                .findFirst()
        val cost = findCost!!.cost + getCost
        findCost.cost = cost
        realm.close()
    }
}