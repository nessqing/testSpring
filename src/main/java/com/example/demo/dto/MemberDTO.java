package com.example.demo.dto;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@Schema(name = "MemberDTO", description = "會員")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Data
public class MemberDTO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_no")
    private Integer memNo;
	
    @Schema(description = "name")
    private String memName;

    @Schema(description = "memSex")
    private Integer memSex;

    @Schema(description = "memEmail")
    private String memMail;

    @Schema(description = "memPassword")
    private String memPassword;

    @Schema(description = "memMobiles")
    private String memMobile;

    
    @Schema(description = "memAddress")
    private String memAdd;
    
    @Schema(description = "memState")
    private boolean memState;
	


}
