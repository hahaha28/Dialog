package `fun`.inaction.dialog.dialogs

import `fun`.inaction.dialog.CenterDialog
import `fun`.inaction.dialog.content.IconTextListContent
import `fun`.inaction.dialog.header.TextHeader
import android.content.Context
import android.view.Gravity

class IconTextListDialog(context: Context,style:Int = Style_Default): CenterDialog(context) {

    private val header = TextHeader(headerContainer)
    private val content = IconTextListContent(contentContainer)

    init{
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
     * 设置对话框标题
     */
    fun setTitle(text:String):IconTextListDialog{
        header.setTitle(text)
        return this
    }

    /**
     * 设置数据
     * list集合中每一项是一个Pair
     * Pair的第一项是图片的id，第二项是显示的字符串
     */
    fun setData(l:List<Pair<Int,String>>):IconTextListDialog{
        content.setData(l)
        return this
    }

    /**
     * 设置标题文字的颜色
     */
    fun setTitleTextColor(color:Int):IconTextListDialog{
        header.setTextColor(color)
        return this
    }



    companion object{

        /**
         * 默认样式，有标题
         */
        const val Style_Default = 0

        /**
         * 无标题样式
         */
        const val Style_NoTitle = 1

        /**
         * 标题在中间
         */
        const val Style_TitleCenter = 2
    }

}