package `fun`.inaction.dialog.content

import `fun`.inaction.dialog.R
import `fun`.inaction.dialog.ViewAdapter
import `fun`.inaction.dialog.content.listadapters.IconTextListAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class IconTextListContent(private val parent: ViewGroup): ViewAdapter {

    private val view:View

    /**
     * 列表的数据，第一个为图标的id，第二个为文字
     */
    private var dataList:List<Pair<String,String>> = listOf()

    /**
     * 列表点击事件
     */
    var onItemClickListener:(v:View,position:Int)->Unit = {v:View,p:Int->}

    /**
     * RecyclerView
     */
    private val recyclerView: RecyclerView
    private val layoutManager: LinearLayoutManager

    /**
     * Style，用来设置view里文字大小什么的
     */
    var style:Style = Style()

    init{
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_list,parent,false)
        recyclerView = view.findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(parent.context)
        recyclerView.layoutManager = layoutManager
    }

    override fun getView(): View {
        val adapter = IconTextListAdapter(dataList,style)
        recyclerView.adapter = adapter
        adapter.onItemClickListener = onItemClickListener
        return view
    }

    /**
     * 设置数据
     * list集合中每一项是一个Pair
     * Pair的第一项是图片的id，第二项是显示的字符串
     */
    fun setData(list:List<Pair<String,String>>){
        dataList = list
    }

    /**
     * 设置文字大小，单位为 sp
     */
    fun setTextSize(size:Float){
        style.textSize = size
    }

    /**
     * 设置文字颜色
     */
    fun setTextColor(color:Int){
        style.textColor = color
    }



    class Style{
        var textSize: Float? = null
        var textColor: Int? = null
    }

}