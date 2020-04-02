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

class IconTextListAdapter(private val dataList:List<Pair<Int,String>>): RecyclerView.Adapter<IconTextListAdapter.ViewHolder>() {

    var onItemClickListener: (v:View,position:Int)->Unit = {v:View,p:Int->}

    var style: Style? = null

    constructor(dataList: List<Pair<Int, String>>,style:Style):this(dataList){
        this.style = style
    }

    class ViewHolder(val view:View): RecyclerView.ViewHolder(view){
        val textView: TextView
        val icon: ImageView

        init {
            textView = view.findViewById(R.id.textView)
            icon = view.findViewById(R.id.icon)

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
        holder.icon.setImageResource(dataList[p].first)
        holder.textView.text = dataList[p].second
        holder.textView

        style?.textSize?.let{holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,it)}
        style?.textColor?.let{holder.textView.setTextColor(it)}

//        if(p == 0) {
//            val c = ConstraintSet()
//            val context = holder.view.context
//            c.clone(holder.view as ConstraintLayout)
//            c.clear(R.id.icon,ConstraintSet.TOP)
////            c.applyTo(holder.view as ConstraintLayout)
//            val m = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,32f,context.resources.displayMetrics)
//            c.connect(R.id.icon, ConstraintSet.TOP, R.id.upperView, ConstraintSet.BOTTOM, m.toInt())
//            c.applyTo(holder.view as ConstraintLayout)
//        }

    }

    override fun getItemCount(): Int = dataList.size
}