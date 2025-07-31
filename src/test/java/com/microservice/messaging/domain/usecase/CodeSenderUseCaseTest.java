package com.microservice.messaging.domain.usecase;

import com.microservice.messaging.domain.spi.ICodeSenderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CodeSenderUseCaseTest {

    private ICodeSenderPort codeSenderPort;
    private CodeSenderUseCase codeSenderUseCase;

    @BeforeEach
    void setUp() {
        codeSenderPort = mock(ICodeSenderPort.class);
        codeSenderUseCase = new CodeSenderUseCase(codeSenderPort);
    }

    @Test
    void sendCodeSms_ShouldGenerate6DigitCodeAndSendSms() {
        String phoneNumber = "+573001234567";

        // Act
        String code = codeSenderUseCase.sendCodeSms(phoneNumber);

        // Assert: 6 dígitos numéricos
        assertNotNull(code);
        assertEquals(6, code.length());
        assertTrue(code.matches("\\d{6}"));

        // Captura el mensaje enviado
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
        verify(codeSenderPort).sendCodeSms(eq(phoneNumber), messageCaptor.capture());

        String message = messageCaptor.getValue();
        assertTrue(message.contains(code));
        assertTrue(message.startsWith("Tu codigo de verificacion para reclamar el pedido es: "));
    }

    @Test
    void sendCodeSms_ShouldReturnDifferentCodesInDifferentCalls() {
        String phoneNumber = "+573001234567";

        String code1 = codeSenderUseCase.sendCodeSms(phoneNumber);
        String code2 = codeSenderUseCase.sendCodeSms(phoneNumber);

        assertNotEquals(code1, code2, "Los códigos deberían ser distintos en llamadas sucesivas (la mayoría del tiempo)");
        assertTrue(code1.matches("\\d{6}"));
        assertTrue(code2.matches("\\d{6}"));
    }
}
