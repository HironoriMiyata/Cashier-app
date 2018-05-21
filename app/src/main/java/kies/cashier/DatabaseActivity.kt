package kies.cashier

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.*

class DatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databass)
        val inflater = this.layoutInflater.inflate(R.layout.dialog_signin, null, false)

        // ダイアログ内のテキストエリア
        val dialogEditText : EditText = inflater.findViewById(R.id.product)
        dialogEditText.requestFocus()
        val dialogEditText2 : EditText = inflater.findViewById(R.id.price)
        dialogEditText2.requestFocus()
        val prodcutList:MutableList<String> = databaseProduct()
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,prodcutList)

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
                AlertDialog.Builder(this).apply {
                    setTitle("商品情報")
                    setMessage("商品情報を追加します")
                    setView(inflater)
                    setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                        // OKをタップしたときの処理
                        Toast.makeText(context, "Dialog OK", Toast.LENGTH_LONG).show()
                        arrayAdapter.insert("New Item " + arrayAdapter.count, arrayAdapter.count - 1)//追加
                        arrayAdapter.notifyDataSetChanged()
                    })
                    setNegativeButton("Cancel", null)
                    show()
                }

            }
        }

        // 項目を長押ししたときの処理
        listView.setOnItemLongClickListener { parent, view, position, id ->

            // 一番下の項目以外は長押しで削除
            if (position == arrayAdapter.count - 1) {
                return@setOnItemLongClickListener false
            }
            AlertDialog.Builder(this).apply {
                setTitle("削除の確認")
                setMessage("本当に削除をしてもいいですか？")
                setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    // OKをタップしたときの処理
                    Toast.makeText(context, "Dialog OK", Toast.LENGTH_LONG).show()
                    arrayAdapter.remove(arrayAdapter.getItem(position))
                    arrayAdapter.notifyDataSetChanged()
                })
                setNegativeButton("Cancel", null)
                show()
            }


            return@setOnItemLongClickListener true
        }

    }


}