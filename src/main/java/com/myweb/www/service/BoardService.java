package com.myweb.www.service;

import java.util.ArrayList;
import java.util.List;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;


public interface BoardService {

	void insert(BoardVO bvo);

	ArrayList<BoardVO> list(PagingVO pvo);

	int count();


}
