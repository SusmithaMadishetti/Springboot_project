package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
	   @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer id;
	    private String name;
        @Column(unique=true)
	    private String email;
        
    /*    public String getDesc() 
        return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		private String desc;*/
      
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
        
}