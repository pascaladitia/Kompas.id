package com.pascal.kompasid.domain.usecase.local

import com.pascal.kompasid.data.local.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow

interface LocalUseCase {
    fun getProfileById(id: Long): Flow<ProfileEntity?>
    fun getAllProfiles(): Flow<List<ProfileEntity>>
    fun deleteProfileById(item: ProfileEntity): Flow<Unit>
    fun insertProfile(item: ProfileEntity): Flow<Unit>
}