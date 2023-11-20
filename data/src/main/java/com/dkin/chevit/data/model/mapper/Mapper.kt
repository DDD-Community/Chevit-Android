package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.domain.base.DomainListModel
import com.dkin.chevit.domain.base.DomainModel

internal fun interface Mapper<Data : DataModel, Domain : DomainModel> {
    fun mapDomain(input: Data): Domain
}

internal fun interface SuspendMapper<Data : DataModel, Domain : DomainModel> {
    suspend fun mapDomain(input: Data): Domain
}

internal fun interface ListMapper<Data : DataModel, Domain : DomainModel> {
    fun mapDomainList(input: List<Data>): DomainListModel<Domain>
}

internal fun interface SuspendListMapper<Data : DataModel, Domain : DomainModel> {
    suspend fun mapDomainList(input: List<Data>): DomainListModel<Domain>
}

internal inline fun <Data : DataModel, Domain : DomainModel> List<Data>.mapDomainList(
    mapSingle: (Data) -> Domain
): DomainListModel<Domain> {
    return DomainListModel(map { mapSingle(it) })
}
