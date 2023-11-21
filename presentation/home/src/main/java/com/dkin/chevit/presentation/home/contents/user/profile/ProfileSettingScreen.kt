package com.dkin.chevit.presentation.home.contents.user.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.icon.IconCameraFill
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun ProfileSettingScreen(
    viewModel: ProfileSettingViewModel,
    onClickBack: () -> Unit,
    onClickImage: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    var name by remember { mutableStateOf(state.name) }
    var imageUrl by remember { mutableStateOf(state.imageUrl) }
    var isValidInput by remember { mutableStateOf(false) }

    LaunchedEffect(name) {
        isValidInput = name.isNotBlank() && name.length < 8 && imageUrl.isNotBlank()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(vertical = 16.dp, horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickableNoRipple { onClickBack() },
                imageVector = ChevitIcon.IconArrowLeftLine,
                contentDescription = "",
            )
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "프로필 설정",
                textAlign = TextAlign.Center,
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
            )
        }
        Spacer(modifier = Modifier.height(92.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.clickableNoRipple { onClickImage() }) {
                Box(
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape)
                        .align(Alignment.Center),
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxWidth(),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(imageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        error = painterResource(id = R.drawable.ic_profile_empty)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(color = ChevitTheme.colors.black)
                        .align(Alignment.BottomEnd)
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ChevitIcon.IconCameraFill,
                        contentDescription = "",
                        tint = ChevitTheme.colors.white
                    )
                }
            }

            //TODO input
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            ChevitButtonFillLarge(
                modifier = Modifier.fillMaxWidth(),
                enabled = isValidInput,
                onClick = {
                    viewModel.saveProfile(name, imageUrl)
                }
            ) {
                Text(text = "저장하기")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}