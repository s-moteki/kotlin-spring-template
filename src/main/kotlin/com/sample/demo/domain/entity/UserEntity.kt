package com.sample.demo.domain.entity


import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

/**
 * ユーザーエンティティ
 *
 * @author moteki
 */
@Entity
@Table(name = "user")
data class UserEntity(

  /** ユーザーID */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", nullable = false)
  val userId: Int?,

  /** 名前 */
  @Basic
  @Column(name = "name", nullable = false, length = 255)
  val name: String,

  /** 年齢 */
  @Basic
  @Column(name = "age", nullable = false, length = 255)
  val age: Int,

  /** パスワード */
  @Column(name = "password", length = 255)
  val password: String?,

  /** アクセストークン */
  @Basic
  @Column(name = "access_token", nullable = false, length = 255)
  val accessToken: String?,

  /** 作成日 */
  @Basic
  @Column(name = "created_at", nullable = false)
  val createdAt: Timestamp = Timestamp(Date().time),

  /** 更新日 */
  @Basic
  @Column(name = "updated_at", nullable = false)
  @UpdateTimestamp
  val updatedAt: Timestamp = Timestamp(Date().time)
)
