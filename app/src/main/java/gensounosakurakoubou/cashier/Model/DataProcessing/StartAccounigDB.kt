package gensounosakurakoubou.cashier.Model.DataProcessing

import gensounosakurakoubou.cashier.Model.DB.AccountingDB.SaveAccouning

class StartAccounigDB{
    fun startAccouningDB(){
        val saveAccouning = SaveAccouning()
        saveAccouning.saveAccouning()
    }
}