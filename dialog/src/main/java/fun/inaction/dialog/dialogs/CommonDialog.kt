package `fun`.inaction.dialog.dialogs

import `fun`.inaction.dialog.CenterDialog
import `fun`.inaction.dialog.content.TextContent
import `fun`.inaction.dialog.footer.CommonFooter
import `fun`.inaction.dialog.header.TextHeader
import android.content.Context
import android.view.Gravity
import android.view.View

class CommonDialog: CenterDialog {


    /**
     * 上中下视图
     */
    val header = TextHeader(headerContainer)
    val content = TextContent(contentContainer)
    val footer = CommonFooter(footerContainer)


    /**
     * 点击确定按钮的回调
     */
    var onConfirmClickListener: (v:View)->Unit = {}

    /**
     * 点击取消按钮的回调
     */
    var onCancelClickListener: (v:View)->Unit = {}

    init {
        setHeader(header)
        setContent(content)
        setFooter(footer)
        footer.setOnConfirmClickListener(View.OnClickListener {
            onConfirmClickListener(it)
        })
        footer.setOnCancelClickListener(View.OnClickListener {
            onCancelClickListener(it)
        })
    }

    constructor(context:Context,style:Int= STYLE_DEFAULT):super(context){
        when(style){
            STYLE_DEFAULT -> {

            }
            STYLE_MATERIAL -> {
                header.setTitleGravity(Gravity.LEFT)
                content.setTextGravity(Gravity.LEFT)
            }
        }
    }

    /**
     * 设置对话框的标题
     * @param text 标题
     */
    fun setTitle(text:String):CommonDialog{
        header.setTitle(text)
        return this
    }

    /**
     * 设置对话框的内容
     */
    fun setContent(text:String):CommonDialog{
        content.setContent(text)
        return this
    }

    /**
     * 设置确定按钮（右边的按钮）的文字（默认为"确定")
     */
    fun setConfirmText(text:String):CommonDialog{
        footer.setConfirmText(text)
        return this
    }

    /**
     * 设置取消按钮（左边的按钮）的文字（默认为“取消”）
     */
    fun setCancelText(text:String):CommonDialog{
        footer.setCancelText(text)
        return this
    }

    companion object{
        const val STYLE_DEFAULT: Int = 0
        const val STYLE_MATERIAL: Int = 1
    }

}