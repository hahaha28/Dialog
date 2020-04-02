package `fun`.inaction.dialog

import android.content.Context
import android.graphics.Point
import android.view.Gravity
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager

/**
 * 位置为中间的对话框的基类
 */
open class CenterDialog(context:Context): BaseDialog(context) {

    init {
        // 居中
        setGravity(Gravity.CENTER)
        // 圆角
        setCorner(25,25)

        //获取屏幕大小
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val screenSize = Point()
        wm.defaultDisplay.getSize(screenSize)
        // 设置宽高
        val lp = ViewGroup.LayoutParams(screenSize.x/5*4,WRAP_CONTENT)
        setLayoutParams(lp)

        // 设置动画
        setEnterAnimation(R.anim.center_enter)
        setExitAnimation(R.anim.center_exit)
    }
}