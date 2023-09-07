package com.myweb.www.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
<<<<<<< HEAD
<<<<<<< HEAD
import com.myweb.www.domain.UserVO;
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
		
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
		
>>>>>>> 727353784ff21ddea1623784970f933179313c00
		udao.insert(bvo);
	}

	@Override
	public ArrayList<BoardVO> list(PagingVO pvo) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
		
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
		
>>>>>>> 727353784ff21ddea1623784970f933179313c00
		return udao.list(pvo);
	}

	@Override
<<<<<<< HEAD
<<<<<<< HEAD
	public int count(PagingVO pvo) {
		return udao.count(pvo);
	}

	@Override
	public void update(BoardVO bvo) {
		 udao.update(bvo);
	}

	@Override
	public void delete(int bno) {
		udao.delete(bno);
	}

	@Override
	public void loanUpdate(int bno, int uno) {
		udao.loanUpdate(bno, uno);
	}

	@Override
	public void loanDelete(int bno) {
		udao.loanDelete(bno);
	}

	@Override
	public BoardVO detail(int bno) {
		return udao.detail(bno);
	}

	@Override
	public ArrayList<BoardVO> myList(int i, PagingVO pvo) {
		return udao.myList(i, pvo);
	}

	@Override
	public int myListCount(int userNum) {
		return udao.myListCount(userNum);
=======
	public int count() {
		
		return udao.count();
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
	public int count() {
		
		return udao.count();
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	}
	
}
