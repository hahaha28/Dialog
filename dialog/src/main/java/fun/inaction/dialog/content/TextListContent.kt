package `fun`.inaction.dialog.content

import `fun`.inaction.dialog.R
import `fun`.inaction.dialog.ViewAdapter
import `fun`.inaction.dialog.content.listadapters.TextListAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TextListContent(private val parent:ViewGroup): ViewAdapter {

    /**
     * 布局的View
     */
    private val view: View

    /**
     * 展示的textList
     */
    private var textList: List<String> = listOf()

    /**
     * 打对勾的位置
     */
    private var rightPosition = 0

    /**
     * RecyclerView
     */
    private val recyclerView: RecyclerView
    private val layoutManager: LinearLayoutManager

    /**
     * TextStyle
     */
    private val textStyle: TextStyle = TextStyle()

    /**
     * 点击事件
     */
    var onItemClickListener: (v:View,position:Int)->Unit = { _:View, _:Int->}

    init {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_list,parent,false)
        recyclerView = view.findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(parent.context)
    }

    override fun getView(): View {
        val adapter =TextListAdapter(textList,textStyle,rightPosition)
        recyclerView.adapter = adapter
        adapter.onItemClickListener = onItemClickListener
        recyclerView.layoutManager = layoutManager
        return view
    }

    /**
     * 设置显示数据
     * @param textList 文字列表
     * @param rightPosition 对勾的位置，可以-1不显示
     */
    fun setData(textList: List<String>, rightPosition: Int = -1) {
        this.textList = textList
        this.rightPosition = rightPosition
    }

    /**
     * 设置列表中文字的大小，单位为sp
     */
    fun setTextSize(textSize: Float){
        textStyle.size = textSize
    }

    /**
     * 设置列表中文字的颜色
     */
    fun setTextColor(color:Int){
        textStyle.color = color
    }

    /**
     * 设置列表中文字的位置，默认为 Gravity.CENTER
     */
    fun setTextGravity(gravity: Int){
        textStyle.gravity = gravity
    }

    class TextStyle{
        var size: Float? = null
        var color: Int? = null
        var gravity: Int? = null
    }

}