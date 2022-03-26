package com.fundevs.mathviewer

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient

class MathViewer : WebView {

    private val textSizeDefault = 14
    private val textColorDefault = "#000000"
    private var pageLoaded = false
    private var formula: String = ""
    private var textSize: Int = 16
    private var textColor: String = ""

    constructor(context: Context) : super(context) {
        initialized()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initialized()
    }

    private fun initialized() {
        setBackgroundColor(Color.TRANSPARENT)
        setTextSize(textSizeDefault)
        setTextColor(textColorDefault)
        isClickable = false
        isLongClickable = false
        isVerticalScrollBarEnabled = false
        isHorizontalScrollBarEnabled = false
        settings.javaScriptEnabled = true

        webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                pageLoaded = true
                updateTextColor()
                updateTextSize()
                updateFormula()
            }
        }

        loadUrl("file:///android_asset/mathscribe/formula_view.html")
    }

    private fun updateFormula() {
        if (pageLoaded) {
            loadUrl("javascript:setText(\"$$$formula$$\")")
        }
    }

    private fun updateTextSize() {
        if (pageLoaded) {
            loadUrl("javascript:setTextSize($textSize)")
        }
    }

    private fun updateTextColor() {
        if (pageLoaded) {
            loadUrl("javascript:setTextColor(\"$textColor\"  )")
        }
    }

    fun setFormula(formula: String) {
        this.formula = formula
    }

    fun setTextSize(textSize: Int) {
        this.textSize = textSize
    }

    fun setTextColor(textColor: String) {
        this.textColor = textColor
    }

}