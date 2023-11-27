package com.dkin.chevit.presentation.home.contents.template

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dkin.chevit.presentation.resource.getTemplateColorByName

@Composable
fun TemplateTabContents(
    modifier: Modifier = Modifier,
    templateViewModel: TemplateViewModel,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "templateList") {
        composable("templateList") {
            TemplateListContents(
                modifier = modifier,
                templateViewModel = templateViewModel,
                navigateToAddTemplate = { navController.navigate("addTemplate") },
                navigateToSortTemplate = { navController.navigate("sortTemplate") },
                openEditBottomSheet = { id, title, color -> navController.navigate("moreTemplate/${id}?title=${title}?color=${color}") }
            )
        }
        dialog(
            route = "sortTemplate",
            dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            val sortType by templateViewModel.sortType.collectAsState()
            TemplateSortContents(
                selectedType = sortType,
                onClickType = { type -> templateViewModel.sortTemplate(type) },
                onClose = { navController.popBackStack() }
            )
        }
        dialog(
            route = "moreTemplate/{planId}?title={title}?color={color}",
            arguments = listOf(
                navArgument("planId") { type = NavType.StringType },
                navArgument("title") { type = NavType.StringType; defaultValue = "" },
                navArgument("color") { type = NavType.StringType; defaultValue = "" },
            ),
            dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            val planId = it.arguments?.getString("planId") ?: ""
            val title = it.arguments?.getString("title") ?: ""
            val color = it.arguments?.getString("color") ?: ""

            MoreTemplateBottomSheet(
                title = title,
                navigateEditItem = {
                    navController.navigate("editTemplate/${planId}?title=${title}?color=${color}")
                },
                deleteItem = { templateViewModel.removeTemplate(planId) },
                onClose = { navController.popBackStack() }
            )
        }
        dialog(
            route = "addTemplate",
            dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            AddTemplateBottomSheet(
                saveTemplate = { title, color -> templateViewModel.saveTemplate(title, color) },
                onClose = { navController.popBackStack() }
            )
        }
        dialog(
            route = "editTemplate/{planId}?title={title}?color={color}",
            arguments = listOf(
                navArgument("planId") { type = NavType.StringType },
                navArgument("title") { type = NavType.StringType; defaultValue = "" },
                navArgument("color") { type = NavType.StringType; defaultValue = "" },
            ),
            dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            val planId = it.arguments?.getString("planId") ?: ""
            val savedTitle = it.arguments?.getString("title") ?: ""
            val savedColor = it.arguments?.getString("color") ?: ""

            EditTemplateBottomSheet(
                title = savedTitle,
                color = getTemplateColorByName(savedColor),
                editTemplate = {title, color -> templateViewModel.editTemplate(planId, title, color) },
                onClose = { navController.popBackStack() }
            )
        }
    }
}
