package com.microservice.messaging.infrastructure.out.twilio.adapter;

import com.microservice.messaging.domain.spi.ICodeSenderPort;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

public class TwilioSmsAdapter implements ICodeSenderPort {

    @Value("${twilio.phone.number}")
    private String fromNumber;

    @Override
    public void sendCodeSms(String phoneNumber, String message) {
        Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(fromNumber),
                message
        ).create();
    }
}
