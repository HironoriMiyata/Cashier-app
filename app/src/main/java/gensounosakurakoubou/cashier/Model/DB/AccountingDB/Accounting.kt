package gensounosakurakoubou.cashier.Model.DB.AccountingDB

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Accounting: RealmObject(){
    @PrimaryKey
    var productId: Int = 0
    @Required
    var productName: String = ""
    var cost: Int = 0
    var productCount: Int = 0

}