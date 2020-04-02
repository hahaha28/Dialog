package `fun`.inaction.dialog.content

import `fun`.inaction.dialog.R
import `fun`.inaction.dialog.ViewAdapter
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TextContent(private val parent:ViewGroup): ViewAdapter {

    private val view: View
    private val textView: TextView

    init {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_text,parent,false)
        textView = view.findViewById(R.id.textView)
    }

    override fun getView(): View = view

    /**
     * 设置内容文字
     * @param content 展示的内容
     * @return
     */
    fun setContent(content: String?): TextContent {
        textView.text = content
        return this
    }

    /**
     * 设置字体大小
     * @param textSize 字体大小
     * @return
     */
    fun setTextSize(textSize: Float): TextContent {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
        return this
    }

    /**
     * 设置文字颜色
     * @param color
     * @return
     */
    fun setTextColor(color: Int): TextContent{
        textView.setTextColor(color)

        return this
    }

    /**
     * 设置文字的gravity
     * @param gravity 必须为Gravity类的常量
     */
    fun setTextGravity(gravity:Int): TextContent{
        textView.gravity = gravity
        return this
    }


}