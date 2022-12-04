package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.ProductsBusinessInterface;
import com.gcu.business.ProductsBusinessService;

@Configuration
public class SpringConfig {
	
	@Bean(name="productsBusinessService", initMethod="init", destroyMethod="destroy")
	//@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	//@RequestScope
	@SessionScope
	public ProductsBusinessInterface getOrdersBusiness() {
		return new ProductsBusinessService();
	}	
}
