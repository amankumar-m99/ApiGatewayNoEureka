package indeedcoder.apigatewaynoeureka.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfiguration {

	@Bean
	public RouteLocator configureRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("Service1", r1 -> r1.path("/service1/**")
						.filters(f -> f.addRequestHeader("Authorization", "Basic Json.Web.Token.fromBean")
								.addResponseHeader("custom-resp", "custom-resp-value"))
						.uri("http://localhost:8085"))
				.route("Service2", r1 -> r1.path("/service2/**").uri("http://localhost:8086")).build();
	}

}
