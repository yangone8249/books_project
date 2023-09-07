package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.UserVO;

public interface UserDAO {
	
	void signUp(UserVO uvo);

	UserVO login(UserVO uvo);
<<<<<<< HEAD

	UserVO idCheck(UserVO uvo);
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	
}
