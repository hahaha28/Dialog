package `fun`.inaction.dialog.footer

import `fun`.inaction.dialog.R
import `fun`.inaction.dialog.ViewAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CommonFooter(private val parent: ViewGroup): ViewAdapter {

    /**
     * 布局的View
     */
    private val view: View

    /**
     * 取消的textView
     */
    private val cancelTextView: TextView

    /**
     * 确定的TextView
     */
    private val confirmTextView: TextView

    init {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.footer_common,parent,false)
        cancelTextView = view.findViewById(R.id.cancel)
        confirmTextView = view.findViewById(R.id.confirm)
    }

    override fun getView(): View  = view

    fun setCancelText(text:String){
        cancelTextView.text = text
    }

    fun setConfirmText(text:String){
        confirmTextView.text = text
    }

    fun setOnCancelClickListener(onCancelClickListener: View.OnClickListener) {
        cancelTextView.setOnClickListener(onCancelClickListener)
    }

    fun setOnConfirmClickListener(onConfirmClickListener: View.OnClickListener) {
        confirmTextView.setOnClickListener(onConfirmClickListener)
    }

}