package `fun`.inaction.dialog.dialogs

import `fun`.inaction.dialog.BottomDialog
import `fun`.inaction.dialog.content.IconTextListContent
import `fun`.inaction.dialog.header.TextHeader
import android.content.Context
import android.view.Gravity
import android.view.View

class BottomIconTextListDialog(context:Context,private val style:Int= Style_Default): BottomDialog(context) {


    val header = TextHeader(headerContainer)
    val content = IconTextListContent(contentContainer)

    init {
        setHeader(header)
        setContent(content)

        header.setTitleGravity(Gravity.LEFT)

        when(style){
            Style_NoTitle -> {
                setHeader(null)
            }
            Style_TitleCenter -> {
                header.setTitleGravity(Gravity.CENTER)
            }
        }
    }

    /**
     * 设置数据
     * list集合中每一项是一个Pair
     * Pair的第一项是图片的id，第二项是显示的字符串
     */
    fun setData(l:List<Pair<Int,String>>):BottomIconTextListDialog{
        content.setData(l)
        return this
    }

    /**
     * 设置对话框标题
     */
    fun setTitle(text:String):BottomIconTextListDialog{
        header.setTitle(text)
        return this
    }

    /**
     * 设置标题文字的颜色
     */
    fun setTitleTextColor(color:Int):BottomIconTextListDialog{
        header.setTextColor(color)
        return this
    }

    /**
     * 设置列表的点击事件
     * @param l 两个参数，第一个为View,第二个参数是Int,代表点击的位置
     */
    fun setOnItemClickListener(l:(v: View, position:Int)->Unit):BottomIconTextListDialog{
        content.onItemClickListener = l
        return this
    }

    companion object{

        /**
         * 默认样式，标题靠左
         */
        const val Style_Default = 0

        /**
         * 无标题样式
         */
        const val Style_NoTitle = 1

        /**
         * 标题居中样式
         */
        const val Style_TitleCenter = 2
    }

}