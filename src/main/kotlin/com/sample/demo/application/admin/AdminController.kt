package com.sample.demo.application.admin

import com.sample.demo.common.PageName
import com.sample.demo.domain.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

/**
 * 管理画面コントローラー
 *
 * @author moteki
 */
@Controller
class AdminController(
  val userService: UserService
) {

  /**
   * ログイン、TOP画面遷移
   *
   * @return 画面遷移
   */
  @GetMapping
  fun index(loginAdminForm: LoginAdminForm, mav: ModelAndView): ModelAndView {
    mav.viewName = PageName.ADMIN_INDEX.key
    return mav
  }

  /**
   * ログイン処理
   *
   * @return 画面遷移
   */
  @PostMapping("/login")
  fun login(@Validated loginAdminForm: LoginAdminForm, bindingResult: BindingResult, mav: ModelAndView): ModelAndView {
    if (bindingResult.hasErrors()) return index(loginAdminForm, mav)

    mav.viewName = PageName.ADMIN_PROFILE.key
    val userDto = AdminFormHelper.to(loginAdminForm)

    // TODO 存在チェックしかしていない
    return if (userService.findUserByCondition(userDto).isEmpty()) {
      index(loginAdminForm, mav)
    } else {
      mav
    }
  }

  /**
   * 引数のURLをリダイレクトURLにして返す
   * @return リダイレクトURL
   */
  fun redirect(url: String) = "redirect:$url"

}
