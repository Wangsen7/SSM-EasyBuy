<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="m_left">
        	<div class="left_n">管理中心</div>
            <div class="left_m">
            
           <c:choose>
           
           	<c:when test="${user.type==0 }">  
            	<div class="left_m_t t_bg1">订单中心</div>
            	<ul>
            	<li><a href="IndexServlet">主页</a></li>
            	</ul>
                <ul>
                	<li><a href="MemberUserServlet?action=wodei">我的订单</a></li>
                    
                </ul>
            </div>
            </c:when>
        <c:otherwise>
        <div class="left_m_t t_bg1">订单中心</div>
            	<ul>
            	<li><a href="IndexServlet">主页</a></li>
            	</ul>
                <ul>
                	<li><a href="MemberUserServlet?action=wodei">我的订单</a></li>
                	                	
                    <li><a href="MemberUserServlet?action=quan">全部订单</a></li>      
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg2">会员中心</div>
                <ul>
                	 <li><a href="MemberUserServlet?action=user">用户信息</a></li>    
                    <li><a href="MemberUserServlet">用户列表</a></li>                  
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg3">商品管理</div>
                <ul>              
                    <li><a href="ProductServlet?pro=spxx">商品信息</a></li>
                    <li><a href="HTshoppingsj.jsp">商品上架</a></li>
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg4">商品分类中心</div>
                <ul>
                	<li><a href="MemberUserServlet?action=common" class="now">商品分类信息</a></li>
                </ul>
            </div>
             <div class="left_m">
            	<div class="left_m_t t_bg4">新闻中心</div>
                <ul>
                	<li><a href="NewsListServlet" class="now">新闻信息</a></li>
                	<li><a href="HTaddnewsT.jsp" class="now">发布新闻</a></li>
                </ul>
            </div>
            </c:otherwise>
         </c:choose>
        </div>