package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.dao.impl.OrderDetailDaoImpl;
import com.entity.Easybuy;
import com.entity.Easybuylist;
import com.entity.Order;
import com.entity.OrderDetail;
import com.entity.ProductCategory;
import com.entity.User;
import com.service.OrderDetailService;
import com.service.ProductCategoryService;
import com.service.UserService;
import com.service.impl.OrderDetialServiceImpl;
import com.service.impl.ProductCategoryServiceImpl;
import com.service.impl.UserServiceImpl;
import com.util.Page;
import com.util.ProductCaPage;
import com.util.UserPage;
//用户
public class MemberUserServlet extends HttpServlet {

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
		UserService userService=new UserServiceImpl();
		String currentPageNo=request.getParameter("currentPageNo");
		String action=request.getParameter("action");
		String id=request.getParameter("id");	
		OrderDetailService servler=new OrderDetialServiceImpl();
		HttpSession session=request.getSession();
		ProductCategoryService pros=new ProductCategoryServiceImpl();
		
		if(action==null){
			if(currentPageNo==null){
				currentPageNo="1";
			}
			UserPage userPage=userService.selByCurrentPageNo(Integer.parseInt(currentPageNo));
			request.setAttribute("userPage",userPage);
			request.getRequestDispatcher("HTmemberUser.jsp").forward(request, response);
		}else if(action.equals("showUpdate")){
			User user1=userService.selById(Integer.parseInt(id));
			request.setAttribute("user1",user1);
			request.getRequestDispatcher("HTaddMemberUser.jsp").forward(request, response);
		/**
		 * 修改用户信息	
		 */
		}else if(action.equals("update")){
			String loginName=request.getParameter("loginName");
			String userName=request.getParameter("userName");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			String identityCode=request.getParameter("identityCode");
			String type=request.getParameter("type");
			int typeInt=0;
			if(type.equals("管理员")){
				typeInt=1;
			}
			User user=new User();
			user.setEmail(email);
			user.setId(Integer.parseInt(id));
			user.setIdentityCode(identityCode);
			user.setLoginName(loginName);
			user.setMobile(mobile);
			user.setUserName(userName);
			user.setType(typeInt);
			int line=userService.updateUserByUser(user);
			if(line>0){
				out.print("<script>alert('修改信息成功');location.href='MemberUserServlet'</script>");
			}else{
				out.print("<script>alert('修改信息失败');location.href='MemberUserServlet'</script>");
			}
		}else if(action.equals("delete")){
			int line=userService.deleteById(Integer.parseInt(id));
			if(line>0){
				out.print("<script>alert('删除信息成功');location.href='MemberUserServlet'</script>");
			}else{
				out.print("<script>alert('删除信息失败');location.href='MemberUserServlet'</script>");
			}
		}else if(action.equals("search")){
			String sea=request.getParameter("sea");
			String loginName=null;
			if(sea==null){
				 loginName=request.getParameter("loginName");
			}else{
				loginName=new String(loginName.getBytes("ISO-8859-1"),"UTF-8");
			}
			if(currentPageNo==null){
				currentPageNo="1";
			}
			UserPage userPage=userService.selByCurrentPageNoAndLoginName(Integer.parseInt(currentPageNo), loginName);
			request.setAttribute("userPage",userPage);
			request.setAttribute("sea","sea");
			request.setAttribute("loginName",loginName);
			request.getRequestDispatcher("HTmemberUser.jsp").forward(request, response);
		}else if(action.equals("news")){
			/*String sea=request.getParameter("sea");
			String loginName=null;
			if(sea==null){
				 loginName=request.getParameter("loginName");
			}else{
				loginName=new String(loginName.getBytes("ISO-8859-1"),"UTF-8");
			}
			if(currentPageNo==null){
				currentPageNo="1";
			}
			UserPage userPage=userService.selByCurrentPageNoAndLoginName(Integer.parseInt(currentPageNo), loginName);
			request.setAttribute("userPage",userPage);
			request.setAttribute("sea","sea");
			request.setAttribute("loginName",loginName);		*/	
			request.getRequestDispatcher("HTnews.jsp").forward(request, response);
		}else if(action.equals("wodei")){
			User user=(User)session.getAttribute("user");
			if(user==null){
				out.print("<script>alert(\"还未登录，请先登录！\");location.href=\"login.jsp\"</script>");
			}else{
			int userid=user.getId();
			List<Order> list=servler.Orderlist(userid);
			request.setAttribute("list", list);
			request.getRequestDispatcher("Member_Order.jsp").forward(request, response);
			}
		}else if(action.equals("quan")){
			User user=(User)session.getAttribute("user");
			if(user.getType()!=1){
				request.getRequestDispatcher("MemberUserServlet?action=wodei").forward(request, response);
			}else{
				List<Easybuylist> lists=new ArrayList<Easybuylist>();
				Page pagenews=new Page();
				String currPageNo=request.getParameter("currPageNo");
					    	if(currPageNo==null){
					    	currPageNo="1";
					    	}
				pagenews=servler.selPage(Integer.parseInt(currPageNo));
				for (Order easybuyOrder : pagenews.getList2()) {
					List<Easybuy> details=servler.details(easybuyOrder.getId());
					    Easybuylist easybuylist=new Easybuylist(easybuyOrder.getLoginName(), easybuyOrder.getSerialNumber(), 
							easybuyOrder.getUserAddress(), easybuyOrder.getCost(), details);
					    lists.add(easybuylist);
				}
				request.setAttribute("pagenews", pagenews);
				request.setAttribute("lists", lists);
				request.getRequestDispatcher("Member_Results.jsp").forward(request, response);
			}
			/**
			 * 查询商品信息
			 */
			}else if(action.equals("common")){		
				
				if(currentPageNo==null){
					currentPageNo="1";
				}		
				ProductCaPage pcg=pros.selPageByCurrentPageNo(Integer.parseInt(currentPageNo));
				
				request.setAttribute("sea","sea");
				request.setAttribute("pcg",pcg);
				request.getRequestDispatcher("HTcommodity.jsp").forward(request, response);
				
			}else if(action.equals("commone")){		
				
				String s=request.getParameter("s");
				ProductCaPage pcg=pros.selPageByCurrentPageNo(Integer.parseInt(s));
				request.setAttribute("sea","sea");
				request.setAttribute("pcg",pcg);
				
				request.getRequestDispatcher("HTcommodity.jsp").forward(request, response);
				/**在commondity.js中调用
				 * 局部刷新显示分类
				 */
			}else if(action.equals("last")){
				String s=request.getParameter("s");
				ProductCaPage pcg=pros.selPageByCurrentPageNo(Integer.parseInt(s));
				request.setAttribute("sea","sea");
				request.setAttribute("pcg",pcg);				
				request.getRequestDispatcher("HTcommodity.jsp").forward(request, response);
				
			}
			
			else if(action.equals("seltype")){
				Integer parentId=Integer.parseInt(request.getParameter("parentId"));
				List<ProductCategory> product=pros.selByParentId(parentId);
				out.print(JSON.toJSONString(product));
				/**
				 * 登陆后的用户信息
				 */
			}else if(action.equals("user")){
				User user=(User)session.getAttribute("user");
				if(user==null){
					out.print("<script>alert(\"还未登录，请先登录！\");location.href=\"login.jsp\"</script>");
				}else{
					/*int usid=user.getId();
					User us=userService.selById(usid);				
					request.setAttribute("us","us");*/
					request.getRequestDispatcher("Member_User.jsp").forward(request, response);
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
