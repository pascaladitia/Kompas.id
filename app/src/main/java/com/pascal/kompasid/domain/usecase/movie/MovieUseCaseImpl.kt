package com.pascal.kompasid.domain.usecase.movie

import com.pascal.kompasid.data.repository.MovieRepositoryImpl
import com.pascal.kompasid.domain.mapper.toDomain
import com.pascal.kompasid.domain.model.Dashboard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Single

@Single
class MovieUseCaseImpl(
    private val repository: MovieRepositoryImpl
) : MovieUseCase {

    override suspend fun dashboard(): Flow<Dashboard> = flow {
        emit(repository.dashboard().toDomain())
    }
}
