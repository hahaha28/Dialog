package `fun`.inaction.sample.dialog

import `fun`.inaction.dialog.dialogs.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /**
     * 显示对话框的 TextView
     */
    private lateinit var dialogTV: TextView

    /**
     * 显示Style的TextView
     */
    private lateinit var styleTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogTV = findViewById(R.id.dialogTV)
        styleTV = findViewById(R.id.styleTV)
    }

    /**
     * 点击 Show 按钮的事件
     */
    fun onClickShow(v: View) {

        when (dialogTV.text) {

            "CommonDialog" -> {
                val dialog = CommonDialog(this)
                with(dialog) {
                    setTitle("提示")
                    setContent("确定要退出吗？")
                    onConfirmClickListener = {
                        dialog.dismiss()
                    }
                    onCancelClickListener = {
                        dialog.dismiss()
                    }
                    show()
                }
            }

            "TextListDialog" -> {
                var style: Int = when (styleTV.text) {
                    "Style_NoTitle" -> TextListDialog.Style_NoTitle
                    "Style_NoTitle_TextCenter" -> TextListDialog.Style_NoTitle_TextCenter
                    else -> TextListDialog.Style_Default
                }
                val dialog = TextListDialog(this, style)
                dialog.setTitle("选择通知栏样式")
                    .setData(listOf("系统样式", "云音乐通知栏", "可以不要右边的对勾"), 1)
                    .setOnItemClickListener { v, position ->
                        toast("你点击了第${position}项")
                        dialog.dismiss()
                    }
                    .show()
            }

            "IconTextListDialog" -> {
                var style: Int = when (styleTV.text) {
                    "Style_NoTitle" -> IconTextListDialog.Style_NoTitle
                    "Style_TitleCenter" -> IconTextListDialog.Style_TitleCenter
                    else -> IconTextListDialog.Style_Default
                }
                val dialog = IconTextListDialog(this, style)
                val data = listOf(
                    Pair(R.drawable.ic_qq, "QQ登录")
                    , Pair(R.drawable.ic_wechat, "微信登录")
                    , Pair(R.drawable.ic_weibo, "微博登录")
                )
                dialog.setTitle("选择登录方式")
                    .setData(data)
                    .setOnItemClickListener { v, position ->
                        toast("你点击了第${position}项")
                        dialog.dismiss()
                    }
                    .show()
            }

            "BottomTextListDialog" -> {
                var style: Int = when (styleTV.text) {
                    "Style_NoCancelButton" -> BottomTextListDialog.Style_NoCancelButton
                    "Style_TextLeft_NoCancelButton" -> BottomTextListDialog.Style_TextLeft_NoCancelButton
                    else -> BottomTextListDialog.Style_Default
                }
                val dialog = BottomTextListDialog(this, style)
                dialog.setData(listOf("拍照", "从相册选择", "我编一个选项"))
                    .setOnItemClickListener { v, position ->
                        toast("你点击了第${position}项")
                        dialog.dismiss()
                    }
                    .setOnCancelClickListener {
                        dialog.dismiss()
                    }
                    .show()
            }

            "BottomIconTextListDialog" -> {
                val style: Int = when (styleTV.text) {
                    "Style_NoTitle" -> BottomIconTextListDialog.Style_NoTitle
                    "Style_TitleCenter" -> BottomIconTextListDialog.Style_TitleCenter
                    else -> BottomIconTextListDialog.Style_Default
                }
                val data = listOf(
                    Pair(R.drawable.ic_qq, "QQ登录")
                    , Pair(R.drawable.ic_wechat, "微信登录")
                    , Pair(R.drawable.ic_weibo, "微博登录")
                )
                val dialog = BottomIconTextListDialog(this, style)
                dialog.setTitle("选择登录方式")
                    .setData(data)
                    .setOnItemClickListener { v, position ->
                        toast("你点击了第${position}项")
                        dialog.dismiss()
                    }
                    .show()
            }

            else -> {
                toast("Bug：${dialogTV.text}")
            }
        }
    }

    /**
     * 点击 选择对话框 按钮的回调
     */
    fun onClickChooseDialog(v: View) {
        val dialog = TextListDialog(this)
        dialog.setTitle("选择对话框")
        val dialogList = listOf(
            "CommonDialog", "TextListDialog", "IconTextListDialog"
            , "BottomTextListDialog", "BottomIconTextListDialog"
        )
        dialog.setData(dialogList, dialogList.indexOf(dialogTV.text))
        dialog.setOnItemClickListener { v, position ->
            dialogTV.setText(dialogList[position])
            styleTV.setText("null")
            dialog.dismiss()
        }
        dialog.show()
    }

    /**
     * 点击 选择Style 按钮的回调
     */
    fun onClickChooseStyle(v: View) {

        // 对话框的 Style 的集合
        var styleList: List<String>? = null

        when (dialogTV.text) {
            "CommonDialog" -> {
                styleList = listOf("Style_Default")
            }
            "TextListDialog" -> {
                styleList = listOf("Style_Default", "Style_NoTitle", "Style_NoTitle_TextCenter")
            }
            "IconTextListDialog" -> {
                styleList = listOf("Style_Default", "Style_NoTitle", "Style_TitleCenter")
            }
            "BottomTextListDialog" -> {
                styleList =
                    listOf("Style_Default", "Style_NoCancelButton", "Style_TextLeft_NoCancelButton")
            }
            "BottomIconTextListDialog" -> {
                styleList = listOf("Style_Default", "Style_NoTitle", "Style_TitleCenter")
            }
        }

        // 如果对话框没有可选的 Style
        if (styleList == null) {
            val dialog = CommonDialog(this)
            with(dialog) {
                setTitle("提示")
                setContent("这个对话框没有可选Style")
                onCancelClickListener = {
                    dialog.dismiss()
                }
                onConfirmClickListener = {
                    dialog.dismiss()
                }
            }
            return
        }

        // 显示可选的Style

        val dialog = TextListDialog(this)
        dialog.setTitle("选择Style")


        dialog.setData(styleList)
        dialog.setOnItemClickListener { v, position ->
            styleTV.setText(styleList[position])
            dialog.dismiss()
        }
        dialog.show()
    }

    /**
     * 显示Toast
     */
    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}
