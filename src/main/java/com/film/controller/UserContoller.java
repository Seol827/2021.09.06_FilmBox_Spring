package com.film.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.film.dto.UserDTO;
import com.film.service.UserService;
import com.mysql.cj.Session;



@Controller
public class UserContoller {

	//private static final Logger logger = LoggerFactory.getLogger(UserContoller.class);

	@Autowired
	private UserService service;

	//회원가입 페이지
	@RequestMapping("/join")
	public String userJoin()
	{
		return "login/join";
	}

	//회원가입 환영 페이지
	@RequestMapping("/joinresult")
	public String joinresult(Model model, UserDTO dto)
	{
		service.insertFilmUser(dto);
		model.addAttribute("member_name", dto.getMember_name());
		return "login/joinresult";
	}

	@RequestMapping(value = "/useridcheck", method = RequestMethod.POST)
	@ResponseBody
	public String idcheck(String member_id)
	{
		int result=service.idcheck(member_id);

		if(result!=0)
			return "fail";
		else
			return "success";

	}

	//마이페이지
	@RequestMapping("/mypage")
	public String goMyPage()
	{
		return "mypage";
	}
	//마이페이지>내 포인트 내역
	@RequestMapping("/mypointlist")
	public String mypointlist()
	{
		return "user/mypointlist";
	}
	//마이페이지>회원정보수정
	@RequestMapping("/myinfo")
	public String myinfo()
	{
		return "user/pwdcheck";
	}
	//마이페이지>나의 필름스토리
	@RequestMapping("/myfilmstory")
	public String myfilmstory()
	{
		return "user/myfilmstory";
	}
	//마이페이지>my예매내역
	@RequestMapping("/myreservelist")
	public String myreservelist()
	{
		return "user/myreservelist";
	}
	
	//회원 정보 수정 전 비밀번호 체크
	@PostMapping("/myinfo")
	public String pwdcheck(HttpSession session, UserDTO dto)
	{
		String member_id=(String) session.getAttribute("login");
		String member_pwd=dto.getMember_pwd();
		
		dto.setMember_id(member_id);
		dto.setMember_pwd(member_pwd);
		
		int result=service.pwdcheck(dto);

		if(result>0)
		{
			return "redirect:modify";
		}
		else
		{
			return "redirect:myinfo";
		}
	}

	//회원 정보 수정
	@GetMapping("/modify")
	public String mypage(Model model, HttpSession session)
	{
		String member_id=(String) session.getAttribute("login");
		//System.out.println("session 테스트------------" + member_id);
		UserDTO dto=service.userDetail(member_id);
		
		model.addAttribute("dto", dto);
		return "user/modifyform";
	}
	
	//수정 후 DB 저장(+메인페이지로 이동)
	@RequestMapping("/modifyresult")
	public String updateUser(Model model, UserDTO dto)
	{
		boolean tf=false;
		Map<String, Object> result=new HashMap<String, Object>();
		if(dto!=null)
		{
			tf=service.updateUser(dto);
		}
		result.put("result", tf);
		return "redirect:mypage";
	}	
	
	//회원 탈퇴
	@RequestMapping("/userquit")
	public String userquit(HttpSession session)
	{
		String member_id=(String) session.getAttribute("login");
		service.deleteUser(member_id);
		
			session.removeAttribute("login");
			session.invalidate();
		
		return "redirect:main";
	}
	
}