package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{
	
	MemberEntity findByMemNo(Integer uuid);
	
	List<MemberEntity> findByMemStateTrue();
	
	List<MemberEntity> findAll();
	
	List<MemberEntity> findByMemSex(Integer gender);
	
	MemberEntity findByMemMail(String mail);
	
	MemberEntity findByMemMobile(String mobile);

}
