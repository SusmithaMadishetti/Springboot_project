package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

public class PhotosController {
	 @Value("${accessKey}")
	 String accessKey;
	 @Value("${secretKey}")
	 String secretKey;
	
	@Autowired
	UploadToS3 s3;
	
@GetMapping(value="/recordAudio")
public ModelAndView renderIndex() {
	return new ModelAndView("recordAudio");
}



	@PostMapping(value="/base64Audio")
	public ModelAndView uploadToS3( @RequestParam("file")MultipartFile image,HttpServletRequest request,
			@RequestParam("recording")String recording) throws Exception {
		ModelAndView successPage= new ModelAndView("success");
		System.out.println("incoming message..");
		if(recording.isEmpty())throw new Exception("recording data is null");
		Decoder decoder=Base64.getDecoder();
		System.out.println(recording);
		byte[] decodedByte=decoder.decode(recording.split(",")[1]);
		FileOutputStream fos;
		BasicAWSCredentials cred=new BasicAWSCredentials(accessKey,secretKey);
		AmazonS3 s3client=AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(cred))
				.withRegion(Regions.US_EAST_2)
				.build();
		try {
			fos=new FileOutputStream("MyAudioTemp.webm");
			fos.write(decodedByte);
			fos.close();
			
			PutObjectRequest putReq=new PutObjectRequest("memoriasush",image.getOriginalFilename(),image.getInputStream(),new ObjectMetadata())
					.withCannedAcl(CannedAccessControlList.PublicRead);
					s3client.putObject(putReq);
					String imgSrc="http://" + "memoriasush" + ".s3.amazonaws.com/" + image.getOriginalFilename();
					successPage.addObject("imgSrc",imgSrc);
//				return successPage;
					
		
		}catch(IOException e) {
			e.printStackTrace();
//			successPage.setViewName("error");
//			 return successPage;
		}
		String myId=(String) request.getSession().getAttribute("id");
		String postId="1";
		String audioURl=s3.upload(myId+postId+".webm",new FileInputStream("MyAudioTemp.webm"));
		successPage.addObject("audioURL",audioURl);
		return successPage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value="/picture")
	public ModelAndView renderIndex1() {
		return new ModelAndView("picture");
	}
	@PostMapping(value="/base64picture")
	public ModelAndView saveAudioAndRenderPage(HttpServletRequest request,@RequestParam("recording1")String recording1) throws Exception {
		ModelAndView successPage= new ModelAndView("success");
		System.out.println("incoming picture..");
		if(recording1.isEmpty())throw new Exception("picture data is null");
		Decoder decoder=Base64.getDecoder();
		System.out.println(recording1);
		byte[] decodedByte=decoder.decode(recording1.split(",")[1]);
		FileOutputStream fos;
		try {
			fos=new FileOutputStream("MyAudioTemp.webm");
			fos.write(decodedByte);
			fos.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		String myId=(String) request.getSession().getAttribute("id");
		String postId="1";
		String pictureURl=s3.upload(myId+postId+".jpeg",new FileInputStream("MypictureTemp.jpeg"));
		successPage.addObject("pictureURL",pictureURl);
		return successPage;
	}





 }









