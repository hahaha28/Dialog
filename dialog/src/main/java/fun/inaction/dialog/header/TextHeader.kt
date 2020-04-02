package `fun`.inaction.dialog.header

import `fun`.inaction.dialog.R
import `fun`.inaction.dialog.ViewAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TextHeader(private val parent: ViewGroup): ViewAdapter {

    private val view: View
    private val textView: TextView

    init {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_text,parent,false)
        textView = view.findViewById(R.id.textView)
    }

    override fun getView(): View = view

    /**
     * 设置文字颜色
     */
    fun setTextColor(color: Int){
        textView.setTextColor(color)
    }

    /**
     * 设置标题
     */
    fun setTitle(title: String){
        textView.text = title
    }

    /**
     * 设置标题文字位置，默认为{@linkplain Gravity}.CENTER
     * @param gravity 标题文字位置，必须是{@linkplain Gravity}的常量
     * @return
     */
    fun setTitleGravity(gravity: Int){
        textView.gravity = gravity
    }

}