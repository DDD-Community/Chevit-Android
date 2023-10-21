package com.dkin.chevit.domain.provider

interface TokenProvider {
    fun getFirebaseToken(): String
}
