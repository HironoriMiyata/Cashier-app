package gensounosakurakoubou.cashier.Model.DB.AccountingDB

import io.realm.Realm

class Cost {

    fun addCost(): Int {
        var cost = findCost()
        return cost
    }

    fun subtractionCost(): Int {
        var cost = findCost()
        return cost
    }

    fun getCost(): Int {
        return findCost()
    }

    private fun findCost(): Int {
        var cost = 0
        var realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            val newProductCount = realm.where(Accounting::class.java)
                    .equalTo("cost", cost)
                    .findFirst()
        }
        return cost
    }
}