package `fun`.inaction.dialog.dialogs

import `fun`.inaction.dialog.content.TextListContent
import `fun`.inaction.dialog.footer.TextFooter
import `fun`.inaction.dialog.BottomDialog
import android.content.Context
import android.view.Gravity
import android.view.View

class BottomTextListDialog(context:Context,private val style:Int= Style_Default):
    BottomDialog(context) {


    val content = TextListContent(contentContainer)
    val footer = TextFooter(footerContainer)

    init{

        setContent(content)
        setFooter(footer)


        when(style){
            Style_Default-> {
                content.setTextGravity(Gravity.CENTER)
            }
            Style_NoCancelButton -> {
                content.setTextGravity(Gravity.CENTER)
                setFooter(null)
            }
            Style_TextLeft_NoCancelButton -> {
                content.setTextGravity(Gravity.LEFT or Gravity.CENTER_VERTICAL)
                setFooter(null)
            }
        }
    }

    /**
     * 设置列表的数据和对勾的位置
     * @param textList 字符串集合
     */
    fun setData(textList:List<String>):BottomTextListDialog{
        content.setData(textList)
        return this
    }


    /**
     * 设置列表的点击事件
     * @param l 两个参数，第一个为View,第二个参数是Int,代表点击的位置
     */
    fun setOnItemClickListener(l:(v: View, position:Int)->Unit):BottomTextListDialog{
        content.onItemClickListener = l
        return this
    }

    /**
     * 设置取消的点击监听
     */
    fun setOnCancelClickListener(l:(v:View)->Unit):BottomTextListDialog{
        footer.onClickListener = l
        return this
    }

    companion object{

        /**
         * 默认样式，无标题，列表文字居中，有取消按钮
         */
        const val Style_Default = 0

        /**
         * 无标题，列表文字居中，无取消按钮
         */
        const val Style_NoCancelButton = 1

        /**
         * 无标题，列表文字靠左，无取消按钮
         */
        const val Style_TextLeft_NoCancelButton = 2

    }
}