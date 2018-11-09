package gensounosakurakoubou.cashier.Model.DB


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*


open class Accounting: RealmObject(){
    @PrimaryKey
    var accountingId: Int = 0
    @Required
    var accountingDay:String = ""
    var cost: Int = 0
    var sales: Int = 0

}