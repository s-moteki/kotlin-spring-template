package com.sample.demo.application.admin

import com.sample.demo.common.PageName
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 管理画面コントローラー
 *
 * @author moteki
 */
@Controller
@RequestMapping("/admin")
class AdminController {

  /**
   * ログイン、TOP画面遷移
   *
   * @return 画面遷移
   */
  @GetMapping
  fun index() = PageName.ADMIN_INDEX.key


  /**
   * ログイン処理
   *
   * @return 画面遷移
   */
  @PostMapping("/login")
  fun login() = PageName.ADMIN_PROFILE.key

}
