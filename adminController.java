package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class adminController {	
	@Autowired
	private UserRepository userRepo;	
	 @GetMapping (value="/useradded")
	 public ModelAndView getAllUsers() {
		 ModelAndView mv=new ModelAndView();
		 List<User> users=(List<User>) userRepo.findAll();
		 mv.addObject("users",users);
		 mv.setViewName("allUsers"); 
		 return mv;
		 
	 }
	
	 @PostMapping(value="/allUpage")
	 public ModelAndView handleRedirect(
				 @RequestParam(name="myId")String myId,
				 @RequestParam(name="myName")String myName,
				 @RequestParam(name="myEmail")String myEmail,
				 @RequestParam(name="myFriends")String myFriends,
				 HttpServletRequest req
				    )
		     {
			 ModelAndView mv = new ModelAndView();
			 req.getSession().setAttribute("id", myId);	
			 if(myEmail=="madishettisusmitha@gmail.com") {
					mv.setViewName("redirect:/useradded");
					return mv;
					
							}
				else {
					return new ModelAndView("error");
					}
			}
}
	 
	 
	 
	/*
	 @PostMapping(value="/user/add")
	 public ModelAndView saveUser(
		 @RequestParam(name="name",required=true)String name,@RequestParam String email){
			User u=new User();
			u.setEmail(email);
			u.setName(name);
		//	u.setDesc(desc);
			userRepo.save(u);
			return new ModelAndView("redirect:/useradded");
}
	

	 @GetMapping(value="/user")
	 public ModelAndView getOneUser(@RequestParam (name="id",required=true)String id)
	 {
		 ModelAndView mv =new ModelAndView();
		 try {
			 List<User> result=userRepo.findByEmail(String email);
			 if(result.isPresent()) {
				 User t = result.get();
				 mv.addObject("user",t);
				 mv.setViewName("userInfo");
			 }
			 else
			 {
				 throw new Exception("not found");
			 }
		 }
				 catch(Exception e) {
					 mv.addObject("error","User not Present");
					 mv.setViewName("userError");
					 e.printStackTrace();
				 }
		 return mv;
	 }

}*/