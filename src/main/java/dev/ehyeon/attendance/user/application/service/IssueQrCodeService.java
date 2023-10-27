package dev.ehyeon.attendance.user.application.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import dev.ehyeon.attendance.user.application.port.in.IssueQrCodeUseCase;
import dev.ehyeon.attendance.user.application.port.out.FindUserPort;
import dev.ehyeon.attendance.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class IssueQrCodeService implements IssueQrCodeUseCase {

    private final FindUserPort findYUserPort;

    public byte[] issueQrCodeById(long id) {
        User foundUser = findYUserPort.findUserById(id);

        return generateQrCode(foundUser);
    }

    private byte[] generateQrCode(User user) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(Long.toString(user.getId()), BarcodeFormat.QR_CODE, 100, 100);

            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);

            return byteArrayOutputStream.toByteArray();
        } catch (WriterException | IOException exception) {
            throw new QrCodeGenerationFailedException();
        }
    }
}
