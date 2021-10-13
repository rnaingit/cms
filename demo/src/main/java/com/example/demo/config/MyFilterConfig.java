package com.example.demo.config;

import com.example.demo.filter.CustomerFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<CustomerFilter> registrationBean()
    {
        FilterRegistrationBean<CustomerFilter> registrationBean =new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomerFilter());
        registrationBean.addUrlPatterns("/customers/*");
        return registrationBean;
    }
}
