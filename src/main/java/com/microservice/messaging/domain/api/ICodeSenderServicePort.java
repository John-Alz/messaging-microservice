package com.microservice.messaging.domain.api;

public interface ICodeSenderServicePort {

    String sendCodeSms(String phoneNumber);

}
