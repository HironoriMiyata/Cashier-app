package gensounosakurakoubou.cashier.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import gensounosakurakoubou.cashier.Model.DB.StartDatabase
import gensounosakurakoubou.cashier.Model.DataProcessing.StartAccounigDB
import gensounosakurakoubou.cashier.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StartDatabase()
        val startAccounigDB = StartAccounigDB()
        startAccounigDB.startAccouningDB()
        val buttonDatabase: Button = findViewById(R.id.database)
        buttonDatabase.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                databaseScreen()
            }
        })
        val buttonCashier: Button = findViewById(R.id.cashier)
        buttonCashier.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                cashierScreen()
            }
        })
        val buttonResult: Button = findViewById(R.id.result)
        buttonResult.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                resultScreen()
            }
        })
    }

    private fun databaseScreen() {
        val databaseIntent = Intent(this, DatabaseActivity()::class.java)
        startActivity(databaseIntent)
    }

    private fun cashierScreen() {
        val cashierIntent = Intent(this, CashierActivity()::class.java)
        startActivity(cashierIntent)
    }

    private fun resultScreen() {
        val resultIntent = Intent(this, ResultActivity()::class.java)
        startActivity(resultIntent)
    }

}
