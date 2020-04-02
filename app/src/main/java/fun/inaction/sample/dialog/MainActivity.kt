package `fun`.inaction.sample.dialog

import `fun`.inaction.dialog.dialogs.BottomTextListDialog
import `fun`.inaction.dialog.dialogs.CommonDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val dialog = CommonDialog(this)
            dialog.setTitle("标题")
                .setContent("测试一下")
//                .show()
            val d = BottomTextListDialog(this)
            d.setData(listOf("1","2"))
            d.show()

        }
    }
}
