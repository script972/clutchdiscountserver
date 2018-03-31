package com.script972.utils;

import com.script972.enums.TypePhotoPath;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadPhotoUtils {



    public void saveUploadedPhoto(MultipartFile file, TypePhotoPath dir) throws IOException {
        byte [] bytes = file.getBytes();
     //   Path path = Paths.get("UploadThis_"+file.getOriginalFilename());
        //Path path = Paths.get(TypePhotoPath.dir(dir)+"/"+generatorStr());
        Path path = Paths.get("/src/"+file.getOriginalFilename());
        Files.write(path, bytes);
    }

    private String generatorStr(){
        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randString = new StringBuilder();
        int count = (int)(Math.random()*30);
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));

        return randString.toString();

    }
}
