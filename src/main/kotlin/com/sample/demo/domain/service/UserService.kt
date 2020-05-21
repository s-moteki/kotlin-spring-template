package com.sample.demo.domain.service

import com.sample.demo.domain.dto.UserDto
import com.sample.demo.domain.entity.UserEntity
import com.sample.demo.domain.repository.UserRepository
import com.sample.demo.domain.service.spec.UserSpecification
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * ユーザー関連のサービスクラス
 *
 * @author moteki
 */
@Service
@Transactional
class UserService(
  private val userRepository: UserRepository
) {

  /**
   * userIdからユーザーを検索
   * @param userId ユーザーID
   * @return ユーザーエンティティ
   */
  fun findUserById(userId: Int): UserEntity {
    return userRepository.findById(userId).orElseThrow { RuntimeException() }
  }

  /**
   * DTOを検索条件として検索
   * @param condition 検索条件
   * @return ユーザーエンティティリスト
   */
  fun findUserByCondition(condition: UserDto): List<UserEntity> {
    val where = Specification.where(UserSpecification.generateWhereByCondition(condition))
    return userRepository.findAll(where)
  }
}
