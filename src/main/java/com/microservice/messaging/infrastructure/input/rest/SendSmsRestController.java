package com.microservice.messaging.infrastructure.input.rest;

import com.microservice.messaging.application.dto.request.PhoneNumberRequestDto;
import com.microservice.messaging.application.dto.response.CodeVerificationResponseDto;
import com.microservice.messaging.application.handler.ICodeSenderHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/send-code")
@RequiredArgsConstructor
public class SendSmsRestController {

    private final ICodeSenderHandler codeSenderHandler;

    @PostMapping()
    public ResponseEntity<CodeVerificationResponseDto> sendCodeVerification(@RequestBody PhoneNumberRequestDto phoneNumberRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(codeSenderHandler.codeSenderSms(phoneNumberRequestDto));
    }


}
