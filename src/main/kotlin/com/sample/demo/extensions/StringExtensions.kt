package com.sample.demo.extensions

import java.util.*


/**
 * String関連のエクステンション
 *
 * @author moteki
 */


/**
 * Base64形式に変換
 * @return Base64形式文字列
 */
fun String.encodeBase64(): String = Base64.getEncoder().encodeToString(this.toByteArray())

