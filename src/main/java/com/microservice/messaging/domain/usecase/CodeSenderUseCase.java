package com.microservice.messaging.domain.usecase;

import com.microservice.messaging.domain.api.ICodeSenderServicePort;
import com.microservice.messaging.domain.spi.ICodeSenderPort;

import java.security.SecureRandom;

public class CodeSenderUseCase implements ICodeSenderServicePort {

    private final ICodeSenderPort codeSenderPort;
    private final SecureRandom random = new SecureRandom();

    public CodeSenderUseCase(ICodeSenderPort codeSenderPort) {
        this.codeSenderPort = codeSenderPort;
    }

    @Override
    public String sendCodeSms(String phoneNumber) {
        String code = String.valueOf(100000 + random.nextInt(900000));
        String message = "Tu codigo de verificacion para reclamar el pedido es: " + code;
        codeSenderPort.sendCodeSms(phoneNumber, message);
        return code;
    }
}
