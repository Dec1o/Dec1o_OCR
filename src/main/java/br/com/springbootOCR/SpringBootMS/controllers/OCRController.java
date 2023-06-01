package br.com.springbootOCR.SpringBootMS.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@RestController
public class OCRController {

    @PostMapping("/ocr")
    public ResponseEntity<String> traduzir(@RequestParam("file") MultipartFile file) {
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        if (!"png".equals(ext) && !"jpg".equals(ext)) {
            return ResponseEntity.badRequest().build();
        }

        String resultado;
        try {
            BufferedImage img = ImageIO.read(file.getInputStream());
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:/Users/decio.faria/Documents/tessdata/");
            tesseract.setLanguage("por");
            resultado = tesseract.doOCR(img);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao ler arquivo");
        } catch (TesseractException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar OCR");
        }

        return ResponseEntity.ok(resultado);
    }
}
