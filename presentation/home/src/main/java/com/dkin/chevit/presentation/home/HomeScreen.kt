package com.dkin.chevit.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.home.component.BottomNavigation
import com.dkin.chevit.presentation.home.contents.HomeTabContents
import com.dkin.chevit.presentation.home.contents.SearchTabContents
import com.dkin.chevit.presentation.home.contents.template.TemplateTabContents
import com.dkin.chevit.presentation.home.contents.template.TemplateViewModel
import com.dkin.chevit.presentation.home.contents.user.MyPageViewModel
import com.dkin.chevit.presentation.home.contents.user.UserTabContents
import com.dkin.chevit.presentation.resource.ChevitTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    templateViewModel: TemplateViewModel,
    myPageViewModel: MyPageViewModel,
    versionName: String,
    initialPage: Int,
    openMyCheckList: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = initialPage)
    val tabIndex = pagerState.currentPage
    val tabList: List<HomeTab> =
        listOf(HomeTab.HOME, HomeTab.TEMPLATE, HomeTab.USER)

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            state = pagerState,
            pageCount = tabList.size,
            userScrollEnabled = false,
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                when (tabList[it]) {
                    HomeTab.HOME -> HomeTabContents(homeViewModel = homeViewModel)
                    HomeTab.SEARCH -> SearchTabContents()
                    HomeTab.TEMPLATE -> TemplateTabContents(
                        templateViewModel = templateViewModel
                    )
                    HomeTab.USER -> UserTabContents(
                        myViewModel = myPageViewModel,
                        versionName = versionName,
                        openMyCheckList = openMyCheckList
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = ChevitTheme.colors.grey1),
        )
        BottomNavigation(
            modifier = Modifier.fillMaxWidth(),
            selectedItem = tabList[tabIndex],
        ) { item ->
            scope.launch {
                val target = tabList.indexOfFirst { item == it }
                pagerState.scrollToPage(target)
            }
        }
    }
}

enum class HomeTab(val desc: String) {
    HOME("홈"), SEARCH("탐색"), TEMPLATE("템플릿"), USER("내정보")
}
