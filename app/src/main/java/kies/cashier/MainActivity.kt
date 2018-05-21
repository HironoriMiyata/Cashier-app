package kies.cashier

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button2: Button = findViewById(R.id.button2) as Button
        button2.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                cashierScreen()
            }
        })
    }
    fun cashierScreen(){
        val intent = Intent(this,CashierActivity::class.java)
        startActivity(intent)
    }
}
