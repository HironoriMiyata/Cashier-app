package gensounosakurakoubou.cashier.Model.DataProcessing

import gensounosakurakoubou.cashier.Model.DB.AccountingDB.LoadAccouning
import gensounosakurakoubou.cashier.Model.DB.AccountingDB.SaveAccouning
import java.util.*

class StartAccounigDB {
    fun startAccouningDB() {
        val saveAccouning = SaveAccouning()
        val getToday = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN)
        val nowTime = getToday.get(Calendar.HOUR_OF_DAY)
        var setTime = 0
        //何もレコードがないときはすぐにレコードを作成する
        if (checkDate()) {
            saveAccouning.saveAccouning()
        }
        //データが本当に24時間表記か調べて24時間表記に直す
        setTime = checkTime(setTime)
        //利用者が決めた時間でレコードの更新が必要か確認する
        if (nowTime > setTime && setTime < 25) {
            if (checkDay(Integer.toString(getToday.get(Calendar.DAY_OF_YEAR)))) {
                saveAccouning.saveAccouning()
            }
        } else {
            if (checkOverTime()) {
                saveAccouning.saveAccouning()
            }
        }
    }

    private fun checkDate(): Boolean {
        return true
    }

    private fun checkTime(setTime: Int): Int {
        var checkedHour = setTime
        if (setTime > 24) {
            checkedHour = setTime % 24
        } else if (setTime < 0) {
            checkedHour = setTime * (-1)
            return checkTime(checkedHour)
        }
        return checkedHour
    }

    private fun checkDay(today: String): Boolean {
        val accounnigDay = LoadAccouning()
        val day = accounnigDay.getAccounigLastDay()
        if (Integer.parseInt(day) < Integer.parseInt(today)) {
            return true
        }
        return false
    }

    private fun checkOverTime(): Boolean {

        return true
    }
}