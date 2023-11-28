package com.dkin.chevit.presentation.checklist.template.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.dkin.chevit.presentation.checklist.main.contents.CategoryListContents
import com.dkin.chevit.presentation.checklist.template.model.TemplateDetailState
import com.dkin.chevit.presentation.resource.ChevitButtonFillMedium
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun TemplateDetailContents(
    templateDetail: TemplateDetailState,
    onClickBack: () -> Unit,
    onClickCategory: (categoryId: String) -> Unit,
    onClickBringTemplate: () -> Unit,
) {
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
                text = templateDetail.templateName,
                textAlign = TextAlign.Center,
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(color = ChevitTheme.colors.grey0)
        )
        if (templateDetail.categories.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier
                            .size(130.dp),
                        painter = painterResource(id = R.drawable.ic_empty_checklist_template),
                        contentDescription = "",
                    )
                    Text(
                        text = "작성한 카테고리가 없어요!\n카테고리를 추가하여 쉽게 관리해 보세요.",
                        textAlign = TextAlign.Center,
                        style = ChevitTheme.typhography.bodyLarge.copy(
                            color = ChevitTheme.colors.textSecondary
                        )
                    )
                }
            }
        } else {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                text = "체크리스트 템플릿",
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
            )
            Spacer(modifier = Modifier.height(20.dp))
            CategoryListContents(
                modifier = Modifier.weight(1f),
                categories = templateDetail.categories,
                onClickCategory = onClickCategory
            )
            Box(modifier = Modifier.padding(24.dp)) {
                ChevitButtonFillMedium(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    onClick = { onClickBringTemplate() }
                ) {
                    Text(text = "불러오기")
                }
            }
        }
    }

}