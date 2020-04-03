package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.News;
import com.entity.Product;
import com.service.NewsService;
import com.service.ProductCategoryService;
import com.service.ProductService;
import com.service.impl.NewsServiceImpl;
import com.service.impl.ProductCategoryServiceImpl;
import com.service.impl.ProductServiceImpl;
import com.util.ProductCategoryVo;

public class IndexServlet extends HttpServlet {

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
		ProductService productService=new ProductServiceImpl();
		/*进口商品*/
		List<Product> list1=productService.selByCategoryLevel1IdAndLimit(660,6);
		request.setAttribute("list1",list1);
		/*家用商品*/
		List<Product> list2=productService.selByCategoryLevel1IdAndLimit(628,6);
		request.setAttribute("list2",list2);
		/*化妆品*/
		List<Product> list3=productService.selByCategoryLevel1IdAndLimit(548,6);
		request.setAttribute("list3",list3);
		//电子商品
		List<Product> list4=productService.selByCategoryLevel1IdAndLimit(670,6);
		request.setAttribute("list4",list4);
		//保健食品
		List<Product> list5=productService.selByCategoryLevel1IdAndLimit(676,6);
		request.setAttribute("list5",list5);
		//箱包
		List<Product> list6=productService.selByCategoryLevel1IdAndLimit(681,6);
		request.setAttribute("list6",list6);
		//三级所有信息
		ProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
		List<ProductCategoryVo> vos=productCategoryService.selAll();
		request.setAttribute("vos",vos);
		//资讯
		NewsService newsService=new NewsServiceImpl();
		List<News> newsList=newsService.selByLimit(5);
		request.setAttribute("newsList",newsList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
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

		doPost(request, response);
	}

}
