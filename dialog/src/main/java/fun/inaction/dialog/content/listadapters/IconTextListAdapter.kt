package `fun`.inaction.dialog.content.listadapters

import `fun`.inaction.dialog.R
import `fun`.inaction.dialog.content.IconTextListContent.Style
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class IconTextListAdapter(private val dataList:List<Pair<String,String>>): RecyclerView.Adapter<IconTextListAdapter.ViewHolder>() {

    var onItemClickListener: (v:View,position:Int)->Unit = {v:View,p:Int->}

    var style: Style? = null

    constructor(dataList: List<Pair<String, String>>,style:Style):this(dataList){
        this.style = style
    }

    class ViewHolder(val view:View): RecyclerView.ViewHolder(view){
        val textView: TextView
        val icon: ImageView

        // 这两个View是用来填充空间的
        val upperView: View
        val bottomView: View

        init {
            textView = view.findViewById(R.id.textView)
            icon = view.findViewById(R.id.icon)
            upperView = view.findViewById(R.id.upper)
            bottomView = view.findViewById(R.id.bottom)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_icon_text_list,parent,false)
        val holder = ViewHolder(view)

        holder.view.setOnClickListener {
            onItemClickListener(it,holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, p: Int){
//        holder.icon.setImageResource(dataList[p].first)
        Glide.with(holder.icon)
            .load(dataList[p].first)
            .into(holder.icon)
        holder.textView.text = dataList[p].second
        holder.textView

        style?.textSize?.let{holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,it)}
        style?.textColor?.let{holder.textView.setTextColor(it)}

        // 设置上下两个View是否显示
        if(p == 0){
            holder.upperView.visibility = View.VISIBLE
        }
        if(p == dataList.size-1){
            holder.bottomView.visibility = View.VISIBLE
        }
        if(p !=0 && p != dataList.size-1){
            holder.upperView.visibility = View.GONE
            holder.bottomView.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int = dataList.size
}