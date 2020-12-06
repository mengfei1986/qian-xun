
CREATE TABLE  IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32)  NOT NULL,
  `sex` int(1) NOT NULL,
  `mobile` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `status` int(1) NOT NULL,
  `inter_time` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE  IF NOT EXISTS `sys_dict_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(32) NOT NULL,
  `item_key` varchar(32)  NOT NULL,
  `item_val` varchar(32) NOT NULL,
  `status` int(11) NOT NULL,
  `create_by` varchar(32) NOT NULL,
  `create_time` varchar(32) NOT NULL,
  `update_by` varchar(32) NOT NULL,
  `update_time` varchar(32) NOT NULL,
   PRIMARY KEY (`id`)
) ;


CREATE TABLE  IF NOT EXISTS `sys_dict`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_name` varchar(32) NOT NULL,
  `dict_code` varchar(32) NOT NULL,
  `remark` varchar(32),
  `status` int(11),
  `create_by` varchar(32) NOT NULL,
  `create_time` varchar(32),
  `update_by` varchar(32) NOT NULL,
  `update_time` varchar(32),
   PRIMARY KEY (`id`)
);