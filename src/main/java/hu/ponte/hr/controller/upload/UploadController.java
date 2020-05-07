package hu.ponte.hr.controller.upload;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import hu.ponte.hr.controller.ImageMeta;
import hu.ponte.hr.services.ImageStore;
import hu.ponte.hr.services.SignService;
@Component
@RequestMapping("api/file")
public class UploadController
{
	@Autowired
	ImageStore imageStore;
	@Autowired
	SignService signService;

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file) {
    	
    	if (file.getSize() <= 2048000) {
    		
	    	ImageMeta im = new ImageMeta();
	    	im.setId("id_" + System.currentTimeMillis());
	    	
	    	try {
				String encodedString = signService.signAndBase64EncodeFile(file);
				im.setDigitalSign(encodedString);
			} catch (NoSuchAlgorithmException | InvalidKeyException | IOException | SignatureException e) { 
				
				e.printStackTrace();
			}
	    	
	    	im.setMimeType(file.getContentType());
	    	im.setName(file.getOriginalFilename());
	    	im.setSize(file.getSize());
	    	imageStore.save(im);
	    	
    	}
    	
    	return "ok";
    }

}
