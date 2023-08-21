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
import com.dkin.chevit.presentation.home.icon.Home
import com.dkin.chevit.presentation.home.icon.HomeIcons
import com.dkin.chevit.presentation.home.icon.HomeSelected
import com.dkin.chevit.presentation.home.icon.Search
import com.dkin.chevit.presentation.home.icon.SearchSelected
import com.dkin.chevit.presentation.home.icon.Survey
import com.dkin.chevit.presentation.home.icon.SurveySelected
import com.dkin.chevit.presentation.home.icon.User
import com.dkin.chevit.presentation.home.icon.UserSelected
import com.dkin.chevit.presentation.home.textDp

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    tabList: List<String>,
    onChangeTab: (index: Int) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(81.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomIconMenu(
            modifier = Modifier.weight(1f),
            activeImage = HomeIcons.HomeSelected,
            inactiveImage = HomeIcons.Home,
            desc = tabList[0],
            selected = selectedIndex == 0,
            onClickItem = { onChangeTab(0) }
        )
        BottomIconMenu(
            modifier = Modifier.weight(1f),
            activeImage = HomeIcons.SearchSelected,
            inactiveImage = HomeIcons.Search,
            desc = tabList[1],
            selected = selectedIndex == 1,
            onClickItem = { onChangeTab(1) }
        )
        BottomIconMenu(
            modifier = Modifier.weight(1f),
            activeImage = HomeIcons.SurveySelected,
            inactiveImage = HomeIcons.Survey,
            desc = tabList[2],
            selected = selectedIndex == 2,
            onClickItem = { onChangeTab(2) }
        )
        BottomIconMenu(
            modifier = Modifier.weight(1f),
            activeImage = HomeIcons.UserSelected,
            inactiveImage = HomeIcons.User,
            desc = tabList[3],
            selected = selectedIndex == 3,
            onClickItem = { onChangeTab(3) }
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
    onClickItem: () -> Unit
) {
    Column(
        modifier = modifier.clickable { onClickItem() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(imageVector = if (selected) activeImage else inactiveImage, contentDescription = desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier,
            text = desc,
            fontSize = 14.textDp,
            lineHeight = 18.textDp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
        )
    }
}