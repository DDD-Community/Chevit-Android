package com.dkin.chevit.domain.usecase.auth

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.repository.AuthRepository
import java.io.File

class UploadProfileImageUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val authRepository: AuthRepository,
) : IOUseCase<UploadProfileImageUseCase.Param, None>(coroutineDispatcherProvider = coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): None {
        authRepository.uploadProfileImage(
            uploadURL = params.uploadURL,
            uploadMethod = params.uploadMethod,
            uploadHeaders = params.uploadHeaders,
            file = params.file
        )
        return None
    }

    data class Param(
        val uploadURL: String,
        val uploadMethod: String,
        val uploadHeaders: String,
        val file: File
    )
}