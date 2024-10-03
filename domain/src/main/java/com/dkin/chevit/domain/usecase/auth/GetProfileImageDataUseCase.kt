package com.dkin.chevit.domain.usecase.auth

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.ProfileImageData
import com.dkin.chevit.domain.repository.AuthRepository

class GetProfileImageDataUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val authRepository: AuthRepository,
) : IOUseCase<GetProfileImageDataUseCase.Param, ProfileImageData>(coroutineDispatcherProvider = coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): ProfileImageData {
        return authRepository.getProfileUploadURL(params.fileSize)
    }

    @JvmInline
    value class Param(val fileSize: Int)
}