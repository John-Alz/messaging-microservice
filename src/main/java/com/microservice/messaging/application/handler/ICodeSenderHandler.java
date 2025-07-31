package com.microservice.messaging.application.handler;

import com.microservice.messaging.application.dto.request.PhoneNumberRequestDto;
import com.microservice.messaging.application.dto.response.CodeVerificationResponseDto;

public interface ICodeSenderHandler {

    CodeVerificationResponseDto codeSenderSms(PhoneNumberRequestDto phoneNumberRequestDto);

}
