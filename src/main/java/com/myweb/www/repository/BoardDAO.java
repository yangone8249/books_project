package com.myweb.www.repository;

import java.util.ArrayList;
import java.util.List;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;

public interface BoardDAO {

	void insert(BoardVO bvo);

	ArrayList<BoardVO> list(PagingVO pvo);

	int count();


	
}
