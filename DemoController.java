  package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class DemoController {
@Autowired
private UserRepository userRepo;	
@GetMapping(value="/")
public ModelAndView renderpage() {
	 ModelAndView mv=new ModelAndView();
	 mv.setViewName("home");
	 return mv;
}

@GetMapping(value="/admin")
public ModelAndView rendersomepage() {
	 ModelAndView mv=new ModelAndView();
	 mv.setViewName("adminlogin");
	 return mv;
}
	 @GetMapping(value="/facebook")
	 public ModelAndView renderFB() {
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("facebookindex");
		 return mv;
	 }
	 @PostMapping(value="/facebookRedirect")
 public ModelAndView handleRedirect(
			 @RequestParam(name="myId")String myId,
			 @RequestParam(name="myName")String myName,
			 @RequestParam(name="myEmail")String myEmail,
			 @RequestParam(name="myFriends")String myFriends,
			 HttpServletRequest req
			    )
	     {
		 ModelAndView mv = new ModelAndView();
		 System.out.println("myId:"+myId+ "myName:"+ myName+"myemail:"+myEmail+myFriends);
	 String[]splitted=myFriends.split("/");
	for(int i=0;i<splitted.length;i++) {
		 System.out.println(i+":"+splitted[i]);
	 }
		 req.getSession().setAttribute("id", myId);
		// System.out.println(myId);
		// System.out.println("session attrs :"+ myId);
		 
		 
		 System.out.println("session attrs :"+ myId);
			
			boolean b = userRepo.existsByEmail(myEmail);
			System.out.println("boolean b value "+b);
			if(b==false) {
				
				User u= userRepo.findByEmail(myEmail);
				u=new User();
				u.setName(myName);
				u.setEmail(myEmail);
		        userRepo.save(u);
		        mv.addObject(u);				  			
				mv.setViewName("index");
				return mv;
				
						}
			else {
				return new ModelAndView("profile");
				}
		}
				/*User u = userRepo.findByEmail(myEmail);
				if(u==null) {
					u=new User();
			//	u.setId(myId);
				u.setName(myName);
				u.setEmail(myEmail);
		        userRepo.save(u);
				mv.addObject(u);
				mv.setViewName("index");
				return mv;	
			}
			else {
				return new ModelAndView("profile");
				}
	     }*/
//		userRepo.save(y);
////System.out.println(myId+myName+myEmail+myFriends);
//// String[]splitted=myFriends.split("/");
////for(int i=0;i<splitted.length;i++) {
//	// System.out.println(i+":"+splitted[i]);
//// }
////req.getSession().setAttribute("id", myId);
////Optional<User> user = userRepo.findById(Integer.parseInt(myId));
//
////mv.addObject("user",user);
//return new ModelAndView("/redirect/index1");
// }
	 
	 
	//@GetMapping(value="/") 
//	 public ModelAndView renderIndex() {
//		 ModelAndView mv =new ModelAndView();
//		 mv.setViewName("index");
//		 return mv;
//	 }
	
	
//	

}
	 
