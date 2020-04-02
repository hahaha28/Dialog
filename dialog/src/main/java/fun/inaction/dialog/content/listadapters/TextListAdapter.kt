package `fun`.inaction.dialog.content.listadapters

import `fun`.inaction.dialog.R
import `fun`.inaction.dialog.content.TextListContent
import `fun`.inaction.dialog.customview.RightView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextListAdapter(private var textList: List<String>, private var rightPosition: Int)
    :RecyclerView.Adapter<TextListAdapter.ViewHolder>() {

    /**
     * 点击监听事件
     */
    var onItemClickListener: (v:View,position:Int)->Unit = {v:View,p:Int->}

    /**
     * 这个用来设置TextView的一些属性，例如，居中，文字大小等等
     */
    private var textStyle: TextListContent.TextStyle? = null

    constructor(textList: List<String>,textStyle:TextListContent.TextStyle,rightPosition: Int)
            :this(textList,rightPosition){
        this.textStyle = textStyle
    }

    class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        var textView: TextView

        var rightView : RightView //对勾

        init{
            textView = view.findViewById(R.id.textView)
            rightView = view.findViewById(R.id.rightView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text_list, parent, false)
        val holder = ViewHolder(view)

        holder.view.setOnClickListener {
            onItemClickListener(it,holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = textList[position] //设置文字

        if (position == rightPosition) {  //设置对勾是否显示
            holder.rightView.visibility = View.VISIBLE
        } else {
            holder.rightView.visibility = View.GONE
        }
        // 设置文字的属性
        if(textStyle != null){
            textStyle!!.color?.let { holder.textView.setTextColor(it) }
            textStyle!!.size?.let { holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,it) }
            textStyle!!.gravity?.let { holder.textView.gravity = it }
        }
    }

    override fun getItemCount(): Int = textList.size

}