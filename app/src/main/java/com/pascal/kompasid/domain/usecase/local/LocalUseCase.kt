package com.pascal.kompasid.domain.usecase.local

import com.pascal.kompasid.domain.model.CommonArticle

interface LocalUseCase {
    suspend fun insertFavorite(entity: CommonArticle)
    suspend fun deleteFavorite(entity: CommonArticle)
    suspend fun getFavorite(): List<CommonArticle>?
    suspend fun getFavorite(title: String): Boolean
}