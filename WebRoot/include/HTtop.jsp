<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="m_top_bg">
    <div class="top">
        <div class="m_logo"><a href="Index.html"><img src="images/logo1.png" /></a></div>
        <div class="m_search">
            <form action="MemberUserServlet?action=search" method="post">
                <input type="text" value="" class="m_ipt" name="loginName" />
                <input type="submit" value="搜索" class="m_btn" />
            </form>                      
           
        </div>
      	<!--    购物车 -->
        <div class="i_car" id="car">
    	<%@ include file="car.jsp" %>
   	 </div>
    </div>
</div>
