package gensounosakurakoubou.cashier.Model.DataProcessing

import gensounosakurakoubou.cashier.Model.DB.Accounting
import gensounosakurakoubou.cashier.Model.DB.Product
import io.realm.Realm
import java.util.*

class Seles{
    fun addSeles(productName: String, v: Int): Int {
        //下手にレコードをいじらないようにするための措置
        if (v == 0) return 0
        val seles = findSeles(productName) * v
        changeSeles(seles)
        return seles
    }

    fun subtractionSeles(productName: String, v: Int): Int {
        if (v == 0) return 0
        val seles = findSeles(productName) * v
        changeSeles(seles + (-1))
        return seles
    }

    fun getSeles(productName: String): Int {
        return findSeles(productName)
    }

    private fun findSeles(productName: String): Int {
        var realm = Realm.getDefaultInstance()
        val seles = realm.where(Product::class.java)
                .equalTo("productName", productName)
                .findFirst()
        val productSeles = seles!!.productPrice
        realm.close()
        return productSeles
    }

    private fun changeSeles(getseles:Int) {
        val getToday = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN)
        val realm = Realm.getDefaultInstance()
        val day = getToday.get(Calendar.DAY_OF_YEAR)
        val findSeles = realm.where(Accounting::class.java)
                .equalTo("Day", day)
                .findFirst()
        val seles = findSeles!!.sales
        findSeles.sales = seles + getseles
        realm.close()
    }
}