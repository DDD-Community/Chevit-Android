package com.dkin.chevit.presentation.auth

import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.dkin.chevit.core.base.ViewBindingListAdapter
import com.dkin.chevit.presentation.auth.databinding.HolderIntroBinding

class IntroAdapter : ViewBindingListAdapter<HolderIntroBinding, IntroPagerUiModel>(
    diffCallback = diffCallback,
    inflater = HolderIntroBinding::inflate,
) {
    override val bindItem: HolderIntroBinding.(IntroPagerUiModel) -> Unit = { item ->
        ivIntro.load(item.imageRes)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<IntroPagerUiModel>() {
            override fun areItemsTheSame(
                oldItem: IntroPagerUiModel,
                newItem: IntroPagerUiModel,
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: IntroPagerUiModel,
                newItem: IntroPagerUiModel,
            ): Boolean = oldItem == newItem
        }
    }
}
