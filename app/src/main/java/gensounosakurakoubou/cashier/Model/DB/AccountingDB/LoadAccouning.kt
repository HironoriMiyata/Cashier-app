package gensounosakurakoubou.cashier.Model.DB.AccountingDB

import gensounosakurakoubou.cashier.Model.DB.Accounting
import gensounosakurakoubou.cashier.Model.DB.Product
import io.realm.Realm

class LoadAccouning {
    val realm = Realm.getDefaultInstance()
    fun getAccouningCost(getDay: String): Int {
        val accountingCost = realm.where(Accounting::class.java)
                .equalTo("accouningDay", getDay)
                .findFirst()
        val cost = accountingCost!!.cost
        return cost
    }

    fun getAccouningSeles(getDay: String): Int {
        val accountingCost = realm.where(Accounting::class.java)
                .equalTo("accouningDay", getDay)
                .findFirst()
        val sales = accountingCost!!.sales
        return sales
    }

    fun getAccouningDay(getDay: String): String {
        val accountingCost = realm.where(Accounting::class.java)
                .equalTo("day", getDay)
                .findFirst()
        val day = accountingCost!!.day
        return day
    }

    fun getAccounigLastDay(): String {
        val realm = Realm.getDefaultInstance()
        val day = realm.where(Accounting::class.java).findAll()

        realm.close()

        return ""
    }

    private fun findLastDay() {

    }

    fun getAccouningHour(getDay: String): String {
        val accountingCost = realm.where(Accounting::class.java)
                .equalTo("accouningDay", getDay)
                .findFirst()
        val hour = accountingCost!!.hour
        return hour
    }
}