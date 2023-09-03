package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.UserVO;

public interface UserService {
	
	void signUp(UserVO uvo);

	UserVO login(UserVO uvo);


}
