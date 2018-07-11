package com.script972.components;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


import com.script972.enums.TypePhotoPath;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by script972
 */

@Component
public class CloudStorageHepler {

    /**
     * Credentials publicKey for AWS S3
     */
    @Value("${aws.s3.publicKey}")
    private String publicKey;

    /**
     * Credentials privateKey for AWS S3
     */
    @Value("${aws.s3.privateKey}")
    private String privateKey;

    /**
     * Routing upload file to server with different prefix name
     *
     * @param filePart uploded file
     * @param prefix   type file
     * @return url to uploaded file
     * @throws IOException
     */
    public String uploadFile(MultipartFile filePart, final TypePhotoPath prefix) throws IOException {
        return streamS3(filePart, prefix);
    }

    /**
     * Method for upload user avatar photo
     *
     * @param mpfile
     * @param prefix
     * @return url - link to amazon service
     * @throws IOException
     */
    private String streamS3(MultipartFile mpfile, TypePhotoPath prefix) throws IOException {
        byte[] bytes = mpfile.getBytes();
        AmazonS3 amazonS3 = buildCredetionals();
        try {
            String objectname = TypePhotoPath.dir(prefix) + "-" + System.currentTimeMillis() + "-" + mpfile.getOriginalFilename();
            InputStream stream = new ByteArrayInputStream(bytes);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(bytes.length);
            metadata.setContentType("image");
            amazonS3.putObject(new PutObjectRequest("clutchdiscount", objectname, stream, metadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            return "https://s3.eu-west-2.amazonaws.com/clutchdiscount/" + objectname;

        } catch (AmazonClientException ace) {
            System.out.println(ace);
        }

        return null;
    }

    /**
     * Method for build credetionals to AWS s3
     *
     * @return
     */
    private AmazonS3 buildCredetionals() {
        AWSCredentials credentials = new BasicAWSCredentials(publicKey,
                privateKey);
        return new AmazonS3Client(credentials);
    }

}
