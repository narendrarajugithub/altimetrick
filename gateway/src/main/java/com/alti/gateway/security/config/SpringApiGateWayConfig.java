package com.alti.gateway.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringApiGateWayConfig {

	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * the path should match with the service controller from the a service(i.e
	 * employee-service) which is located(i.e Uri("lb://employee-service") in
	 * service discovery(eureka service discovery server). it is
	 * mandatory@RequestMapping(/employee-services) along with @RestController.
	 * Otherwise Routing can't work. injava28 sec 6 173.step24
	 */
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		LOG.info("****Routelocator bean created****");

		

		return builder.routes().route(p -> p.path("/employee-services/**").uri("lb://employee-service"))
				.route(p -> p.path("/todo-service/**").uri("lb://todo-service")).build();

	}

}
