USE jpa_learn;
CREATE TABLE cst_customer (
      cust_id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
      cust_name VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
      cust_source VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
      cust_industry VARCHAR(32) DEFAULT NULL COMMENT '客户所属行业',
      cust_level VARCHAR(32) DEFAULT NULL COMMENT '客户级别',
      cust_address VARCHAR(128) DEFAULT NULL COMMENT '客户联系地址',
      cust_phone VARCHAR(64) DEFAULT NULL COMMENT '客户联系电话',
      PRIMARY KEY (`cust_id`)
    ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;