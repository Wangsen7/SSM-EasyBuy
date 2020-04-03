<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="car_t">购物车 [ <span>${fn:length(shoppingCar.list) }</span> ]</div>
        <div class="car_bg">
       		<!--Begin 购物车未登录 Begin-->
        	<div class="un_login"><c:if test="${empty user }">还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a></c:if> 查看购物车！</div>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
            	<c:forEach items="${shoppingCar.list }" var="list">
            		<li>
                	<div class="img"><a href="#"><img src="${ctx }/files/${list.product.fileName}" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">${list.product.name }</a></div>
                    <div class="price"><font color="#ff4e00">￥${list.product.price }</font> X${list.num }</div>
                </li>
            	</c:forEach>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span><c:out value="${shoppingCar.sum }" default="0"></c:out></span></div>
            <div class="price_a"><a href="CaoOneServlet">去购物车结算</a></div>
            <!--End 购物车已登录 End-->
        </div>
