package com.barisatalay.simpledialog.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.barisatalay.simpledialog.R
import com.barisatalay.simpledialog.model.mdlDialog
import com.barisatalay.simpledialog.model.mdlStyle
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity: AppCompatActivity() {
    private val dialog = mdlDialog()

    companion object {
        fun newInstance(
            mContext: Context,
            title: String,
            description: String,
            buttonTitle: String,
            isHtml: Boolean,
            style: mdlStyle?
        ): Intent {
            val intent = Intent(mContext, DialogActivity::class.java)
            intent.putExtra("DialogTitle", title)
            intent.putExtra("DialogDescription", description)
            intent.putExtra("DialogButtonTitle", buttonTitle)
            intent.putExtra("isHtml", isHtml)
            style?.let {
                intent.putExtra("TitleColor", style.titleColor)
                intent.putExtra("MessageColor", style.messageColor)
                intent.putExtra("ButtonColor", style.buttonColor)
            }
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            return intent
        }
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_dialog)
        catchExtras()

        dialog_title.text = dialog.getTitle()
        dialog_description.text = dialog.getDescription()
        button_title.text = dialog.getButtonTitle()

        setStyles()

        button_title.setOnClickListener {
            finish()
        }
    }

    private fun setStyles() {
        if (dialog.titleColor != 0)
            dialog_title.setTextColor(ContextCompat.getColor(applicationContext, dialog.titleColor))

        if (dialog.messageColor != 0)
            dialog_description.setTextColor(ContextCompat.getColor(applicationContext, dialog.messageColor))

        if (dialog.buttonColor != 0)
            button_title.setTextColor(ContextCompat.getColor(applicationContext, dialog.buttonColor))
    }

    private fun catchExtras() {
        if (intent.hasExtra("isHtml"))
            intent?.extras?.getBoolean("isHtml", false)?.let { dialog.setHtml(it) }

        if (intent.hasExtra("DialogTitle"))
            intent?.extras?.getString("DialogTitle", "")?.let { dialog.setTitle(it) }

        if (intent.hasExtra("DialogDescription"))
            intent?.extras?.getString("DialogDescription", "")?.let { dialog.setDescription(it) }

        if (intent.hasExtra("DialogButtonTitle"))
            intent?.extras?.getString("DialogButtonTitle", "")?.let { dialog.setButtonTitle(it) }

        if (intent.hasExtra("TitleColor"))
            intent?.extras?.getInt("TitleColor")?.let { dialog.titleColor = it }

        if (intent.hasExtra("MessageColor"))
            intent?.extras?.getInt("MessageColor")?.let { dialog.messageColor = it }

        if (intent.hasExtra("ButtonColor"))
            intent?.extras?.getInt("ButtonColor")?.let { dialog.buttonColor = it }
    }

    override fun onBackPressed() {}
}