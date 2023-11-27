package com.dkin.chevit.presentation.home.contents.template

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.dkin.chevit.presentation.common.model.SortType
import com.dkin.chevit.presentation.resource.TemplateColor
import javax.inject.Inject

@HiltViewModel
class TemplateViewModel @Inject constructor() :
    MVIViewModel<TemplateIntent, TemplateState, TemplateEffect>() {

    private val _templateState: MutableStateFlow<TemplateState> =
        MutableStateFlow(TemplateState.dummy())
    val templateState = _templateState.asStateFlow()
    private val _sortType: MutableStateFlow<SortType> = MutableStateFlow(SortType.NEW)
    val sortType = _sortType.asStateFlow()

    override fun createInitialState(): TemplateState = TemplateState.dummy()

    override suspend fun processIntent(intent: TemplateIntent) {
        when (intent) {
            else -> {}
        }
    }

    fun getTemplateList() {
        //TODO
    }

    fun onClickTemplate(id: String) {
        setEffect { TemplateEffect.NavigateToTemplate(id) }
    }

    fun sortTemplate(type: SortType) {
        //TODO
    }

    fun removeTemplate(planId: String) {
        //TODO
    }

    fun saveTemplate(title: String, color: TemplateColor) {
        //TODO
    }

    fun editTemplate(id: String,title: String, color: TemplateColor) {
        //TODO
    }
}