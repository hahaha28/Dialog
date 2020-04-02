package `fun`.inaction.dialog

import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.ViewGroup

open class BaseDialog(val context:Context) {

    private val dialogHelper = DialogHelper(context)

    /**
     * 上中下视图的容器
     */
    val headerContainer = dialogHelper.headerContainer
    val contentContainer = dialogHelper.contentContainer
    val footerContainer = dialogHelper.footerContainer

    fun setHeader(header:ViewAdapter?){
        dialogHelper.header = header
    }

    fun setContent(content:ViewAdapter?){
        dialogHelper.content = content
    }

    fun setFooter(footer:ViewAdapter?){
        dialogHelper.footer = footer
    }

    /**
     * 设置对话框出现的位置
     */
    fun setGravity(gravity:Int){
        dialogHelper.gravity = gravity
    }

    /**
     * 设置对话框的圆角
     * @param top 顶部的两个圆角
     * @param bottom 底部的两个圆角
     */
    fun setCorner(top:Int,bottom:Int){
        dialogHelper.topCornerRadius = top
        dialogHelper.bottomCornerRadius = bottom
    }

    /**
     * 设置对话框的大小
     */
    fun setLayoutParams(params: ViewGroup.LayoutParams){
        dialogHelper.rootViewLayoutParams = params
    }

    /**
     * 设置对话框进场动画
     * @param resId 动画文件的id
     */
    fun setEnterAnimation(resId:Int){
        dialogHelper.enterAnimId = resId
    }

    /**
     * 设置对话框退场动画
     * @param resId 动画文件的id
     */
    fun setExitAnimation(resId:Int){
        dialogHelper.exitAnimId = resId
    }

    /**
     * 显示对话框
     */
    fun show() = dialogHelper.show()

    /**
     * 移除对话框
     */
    fun dismiss() = dialogHelper.dismiss()

    /**
     * 设置对话框能否通过点击返回按钮取消
     */
    fun setCancelable(flag:Boolean) = dialogHelper.setCancelable(flag)

    /**
     * 设置对话框能否通过点击外部取消
     */
    fun setCanceledOnTouchOutside(cancel:Boolean) = dialogHelper.setCanceledOnTouchOutside(cancel)

    /**
     * 设置对话框的消失的监听
     */
    fun setOnDismissListener(l:(dialog:DialogInterface)->Unit)
            = dialogHelper.setOnDismissListener(l)

    /**
     * 设置对话框出现的监听
     */
    fun setOnShowListener(l:(dialog:DialogInterface)->Unit) = dialogHelper.setOnShowListener(l)

}