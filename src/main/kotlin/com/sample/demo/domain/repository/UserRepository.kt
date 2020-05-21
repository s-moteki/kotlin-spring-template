package com.sample.demo.domain.repository

import com.sample.demo.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

/**
 * ユーザーリポジトリ
 */
interface UserRepository : JpaRepository<UserEntity, Int>, JpaSpecificationExecutor<UserEntity>
