package com.pl.wechat.app.utils

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.pl.wechat.R

/**
 * Created by zbc on 2019/5/10 0010.
 * description：
 */
class DialogUtils {

    companion object {
        fun getBottomDialog(context: Context): Dialog {
            val dialog = Dialog(context, R.style.DialogBottomStyle)
            dialog.setContentView(R.layout.dialog_group_chat_setting)
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            val window: Window? = dialog.window
            window!!.setGravity(Gravity.BOTTOM)
            window.setWindowAnimations(R.style.DialogBottomAnim)
            val params: WindowManager.LayoutParams = window.attributes
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            window.attributes = params
            return dialog
        }
    }
}