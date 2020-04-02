package `fun`.inaction.dialog

import `fun`.inaction.dialog.BaseDialog
import android.content.Context
import android.graphics.Point
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager

open class BottomDialog(context:Context): BaseDialog(context) {

    init {
        // 位置为底部
        setGravity(Gravity.BOTTOM)
        // 圆角
        setCorner(45,0)

        //获取屏幕大小
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val screenSize = Point()
        wm.defaultDisplay.getSize(screenSize)
        // 设置宽高
        val lp = ViewGroup.LayoutParams(screenSize.x, ViewGroup.LayoutParams.WRAP_CONTENT)
        setLayoutParams(lp)
        
        // 设置动画
        setEnterAnimation(R.anim.bottom_enter)
        setExitAnimation(R.anim.bottom_exit)
    }
}