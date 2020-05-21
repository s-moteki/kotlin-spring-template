package com.sample.demo.domain.dto


import java.sql.Timestamp

/**
 * ユーザー情報を保持するDTO
 *
 * @author moteki
 */
data class UserDto(

  /** ユーザーID */
  val userId: String = "",

  /** 名前 */
  val name: String = "",

  /** 年齢 */
  val age: Int?,

  /** パスワード */
  val password: String?,

  /** アクセストークン */
  val accessToken: String?,

  /** 作成日 */
  val createdAt: Timestamp?,

  /** 更新日 */
  val updatedAt: Timestamp?
)
