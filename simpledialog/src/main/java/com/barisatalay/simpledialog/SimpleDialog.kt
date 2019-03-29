package com.barisatalay.simpledialog

import android.app.Activity
import com.barisatalay.simpledialog.model.mdlStyle
import com.barisatalay.simpledialog.ui.DialogActivity

class SimpleDialog(private val activity: Activity) {
    private var style: mdlStyle? = null

    fun show(title: String, message: String, buttonText:String, isHtml: Boolean){
        activity.runOnUiThread {
            activity.startActivity(
                DialogActivity.newInstance(
                    activity,
                    title,
                    message,
                    buttonText,
                    isHtml,
                    style)
            )
        }
    }

    fun show(title: String, message: String, buttonText:String){
        show(title,message,buttonText, false)
    }

    fun style(style: mdlStyle): SimpleDialog{
        this.style = style

        return this
    }
}