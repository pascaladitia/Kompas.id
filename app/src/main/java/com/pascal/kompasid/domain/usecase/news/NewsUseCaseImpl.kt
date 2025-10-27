package com.pascal.kompasid.domain.usecase.news

import com.pascal.kompasid.data.repository.NewsRepositoryImpl
import com.pascal.kompasid.domain.mapper.toDomain
import com.pascal.kompasid.domain.model.AdsBanner
import com.pascal.kompasid.domain.model.Article
import com.pascal.kompasid.domain.model.BreakingNews
import com.pascal.kompasid.domain.model.Dashboard
import com.pascal.kompasid.domain.model.HotTopics
import com.pascal.kompasid.domain.model.IframeCampaign
import com.pascal.kompasid.domain.model.Kabinet
import com.pascal.kompasid.domain.model.LiveReport
import com.pascal.kompasid.domain.model.PonAcehSumut
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

    override suspend fun getAdsBanner(): Flow<AdsBanner> = flow {
        emit(repository.getAdsBanner().toDomain())
    }

    override suspend fun getArticles(): Flow<List<Article>> = flow {
        emit(repository.getArticles().toDomain())
    }

    override suspend fun getBreakingNews(): Flow<BreakingNews> = flow {
        emit(repository.getBreakingNews().toDomain())
    }

    override suspend fun getHotTopics(): Flow<HotTopics> = flow {
        emit(repository.getHotTopics().toDomain())
    }

    override suspend fun getIframeCampaign(): Flow<IframeCampaign> = flow {
        emit(repository.getIframeCampaign().toDomain())
    }

    override suspend fun getKabinet(): Flow<Kabinet> = flow {
        emit(repository.getKabinet().toDomain())
    }

    override suspend fun getLiveReport(): Flow<LiveReport> = flow {
        emit(repository.getLiveReport().toDomain())
    }

    override suspend fun getPonAcehSumut(): Flow<PonAcehSumut> = flow {
        emit(repository.getPonAcehSumut().toDomain())
    }
}
