package com.dkin.chevit.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.home.component.BottomNavigation
import com.dkin.chevit.presentation.home.component.HomeTopBar
import com.dkin.chevit.presentation.home.contents.HomeTabContents
import com.dkin.chevit.presentation.home.contents.SearchTabContents
import com.dkin.chevit.presentation.home.contents.TemplateTabContents
import com.dkin.chevit.presentation.home.contents.UserTabContents
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0)
    val tabIndex = pagerState.currentPage
    val tabList: List<HomeTab> =
        listOf(HomeTab.HOME, HomeTab.SEARCH, HomeTab.TEMPLATE, HomeTab.USER)

    Scaffold(
        modifier = modifier,
        topBar = { HomeTopBar() },
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            HorizontalPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                state = pagerState,
                pageCount = tabList.size
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    when (tabList[it]) {
                        HomeTab.HOME -> HomeTabContents()
                        HomeTab.SEARCH -> SearchTabContents()
                        HomeTab.TEMPLATE -> TemplateTabContents()
                        HomeTab.USER -> UserTabContents()
                    }
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.Gray))
            BottomNavigation(
                modifier = Modifier.fillMaxWidth(),
                selectedIndex = tabIndex,
                tabList = tabList.map { it.desc },
                onChangeTab = {
                    scope.launch {
                        pagerState.animateScrollToPage(it)
                    }
                })
        }
    }
}

enum class HomeTab(val desc: String) {
    HOME("홈"), SEARCH("탐색"), TEMPLATE("템플릿"), USER("내정보")
}
