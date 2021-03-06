package com.Dy.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Dy.Pojo.PageInfo;
import com.Dy.Pojo.User;
import com.Dy.Service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	
	//首页
//	@RequestMapping(value="/index")
//	public String index(HttpServletRequest request, HttpServletResponse response,Model model) {
//		Cookie[] cookies = request.getCookies();
//		if(cookies==null) 
//			return "login";
//		else{
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equals("SessionId"))
//					  User user = (User)request.getSession().getSessionContext().getSession(cookie.getValue()).getAttribute("User");
//			}
//		}
//		
//		return "index";
//	}
	
	
	@RequestMapping(value="/login")
	public String login(String username,String password,HttpServletRequest request, HttpServletResponse response) {
		User user = userService.GetUserByNameAndPw(username, password);
		//如果账号密码错误
		if(user==null)
			return "login";
		//如果第一次登录,创建session,保存
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		//
		request.getCookies();
		
		return "login";
	}
}
