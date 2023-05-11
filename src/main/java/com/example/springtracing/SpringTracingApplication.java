package com.example.springtracing;

import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import static com.example.springtracing.SpringTracingApplication.*;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class SpringTracingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTracingApplication.class, args);
    }

    @Bean
    public SpanExporter spanExporter(AppConfig config) {
        return OtlpGrpcSpanExporter.builder().setEndpoint(config.otlpEndpoint()).build();
    }

    @ConfigurationProperties("app.config")
    record AppConfig(String otlpEndpoint) {}

}
