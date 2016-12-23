package com.yyit.marketOperation.message.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations="classpath:mongodb-context.xml")
public class MongodbBeans {
  
}
