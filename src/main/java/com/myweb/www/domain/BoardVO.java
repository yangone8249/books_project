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
	
<<<<<<< HEAD
<<<<<<< HEAD
=======
	
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
	
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	public BoardVO(String title, String writer, String user, String content, String img) {
		
		boardTitle = title;
		boardWriter = writer;
		boardUser = user;
		boardContent = content;
		boardImg = img;
	}
<<<<<<< HEAD
<<<<<<< HEAD
	public BoardVO(int bno, String title, String writer, String user, String content, String img) {
		
		boardNum = bno;
		boardTitle = title;
		boardWriter = writer;
		boardUser = user;
		boardContent = content;
		boardImg = img;
	}
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	private int boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardRegDate;
	private int boardCount;
	private String boardImg;
<<<<<<< HEAD
<<<<<<< HEAD
	private int boardLoan; 
	private String boardUser;
	private int boardAuth; //대출했는지 안했는지 여부
=======
	private int boardLoan; //대출했는지 안했는지 여부
	private String boardUser;
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
	private int boardLoan; //대출했는지 안했는지 여부
	private String boardUser;
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	
}
