package com.sample.demo.config

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import javax.servlet.Filter

/**
 * アプリケーション固有設定クラス
 *
 * @author moteki
 */
@Configuration
class AppConfig {
  /**
   * メッセージプロパティ
   */
  @Bean
  fun messageSource(): MessageSource {
    return ReloadableResourceBundleMessageSource().apply {
      setBasename("classpath:messages")
      setDefaultEncoding("UTF-8")
    }
  }

  /**
   * バリデータでメッセージプロパティを使用
   */
  @Bean
  fun getValidator() = LocalValidatorFactoryBean()
    .apply { setValidationMessageSource(messageSource()) }


  /**
   * cors認証 TODO restful-api実装時に使用
   */
  @Bean
  fun corsFilter(): FilterRegistrationBean<*> {

    val config = CorsConfiguration().apply {
      allowCredentials = true
      addAllowedOrigin("*")
      addAllowedHeader(CorsConfiguration.ALL)
      addAllowedMethod(CorsConfiguration.ALL)
    }
    val source = UrlBasedCorsConfigurationSource().apply { registerCorsConfiguration("/**", config) }

    return FilterRegistrationBean<Filter>(CorsFilter(source)).apply { order = 0 }
  }
}
