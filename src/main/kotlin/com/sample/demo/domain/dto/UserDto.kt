package com.sample.demo.domain.dto


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
  val age: Int = 0,

  /** パスワード */
  val password: String = "",

  /** アクセストークン */
  val accessToken: String = ""
)
