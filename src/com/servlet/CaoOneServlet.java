package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ProductCategoryService;
import com.service.impl.ProductCategoryServiceImpl;
import com.util.ProductCategoryVo;
import com.util.ShoppingCar;

public class CaoOneServlet extends HttpServlet {

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
		if(action==null){
			//三级所有商品信息
			ProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
			List<ProductCategoryVo> vos=productCategoryService.selAll();
			request.setAttribute("vos",vos);
			request.getRequestDispatcher("buyCarOne.jsp").forward(request, response);
		}else if("delete".equals(action)){
			//三级所有商品信息
			ProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
			List<ProductCategoryVo> vos=productCategoryService.selAll();
			request.setAttribute("vos",vos);
			
			ShoppingCar shoppingCar=null;
			HttpSession session=request.getSession();
			if(session.getAttribute("shoppingCar")!=null){
				shoppingCar=(ShoppingCar)session.getAttribute("shoppingCar");
			}else{
				shoppingCar=new ShoppingCar();
			}
			String index=request.getParameter("index");
			shoppingCar.delete(Integer.parseInt(index));
			request.getRequestDispatcher("buyCarOne.jsp").forward(request, response);
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
