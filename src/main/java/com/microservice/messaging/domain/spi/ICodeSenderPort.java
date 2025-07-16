package com.microservice.messaging.domain.spi;

public interface ICodeSenderPort {

    void sendCodeSms(String phoneNumber, String message);

}
