package gensounosakurakoubou.cashier.Model.DB.AccountingDB

import gensounosakurakoubou.cashier.Model.DB.Accounting
import io.realm.Realm

class  LoadAccouning{
    val realm = Realm.getDefaultInstance()
    fun getAccouningCost(getDay:String):Int{
        val accountingCost = realm.where(Accounting::class.java)
                .equalTo("accouningDay", getDay)
                .findFirst()
        val cost = accountingCost!!.cost
        return cost
    }
    fun getAccouningSeles(getDay: String):Int{
        val accountingCost = realm.where(Accounting::class.java)
                .equalTo("accouningDay", getDay)
                .findFirst()
        val sales = accountingCost!!.sales
        return sales
    }
}