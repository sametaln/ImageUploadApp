package com.example.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 S3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAVJVJREX4H3PHXYWE","X7VhYIsvMR2vX2iRod6Y6oHyAho/0DyXdP9g2jJ1"
        );

        return AmazonS3ClientBuilder.standard().withRegion("eu-central-1").withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }
}

