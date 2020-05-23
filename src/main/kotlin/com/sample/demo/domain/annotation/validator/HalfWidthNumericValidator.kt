package com.moteki.restfulapi.domain.annotation.validator

import com.sample.demo.domain.annotation.HalfWidthNumeric
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

/**
 * 半角数字バリデータ
 *
 * @author moteki
 */
class HalfWidthNumericValidator : ConstraintValidator<HalfWidthNumeric, String> {

  companion object {
    private val NUMERIC_REGEX = Regex("^[0-9]+$")
  }

  override fun initialize(constraintAnnotation: HalfWidthNumeric) {}

  override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
    // 空、nullは別で付与するためtrue
    return if (value.isNullOrBlank()) true
    else NUMERIC_REGEX.matches(value)
  }
}
