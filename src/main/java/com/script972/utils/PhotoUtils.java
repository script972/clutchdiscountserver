package com.script972.utils;

import com.script972.enums.TypePhotoPath;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PhotoUtils {

    public byte [] downloadPhoto(String namephoto, TypePhotoPath type) throws IOException {
        namephoto = namephoto.replace(",", ".");
        Path path= Paths.get(TypePhotoPath.dir(type)+"/"+namephoto);
        byte[] data = Files.readAllBytes(path);
        return data;
    }

    public String saveUploadedPhoto(MultipartFile file, TypePhotoPath dir) throws IOException {
        byte [] bytes = file.getBytes();
        String type=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        Path path = Paths.get(TypePhotoPath.dir(dir)+"/"+generatorStr()+type);
        path=Files.write(path, bytes);
        String fileName=path.getFileName().toString().replace(".",",");
        return String.valueOf(fileName);
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
