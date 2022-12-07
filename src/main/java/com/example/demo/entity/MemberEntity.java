package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MEMBER")
public class MemberEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_no")
    private Integer memNo;
		
	@Column(name = "mem_name")
	private String memName;
	
	@Column(name = "mem_sex")
	private Integer memSex;
	
	@Column(name = "mem_mail")
	private String memMail;
	
	@Column(name = "mem_password")
	private String memPassword;
	
	@Column(name = "mem_mobile")
	private String memMobile;
	
	@Column(name = "mem_img")
	private byte[] memImage;
	
	//memo:address
	@Column(name = "mem_add")
	private String memAdd;
	
	@Column(name = "mem_state")
	private boolean memState;
	
	
	
	

}
