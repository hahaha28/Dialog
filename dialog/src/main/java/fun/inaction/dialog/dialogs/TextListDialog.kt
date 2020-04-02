package `fun`.inaction.dialog.dialogs

import `fun`.inaction.dialog.CenterDialog
import `fun`.inaction.dialog.content.TextListContent
import `fun`.inaction.dialog.header.TextHeader
import android.content.Context
import android.view.Gravity
import android.view.View

class TextListDialog(context:Context, private val style:Int = Style_Default): CenterDialog(context) {

    val header = TextHeader(headerContainer)
    val content = TextListContent(contentContainer)

    init{
        setHeader(header)
        setContent(content)

        header.setTitleGravity(Gravity.LEFT)
        when(style){
            Style_Default -> null
            Style_NoTitle -> {
                setHeader(null)
            }
            Style_NoTitle_TextCenter -> {
                setHeader(null)
                content.setTextGravity(Gravity.CENTER)
            }
        }
    }

    /**
     * 设置列表的数据和对勾的位置
     * @param textList 字符串集合
     * @param rightPosition 对勾的位置，设为-1则不显示对勾
     */
    fun setData(textList:List<String>,rightPosition:Int=-1):TextListDialog{
        content.setData(textList, rightPosition)
        return this
    }

    /**
     * 设置对话框的标题
     */
    fun setTitle(title:String):TextListDialog{
        header.setTitle(title)
        return this
    }

    /**
     * 设置列表的点击事件
     * @param l 两个参数，第一个为View,第二个参数是Int,代表点击的位置
     */
    fun setOnItemClickListener(l:(v: View,position:Int)->Unit):TextListDialog{
        content.onItemClickListener = l
        return this
    }

    companion object{

        /**
         * 默认样式
         */
        const val Style_Default = 0

        /**
         * 无标题样式
         */
        const val Style_NoTitle = 1

        /**
         * 无标题，且列表文字居中
         */
        const val Style_NoTitle_TextCenter = 2
    }

}