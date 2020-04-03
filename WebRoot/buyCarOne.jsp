<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
    
    <script type="text/javascript" src="${ctx }/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx }/js/menu.js"></script>    
                
	<script type="text/javascript" src="${ctx }/js/n_nav.js"></script>   
    
    <script type="text/javascript" src="${ctx }/js/num.js">
    	var jq = jQuery.noConflict();
    </script>     
    
    <script type="text/javascript" src="${ctx }/js/shade.js"></script>
    <script type="text/javascript" src="${ctx }/js/shopping.js"></script>
<title>易买网购物车</title>
</head>
<body>  
<%@ include file="include/header.jsp" %>
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">全部商品分类</div>
            <div class="leftNav none">
                <ul>      
                    <c:forEach items="${vos }" var="vo1" varStatus="status">
               	 <li >
               	 		<a class="a" href="BrandListServlet?id=${vo1.productCategory.id }&ProductName=${vo1.productCategory.name }">
	                    	<div class="fj">
	                        		<span class="n_img"><span></span><c:choose><c:when test="${status.index==0 }"><img src="images/nav5.png" /></c:when><c:when test="${status.index==1 }"><img src="images/nav4.png" /></c:when><c:when test="${status.index==2 }"><img src="images/nav1.png" /></c:when><c:when test="${status.index==3 }"><img src="images/nav9.png" /></c:when><c:when test="${status.index==4 }"><img src="images/nav2.png" /></c:when><c:otherwise><img src="images/nav10.png" /></c:otherwise></c:choose></span>
	                            <span class="fl">${vo1.productCategory.name }</span>
	                        </div>
                        </a>
                        <div class="zj" style="position:absolute;left:210px;top:-${status.index*40 }px" >
                            <div class="zj_l">
                             	<c:forEach items="${vo1.vos }" var="vo2">
                              		<div class="zj_l_c">
	                                	 <a href="BrandListServlet?id=${vo2.productCategory.id }&ProductName=${vo2.productCategory.name }"><h2>${vo2.productCategory.name }</h2></a>
	                                	  <c:forEach items="${vo2.vos }" var="vo3">
	                                   		 <a href="BrandListServlet?id=${vo3.productCategory.id }&ProductName=${vo3.productCategory.name }">${vo3.productCategory.name }</a>|
	                                 	  </c:forEach>
                              		  </div>
                              </c:forEach>
                            </div>
                            <div class="zj_r">
                                <a href="#"><img src="images/n_img1.jpg" width="236" height="200" /></a>
                                <a href="#"><img src="images/n_img2.jpg" width="236" height="200" /></a>
                            </div>
                        </div>
                    </li>
                </c:forEach>       	
                </ul>            
            </div>
        </div>  
        <!--End 商品分类详情 End-->                                                     
    	<ul class="menu_r">                                                                                                                                               
        	<li><a href="IndexServlet">首页</a></li>
        	<c:forEach items="${vos }" var="vo">
    	 		<li><a href="BrandListServlet?id=${vo.productCategory.id }">${vo.productCategory.name }</a></li>
         
        	</c:forEach>   
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End--> 
<div class="i_bg">  
    <div class="content mar_20">
    	<img src="images/img1.jpg" />        
    </div>
    
    <!--Begin 第一步：查看购物车 Begin -->
    <div class="content mar_20" id="carOne">
    	<%@ include file="include/carOne.jsp" %>
    	<%-- <table border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0" cellpadding="0">
          <tr>
            <td class="car_th" width="490">商品名称</td>
            <td class="car_th" width="150">购买数量</td>
            <td class="car_th" width="130">小计</td>
            <td class="car_th" width="140">返还积分</td>
            <td class="car_th" width="150">操作</td>
          </tr>
          <c:forEach items="${shoppingCar.list }" var="shoppingCarItem" varStatus="status">
          	  <tr>
            <td>
            	<div class="c_s_img"><img src="${ctx }/files/${shoppingCarItem.product.fileName }" width="73" height="73" /></div>
                ${shoppingCarItem.product.name }
            </td>
           <!--  <td align="center">颜色：灰色</td> -->
            <td align="center">
            	<div class="c_num">
                    <input type="button" value="" onclick="jianUpdate1(jq(this));" class="car_btn_1" />
                    <input type="hidden" value="${shoppingCarItem.product.id }" id="id"/>
                	<input type="text" value="${shoppingCarItem.num }" name="num" id="num" class="car_ipt" />  
                    <input type="button" value="" onclick="addUpdate1(jq(this));" class="car_btn_2" />
                </div>
            </td>
            <td align="center" style="color:#ff4e00;">￥${shoppingCarItem.product.price*shoppingCarItem.num } </td>
            <td align="center"><fmt:formatNumber type="number" value="${shoppingCarItem.product.price*shoppingCarItem.num/20 }" maxFractionDigits="0"/> R</td>
            <td align="center"><a onclick="ShowDiv('MyDiv','fade')" <c:set  var="index" value="${status.index }"></c:set>>删除</a>&nbsp; &nbsp;<a href="#">加入收藏</a></td>
          </tr>
          
          </c:forEach>
        
          <tr height="70">
          	<td colspan="6" style="font-family:'Microsoft YaHei'; border-bottom:0;">
            	<label class="r_rad"><input type="checkbox" name="clear" checked="checked" /></label><label class="r_txt">清空购物车</label>
                <span class="fr">商品总价：<b style="font-size:22px; color:#ff4e00;">￥${shoppingCar.sum }</b></span>
            </td>
          </tr>
          <tr valign="top" height="150">
          	<td colspan="6" align="right">
            	<a href="#"><img src="images/buy1.gif" /></a>&nbsp; &nbsp; <a href="#"><img src="images/buy2.gif" /></a>
            </td>
          </tr>
        </table> --%>
        
    </div>
	<!--End 第一步：查看购物车 End--> 
    
    
    <!--Begin 弹出层-删除商品 Begin-->
    <div id="fade" class="black_overlay"></div>
    <div id="MyDiv" class="white_content">             
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')" ><img src="images/close.gif" /></span>
            </div>
            <div class="notice_c">
           		
                <table border="0" align="center" style="font-size:16px;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td>您确定要把该商品移除购物车吗？</td>
                  </tr>
                  <tr height="50" valign="bottom">
                    <td><a href="CaoOneServlet?action=delete&index=${index }" class="b_sure">确定</a><a href="javascript:CloseDiv('MyDiv','fade')" class="b_buy">取消</a></td>
                  </tr>
                </table>
                    
            </div>
        </div>
    </div>    
    <!--End 弹出层-删除商品 End-->
    
    
    <%@ include file="include/end.jsp" %>
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
        