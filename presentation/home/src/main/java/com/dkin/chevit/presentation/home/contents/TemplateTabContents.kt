package com.dkin.chevit.presentation.home.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.home.HomeViewModel
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitButtonFillMedium
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowRight
import com.dkin.chevit.presentation.resource.icon.IconFilterFill

@Composable
fun TemplateTabContents(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
) {
    Column(modifier = modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(start = 24.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "내 템플릿",
                style = ChevitTheme.typhography.headlineMedium.copy(
                    color = ChevitTheme.colors.textPrimary,
                ),
            )
            Icon(
                imageVector = ChevitIcon.IconFilterFill,
                contentDescription = "",
            )
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f), contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier
                        .size(140.dp),
                    painter = painterResource(id = R.drawable.ic_empty_template),
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "생성된 항목이 없어요\n나만의 템플릿을 만들어 보아요!",
                    textAlign = TextAlign.Center,
                    style = ChevitTheme.typhography.bodyLarge.copy(
                        color = ChevitTheme.colors.textSecondary
                    )
                )
                Spacer(modifier = Modifier.height(18.dp))
                ChevitButtonFillMedium(
                    modifier = Modifier.size(width = 187.dp, height = 54.dp),
                    onClick = { homeViewModel.onClickAddTemplate() }
                ) {
                    Text(text = "추가하기")
                }
            }

        }
    }
}
