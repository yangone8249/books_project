package com.myweb.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 727353784ff21ddea1623784970f933179313c00
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.UserVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.BoardService;
import com.myweb.www.service.UserService;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@Slf4j
@RequestMapping("/board/*")
public class boardController {
	
	@Inject
	private BoardService bsv;

<<<<<<< HEAD
<<<<<<< HEAD
//	insert 페이지 이동
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	@GetMapping("insert")
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView("/board/insert");
		return mav;
	}
<<<<<<< HEAD
<<<<<<< HEAD

//	도서 insert 메서드
=======
	
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
	
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	@PostMapping("insert")
	public ModelAndView insertPost(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/board/insert");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		log.info("title : "+title);
		log.info("writer : "+writer);
		log.info("user : "+user);
		log.info("content : "+content);
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
		long size = file.getSize(); //파일 사이즈
		
		System.out.println("파일명 : "  + fileRealName);
		System.out.println("용량크기(byte) : " + size);
		

		
		if(title == null || title.equals("")) {
			
			log.info("title if문 진입");
			request.setAttribute("title", 1);
			return mav;
		}
		if(writer == null || writer.equals("")) {
			
			log.info("writer if문 진입");
			request.setAttribute("writer", 1);
			return mav;
		}
		if(user == null || user.equals("")) {
			
			log.info("user if문 진입");
			redirectAttributes.addFlashAttribute("user", null);
			redirectAttributes.addFlashAttribute("ses", 1);
			mav = new ModelAndView("redirect:/");
			return mav;
		}
		if(fileRealName == null || fileRealName.equals("")) {
			
			log.info("file if문 진입");
			request.setAttribute("file", 1);
			return mav;
		}
		if(content == null || content.equals("")) {
			
			log.info("content if문 진입");
			request.setAttribute("content", 1);
			return mav;
		}
		
		//파일 업로드 경로 지정
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		String uploadFolder = "E:\\_myweb\\_java\\fileUpload";

		//DB와 폴더에 넣을 파일명 지정(랜덤)
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유문자열" + uniqueName);
		System.out.println("확장자명" + fileExtension);
		String img = uniqueName+fileExtension;
				
		//이미지 형식인지 체크
		final String[] IMG_EXTENSION = { "jpg", "png", "jpeg", "gif", "bmp" };
		String imgfileCheck = null;
		for(int i=0; i<IMG_EXTENSION.length; i++) {
			log.info(i+"번째");
			if(fileExtension.substring(1).equals(IMG_EXTENSION[i])) {
				log.info("if문 진입! "+IMG_EXTENSION[i]);
				imgfileCheck =  "";
				break;
			}
		}
		if(imgfileCheck == null) {

			log.info("img파일이 아닙니다.");
			request.setAttribute("img", 1);
			return mav;
		}
		
		// 실제 저장될 경로
		File saveFile = new File(uploadFolder+"\\"+uniqueName + fileExtension);  
		

		System.out.println("실제 저장될 경로 : " + saveFile);
		
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
			File saveThumbFile = new File(uploadFolder+"\\"+"th_"+uniqueName + fileExtension); 
			Thumbnails.of(saveFile).size(75, 75).toFile(saveThumbFile);
			
			BoardVO bvo = new BoardVO(title, writer, user, content, img);
			log.info("bvo : "+bvo);
			
			bsv.insert(bvo);
			
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav = new ModelAndView("redirect:/");
		return mav;
	}
<<<<<<< HEAD
<<<<<<< HEAD
	
//	List 출력 메서드
=======

>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======

>>>>>>> 727353784ff21ddea1623784970f933179313c00
	@GetMapping("allList")
	public ModelAndView allList(HttpServletRequest request, PagingVO pvo) {
		ModelAndView mav = new ModelAndView("/board/list");
		log.info(">>>>pageVO : " + pvo);
		ArrayList<BoardVO> list = bsv.list(pvo);
<<<<<<< HEAD
<<<<<<< HEAD
		int count = bsv.count(pvo);
=======
		int count = bsv.count();
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
		int count = bsv.count();
>>>>>>> 727353784ff21ddea1623784970f933179313c00
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		PagingHandler ph = new PagingHandler(pvo, count);
		request.setAttribute("ph", ph);
		return mav;
	}
<<<<<<< HEAD
<<<<<<< HEAD

//	도서 detail 메서드
	@GetMapping("detail")
	public ModelAndView detail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/board/detail");
		
		int bno = Integer.parseInt(request.getParameter("bno"));

		log.info("bno : "+bno);
		
		BoardVO bvo = bsv.detail(bno);
		
		log.info("bvo : "+bvo);
		
		request.setAttribute("bvo", bvo);
		
		return mav;
	}

//	도서 update 페이지 이동
	@GetMapping("update")
	public ModelAndView GetUpdate(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/board/update");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		String img = request.getParameter("img");

		log.info("bno : "+bno);
		log.info("title : "+request.getParameter("title"));
		log.info("writer : "+request.getParameter("writer"));
		log.info("content : "+request.getParameter("content"));
		log.info("user : "+request.getParameter("user"));
		log.info("img : "+request.getParameter("img"));
		
		BoardVO bvo = new BoardVO(bno, title, writer, user, content, img);
		
		log.info("bvo : "+bvo);
		
		request.setAttribute("bvo", bvo);
		
		return mav;
	}

//	도서 update 메서드
	@PostMapping("update")
	public ModelAndView PutUpdate(HttpServletRequest request, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("/board/update");
		

		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		String img = request.getParameter("img");

		log.info("bno : "+bno);
		log.info("title : "+request.getParameter("title"));
		log.info("writer : "+request.getParameter("writer"));
		log.info("content : "+request.getParameter("content"));
		log.info("user : "+request.getParameter("user"));
		log.info("img : "+request.getParameter("img"));

		BoardVO bvo = new BoardVO(bno, title, writer, user, content, img);
		
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
		long size = file.getSize(); //파일 사이즈
		
		System.out.println("파일명 : "  + fileRealName);
		System.out.println("용량크기(byte) : " + size);
		
		request.setAttribute("bvo", bvo);
		
		if(title == null || title.equals("")) {
			
			log.info("title if문 진입");
			request.setAttribute("title", 1);
			return mav;
		}
		if(writer == null || writer.equals("")) {
			
			log.info("writer if문 진입");
			request.setAttribute("writer", 1);
			return mav;
		}
		if(user == null || user.equals("")) {
			
			log.info("user if문 진입");
			redirectAttributes.addFlashAttribute("user", null);
			redirectAttributes.addFlashAttribute("ses", 1);
			mav = new ModelAndView("redirect:/");
			return mav;
		}
		if(fileRealName == null || fileRealName.equals("")) {
			
			log.info("file if문 진입");
			request.setAttribute("file", 1);
			return mav;
		}
		if(content == null || content.equals("")) {
			
			log.info("content if문 진입");
			request.setAttribute("content", 1);
			return mav;
		}
		
		//파일 업로드 경로 지정
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		String uploadFolder = "E:\\_myweb\\_java\\fileUpload";

		//DB와 폴더에 넣을 파일명 지정(랜덤)
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유문자열" + uniqueName);
		System.out.println("확장자명" + fileExtension);
		img = uniqueName+fileExtension;
				
		//이미지 형식인지 체크
		final String[] IMG_EXTENSION = { "jpg", "png", "jpeg", "gif", "bmp" };
		String imgfileCheck = null;
		for(int i=0; i<IMG_EXTENSION.length; i++) {
			log.info(i+"번째");
			if(fileExtension.substring(1).equals(IMG_EXTENSION[i])) {
				log.info("if문 진입! "+IMG_EXTENSION[i]);
				imgfileCheck =  "";
				break;
			}
		}
		if(imgfileCheck == null) {

			log.info("img파일이 아닙니다.");
			request.setAttribute("img", 1);
			return mav;
		}
		
		// 실제 저장될 경로
		File saveFile = new File(uploadFolder+"\\"+uniqueName + fileExtension);  
		

		System.out.println("실제 저장될 경로 : " + saveFile);
		
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
			File saveThumbFile = new File(uploadFolder+"\\"+"th_"+uniqueName + fileExtension); 
			Thumbnails.of(saveFile).size(75, 75).toFile(saveThumbFile);
			
			bvo = new BoardVO(bno, title, writer, user, content, img);
			log.info("bvo : "+bvo);
			
			bsv.update(bvo);
			
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav = new ModelAndView("redirect:/");
		return mav;
	}
	
	@GetMapping("delete")
	public ModelAndView delete(HttpServletRequest request, PagingVO pvo) {
		ModelAndView mav = new ModelAndView("/board/list");
		log.info("delete 진입");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		log.info("bno : "+bno);
		
		bsv.delete(bno);
		
		log.info(">>>>pageVO : " + pvo);
		ArrayList<BoardVO> list = bsv.list(pvo);
		int count = bsv.count(pvo);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		PagingHandler ph = new PagingHandler(pvo, count);
		request.setAttribute("ph", ph);

		return mav;
	}

	@GetMapping("loanUpdate")
	public ModelAndView loanUpdate(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/board/detail");
		log.info("loanUpdate 진입");
		int bno = Integer.parseInt(request.getParameter("bno"));
		log.info("bno : "+bno);
		int uno = Integer.parseInt(request.getParameter("uno"));
		log.info("uno : "+uno);
		

		bsv.loanUpdate(bno, uno);
		
		BoardVO bvo = bsv.detail(bno);
		
		log.info("bvo : "+bvo);
		
		request.setAttribute("bvo", bvo);
		
		return mav;
	}
	
	@GetMapping("loanDelete")
	public ModelAndView loanDelete(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/board/detail");
		log.info("loanUpdate 진입");
		int bno = Integer.parseInt(request.getParameter("bno"));
		log.info("bno : "+bno);
		int uno = Integer.parseInt(request.getParameter("uno"));
		log.info("uno : "+uno);
		
		bsv.loanDelete(bno);
		
		BoardVO bvo = bsv.detail(bno);
		
		log.info("bvo : "+bvo);
		
		request.setAttribute("bvo", bvo);
		
		return mav;
	}
	
	@GetMapping("myList")
	public ModelAndView myList(HttpServletRequest request, PagingVO pvo, HttpSession session) {
		ModelAndView mav = new ModelAndView("/board/myList");
		
		log.info(">>>>pageVO : " + pvo);
		UserVO uvo = (UserVO)session.getAttribute("user");
		log.info(">>>>uvo : " + uvo);
		
		ArrayList<BoardVO> list = bsv.myList(uvo.getUserNum(), pvo);
		int count = bsv.myListCount(uvo.getUserNum());
		log.info(">>>>count : " + count);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		PagingHandler ph = new PagingHandler(pvo, count);
		request.setAttribute("ph", ph);
		return mav;
	}
=======
	
>>>>>>> 727353784ff21ddea1623784970f933179313c00
=======
	
>>>>>>> 727353784ff21ddea1623784970f933179313c00
}
