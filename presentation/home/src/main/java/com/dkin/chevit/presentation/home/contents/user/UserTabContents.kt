package com.dkin.chevit.presentation.home.contents.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.dkin.chevit.presentation.home.MyPageViewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dkin.chevit.presentation.home.HomeViewModel

@Composable
fun UserTabContents(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    myViewModel: MyPageViewModel,
    versionName: String,
) {
    val myPageState by myViewModel.state.collectAsState()
    val homeState by homeViewModel.state.collectAsState()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "user") {
        composable("user") {
            UserContents(
                modifier = modifier,
                myViewModel = myViewModel,
                versionName = versionName,
                myPageState = myPageState,
                onClickMyCheckList = { navController.navigate("myCheckList") },
            )
        }
        composable("myCheckList") {
            homeViewModel.refreshMyCheckList()
            MyCheckListContents(
                onClickBack = { navController.popBackStack() },
                checkList = homeState.checkList,
                onClickChecklist = { id -> homeViewModel.onClickChecklist(id) }
            )
        }
    }
}
