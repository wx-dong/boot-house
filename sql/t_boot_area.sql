drop table if exists t_boot_area;
CREATE table if not exists t_boot_area(
	id int not null auto_increment comment '主键',
	pid int not null comment 'parent id',
	name VARCHAR(128) comment '地区名称',
	sort int comment '排序字段',
	PRIMARY key(id)
	);
