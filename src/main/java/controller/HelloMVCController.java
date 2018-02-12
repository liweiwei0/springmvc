package controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/hello")
public class HelloMVCController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloMVCController.class);

	@RequestMapping("/mvc")
	public String helloMvc() {
		System.out.println(logger);
		return "home";
	}
	
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {
		if(null != file) {
			logger.info("文件上传中："+file.getName());
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\Users\\lww\\Desktop", System.currentTimeMillis()+file.getOriginalFilename()));
		}
		return "success";
	}
}
