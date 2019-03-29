package com.barisatalay.simpledialog.model

import android.text.Html
import android.text.SpannableString
import android.text.Spanned

internal class mdlDialog {
    private var title: String? = null

    private var description: String? = null

    private var buttonTitle: String? = null

    private var isHtml = false

    var titleColor: Int = 0
    var messageColor: Int = 0
    var buttonColor: Int = 0

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getDescription(): Spanned {
        return if (isHtml)
            textToHtml(description)
        else
            SpannableString(description)
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getButtonTitle(): String? {
        return buttonTitle
    }

    fun setButtonTitle(buttonTitle: String) {
        this.buttonTitle = buttonTitle
    }

    fun isHtml(): Boolean {
        return isHtml
    }

    fun setHtml(html: Boolean) {
        isHtml = html
    }

    fun textToHtml(pValue: String?): Spanned {
        return if (android.os.Build.VERSION.SDK_INT < 24) {
            Html.fromHtml(pValue)
        } else {
            Html.fromHtml(pValue, Html.FROM_HTML_MODE_COMPACT)
        }
    }
}