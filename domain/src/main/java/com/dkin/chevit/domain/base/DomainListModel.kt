package com.dkin.chevit.domain.base

data class DomainListModel<T : DomainModel>(val list: List<T>) : DomainModel
