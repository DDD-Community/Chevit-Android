package com.dkin.chevit.presentation.home.contents.template.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.window.DialogProperties
import androidx.fragment.app.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navArgument
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import com.dkin.chevit.presentation.home.R
import com.dkin.chevit.presentation.home.contents.template.MoreBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TemplateDetail :
    MVIComposeFragment<TemplateDetailIntent, TemplateDetailState, TemplateDetailEffect>() {
    override val viewModel: TemplateDetailViewModel by viewModels()

    private lateinit var planId: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "detail") {
                    composable("detail") {
                        TemplateDetailScreen(
                            modifier = Modifier.fillMaxSize(),
                            viewModel = viewModel,
                            onClickBack = { findNavController().popBackStack() },
                            openCategoryMoreSheet = { id, title, type ->
                                navController.navigate("categoryMore/${id}?title=${title}?type=${type.name}")
                            }
                        )
                    }
                    dialog(
                        route = "categoryMore/{categoryId}?title={title}?type={type}",
                        arguments = listOf(
                            navArgument("categoryId") { type = NavType.StringType },
                            navArgument("title") { type = NavType.StringType; defaultValue = "" },
                            navArgument("type") { type = NavType.StringType; defaultValue = "" },
                        ),
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false),
                    ) {
                        val categoryId = it.arguments?.getString("categoryId") ?: ""
                        val title = it.arguments?.getString("title") ?: ""
                        val type = it.arguments?.getString("type") ?: ""
                        MoreBottomSheet(
                            title = title,
                            navigateEditItem = {
                                navController.popBackStack()
                                deepLink(
                                    DeepLink.EditCategory(
                                        planId = planId,
                                        categoryId = categoryId,
                                        title = title,
                                        type = type
                                    )
                                ) { popUpTo(R.id.templateDetail) }
                            },
                            deleteItem = {
                                navController.popBackStack()
                                viewModel.dispatch(TemplateDetailIntent.DeleteCategory(categoryId))
                            },
                            onClose = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("planId")
        id?.let {
            planId = it
            viewModel.dispatch(TemplateDetailIntent.InitTemplateDetail(it))
        } ?: findNavController().popBackStack()
    }

    override fun processEffect(effect: TemplateDetailEffect) {
        when (effect) {
            TemplateDetailEffect.NavigateToAddCategory -> {
                deepLink(
                    DeepLink.AddCategory(
                        planId = planId,
                    )
                ) { popUpTo(R.id.templateDetail) }
            }

            is TemplateDetailEffect.NavigateToChecklistDetail -> {
                deepLink(
                    DeepLink.CheckListDetail(
                        planId = planId,
                        categoryId = effect.categoryId
                    )
                ) { popUpTo(R.id.templateDetail) }
            }

            TemplateDetailEffect.DeleteCategoryFailed ->
                Toast.makeText(requireContext(), "카테고리 삭제에 실패하였습니다.", Toast.LENGTH_SHORT).show()


            TemplateDetailEffect.GetTemplateFail ->
                Toast.makeText(requireContext(), "템플릿을 가져오지 못했습니다.", Toast.LENGTH_LONG).show()
        }
    }

    override fun processState(state: TemplateDetailState) {}
}