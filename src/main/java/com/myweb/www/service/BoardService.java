package com.myweb.www.service;

import java.util.ArrayList;
import java.util.List;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
<<<<<<< HEAD
import com.myweb.www.domain.UserVO;
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00


public interface BoardService {

	void insert(BoardVO bvo);

	ArrayList<BoardVO> list(PagingVO pvo);

<<<<<<< HEAD
	int count(PagingVO pvo);

	void update(BoardVO bvo);

	void delete(int bno);

	void loanUpdate(int bno, int uno);

	void loanDelete(int bno);
	
	BoardVO detail(int bno);

	ArrayList<BoardVO> myList(int i, PagingVO pvo);

	int myListCount(int userNum);
=======
	int count();

>>>>>>> 727353784ff21ddea1623784970f933179313c00

}
