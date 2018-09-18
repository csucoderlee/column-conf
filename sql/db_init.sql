DROP TABLE IF EXISTS `page_column_conf`;
CREATE TABLE `page_column_conf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '列配置项ID',
  `col_code` varchar(40) NOT NULL COMMENT '列编码',
  `col_title` varchar(40) NOT NULL COMMENT '列显示标题',
  `page_id` bigint(20) NOT NULL COMMENT '列所属页面ID',
  `is_default` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否为该页面默认显示的列',
  `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '列在当前页面的排序号',
  `width` int(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_idx` (`page_id`)
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=utf8 COMMENT='页面列配置项表';

DROP TABLE IF EXISTS `user_column_conf`;
CREATE TABLE `user_column_conf` (
  `account_id` bigint(20) NOT NULL COMMENT '账号id',
  `page_id` bigint(20) NOT NULL COMMENT '列所属页面ID',
  `col_id` bigint(20) NOT NULL COMMENT '列ID',
  `visible` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可见: 1可见, 0不可见',
  `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '列在当前页面的排序号',
  `width` int(9) DEFAULT NULL,
  UNIQUE KEY `account_page_col_idx` (`account_id`,`page_id`,`col_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户列配置项表';