package com.dkin.chevit.presentation.checklist.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navArgument
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.checklist.main.Checklist
import com.dkin.chevit.presentation.checklist.template.contents.TemplateDetailContents
import com.dkin.chevit.presentation.checklist.template.contents.TemplateCategoryDetailContents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BringTemplate :
    MVIComposeFragment<BringTemplateIntent, BringTemplateState, BringTemplateEffect>() {
    override val viewModel: BringTemplateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        BringTemplateScreen(
                            modifier = Modifier.fillMaxSize(),
                            viewModel = viewModel,
                            onClickBack = { findNavController().popBackStack() },
                            onClickTemplate = { id -> navController.navigate("categoryList/$id") }
                        )
                    }
                    composable(
                        route = "categoryList/{templateId}",
                        arguments = listOf(
                            navArgument("templateId") { type = NavType.StringType },
                        )
                    ) {
                        val templateId = it.arguments?.getString("templateId") ?: ""
                        viewModel.dispatch(BringTemplateIntent.GetTemplate(templateId))
                        val templateDetail by viewModel.templateState.collectAsState()
                        TemplateDetailContents(
                            templateDetail = templateDetail,
                            onClickBack = { navController.popBackStack() },
                            onClickCategory = { categoryId ->
                                navController.navigate("checklistDetail/${templateId}/${categoryId}")
                            },
                            onClickBringTemplate = { viewModel.dispatch(BringTemplateIntent.BringTemplate(templateId)) }
                        )
                    }
                    composable(
                        route = "checklistDetail/{templateId}/{categoryId}",
                        arguments = listOf(
                            navArgument("templateId") { type = NavType.StringType },
                            navArgument("categoryId") { type = NavType.StringType },
                        )
                    ) {
                        val templateId = it.arguments?.getString("templateId") ?: ""
                        val categoryId = it.arguments?.getString("categoryId") ?: ""
                        viewModel.dispatch(BringTemplateIntent.GetCategory(templateId, categoryId))
                        val categoryDetail by viewModel.detailState.collectAsState()
                        TemplateCategoryDetailContents(
                            categoryDetail = categoryDetail,
                            onClickBack = { navController.popBackStack() }
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
            viewModel.initTemplateList(it)
        } ?: findNavController().popBackStack()
    }

    override fun processEffect(effect: BringTemplateEffect) {
        when (effect) {
            BringTemplateEffect.BringTemplateFail -> {
                Toast.makeText(requireContext(), "템플릿 불러오기에 실패하였습니다.", Toast.LENGTH_LONG).show()
            }

            BringTemplateEffect.BringTemplateSuccess -> {
                Toast.makeText(requireContext(), "선택한 템플릿이 성공적으로 추가되었습니다.", Toast.LENGTH_LONG)
                    .show()
                setFragmentResult(
                    Checklist.BRING_TEMPLATE_RESULT,
                    bundleOf(Checklist.BRING_TEMPLATE_RESULT to true)
                )
                findNavController().popBackStack()
            }

            BringTemplateEffect.GetTemplateListFail -> {
                Toast.makeText(requireContext(), "템플릿 리스트를 가져오지 못했습니다.", Toast.LENGTH_LONG).show()
            }

            BringTemplateEffect.GetTemplateFail -> {
                Toast.makeText(requireContext(), "템플릿을 가져오지 못했습니다.", Toast.LENGTH_LONG).show()
            }

            BringTemplateEffect.GetCategoryFail -> {
                Toast.makeText(requireContext(), "체크리스트를 가져오지 못했습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun processState(state: BringTemplateState) {}
}