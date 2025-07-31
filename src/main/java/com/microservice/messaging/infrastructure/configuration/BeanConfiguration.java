package com.microservice.messaging.infrastructure.configuration;

import com.microservice.messaging.domain.api.ICodeSenderServicePort;
import com.microservice.messaging.domain.spi.ICodeSenderPort;
import com.microservice.messaging.domain.usecase.CodeSenderUseCase;
import com.microservice.messaging.infrastructure.out.twilio.adapter.TwilioSmsAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public ICodeSenderPort codeSenderPort() {
        return new TwilioSmsAdapter();
    }

    @Bean
    public ICodeSenderServicePort codeSenderServicePort() {
        return new CodeSenderUseCase(codeSenderPort());
    }

}
