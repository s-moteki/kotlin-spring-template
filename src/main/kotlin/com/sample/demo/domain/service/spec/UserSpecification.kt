package com.sample.demo.domain.service.spec

import com.sample.demo.domain.dto.UserDto
import com.sample.demo.domain.entity.UserEntity
import com.sample.demo.domain.entity.UserEntity_
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

/**
 * UserEntity関連のクエリビルダー
 *
 * @author moteki
 */
class UserSpecification {

  companion object {
    /**
     * Formの検索条件から条件クエリを生成する
     *
     * @param searchProductForm
     * @return 条件クエリ
     */
    fun generateWhereByCondition(userDto: UserDto): Specification<UserEntity> {

      val conditionList = mutableListOf<Specification<UserEntity>>()
      if (userDto.userId.isNotBlank()) {
        conditionList.add(eqUserIdWhere(userDto.userId))
      }

      return conditionList.stream().reduce(noneWhere(), Specification<UserEntity>::and)
    }

    /**
     * userIDの等価検索条件
     * @return 等価条件Where
     */
    private fun eqUserIdWhere(userId: String): Specification<UserEntity> {
      return Specification { root: Root<UserEntity>, _: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder ->
        criteriaBuilder.equal(root.get(UserEntity_.userId), "%$userId%")
      }
    }


    /**
     * @return 無条件Specification
     */
    private fun noneWhere(): Specification<UserEntity>? {
      return Specification.where(null)
    }

  }
}
