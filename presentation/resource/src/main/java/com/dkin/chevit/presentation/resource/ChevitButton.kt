package com.dkin.chevit.presentation.resource

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.dkin.chevit.presentation.resource.databinding.ButtonBinding

class ChevitButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {
    private val binding = ButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val typedArray = attrs?.let {
            context.obtainStyledAttributes(it, R.styleable.ChevitButton)
        }
        val isEnabled = typedArray?.getBoolean(R.styleable.ChevitButton_isEnabled, true) ?: true
        val style = typedArray?.getInt(R.styleable.ChevitButton_style, 0) ?: 0
        val size = typedArray?.getInt(R.styleable.ChevitButton_size, 0) ?: 0
        val drawable = typedArray?.getDrawable(R.styleable.ChevitButton_drawable)
        val text = typedArray?.getString(R.styleable.ChevitButton_text)
        val buttonStyle = Style.valueOf(style)
        val buttonSize = Size.valueOf(size)

        binding.layoutBackground.isClickable = false
        binding.layoutBackground.isEnabled = isEnabled
        when (buttonStyle) {
            Style.FILL -> R.drawable.bg_button_filled
            Style.OUTLINE -> R.drawable.bg_button_outline
        }.let(::setBackgroundResource)
        val fontSize = when (buttonSize) {
            Size.LARGE -> R.dimen.headline_medium
            Size.MEDIUM -> R.dimen.headline_small
        }.let(context.resources::getDimensionPixelSize)
        binding.tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize.toFloat())
        setDrawable(drawable)
        setText(text)
        typedArray?.recycle()
    }

    fun setDrawable(@DrawableRes drawableRes: Int?) = with(binding.ivIcon) {
        drawableRes?.let(::setImageResource)
        isVisible = drawableRes != null
    }

    fun setText(text: String?) {
        binding.tvTitle.text = text
    }

    fun setDrawable(drawable: Drawable?) = with(binding.ivIcon) {
        setImageDrawable(drawable)
        isVisible = drawable != null
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.layoutBackground.setOnClickListener(l)
    }

    enum class Style {
        FILL, OUTLINE;

        companion object {
            fun valueOf(value: Int) = values().find { it.ordinal == value } ?: FILL
        }
    }

    enum class Size {
        LARGE, MEDIUM;

        companion object {
            fun valueOf(value: Int) = values().find { it.ordinal == value } ?: LARGE
        }
    }
}
