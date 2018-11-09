package gensounosakurakoubou.cashier.Model.DB.AccountingDB

import gensounosakurakoubou.cashier.Model.DB.Accounting
import io.realm.Realm
import java.util.*

class SaveAccouning{
    fun saveAccouning(){
        val loadId = LoadAccouningID()
        val realm = Realm.getDefaultInstance()
        var id = loadId.findLoadAccouningID()
        //計算のためにコストとセールは初期値を０にすること
        realm.beginTransaction()
        val accouning = realm.createObject(Accounting::class.java, id)
        accouning.accountingId = id
       // accouning.accountingDay = Calendar.getInstance()
        accouning.cost = 0
        accouning.sales = 0
        realm.commitTransaction()
        realm.close()
    }
}