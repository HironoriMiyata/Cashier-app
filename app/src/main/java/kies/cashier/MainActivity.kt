package kies.cashier

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StartDatabase()
        val buttonDatabase: Button = findViewById(R.id.database) as Button
        buttonDatabase.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                DatabaseScreen()
            }
        })
        val buttonCashier: Button = findViewById(R.id.cashier) as Button
        buttonCashier.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                cashierScreen()
            }
        })
        val buttonresult: Button = findViewById(R.id.result) as Button
        buttonresult.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                resultScreen()
            }
        })
    }
    fun DatabaseScreen(){
        val intent = Intent(this,DatabaseActivity()::class.java)
        startActivity(intent)
    }
    fun cashierScreen(){
        val intent = Intent(this,CashierActivity::class.java)
        startActivity(intent)
    }
    fun resultScreen(){
        val intent = Intent(this,ResultActivity::class.java)
        startActivity(intent)
    }

}
