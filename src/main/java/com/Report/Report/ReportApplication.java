package com.Report.Report;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import com.Report.Report.Service.ConsumingStockService;
import com.Report.Report.Service.ConsumingStoreService;

@SpringBootApplication
public class ReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner run(ConsumingStockService stockService) {
        return args -> stockService.processStockData();
    }
    
    @Bean
    @Profile("!test")
    public CommandLineRunner run1(ConsumingStoreService storeService) {
        return args -> storeService.processStoreData();
    }
}
