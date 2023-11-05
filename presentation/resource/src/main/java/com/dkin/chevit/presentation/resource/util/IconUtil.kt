package com.dkin.chevit.presentation.resource.util

import androidx.compose.ui.graphics.vector.ImageVector
import com.dkin.chevit.presentation.common.category.CategoryType
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.category.CategoryBaby
import com.dkin.chevit.presentation.resource.icon.category.CategoryBeautyProducts
import com.dkin.chevit.presentation.resource.icon.category.CategoryBusiness
import com.dkin.chevit.presentation.resource.icon.category.CategoryCamping
import com.dkin.chevit.presentation.resource.icon.category.CategoryClothes
import com.dkin.chevit.presentation.resource.icon.category.CategoryCompanionAnimal
import com.dkin.chevit.presentation.resource.icon.category.CategoryElectronics
import com.dkin.chevit.presentation.resource.icon.category.CategoryEmergencyMedicine
import com.dkin.chevit.presentation.resource.icon.category.CategoryEtc
import com.dkin.chevit.presentation.resource.icon.category.CategoryExercise
import com.dkin.chevit.presentation.resource.icon.category.CategoryMountain
import com.dkin.chevit.presentation.resource.icon.category.CategoryPhoto
import com.dkin.chevit.presentation.resource.icon.category.CategoryRequires
import com.dkin.chevit.presentation.resource.icon.category.CategorySwimming
import com.dkin.chevit.presentation.resource.icon.category.CategoryToiletries

fun CategoryType.getCategoryIcon(): ImageVector {
    return when(this) {
        CategoryType.REQUIRES -> ChevitIcon.CategoryRequires
        CategoryType.ELECTRONICS -> ChevitIcon.CategoryElectronics
        CategoryType.EXERCISE -> ChevitIcon.CategoryExercise
        CategoryType.TOILETRIES -> ChevitIcon.CategoryToiletries
        CategoryType.EMERGENCY_MEDICINE -> ChevitIcon.CategoryEmergencyMedicine
        CategoryType.BEAUTY_PRODUCTS -> ChevitIcon.CategoryBeautyProducts
        CategoryType.BABY -> ChevitIcon.CategoryBaby
        CategoryType.COMPANION_ANIMAL -> ChevitIcon.CategoryCompanionAnimal
        CategoryType.MOUNTAIN -> ChevitIcon.CategoryMountain
        CategoryType.BUSINESS -> ChevitIcon.CategoryBusiness
        CategoryType.PHOTO -> ChevitIcon.CategoryPhoto
        CategoryType.CAMPING -> ChevitIcon.CategoryCamping
        CategoryType.SWIMMING -> ChevitIcon.CategorySwimming
        CategoryType.CLOTHES -> ChevitIcon.CategoryClothes
        CategoryType.ETC -> ChevitIcon.CategoryEtc
    }
}