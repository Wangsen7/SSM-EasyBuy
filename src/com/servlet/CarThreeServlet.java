package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductCategoryDao;
import com.dao.ProductDao;
import com.dao.impl.ProductCategoryDaoImpl;
import com.dao.impl.ProductDaoImpl;
import com.entity.User;
import com.service.ProductCategoryService;
import com.service.impl.ProductCategoryServiceImpl;
import com.util.ProductCategoryVo;
import com.util.ShoppingCar;
import com.util.ShoppingCarItem;

public class CarThreeServlet extends HttpServlet {

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
		ProductDao product=new ProductDaoImpl();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String pro=request.getParameter("pro");
		if(pro==null){
			//三级所有商品信息
	
		}
		/*else if(pro.equals("dizier")){
			HttpSession session=request.getSession();
			String dizi=request.getParameter("dizi");
            if(dizi==null||dizi.equals("null")||dizi.equals("")){
            	out.print("<script>alert(\"地址不能为空！\");location.href=\"CarTwoServlet\"</script>");
            }else{
            	session.setAttribute("dizi", dizi);
            	out.print("<script>alert(\"地址填写成功，请继续下单！\");location.href=\"CarTwoServlet\"</script>");
            }
			
		}*/else if(pro.equals("qeire")){
			//三层分类
			HttpSession session=request.getSession();
			ProductCategoryService productCtegoryDao=new ProductCategoryServiceImpl();			
			List<ProductCategoryVo> overlist=productCtegoryDao.selAll();	
			
			String address=request.getParameter("address");
			request.setAttribute("overlist", overlist);			
			User user=(User)session.getAttribute("user");
			
			if(user==null){
				out.print("<script>alert(\"还未登录，请先登录！\");location.href=\"login.jsp\"</script>");
			}else if(address==null){
				out.print("<script>alert(\"地址不能为空,请填写地址并提交！\");location.href=\"CarTwoServlet\"</script>");
			}else{
			String userAddress=address;
			float cost=Float.parseFloat(request.getParameter("zong"));
			
			String serialNumber=UUID.randomUUID().toString().replace("-","").toUpperCase();
			int sf=product.tdindan(user.getId(), user.getLoginName(), userAddress, cost, serialNumber);
			if(sf>0){
				ShoppingCar shingpingitem=(ShoppingCar)session.getAttribute("shoppingCar");
				int orderId=product.diid();
				for (ShoppingCarItem detail : shingpingitem.getList()) {
					int productId=detail.getProduct().getId();
					int quantity=detail.getNum();
					float cost1=detail.getNum()*detail.getProduct().getPrice();
					product.tdshangp(orderId, productId, quantity, cost1);
				}
			
							

				session.removeAttribute("shingpingitem");
				request.setAttribute("cost", cost);
				
				request.setAttribute("serialNumber", serialNumber);
				request.getRequestDispatcher("buyCarThree.jsp").forward(request, response);
				}else{				
					out.print("<script>alert(\"加入购物车失败！\");location.href=\"CarTwoServlet\"</script>");
				}
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
