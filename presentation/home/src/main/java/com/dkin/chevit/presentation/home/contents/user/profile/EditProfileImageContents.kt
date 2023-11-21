package com.dkin.chevit.presentation.home.contents.user.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitBottomsheet
import com.dkin.chevit.presentation.resource.ChevitTheme

@Composable
fun EditProfileImageContents(
    viewModel: ProfileSettingViewModel,
    onClickBack: () -> Unit,
) {
    ChevitBottomsheet(
        modifier = Modifier.fillMaxSize(),
        onClickBackground = onClickBack
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.fillMaxWidth().clickable {
                    viewModel.openAlbum()
                    onClickBack()
                }
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "사진 보관함에서 선택",
                    style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = ChevitTheme.colors.grey0)
            )
            Column(
                modifier = Modifier.fillMaxWidth().clickable {
                    viewModel.resetProfileImage()
                    onClickBack()
                }
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "기본 이미지로 변경",
                    style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}