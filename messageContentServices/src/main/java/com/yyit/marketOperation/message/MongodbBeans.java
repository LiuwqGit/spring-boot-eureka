package com.yyit.marketOperation.message;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations="classpath:mongodb-context.xml")
public class MongodbBeans {
  //此文件，专门用来加载mongodb的配置
}
