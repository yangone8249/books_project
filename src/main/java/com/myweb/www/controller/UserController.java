package com.myweb.www.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.UserVO;
import com.myweb.www.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user/*")
public class UserController {
	
	@Inject
	private UserService usv;
	
	
	@GetMapping("/signUp")
	public ModelAndView signUpGet() {
        ModelAndView mav = new ModelAndView("/user/signUp");
		return mav;
	}
<<<<<<< HEAD

	//회원가입 메서드
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	@PostMapping("/signUp")
	public ModelAndView signUpPost(HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView("/user/signUp");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		log.info("ID : "+id);
		log.info("PW : "+pw);
		if(id == null || id == "") {
			
			log.info("id if문 진입");
			request.setAttribute("id", 1);
			return mav;	
		}
		if(pw == null || pw == "") {
			
			log.info("pw if문 진입");
			request.setAttribute("pw", 1);
			return mav;	
		}
		
		UserVO uvo = new UserVO(id, pw);
		log.info("uvo : "+uvo);
		
<<<<<<< HEAD
		//id 중복체크
		boolean idCheck = usv.idCheck(uvo);  //중복체크 Service 이동
		log.info("idCheck : "+idCheck);
		if(idCheck) {
			log.info("id중복 확인");
			request.setAttribute("idCheck", 1);
			return mav;
		}
		
		usv.signUp(uvo); //회원가입 Service 이동
		
=======
		usv.signUp(uvo);
>>>>>>> 727353784ff21ddea1623784970f933179313c00
		mav = new ModelAndView("redirect:/");
		
		return mav;	
	}
<<<<<<< HEAD

	//로그인 메서드
=======
	
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		log.info("ID : "+id);
		log.info("PW : "+pw);
		
		if(id == null || id == "") {
			
			log.info("id if문 진입");
			redirectAttributes.addFlashAttribute("id", 1);
			return mav;
		}
		if(pw == null || pw == "") {
			
			log.info("pw if문 진입");
			redirectAttributes.addFlashAttribute("pw", 1);
			return mav;
		}
		
		UserVO uvo = new UserVO(id, pw);
		log.info("uvo : "+uvo);
		
<<<<<<< HEAD
		uvo = usv.login(uvo); //로그인 Service 이동
=======
		uvo = usv.login(uvo);
>>>>>>> 727353784ff21ddea1623784970f933179313c00
		
		log.info("uvo : "+uvo);
		if(uvo == null) {
			
			log.info("uvo Null");
			redirectAttributes.addFlashAttribute("uvo", 1);
			return mav;
		}

<<<<<<< HEAD
		session.setAttribute("user", uvo); //세션 설정
=======
		session.setAttribute("user", uvo);
>>>>>>> 727353784ff21ddea1623784970f933179313c00
		session.setMaxInactiveInterval(20*60); //세션 20분 지속
		return mav;
	}
	
<<<<<<< HEAD
	//logout 메서드
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		log.info("ses : "+session.getAttribute("user"));
		
<<<<<<< HEAD
		session.invalidate(); //세션 끊기
=======
		session.invalidate();
>>>>>>> 727353784ff21ddea1623784970f933179313c00
		
		return mav;
	}
}
