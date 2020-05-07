package hu.ponte.hr.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.ponte.hr.services.ImageStore;

@RestController()
@RequestMapping("api/images")
public class ImagesController {

    @Autowired
    private ImageStore imageStore;

    @GetMapping("meta")
    public List<ImageMeta> listImages() {
    	List<ImageMeta> imageList = imageStore.findAll();
    	return imageList;
    }

    @GetMapping("preview/{id}")
    public ImageMeta getImage(@PathVariable("id") String id, HttpServletResponse response) {
    	return imageStore.getOne(id);
	}

}
