package org.example.repro;

import io.micrometer.observation.ObservationRegistry;
import jakarta.servlet.DispatcherType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.filter.ServerHttpObservationFilter;

@SpringBootApplication
public class ReproApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReproApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<ServerHttpObservationFilter> webMvcObservationFilter(ObservationRegistry registry) {
        ServerHttpObservationFilter filter = new ServerHttpObservationFilter(registry);
        FilterRegistrationBean<ServerHttpObservationFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
        registration.addUrlPatterns("/metrics");
        return registration;
    }

}
