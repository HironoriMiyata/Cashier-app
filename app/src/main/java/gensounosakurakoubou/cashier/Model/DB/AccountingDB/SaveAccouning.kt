package gensounosakurakoubou.cashier.Model.DB.AccountingDB

import android.text.format.DateFormat
import gensounosakurakoubou.cashier.Model.DB.Accounting
import io.realm.Realm
import java.util.*

class SaveAccouning {
    fun saveAccouning() {
        val loadId = LoadAccouningID()
        val realm = Realm.getDefaultInstance()
        val id = loadId.findLoadAccouningID()
        val getToday = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN)
        val today = getToday.time

        //計算のためにコストとセールは初期値を０にすること
        realm.beginTransaction()
        val accouning = realm.createObject(Accounting::class.java, id)
        accouning.accountingId = id
        accouning.accountingDay =  DateFormat.format("yyyy/MM/dd", today).toString()
        accouning.cost = 0
        accouning.sales = 0
        realm.commitTransaction()
        realm.close()
    }
}