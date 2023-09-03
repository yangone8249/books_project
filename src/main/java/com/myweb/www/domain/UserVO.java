package com.myweb.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserVO {
	
	
	public UserVO(String id, String pw) {
		
		userId = id;
		userPw = pw;
	}
	private int userNum;
	private String userId;
	private String userPw;
	private String userRegdate;
	
}
