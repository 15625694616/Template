//package com.kcg.touristguide.utils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//public class FileUploadUtil {
//    private static String getIp() {
//        InetAddress addr = null;
//        try {
//            addr = InetAddress.getLocalHost();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//
//        String ip = addr.getHostAddress().toString(); //获取本机ip
//        System.out.println(ip);
//        return ip + ":8081/imgs";
//
//    }
//
//    private static final String IMAGEMAT = "png";  //图片格式
//    public static String host = "http://localhost:8080";//服务器IP
//    public static String rootPath = "E:\\app\\";//服务器路径
//    private static final String ROTATE = "rotate";
//
//    private static String localhost = "47.112.132.196:8081/imgs";
//
//    public static StringBuffer upload(MultipartFile files[]) {
//        String url = null;
//
//        StringBuffer buf = new StringBuffer();
//        for (MultipartFile file : files) {
//            String fileName = file.getOriginalFilename();
//            String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
//            // 新的图片文件名 = 获取时间戳+"."图片扩展名
//            String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
//            //创建输出文件对象
//            File outFile = new File(Constant.imgURL + newFileName);
//            File parentFile = outFile.getParentFile();
//            if (!outFile.getParentFile().exists()) {
//                //假如文件不存在即重新创建新的文件已防止异常发生
//                outFile.getParentFile().mkdirs();
//            }
//            try {
//                file.transferTo(outFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//
//            }
//            String key = System.currentTimeMillis() + ".png";
//            url = CosUtils.upLoad(key, outFile);
//            buf.append(url + ";");
//        }
//        return buf;
//    }
//
//    public static String uploadOne(MultipartFile file) {
//        String url = null;
//
//        String fileName = file.getOriginalFilename();
//        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
//        // 新的图片文件名 = 获取时间戳+"."图片扩展名
//        String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
//        //创建输出文件对象
//        File outFile = new File(Constant.imgURL + newFileName);
//        File parentFile = outFile.getParentFile();
//        if (!outFile.getParentFile().exists()) {
//            //假如文件不存在即重新创建新的文件已防止异常发生
//            outFile.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(outFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        String key = System.currentTimeMillis() + ".png";
//        url = CosUtils.upLoad(key, outFile);
//        return url;
//    }
//
//    public static String uploadLocalhost(MultipartFile file) {
//        String ip = getIp();
//        String fileName = file.getOriginalFilename();
//        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
//        // 新的图片文件名 = 获取时间戳+"."图片扩展名
//        String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
//        String urls = "http://" + ip + "/" + newFileName;
//        //创建输出文件对象
//        File outFile = new File(Constant.imgURL + newFileName);
//        File parentFile = outFile.getParentFile();
//        if (!outFile.getParentFile().exists()) {
//            //假如文件不存在即重新创建新的文件已防止异常发生
//            outFile.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(outFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        return urls;
//    }
//
//    public static StringBuffer uploadLocalhosts(MultipartFile files[]) {
//        String url = null;
//
//        StringBuffer buf = new StringBuffer();
//        for (MultipartFile file : files) {
//            String fileName = file.getOriginalFilename();
//            String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
//            // 新的图片文件名 = 获取时间戳+"."图片扩展名
//            String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
//            String name = Constant.imgURL + newFileName;
//            String urls = "http://" + localhost + "/" + newFileName;
//            //创建输出文件对象
//            File outFile = new File(name);
//            File parentFile = outFile.getParentFile();
//            if (!outFile.getParentFile().exists()) {
//                //假如文件不存在即重新创建新的文件已防止异常发生
//                outFile.getParentFile().mkdirs();
//            }
//            try {
//                file.transferTo(outFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            buf.append(urls + ";");
//        }
//        return buf;
//    }
//
//
//    static Boolean isImageFile(String fileName) {
//        String[] img_type = new String[]{".jpg", ".jpeg", ".png", ".gif", ".bmp"};
//        if (fileName == null) {
//            return false;
//        }
//        fileName = fileName.toLowerCase();
//        for (String type : img_type) {
//            if (fileName.endsWith(type)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 获取文件后缀名
//     *
//     * @param fileName
//     * @return
//     */
//    static String getFileType(String fileName) {
//        if (fileName != null && fileName.indexOf(".") >= 0) {
//            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
//
//        }
//        return "";
//    }
//
////    public static void main(String[] args) {
////        try {
////            String url="https://app-1253518772.cos.ap-guangzhou.myqcloud.com/c841a3e1059f2969dd1a3fbc068463cc.mp4";
////           String lpath = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."))+".png";
////            String a=randomGrabberFFmpegVideoImage(url,"",2);
////            System.out.println(a);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
////
////    /** 获取视频缩略图
////     * @param lpath
////     * @param filePath：视频路径
////     * @param mod：视频长度/mod获取第几帧
////     * @throws Exception
////     */
////    public static String randomGrabberFFmpegVideoImage(String filePath, String lpath, int mod) throws Exception {
////        String targetFilePath = "";
////        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
////        ff.start();
////        String rotate = ff.getVideoMetadata(ROTATE);
////        int ffLength = ff.getLengthInFrames();
////        Frame f;
////        int i = 0;
////        int index = mod;
////        while (i < ffLength) {
////            f = ff.grabImage();
////            if (i == index) {
////                if (null != rotate && rotate.length() > 1) {
////                    OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
////                    opencv_core.IplImage src = converter.convert(f);
////                    f = converter.convert(rotate(src, Integer.valueOf(rotate))); //旋转图片
////                }
////                targetFilePath = getImagePath(lpath, i); //根据视频路径生成缩略图存放路径 
////                doExecuteFrame(f, targetFilePath); //获取缩略图
////                break;
////            }
////            i++;
////        }
////        ff.stop();
////        return targetFilePath; //返回的是视频第一帧
////    }
////
////    /**
////     *  
////     *      * 旋转图片 
////     *      * @param src 
////     *      * @param angle 
////     *      * @return 
////     *      
////     */
////    public static opencv_core.IplImage rotate(opencv_core.IplImage src, int angle) {
////        opencv_core.IplImage img = opencv_core.IplImage.create(src.height(), src.width(), src.depth(), src.nChannels());
////        opencv_core.cvTranspose(src, img);
////        opencv_core.cvFlip(img, img, angle);
////        return img;
////    }
////
////    private static String getImagePath(String filePath, int index) {
////        return rootPath + filePath;
////    }
////
////    public static void doExecuteFrame(Frame f, String targerFilePath) {
////        if (null == f || null == f.image) {
////            return;
////        }
////        Java2DFrameConverter converter = new Java2DFrameConverter();
////        BufferedImage bi = converter.getBufferedImage(f);
////        File output = new File(targerFilePath);
////        try {
////            ImageIO.write(bi, IMAGEMAT, output);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//
////        }
//
//        }