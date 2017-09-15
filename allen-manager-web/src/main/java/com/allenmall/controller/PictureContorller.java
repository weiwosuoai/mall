package com.allenmall.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.allenmall.common.utils.FastDFSClient;
import com.allenmall.common.utils.JsonUtils;

/**
 * 图片controller
 * @author Allen
 *
 */
@Controller
public class PictureContorller {
	
	private static final Log logger = LogFactory.getLog(PictureContorller.class);
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	/**
	 * 上传图片
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping(value = "/pic/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		try {
			// 1.取文件的拓展名
			String originalFileName = uploadFile.getOriginalFilename();
			String extName = originalFileName.substring(originalFileName.indexOf(".") + 1);
			// 2.利用 fastdfs utils 上传图片
			FastDFSClient client = new FastDFSClient("classpath:client.conf");
			// 3.图片服务器返回的图片所在的路径
			String path = client.uploadFile(uploadFile.getBytes(), extName);
			// 4.拼接 要返回的 url
			String url = IMAGE_SERVER_URL + path;
			
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			
			// 5.转换成 json 字符串（Note: js 组将浏览器兼容）
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			logger.error("", e);
		}
		Map result = new HashMap<>();
		result.put("error", 1);
		result.put("message", "上传图片失败！");
		return JsonUtils.objectToJson(result);
	}
	

}
