package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Product;
import com.service.ProductCategoryService;
import com.service.ProductService;
import com.service.impl.ProductCategoryServiceImpl;
import com.service.impl.ProductServiceImpl;
import com.util.CollectProduct;
import com.util.Page;
import com.util.ProductCategoryVo;

public class BrandListServlet extends HttpServlet {

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
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String action=request.getParameter("action");
		ProductService productService=new ProductServiceImpl();
		String currentPageNo=request.getParameter("currentPageNo");
		
		
		Page page=null;
		List<Product> list=null;
		if(action==null||action.equals("dian")){
			if(currentPageNo==null){
				currentPageNo="1";
			}			
			String id=request.getParameter("id");
			page=productService.selPageByCurrentPageNo(Integer.parseInt(currentPageNo),Integer.parseInt(id));
			request.setAttribute("id",id);
			request.setAttribute("action","dian");
			//为了查询一共有多少件商品
		list=productService.selByCategoryLevel1IdOrCategoryLevel2IdOrCategoryLevel3Id(Integer.parseInt(id));
		}else if(action.equals("search")){
			if(currentPageNo==null){
				currentPageNo="1";
			}	
			String name=request.getParameter("name");
			page=productService.selPageByCurrentPageNoAndName(Integer.parseInt(currentPageNo),name);
			request.setAttribute("name",name);
			request.setAttribute("action","search1");
			list=productService.selByName(name);
		}else if(action.equals("search1")){
			if(currentPageNo==null){
				currentPageNo="1";
			}	
			String name=request.getParameter("name");
			name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
			page=productService.selPageByCurrentPageNoAndName(Integer.parseInt(currentPageNo),name);
			request.setAttribute("name",name);
			request.setAttribute("action","search1");
			//为了查询一共有多少件商品
			list=productService.selByName(name);
		}
		
		//三级所有商品信息
		ProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
		List<ProductCategoryVo> vos=productCategoryService.selAll();
		request.setAttribute("vos",vos);
		request.setAttribute("page",page);
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("brandList.jsp").forward(request, response);
/*		out.flush();An error has occurred. See error log for more details.
org.mozilla.xpcom.internal.XPCOMImpl.getComponentManager()Lorg/mozilla/interfaces/nsIComponentManager;*/

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
