package com.microservice.messaging.application.handler.impl;

import com.microservice.messaging.application.dto.request.PhoneNumberRequestDto;
import com.microservice.messaging.application.dto.response.CodeVerificationResponseDto;
import com.microservice.messaging.application.handler.ICodeSenderHandler;
import com.microservice.messaging.domain.api.ICodeSenderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeSenderHandler implements ICodeSenderHandler {

    private final ICodeSenderServicePort codeSenderServicePort;

    @Override
    public CodeVerificationResponseDto codeSenderSms(PhoneNumberRequestDto phoneNumberRequestDto) {
        String code = codeSenderServicePort.sendCodeSms(phoneNumberRequestDto.phoneNumber());
        return new CodeVerificationResponseDto(code);
    }
}
