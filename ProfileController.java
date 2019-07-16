package com.example.demo;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
@Controller
public class ProfileController {
	@Autowired
	private UserRepository userRepo;	
	
	 @Value("${accessKey}")
	 String accessKey;
	 @Value("${secretKey}")
	 String secretKey;
	 
	// @RequestMapping(value="/profile",method=RequestMethod.GET)
	 
	// @GetMapping(value="/") 
	// public ModelAndView renderPage() {
	//	 ModelAndView indexPage =new ModelAndView();
		// indexPage.setViewName("index1");
		// return indexPage;
	// }
	 @PostMapping(value="/upload")
	 
	 public ModelAndView uploadToS3(
			 @RequestParam("file")MultipartFile image
//			 @RequestParam(name="myEmail")String myEmail,
			// @RequestParam (name="name")String name,
		// @RequestParam(name="desc") String desc
			 )
			 {
			ModelAndView profilePage =new ModelAndView();
		 BasicAWSCredentials cred=new BasicAWSCredentials(accessKey,secretKey);
	AmazonS3 s3client=AmazonS3ClientBuilder
			.standard()
			.withCredentials(new AWSStaticCredentialsProvider(cred))
			.withRegion(Regions.US_EAST_2)
			.build();
		 
		 try {
		PutObjectRequest putReq=new PutObjectRequest("memoriasush",image.getOriginalFilename(),image.getInputStream(),new ObjectMetadata())
		.withCannedAcl(CannedAccessControlList.PublicRead);
		s3client.putObject(putReq);
		String imgSrc="http://" + "memoriasush" + ".s3.amazonaws.com/" + image.getOriginalFilename();
		profilePage.addObject("imgSrc",imgSrc);
//		System.out.println(name);
//		User r = userRepo.findByEmail(myEmail);
	//	User u=new User();
	//	r=new User();
	//	u.setDesc(desc);
		//u.setName(name);
    //   userRepo.save(u);
	//	profilePage.addObject(u);
		profilePage.setViewName("profile");
 return profilePage;

//	}
//		else {
//			return new ModelAndView("facebookindex");
//			}
//		 		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 profilePage.setViewName("error");
		 return profilePage;
	}
		
		 
	 }

  }
	 //public String renderFirstPage(@RequestParam Map<String,Object>model,Model viewModel) {
	//	return "index";
	 // }

