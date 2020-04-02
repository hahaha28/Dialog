package `fun`.inaction.dialog.footer

import `fun`.inaction.dialog.R
import `fun`.inaction.dialog.ViewAdapter
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView

class TextFooter(private val parent: ViewGroup): ViewAdapter{

    /**
     * 布局的View
     */
    private val view: View

    /**
     * 取消的那个View
     */
    private val textView: TextView

    /**
     * 分割线
     */
    private val divideLine: View

    /**
     * 点击监听
     */
    var onClickListener: (v:View)->Unit = {}

    init {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.footer_text,parent,false)
        textView = view.findViewById(R.id.cancel)
        divideLine = view.findViewById(R.id.line)

        view.setOnClickListener {
            onClickListener(it)
        }
    }

    override fun getView(): View = view

    /**
     * 设置取消按钮显示的文字
     */
    fun setCancelText(text:String){
        textView.text = text
    }

    /**
     * 设置文字大小，单位为sp
     */
    fun setTextSize(size:Float){
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,size)
    }

    /**
     * 设置取消按钮显示的位置
     */
    fun setTextGravity(gravity:Int){
        textView.gravity = gravity
    }

    /**
     * 设置是否有分割线
     */
    fun hasDivideLine(boolean:Boolean){
        divideLine.visibility = if(true) View.VISIBLE else View.GONE
    }

}