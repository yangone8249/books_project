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
	
 
	
}

