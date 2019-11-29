package com.sp.bdi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sp.bdi.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SessionFilter implements Filter {

 
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpSession hs = hsr.getSession();
		String uri =hsr.getRequestURI();
		
		UserVO user = null;
		if(hs.getAttribute("user")!=null) {
			user =(UserVO)hs.getAttribute("user");
			//getAttribute는 속성을 통한 설정이 없으면 무조건 null값을 리턴하기 때문에 
			//hs.getAttribute("user")가 있으면 (아마 map 형태일것)
			
			
		if(user==null && uri.indexOf("login")==-1){
			//user 가 null 이거나 hsr.getRequestURL으로 받아온 주소에
			//login이 들어가 있으면 0 없으면 -1 경우
			if(uri.indexOf("/views")==0) {
			//경로가 /views 일 경우
				hsr.setAttribute("msg","로그인 해주세요");
				hsr.setAttribute("url", "/views/user/login");
				RequestDispatcher rd = request.getRequestDispatcher("/views/msg");
				rd.forward(request, response);
				return;
			}
			log.debug("uri=>{}",uri);
			throw new ServletException("로그인이 필요합니다.");
		}
	
			log.debug("filter user:{}",user);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
