package `fun`.inaction.dialog

import `fun`.inaction.dialog.rclayout.RCRelativeLayout
import android.app.Dialog
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat

class DialogHelper(val mContext: Context) : Dialog(mContext) {

    /**
     * 对话框头部视图
     */
    var header: ViewAdapter? = null

    /**
     * 对话框中间视图
     */
    var content: ViewAdapter? = null

    /**
     * 对话框底部视图
     */
    var footer: ViewAdapter? = null

    /**
     * 对话框的圆角
     */
    var topCornerRadius: Int = 0
    var bottomCornerRadius: Int = 0

    /**
     * 对话框的位置，默认为中间
     */
    var gravity: Int = Gravity.CENTER

    /**
     * 对话框动画的id
     */
    var enterAnimId: Int? = null
    var exitAnimId: Int? = null

    private val decorView = window!!.decorView as FrameLayout

    private val rootView: View = layoutInflater //这是最上层（除decorView）的view
        .inflate(R.layout.base_container, decorView, false)

    var rootViewLayoutParams: ViewGroup.LayoutParams? = null

    val headerContainer =
        rootView.findViewById<ViewGroup>(R.id.kydialog_header_container)
    val contentContainer =
        rootView.findViewById<ViewGroup>(R.id.kydialog_content_container)
    val footerContainer =
        rootView.findViewById<ViewGroup>(R.id.kydialog_footer_container)


    override fun onCreate(savedInstanceState: Bundle?) {
        //设置Window位置
        window?.setGravity(gravity)
        //设置Window背景
        window?.setDimAmount(0.4f)


        //获取屏幕大小
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val screenSize = Point()
        wm.defaultDisplay.getSize(screenSize)

        //初始化decorView
        decorView.removeAllViews()
        decorView.setBackgroundColor(0x00000000)
        decorView.setPadding(0, 0, 0, 0)

        //设置rootView大小
        val defaultLayoutParams = ViewGroup.LayoutParams(screenSize.x/5*4,WRAP_CONTENT)
        rootView.layoutParams = rootViewLayoutParams?:defaultLayoutParams


        //获取RCLayout，设置圆角
        val rcRelativeLayout: RCRelativeLayout = rootView.findViewById(R.id.rclayout)
        rcRelativeLayout.setTopLeftRadius(topCornerRadius)
        rcRelativeLayout.setTopRightRadius(topCornerRadius)
        rcRelativeLayout.setBottomLeftRadius(bottomCornerRadius)
        rcRelativeLayout.setBottomRightRadius(bottomCornerRadius)

        decorView.addView(rootView) //添加rootView到decorView

        //设置顶部、内容、底部


        if (header != null) {
            headerContainer.addView(header!!.getView())
        }
        if (content != null) {
            contentContainer.addView(content!!.getView())
            Log.e("MyDebug","no null")
        }
        if (footer != null) {
            footerContainer.addView(footer!!.getView())
        }


        //设置动画
        enterAnimId?.let{
            val anim = AnimationUtils.loadAnimation(context,it)
            rootView.startAnimation(anim)
        }
    }

    override fun dismiss() {
        //退出动画

        if(exitAnimId != null){
            val anim = AnimationUtils.loadAnimation(context, exitAnimId!!)

            anim.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationRepeat(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    super@DialogHelper.dismiss()
                }

                override fun onAnimationStart(animation: Animation?) {

                }

            })
            rootView.startAnimation(anim)
        }else{
            super.dismiss()
        }
    }


}