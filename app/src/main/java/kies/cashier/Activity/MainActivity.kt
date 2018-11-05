package kies.cashier.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kies.cashier.Model.DB.StartDatabase
import kies.cashier.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StartDatabase()
        val buttonDatabase: Button = findViewById(R.id.database) as Button
        buttonDatabase.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                databaseScreen()
            }
        })
        val buttonCashier: Button = findViewById(R.id.cashier) as Button
        buttonCashier.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                cashierScreen()
            }
        })
        val buttonResult: Button = findViewById(R.id.result) as Button
        buttonResult.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                resultScreen()
            }
        })
    }

    fun databaseScreen() {
        val databaseIntent = Intent(this, DatabaseActivity()::class.java)
        startActivity(databaseIntent)
    }

    fun cashierScreen() {
        val cashierIntent = Intent(this, CashierActivity()::class.java)
        startActivity(cashierIntent)
    }

    fun resultScreen() {
        val resultIntent = Intent(this, ResultActivity()::class.java)
        startActivity(resultIntent)
    }

}
