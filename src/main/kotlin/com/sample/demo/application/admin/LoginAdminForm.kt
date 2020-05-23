package com.sample.demo.application.admin

import com.sample.demo.domain.annotation.HalfWidthNumeric
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * ログインフォーム
 *
 * @author moteki
 */
data class LoginAdminForm(

  /** ユーザーID */
  @field:NotNull
  @field:NotBlank
  @HalfWidthNumeric
  val userId: String = "",

  /** パスワード */
  @field:NotNull
  @field:NotBlank
  val password: String = ""
)
