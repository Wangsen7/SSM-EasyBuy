package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.News;
import com.entity.ProductCategory;
import com.service.NewsService;
import com.service.ProductCategoryService;
import com.service.impl.NewsServiceImpl;
import com.service.impl.ProductCategoryServiceImpl;
import com.util.NewsPage;

public class NewsListServlet extends HttpServlet {

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
	/**
	 * 新闻管理
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		NewsService newsService=new NewsServiceImpl();
		String currentPageNo=request.getParameter("currentPageNo");
		String action=request.getParameter("action");
		String id=request.getParameter("id");
		if(action==null){
			if(currentPageNo==null){
				currentPageNo="1";
			}
			NewsPage newsPage=newsService.selPageByCurrentPageNo(Integer.parseInt(currentPageNo));
			/*List<News> newsList=newsService.selAll();
			request.setAttribute("newsList",newsList);*/
			request.setAttribute("newsPage",newsPage);
			request.getRequestDispatcher("HTnewsList.jsp").forward(request, response);
		}else if(action.equals("news")){
			List<News> listn=newsService.selNewsById(Integer.parseInt(id));		
			request.setAttribute("listn",listn);
			request.getRequestDispatcher("HTnews.jsp").forward(request, response);
		}else if(action.equals("add")){
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Date date=new Date();
			News news=new News();
			news.setTitle(title);
			news.setContent(content);
			news.setCreateTime(date);
			int line=newsService.addNews(news);
			if(line>0){
				out.print("<script>alert('"+date+"');location.href='NewsListServlet'</script>");
			}else{
				out.print("<script>alert('添加资讯失败');location.href='HTaddnewsT.jsp'</script>");
			}
			//跳转到修改页面
		}else if(action.equals("addNews")){
			
			List<News> news=newsService.selNewsById(Integer.parseInt(id));
			request.setAttribute("news",news);
			request.setAttribute("up","up");
			request.getRequestDispatcher("HTaddNews.jsp").forward(request, response);
			
		}else if(action.equals("update")){
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Date date=new Date();
			News news=new News();
			news.setContent(content);
			news.setCreateTime(date);
			news.setTitle(title);
			news.setId(Integer.parseInt(id));
			int line=newsService.updateNews(news);
			if(line>0){				
				out.print("<script>alert('修改资讯成功');location.href='NewsListServlet'</script>");
			}else{
				out.print("<script>alert('修改资讯失败');location.href='NewsListServlet'</script>");
			}
		}else if(action.equals("delete")){
			int line=newsService.deleteNews(Integer.parseInt(id));
			if(line>0){				
				out.print("<script>alert('删除资讯成功');location.href='NewsListServlet'</script>");
			}else{
				out.print("<script>alert('删除资讯失败');location.href='NewsListServlet'</script>");
			}
		}else if(action.equals("search")){
			String title=request.getParameter("title");
			String sea=request.getParameter("sea");
			if(sea!=null){
				title=new String(title.getBytes("ISO-8859-1"),"UTF-8");
			}
			if(currentPageNo==null){
				currentPageNo="1";
			}
			NewsPage newsPage=newsService.selByCurrentPageNoAndTitle(Integer.parseInt(currentPageNo), title);
			request.setAttribute("newsPage",newsPage);
			request.setAttribute("sea","sea");
			request.setAttribute("title",title);
			request.getRequestDispatcher("HTnewsList.jsp").forward(request, response);
			
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
