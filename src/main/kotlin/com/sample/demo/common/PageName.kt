package com.sample.demo.common

/**
 * 遷移先情報を管理する(html)
 *
 * @author moteki
 */
enum class PageName(val key: String) {
  /** トップ画面 */
  ADMIN_INDEX("index"),
  /** プロファイル(ログイン後)ページ */
  ADMIN_PROFILE("profile")
}
