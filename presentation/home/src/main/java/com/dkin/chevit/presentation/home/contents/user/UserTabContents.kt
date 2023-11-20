package com.dkin.chevit.presentation.home.contents.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import com.dkin.chevit.presentation.home.MyPageViewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.dkin.chevit.presentation.home.HomeViewModel
import com.dkin.chevit.presentation.resource.ChevitDialog
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

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
                onClickSignOut = { navController.navigate("signOut") },
                onClickWithdraw = { navController.navigate("withdraw") }
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
        dialog(
            route = "signOut",
            dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickableNoRipple { },
                contentAlignment = Alignment.Center
            ) {
                ChevitDialog(
                    title = "로그아웃 하시겠습니까?",
                    body = "로그아웃시\n소셜 로그인 연동이 해제됩니다.",
                    cancelBtnText = "로그아웃",
                    confirmBtnText = "취소",
                    onClickCancel = { myViewModel.signOut() },
                    onClickConfirm = { navController.popBackStack() },
                )
            }
        }
        dialog(
            route = "withdraw",
            dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickableNoRipple { },
                contentAlignment = Alignment.Center
            ) {
                ChevitDialog(
                    title = "정말 탈퇴하시겠습니까?",
                    body = "회원 탈퇴시 계정과 함께\n저장되어 있는 체크리스트가 삭제됩니다.",
                    cancelBtnText = "회원탈퇴",
                    confirmBtnText = "취소",
                    onClickCancel = { myViewModel.withdraw() },
                    onClickConfirm = { navController.popBackStack() },
                )
            }
        }
    }
}
