package kies.cashier

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class ResultActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_result)
        val proftiTextView: TextView = findViewById(R.id.profit)
        val grossTextView: TextView = findViewById(R.id.gross)
    }
}