package com.sample.demo.application.admin

import com.sample.demo.domain.dto.UserDto

/**
 * フォーム値とDTOの相互変換ヘルパー
 *
 * @author moteki
 */
class AdminFormHelper {
  companion object {
    /**
     * Form → Dto
     *
     * @param loginAdminForm Form
     * @return UserDto
     */
    fun to(loginAdminForm: LoginAdminForm): UserDto {
      return UserDto(
        userId = loginAdminForm.userId,
        password = loginAdminForm.password
      )
    }
  }
}
