package com.dkin.chevit.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.home.HomeTab
import com.dkin.chevit.presentation.home.textDp
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.Home
import com.dkin.chevit.presentation.resource.icon.HomeSelected
import com.dkin.chevit.presentation.resource.icon.Search
import com.dkin.chevit.presentation.resource.icon.SearchSelected
import com.dkin.chevit.presentation.resource.icon.Survey
import com.dkin.chevit.presentation.resource.icon.SurveySelected
import com.dkin.chevit.presentation.resource.icon.User
import com.dkin.chevit.presentation.resource.icon.UserSelected

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    selectedItem: HomeTab,
    onChangeTab: (item: HomeTab) -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(81.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BottomIconMenu(
            modifier = Modifier.weight(1f),
            activeImage = ChevitIcon.HomeSelected,
            inactiveImage = ChevitIcon.Home,
            desc = HomeTab.HOME.desc,
            selected = selectedItem == HomeTab.HOME,
            onClickItem = { onChangeTab(HomeTab.HOME) },
        )
//        BottomIconMenu(
//            modifier = Modifier.weight(1f),
//            activeImage = ChevitIcon.SearchSelected,
//            inactiveImage = ChevitIcon.Search,
//            desc = HomeTab.SEARCH.desc,
//            selected = selectedItem == HomeTab.SEARCH,
//            onClickItem = { onChangeTab(HomeTab.SEARCH) },
//        )
        BottomIconMenu(
            modifier = Modifier.weight(1f),
            activeImage = ChevitIcon.SurveySelected,
            inactiveImage = ChevitIcon.Survey,
            desc = HomeTab.TEMPLATE.desc,
            selected = selectedItem == HomeTab.TEMPLATE,
            onClickItem = { onChangeTab(HomeTab.TEMPLATE) },
        )
        BottomIconMenu(
            modifier = Modifier.weight(1f),
            activeImage = ChevitIcon.UserSelected,
            inactiveImage = ChevitIcon.User,
            desc = HomeTab.USER.desc,
            selected = selectedItem == HomeTab.USER,
            onClickItem = { onChangeTab(HomeTab.USER) },
        )
    }
}

@Composable
private fun BottomIconMenu(
    modifier: Modifier = Modifier,
    activeImage: ImageVector,
    inactiveImage: ImageVector,
    desc: String,
    selected: Boolean,
    onClickItem: () -> Unit,
) {
    Column(
        modifier = modifier.clickable { onClickItem() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(imageVector = if (selected) activeImage else inactiveImage, contentDescription = desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier,
            text = desc,
            fontSize = 14.textDp,
            lineHeight = 18.textDp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
            color = if (selected) ChevitTheme.colors.grey10 else ChevitTheme.colors.grey4,
        )
    }
}
