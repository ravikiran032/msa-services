package com.salesorder.service.salesorderservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="salesorder-service")
@Component
public class SalesOrderConfiguration {

}
