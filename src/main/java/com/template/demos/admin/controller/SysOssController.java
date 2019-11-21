//package com.kcg.touristguide.admin.controller;
//
////import com.admin.paper_recycling.utils.*;
//import com.kcg.touristguide.utils.AliyunOSSUtil;
//import com.kcg.touristguide.utils.Constant;
//import com.kcg.touristguide.utils.R;
//import com.kcg.touristguide.utils.RRException;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/sys/oss")
//public class SysOssController {
////    @Autowired
////    private SysOssService sysOssService;
////    @Autowired
////    private SysConfigService sysConfigService;
//
//    private final static String KEY = Constant.CLOUD_STORAGE_CONFIG_KEY;
//
//
//    @ApiOperation(value = "上传图片")
//    @PostMapping("/upload")
//    public R upload(@RequestParam("file") MultipartFile file) {
//        String filename = file.getOriginalFilename();
//        System.out.println(filename);
//        try {
//            if (file != null) {
//                if (!"".equals(filename.trim())) {
//                    String originalFilename = file.getOriginalFilename();
//                    System.out.println(originalFilename);
//                    String fileType = originalFilename.substring(originalFilename.lastIndexOf(".", originalFilename.length()));
//                    // 上传到OSS
//                    String upload = AliyunOSSUtil.upload(file.getInputStream(), fileType);
//                    R r = new R();
//                    Map map = new HashMap();
//
//                    r.put("url", upload);
//                    return r;
//
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return R.error("上传失败");
//    }
////    /**
////     * 列表
////     *
////     * @param params 请求参数
////     * @return R
////     */
////    @RequestMapping("/list")
////    @RequiresPermissions("sys:oss:all")
////    public R list(@RequestParam Map<String, Object> params) {
////        //查询列表数据
////        PageUtilsPlus pageUtil = sysOssService.queryPage(params);
////        return R.ok().put("page", pageUtil);
////    }
////]
//
////    /**
////     * 获取云存储配置信息
////     *
////     * @return R
////     */
////    @RequestMapping("/config")
////    @RequiresPermissions("sys:oss:all")
////    public R config() {
////        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);
////
////        return R.ok().put("config", config);
////    }
//
//
////    /**
////     * 保存云存储配置信息
////     *
////     * @param config 配置信息
////     * @return R
////     */
////    @SysLog("保存云存储配置信息")
////    @RequestMapping("/saveConfig")
////    @RequiresPermissions("sys:oss:all")
////    public R saveConfig(@RequestBody CloudStorageConfig config) {
////        //校验类型
////        ValidatorUtils.validateEntity(config);
////
////        if (config.getType() == Constant.CloudService.QINIU.getValue()) {
////            //校验七牛数据
////            ValidatorUtils.validateEntity(config, QiniuGroup.class);
////        } else if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
////            //校验阿里云数据
////            ValidatorUtils.validateEntity(config, AliyunGroup.class);
////        } else if (config.getType() == Constant.CloudService.QCLOUD.getValue()) {
////            //校验腾讯云数据
////            ValidatorUtils.validateEntity(config, QcloudGroup.class);
////        } else if (config.getType() == Constant.CloudService.DISCK.getValue()) {
////            //校验腾讯云数据
////            ValidatorUtils.validateEntity(config, DiskGroup.class);
////        }
////
////        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));
////
////        return R.ok();
////    }
//
//    /**
//     * 上传文件到本地
//     *
//     * @param file 文件
//     * @return R
//     * @throws Exception 异常
//     */
//
////    @RequestMapping("/upload")
////    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
////        if (file.isEmpty()) {
////            throw new RRException("上传文件不能为空");
////        }
////        String url= FileUploadUtil.uploadOne(file);
////        R r = new R();
////        r.put("url", url);
////        r.put("link", url);
////        return r;
////    }
//
////    @RequestMapping("/uploadMult")
////    public R uploadMult(@RequestParam("file") MultipartFile[] file) throws Exception {
////
////        String url= String.valueOf(FileUploadUtil.upload(file));
////        R r = new R();
////        r.put("url", url);
////        r.put("link", url);
////        return r;
////    }
////    /**
////     * 删除图片
////     *
////     * @param ids 主键集
////     * @return R
////     */
////    @SysLog("删除图片")
////    @RequestMapping("/delete")
////    @RequiresPermissions("sys:oss:all")
////    public R delete(@RequestBody Long[] ids) {
////        sysOssService.removeByIds(Arrays.asList(ids));
////
////        return R.ok();
////    }
//
////    @PostMapping("/categories")
////    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
////        categoryService.add(bean);
////        saveOrUpdateImageFile(bean, image, request);
////        return bean;
////    }
////    @RequestMapping("/uploadFile")
////    public R saveOrUpdateImageFile(MultipartFile file)
////            throws IOException {
////        String num=CommonUtil.generateOrderNumber();
////        File imageFolder= new File("D:\\java\\imgs");
////        File files = new File(imageFolder,num+".jpg");
////        if(!files.getParentFile().exists())
////            files.getParentFile().mkdirs();
////        file.transferTo(files);
////        BufferedImage img = ImageUtil.change2jpg(files);
////        ImageIO.write(img, "jpg", files);
////        String s="http://39.97.247.130:8097/imgs/"+num+".jpg";
////        R r = new R();
////        r.put("url", s);
////        r.put("link", s);
////        return r;
////    }
//
//}
