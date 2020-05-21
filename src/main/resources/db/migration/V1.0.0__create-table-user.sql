-- ユーザーテーブル
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ユーザーID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名前',
  `age` bigint(20) NOT NULL COMMENT '年齢',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT 'パスワード',
  `access_token` varchar(255) NOT NULL DEFAULT '' COMMENT 'アクセストークン',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT 'ユーザーテーブル';
