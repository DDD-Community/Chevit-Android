package com.dkin.chevit.presentation.home.contents.user

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.DeepLink.Companion
import com.dkin.chevit.presentation.home.model.Terms
import com.dkin.chevit.presentation.resource.ChevitBottomsheet
import com.dkin.chevit.presentation.resource.ChevitDialog
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun UserTabContents(
    modifier: Modifier = Modifier,
    myViewModel: MyPageViewModel,
    versionName: String,
    openMyCheckList: () -> Unit
) {
    val myPageState by myViewModel.state.collectAsState()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "user") {
        composable("user") {
            UserContents(
                modifier = modifier,
                myViewModel = myViewModel,
                versionName = versionName,
                myPageState = myPageState,
                onClickMyCheckList = { openMyCheckList() },
                onClickSignOut = { navController.navigate("signOut") },
                onClickWithdraw = { navController.navigate("withdraw") }
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
                    onClickCancel = { myViewModel.dispatch(MyPageIntent.SignOutClicked) },
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
                    onClickCancel = { myViewModel.dispatch(MyPageIntent.WithDrawClicked) },
                    onClickConfirm = { navController.popBackStack() },
                )
            }
        }
        dialog(
            route = "chevit://terms",
            dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            val itemList = listOf(Terms.SERVICE, Terms.PRIVACY)
            TermsSelectorBottomSheet(
                itemList = itemList,
                onClickItem = { item ->
                    navController.popBackStack()
                    myViewModel.dispatch(MyPageIntent.TermsBottomSheetClicked(item))
                },
                onClose = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun TermsSelectorBottomSheet(
    itemList: List<Terms>,
    onClickItem: (item: Terms) -> Unit,
    onClose: () -> Unit
) {
    ChevitBottomsheet(
        modifier = Modifier.fillMaxSize(),
        onClickBackground = onClose
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            itemList.forEach {
                TermsItem(item = it, onClickItem = onClickItem)
            }
        }
    }
}

@Composable
fun TermsItem(
    item: Terms,
    onClickItem: (item: Terms) -> Unit,
) {
    Column(modifier = Modifier.clickable { onClickItem(item) }) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = item.title,
            style = ChevitTheme.typhography.headlineSmall.copy(color = ChevitTheme.colors.textPrimary),
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
}
