package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.myweb.www.domain.UserVO;
import com.myweb.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO udao;
	
	@Override
	public void signUp(UserVO uvo) {
		udao.signUp(uvo);
	}

	@Override
	public UserVO login(UserVO uvo) {
		return udao.login(uvo);
	}
<<<<<<< HEAD
<<<<<<< HEAD

	@Override
	public boolean idCheck(UserVO uvo) {
		UserVO check = udao.idCheck(uvo);
		log.info("check : "+check);
		if(check != null) {
			log.info("아이디 중복됨");
			return true;
		}
		log.info("아이디 사용가능");
		return false;
	}
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	
 
	
}

