package com.youtubeclone.app.utils

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun ViewGroup.inflateView(@LayoutRes resId: Int): View {
    return LayoutInflater.from(this.context).inflate(resId, this, false)
}

fun ImageView.loadFromUrl(imgUrl: String?) {
    Glide.with(this)
        .load(imgUrl)
        .into(this)
}

fun SpannableString.withClickableSpan(
    clickablePart: String,
    onClickListener: () -> Unit
): SpannableString {
    val clickableSpan = object : ClickableSpan() {

        override fun onClick(widget: View) = onClickListener.invoke()
        override fun updateDrawState(ds: TextPaint) {
            ds.color = Color.rgb(26, 115, 232)
            ds.isUnderlineText = false
        }
    }
    val clickablePartStart = indexOf(clickablePart)
    setSpan(
        clickableSpan,
        clickablePartStart,
        clickablePartStart + clickablePart.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return this
}
