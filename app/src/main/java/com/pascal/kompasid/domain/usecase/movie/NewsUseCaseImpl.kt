package com.pascal.kompasid.domain.usecase.movie

import com.pascal.kompasid.data.repository.NewsRepositoryImpl
import com.pascal.kompasid.domain.mapper.toDomain
import com.pascal.kompasid.domain.model.Dashboard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Single

@Single
class NewsUseCaseImpl(
    private val repository: NewsRepositoryImpl
) : NewsUseCase {

    override suspend fun dashboard(): Flow<Dashboard> = flow {
        emit(repository.dashboard().toDomain())
    }
}
