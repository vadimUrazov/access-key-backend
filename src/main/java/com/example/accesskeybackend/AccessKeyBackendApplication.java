package com.example.accesskeybackend;

import com.example.accesskeybackend.props.AccessKeyProviderProps;
import com.example.accesskeybackend.props.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("dev")
@EnableConfigurationProperties({SecurityProperties.class, AccessKeyProviderProps.class})
public class AccessKeyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessKeyBackendApplication.class, args);
    }

}
