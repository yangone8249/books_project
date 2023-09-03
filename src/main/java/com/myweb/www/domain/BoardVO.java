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
public class BoardVO {
	
	
	public BoardVO(String title, String writer, String user, String content, String img) {
		
		boardTitle = title;
		boardWriter = writer;
		boardUser = user;
		boardContent = content;
		boardImg = img;
	}
	private int boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardRegDate;
	private int boardCount;
	private String boardImg;
	private int boardLoan; //대출했는지 안했는지 여부
	private String boardUser;
	
}
