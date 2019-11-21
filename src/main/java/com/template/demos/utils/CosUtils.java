//package com.kcg.touristguide.utils;
//
//
//
//
//import com.qcloud.cos.COSClient;
//import com.qcloud.cos.ClientConfig;
//import com.qcloud.cos.auth.BasicCOSCredentials;
//import com.qcloud.cos.auth.COSCredentials;
//import com.qcloud.cos.model.PutObjectRequest;
//import com.qcloud.cos.model.PutObjectResult;
//import com.qcloud.cos.region.Region;
//
//import java.io.File;
//
//public class CosUtils {
////    private static String key=ResourceUtil.getConfigByName("tengxun.accesskey");
////    private static  String serKey=ResourceUtil.getConfigByName("tengxun.accesskey");
//
//
//    private static String appId="1253518772";
//    private static String bucket="app-1253518772";
//    private static  String SecretID="AKIDMVO7SIqMaYSBh3nLYcQ3cwAVZNm08kPz";
//    private static String SercretKey="fIl6DD5jYJsHN3W0EDyWs25wgARVMUP8";
//    private static Integer time=7776000;
//    private static Long nowTime=System.currentTimeMillis();
//    private static Long rand=nowTime+110;
//    private static String filed="/1253518772/app-1253518772/";
//
//    public   static String upLoad(String key,File file){
//        COSCredentials cred=new BasicCOSCredentials( ResourceUtil.getConfigByName("tengxun.accesskey"),ResourceUtil.getConfigByName("tengxun.secretkey"))  ;
//        ClientConfig clientConfig=new ClientConfig(new Region(ResourceUtil.getConfigByName("tengxun.region")));
//        COSClient cosClient=new COSClient(cred,clientConfig);
//        PutObjectRequest putObjectRequest=new PutObjectRequest("app-1253518772",key,file);
//        PutObjectResult putObjectResult=cosClient.putObject(putObjectRequest);
//        cosClient.shutdown();
//        String url="https://app-1253518772.cos.ap-guangzhou.myqcloud.com/"+key;
//        return  url;
//    }
//
////    public static String sampleSnapshotInfo(String key,File file){
////    String url="a=["+appId+"]&b=["+bucket+"]&k=["+SecretID+"]&e=["+time+"]&t=["+nowTime+"]&r=["+rand+"]";
////
////    }
//
//}
