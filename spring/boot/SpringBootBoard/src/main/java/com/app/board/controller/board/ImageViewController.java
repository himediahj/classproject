package com.app.board.controller.board;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
@Log4j2
public class ImageViewController {
    @GetMapping(value = "/upload/photo/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody   // 이거 안붙이면 templates 가서 html 파일 찾으니까
    public ResponseEntity<byte[]> viewImage(@PathVariable("fileName") String fileName) throws IOException {
        log.info(" ImageView Controller ... ");

        byte[] imageByteArray = null;
        HttpStatus status = HttpStatus.NOT_FOUND;

        File savedFile = new File(new File("").getAbsolutePath(), "photo\\"+fileName);

        if(savedFile.exists()){ // 파일 존재한다면
            // 응답 처리
            InputStream imageStream = new FileInputStream(savedFile);
            imageByteArray = imageStream.readAllBytes();
            imageStream.close();

            status = HttpStatus.OK;
        }

        return new ResponseEntity<byte[]>(imageByteArray, status);

    }
}
