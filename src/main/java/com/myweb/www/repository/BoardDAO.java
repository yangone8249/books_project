package com.myweb.www.repository;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.UserVO;
=======
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
>>>>>>> 727353784ff21ddea1623784970f933179313c00

public interface BoardDAO {

	void insert(BoardVO bvo);

	ArrayList<BoardVO> list(PagingVO pvo);

<<<<<<< HEAD
	int count(PagingVO pvo);

	void update(BoardVO bvo);

	void delete(int bno);

	void loanUpdate(@Param("bno") int bno, @Param("uno") int uno);

	void loanDelete(int bno);

	BoardVO detail(int bno);

	ArrayList<BoardVO> myList(@Param("uno")int uno, @Param("pvo")PagingVO pvo);
	
	int myListCount(@Param("uno")int uno);
=======
	int count();


	
>>>>>>> 727353784ff21ddea1623784970f933179313c00
}
