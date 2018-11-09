package gensounosakurakoubou.cashier.Model.DB.AccountingDB

import gensounosakurakoubou.cashier.Model.DB.Accounting
import io.realm.Realm

class LoadAccouningID {
    fun loadAccouningID(): List<Int> {
        val realm = Realm.getDefaultInstance()
        val productID = realm.where(Accounting::class.java).findAll()
        val idList = mutableListOf<Int>()
        for (id in productID) {
            idList.add(id.accountingId)
        }
        realm.close()
        idList.sorted()
        return idList
    }

    fun findLoadAccouningID(): Int {
        var id = 0
        val productID = loadAccouningID()

        try {
            while (id == productID[id]) {
                id++
            }
        } catch (e: IndexOutOfBoundsException) {
            return id
        }
        return id
    }
}
