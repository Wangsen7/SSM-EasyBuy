package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.entity.Product;
import com.entity.User;
import com.service.ProductService;
import com.service.UserService;
import com.service.impl.ProductServiceImpl;
import com.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		UserService userService=new UserServiceImpl();
		if(action.equals("login")){
			String loginName=request.getParameter("loginName");
			String password=request.getParameter("password");
			//给密码加密
			password=DigestUtils.md5Hex(password);
			User user=userService.selByLoginNameAndPassword(loginName, password);
			if(user!=null){
				request.getSession().setAttribute("user",user);
				
				out.print("<script>alert('登录成功');location.href='IndexServlet'</script>");
			}else{
				out.print("<script>alert('登录失败');location.href='login.jsp'</script>");
			}
		}else if(action.equals("regist")){
			String loginName=request.getParameter("loginName");
			String password=request.getParameter("password");
			password=DigestUtils.md5Hex(password);
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			String userName=request.getParameter("userName");
			int sex=Integer.parseInt(request.getParameter("sex"));
			String identityCode=request.getParameter("identityCode");
			int type=0;
			User user=new User();
			user.setEmail(email);
			user.setIdentityCode(identityCode);
			user.setLoginName(loginName);
			user.setUserName(userName);
			user.setType(type);
			user.setMobile(mobile);
			user.setPassword(password);
			user.setSex(sex);
			int line=userService.addByUser(user);
			if(line>0){
				out.print("<script>alert('注册成功');location.href='login.jsp'</script>");
			}else{
				out.print("<script>alert('注册失败');location.href='regist.jsp'</script>");
			}
		}else if(action.equals("user")){
			String loginName=request.getParameter("loginName");			
			int line=userService.selUserCountByLoginName(loginName);
			if(line>0){
				out.print("已存在该用户！");
			}
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
