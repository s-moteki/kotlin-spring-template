package com.sample.demo.domain.annotation

import com.moteki.restfulapi.domain.annotation.validator.HalfWidthNumericValidator
import javax.validation.Constraint
import javax.validation.Payload
import javax.validation.ReportAsSingleViolation
import kotlin.reflect.KClass


/**
 * 半角数字アノテーションクラス
 *
 * @author moteki
 * @see HalfWidthNumericValidator.isValid
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@ReportAsSingleViolation
@Constraint(validatedBy = [HalfWidthNumericValidator::class])
annotation class HalfWidthNumeric(
  val message: String = "{custom.validation.HalfWidthNumeric.message}",
  val groups: Array<KClass<out Any>> = [],
  val payload: Array<KClass<out Payload>> = []
)
