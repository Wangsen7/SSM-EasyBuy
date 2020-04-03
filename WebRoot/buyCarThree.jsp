
<!--Begin Header Begin-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
    
<title>易买网购物车</title>
</head>
<body>  
<!--Begin Header Begin-->
<%@ include file="include/header.jsp" %>
<!--End Header End--> 
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">全部商品分类</div>
            <div class="leftNav none">
                <ul>      
                    <c:forEach items="${overlist }" var="vo1" varStatus="status">
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
        	<c:forEach items="${overlist }" var="vo">
    	 		<li><a href="BrandListServlet?id=${vo.productCategory.id }">${vo.productCategory.name }</a></li>
         
        	</c:forEach>   
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End--> 
<div class="i_bg">  
    <div class="content mar_20">
    	<img src="images/img3.jpg" />        
    </div>
    
    <!--Begin 第三步：提交订单 Begin -->
    <div class="content mar_20">
    	
        <!--Begin 银行卡支付 Begin -->
    	<div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td style="font-size:18px;">
                	感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color="#ff4e00">${serialNumber}</font>
                </td>
              </tr>
              <tr>
                <td style="font-size:14px; font-family:'宋体'; padding:10px 0 20px 0; border-bottom:1px solid #b6b6b6;">
                	您选定的配送方式为: <font color="#ff4e00">申通快递</font>； &nbsp; &nbsp;您选定的支付方式为: <font color="#ff4e00">支付宝</font>； &nbsp; &nbsp;您的应付款金额为: <font color="#ff4e00">￥${shoppingCar.sum+15}</font>
                </td>
              </tr>
              <tr>
                <td style="padding:20px 0 30px 0; font-family:'宋体';">
                	银行名称 收款人信息：全称 ××× ；帐号或地址 ××× ；开户行 ×××。 <br />
                    注意事项：办理电汇时，请在电汇单“汇款用途”一栏处注明您的订单号。
                </td>
              </tr>
              <tr>
                <td>
                	<a href="IndexServlet">首页</a> &nbsp; &nbsp; <a href="#">用户中心</a>
                </td>
              </tr>
            </table>        	
        </div>
        <!--Begin 银行卡支付 Begin -->
        
        <!--Begin 支付宝支付 Begin -->
    	<%-- <div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td style="font-size:18px;">
                	感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color="#ff4e00">2015092598275</font>
                </td>
              </tr>
              <tr>
                <td style="font-size:14px; font-family:'宋体'; padding:10px 0 20px 0; border-bottom:1px solid #b6b6b6;">
                	您选定的配送方式为: <font color="#ff4e00">申通快递</font>； &nbsp; &nbsp;您选定的支付方式为: <font color="#ff4e00">银行卡</font>； &nbsp; &nbsp;您的应付款金额为: <font color="#ff4e00">￥${shoppingCar.sum+15}</font>
                </td>
              </tr>
              <tr>
                <td style="padding:20px 0 30px 0; font-family:'宋体';">
                	支付宝网站(www.alipay.com) 是国内先进的网上支付平台。<br />
                    支付宝收款接口：在线即可开通，零预付，免年费，单笔阶梯费率，无流量限制。<br />
                    <a href="#" style="color:#ff4e00;">立即在线申请</a>
                </td>
              </tr>
              <tr>
                <td>
                	<div class="btn_u" style="margin:0 auto; padding:0 20px; width:120px;"><a href="ShoppingServlet?action=addsho">立即使用支付宝支付</a></div>
                	<a href="#">首页</a> &nbsp; &nbsp; <a href="#">用户中心</a>
                </td>
              </tr>
            </table>        	
        </div> --%>
        <!--Begin 支付宝支付 Begin -->
        
        <!--Begin 余额不足 Begin -->
    	<!-- <div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr>
                <td>
                	<p style="font-size:22px;">提示 !</p>
                    <b style="color:#ff4e00; font-size:16px; font-family:'宋体';">您的余额不足以支付整个订单，请选择其他支付方式</b>
                	<div class="backs"><a href="CarTwoServlet">返回上一页</a></div>
                </td>
              </tr>
            </table>        	
        </div> -->
        <!--Begin 余额不足 Begin -->
        
        
    </div>
	<!--End 第三步：提交订单 End--> 
    
    
    <!--Begin Footer Begin -->
   
    <%@ include file="include/end.jsp" %>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>

<!--End Header End--> 
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
    	<img src="images/img3.jpg" />        
    </div>
    
    <!--Begin 第三步：提交订单 Begin -->
    <div class="content mar_20">
    	
        <!--Begin 银行卡支付 Begin -->
    	<div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td style="font-size:18px;">
                	感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color="#ff4e00">2015092598275</font>
                </td>
              </tr>
              <tr>
                <td style="font-size:14px; font-family:'宋体'; padding:10px 0 20px 0; border-bottom:1px solid #b6b6b6;">
                	您选定的配送方式为: <font color="#ff4e00">申通快递</font>； &nbsp; &nbsp;您选定的支付方式为: <font color="#ff4e00">支付宝</font>； &nbsp; &nbsp;您的应付款金额为: <font color="#ff4e00">￥${shoppingCar.sum+15}</font>
                </td>
              </tr>
              <tr>
                <td style="padding:20px 0 30px 0; font-family:'宋体';">
                	银行名称 收款人信息：全称 ××× ；帐号或地址 ××× ；开户行 ×××。 <br />
                    注意事项：办理电汇时，请在电汇单“汇款用途”一栏处注明您的订单号。
                </td>
              </tr>
              <tr>
                <td>
                	<a href="IndexServlet">首页</a> &nbsp; &nbsp; <a href="#">用户中心</a>
                </td>
              </tr>
            </table>        	
        </div>
        <!--Begin 银行卡支付 Begin -->
        
        <!--Begin 支付宝支付 Begin -->
    	<%-- <div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td style="font-size:18px;">
                	感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color="#ff4e00">2015092598275</font>
                </td>
              </tr>
              <tr>
                <td style="font-size:14px; font-family:'宋体'; padding:10px 0 20px 0; border-bottom:1px solid #b6b6b6;">
                	您选定的配送方式为: <font color="#ff4e00">申通快递</font>； &nbsp; &nbsp;您选定的支付方式为: <font color="#ff4e00">银行卡</font>； &nbsp; &nbsp;您的应付款金额为: <font color="#ff4e00">￥${shoppingCar.sum+15}</font>
                </td>
              </tr>
              <tr>
                <td style="padding:20px 0 30px 0; font-family:'宋体';">
                	支付宝网站(www.alipay.com) 是国内先进的网上支付平台。<br />
                    支付宝收款接口：在线即可开通，零预付，免年费，单笔阶梯费率，无流量限制。<br />
                    <a href="#" style="color:#ff4e00;">立即在线申请</a>
                </td>
              </tr>
              <tr>
                <td>
                	<div class="btn_u" style="margin:0 auto; padding:0 20px; width:120px;"><a href="ShoppingServlet?action=addsho">立即使用支付宝支付</a></div>
                	<a href="#">首页</a> &nbsp; &nbsp; <a href="#">用户中心</a>
                </td>
              </tr>
            </table>        	
        </div> --%>
        <!--Begin 支付宝支付 Begin -->
        
        <!--Begin 余额不足 Begin -->
    <!-- 	<div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr>
                <td>
                	<p style="font-size:22px;">提示 !</p>
                    <b style="color:#ff4e00; font-size:16px; font-family:'宋体';">您的余额不足以支付整个订单，请选择其他支付方式</b>
                	<div class="backs"><a href="CarTwoServlet">返回上一页</a></div>
                </td>
              </tr>
            </table>        	
        </div> -->
        <!--Begin 余额不足 Begin -->
        
        
    </div>
	<!--End 第三步：提交订单 End--> 
    
    
    <!--Begin Footer Begin -->
   
    <%@ include file="include/end.jsp" %>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
