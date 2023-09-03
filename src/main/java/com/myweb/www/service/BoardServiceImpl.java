package com.myweb.www.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.BoardDAO;
import com.myweb.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO udao;

	@Override
	public void insert(BoardVO bvo) {
		
		udao.insert(bvo);
	}

	@Override
	public ArrayList<BoardVO> list(PagingVO pvo) {
		
		return udao.list(pvo);
	}

	@Override
	public int count() {
		
		return udao.count();
	}
	
}
