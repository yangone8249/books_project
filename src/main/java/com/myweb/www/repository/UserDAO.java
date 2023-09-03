package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.UserVO;

public interface UserDAO {
	
	void signUp(UserVO uvo);

	UserVO login(UserVO uvo);
	
}
