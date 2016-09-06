

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL COMMENT 'id 用户',
  `nick_name` varchar(30) NOT NULL COMMENT '昵称',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `email` varchar(50) COMMENT '电子邮箱',
  `wx_no` int(10) COMMENT '微信号',
  `passwd` varchar(60) COMMENT '密码，如果使用则存储加密签名',
  `enable` int(4) NOT NULL COMMENT '是否启用,1,启用 0,不启用。默认启用',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` varchar(10) NOT NULL COMMENT 'id 小组',
  `name` varchar(30) NOT NULL COMMENT '小组名称',
  `user_id` varchar(20) NOT NULL COMMENT '成员id',
  `enable` int(4) NOT NULL COMMENT '是否启用,1,启用 0,不启用。默认启用',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `trans`;
CREATE TABLE `trans` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `trans_amt` decimal(20) NOT NULL COMMENT '交易金额',
  `payer_id` varchar(20) COMMENT '付款人id',
  `group_id` varchar(20) COMMENT '小组id',
  `pay_time` datetime COMMENT '付款时间',
  `divide_to` int(4) COMMENT '该笔金额由多少人均摊',
  `per_amt` decimal(20) COMMENT '每个人的应付金额',
  `memo` varchar(200) COMMENT '备注',
  `image` varchar(100) COMMENT '图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `trans_ext`;
CREATE TABLE `trans_ext` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `trans_id` decimal(10) NOT NULL COMMENT '交易表id',
  `group_id` varchar(20) COMMENT '小组id',
  `user_id` varchar(20) COMMENT '成员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;