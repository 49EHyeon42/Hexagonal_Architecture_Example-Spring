package dev.ehyeon.attendance.user.adapter.in.web;

import dev.ehyeon.attendance.global.error.Error;
import dev.ehyeon.attendance.global.error.ErrorResponse;
import dev.ehyeon.attendance.user.application.port.in.IssueQrCodeRequest;
import dev.ehyeon.attendance.user.application.port.in.IssueQrCodeUseCase;
import dev.ehyeon.attendance.user.application.service.QrCodeGenerationFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class IssueQrCodeController {

    private final IssueQrCodeUseCase issueQrCodeUseCase;

    @PostMapping(value = "/user/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] issueQrCode(@RequestBody @Valid IssueQrCodeRequest request) {
        return issueQrCodeUseCase.issueQrCodeById(request.getId());
    }

    @ExceptionHandler(QrCodeGenerationFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse qrCodeGenerationFailedException() {
        return new ErrorResponse(Error.QRCODE_GENERATION_FAILED.getMessage());
    }
}
