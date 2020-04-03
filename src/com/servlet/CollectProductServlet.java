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
import com.entity.ProductCategory;
import com.service.ProductCategoryService;
import com.service.ProductService;
import com.service.impl.ProductCategoryServiceImpl;
import com.service.impl.ProductServiceImpl;
import com.util.CollectProduct;
import com.util.HistoryProduct;
import com.util.ProductCategoryVo;
//收藏商品
public class CollectProductServlet extends HttpServlet {

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
		ProductCategoryService proc=new ProductCategoryServiceImpl();
		if(action==null){
			//收藏商品
			CollectProduct collectProduct=null;
			HttpSession session=request.getSession();
			if(session.getAttribute("collectProduct")!=null){
				collectProduct=(CollectProduct)session.getAttribute("collectProduct");
			}else{
				collectProduct=new CollectProduct();
			}
			String id=request.getParameter("id");
			ProductService productService=new ProductServiceImpl();
			Product product=productService.selByid(Integer.parseInt(id));
			int reg=collectProduct.addCollectProduct(product);
			session.setAttribute("collectProduct",collectProduct);		
			out.print(reg);
		}else if(action.equals("delete")){
			//收藏商品
			CollectProduct collectProduct=null;
			HttpSession session=request.getSession();
			if(session.getAttribute("collectProduct")!=null){
				collectProduct=(CollectProduct)session.getAttribute("collectProduct");
			}else{
				collectProduct=new CollectProduct();
			}
			String index=request.getParameter("index");
			collectProduct.deleteCollectProduct(Integer.parseInt(index));
			session.setAttribute("collectProduct",collectProduct);		
			request.getRequestDispatcher("HTcollect.jsp").forward(request, response);
			/**
			 * 添加分类商品
			 */
		}else if(action.equals("add")){
			String name=request.getParameter("three");
			Integer parentId=Integer.parseInt(request.getParameter("parentid"));
			Integer type=Integer.parseInt(request.getParameter("jb"));
			ProductCategory productCategory=new ProductCategory();
			productCategory.setName(name);
			productCategory.setParentId(parentId);
			productCategory.setType(type);
			int line=proc.add(name, parentId, type);
			
			/*out.print(line);*/
			if(line>0){				
				out.print("<script>alert('添加成功');location.href='MemberUserServlet?action=common'</script>");
			}else{
				out.print("<script>alert('添加失败');</script>");
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
