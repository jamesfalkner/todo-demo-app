package io.quarkus.sample;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

abstract public class CommonResource {

    protected PutObjectRequest buildPutRequest(FormData formData) {
        return PutObjectRequest.builder()
                .bucket("quarkus-stackgen-init")
                .key(formData.filename)
                .contentType(formData.mimetype)
                .build();
    }

    protected GetObjectRequest buildGetRequest(String objectKey) {
        return GetObjectRequest.builder()
                .bucket("quarkus-stackgen-init")
                .key(objectKey)
                .build();
    }

}