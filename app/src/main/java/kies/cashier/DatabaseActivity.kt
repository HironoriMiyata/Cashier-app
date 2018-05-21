package kies.cashier

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class DatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databass)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1).apply {
            add("Android")
            add("iOS")
            add("Windows")
            add("macOS")
            add("Unix")
            add("+") // 追加
        }

        val listView : ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter

        // 項目をタップしたときの処理
        listView.setOnItemClickListener {parent, view, position, id ->

            // 項目の TextView を取得
            val itemTextView : TextView = view.findViewById(android.R.id.text1)

            // 項目のラベルテキストをログに表示
            Log.i("debug", itemTextView.text.toString())

            // 一番下の項目をタップしたら新しい項目をその項目の上に追加
            if (position == arrayAdapter.count - 1) {
                arrayAdapter.insert("New Item " + arrayAdapter.count, arrayAdapter.count - 1)
                arrayAdapter.notifyDataSetChanged()
            }
        }

        // 項目を長押ししたときの処理
        listView.setOnItemLongClickListener { parent, view, position, id ->

            // 一番下の項目以外は長押しで削除
            if (position == arrayAdapter.count - 1) {
                return@setOnItemLongClickListener false
            }

            arrayAdapter.remove(arrayAdapter.getItem(position))
            arrayAdapter.notifyDataSetChanged()

            return@setOnItemLongClickListener true
        }

    }
    

}