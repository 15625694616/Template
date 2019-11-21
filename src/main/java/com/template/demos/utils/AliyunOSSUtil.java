package com.template.demos.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.io.InputStream;

/**
 * @author jon
 * @date 2019/7/15 14:11
 */
public class AliyunOSSUtil {
    private static String endpoint = "oss-cn-huhehaote.aliyuncs.com";
    private static String accessKeyId = "LTAI4FoGABUhuw3m2SF4ibmR";
    private static String accessKeySecret = "6cpnXsvF371cQtbDDlW4q3jm2JiaOQ";
    private static String bucketName = "wenhuaquanyulvyou";
    private static String key = "file";
   // private static String addr="https://img.kcgeis.com";
    private static String host="https://"+bucketName+"."+endpoint;
    public static String upload(File file){
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        key= CharUtil.getRandomNum(10);
        try {
            PutObjectResult putObjectResult = ossClient.putObject(new PutObjectRequest(bucketName, key, file));
            System.out.println(putObjectResult.getETag());
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } finally {
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            ossClient.shutdown();
        }
        String fileName=file.getName();
        String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        return host+"/"+key;
    }
    public static String upload(InputStream file,String fileType){
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        key= CharUtil.getRandomNum(10)+fileType;
        try {
            PutObjectResult putObjectResult = ossClient.putObject(new PutObjectRequest(bucketName, key, file));
            System.out.println(putObjectResult.getETag());
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } finally {
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            ossClient.shutdown();
        }
//        String fileName=file.getName();
//        String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        return host+"/"+key;
    }




}
