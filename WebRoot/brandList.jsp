<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <script type="text/javascript" src="${ctx }/js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="${ctx }/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx }/js/menu.js"></script>    
            
	<script type="text/javascript" src="${ctx }/js/lrscroll_1.js"></script>
    
    
	<script type="text/javascript" src="${ctx }/js/n_nav.js"></script>    
    <script type="text/javascript" src="${ctx }/js/milk_ban.js"></script>
    <script type="text/javascript" src="${ctx }/js/paper_ban.js"></script>
    <script type="text/javascript" src="${ctx }/js/baby_ban.js"></script>
    <script type="text/javascript" src="${ctx }/js/shopping.js"></script>
<title>易买网</title>
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
                	 <li>
                    	<a class="a" href="BrandListServlet?id=${vo1.productCategory.id }">
	                    	<div class="fj">
	                        	<span class="n_img"><span></span><c:choose><c:when test="${status.index==0 }"><img src="images/nav5.png" /></c:when><c:when test="${status.index==1 }"><img src="images/nav4.png" /></c:when><c:when test="${status.index==2 }"><img src="images/nav1.png" /></c:when><c:when test="${status.index==3 }"><img src="images/nav9.png" /></c:when><c:when test="${status.index==4 }"><img src="images/nav2.png" /></c:when><c:otherwise><img src="images/nav10.png" /></c:otherwise></c:choose></span>
	                            <span class="fl">${vo1.productCategory.name }</span>
	                        </div>
                        </a>
                       <div class="zj" style="position:absolute;left:210px;top:-${status.index*40 }px" >
                            <div class="zj_l">
                             	<c:forEach items="${vo1.vos }" var="vo2">
                              		<div class="zj_l_c">
	                                	<a href="BrandListServlet?id=${vo2.productCategory.id }"><h2>${vo2.productCategory.name }</h2></a>
	                                	  <c:forEach items="${vo2.vos }" var="vo3">
	                                   		 <a href="BrandListServlet?id=${vo3.productCategory.id }">${vo3.productCategory.name }</a>|
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
            <!-- <li><a href="Food.html">美食</a></li>
            <li><a href="Fresh.html">生鲜</a></li>
            <li><a href="HomeDecoration.html">家居</a></li>
            <li><a href="SuitDress.html">女装</a></li>
            <li><a href="MakeUp.html">美妆</a></li>
            <li><a href="Digital.html">数码</a></li>
            <li><a href="GroupBuying.html">团购</a></li> -->
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End--> 
<div class="i_bg">
	<div class="postion">
    	<span class="fl">全部 > 美妆个护 > 香水 > 香奈儿
    	
    	</span>
    </div>
    
    <div class="content mar_20">
    	<div class="l_history">
        	<div class="his_t">
            	<span class="fl">浏览历史</span>
                <span class="fr"><a href="#">清空</a></span>
            </div>
        	<ul>
        	<c:forEach items="${historyProduct.list }" var="product">
        		 <li>
                    <div class="img"><a href="ProductServlet?id=${product.id }"><img src="${ctx }/files/${product.fileName}" width="185" height="162" /></a></div>
                	<div class="name"><a href="ProductServlet?id=${product.id }">${product.name }</a></div>
                    <div class="price">
                    	<font>￥<span>${product.price }</span></font> &nbsp; <fmt:formatNumber type="number" maxFractionDigits="0" value="${product.price/20 }"></fmt:formatNumber>R
                    </div>
                </li>
        	</c:forEach>
            	<!-- <li>
                    <div class="img"><a href="#"><img src="images/his_1.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>368.00</span></font> &nbsp; 18R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/his_2.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>768.00</span></font> &nbsp; 18R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/his_3.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>680.00</span></font> &nbsp; 18R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/his_4.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>368.00</span></font> &nbsp; 18R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/his_5.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>368.00</span></font> &nbsp; 18R
                    </div>
                </li> -->
        	</ul>
        </div>
        <div class="l_list">
        	<!-- <table border="0" style="width:100%; margin-bottom:30px; border:1px solid #eaeaea;" cellspacing="0" cellpadding="0">
              <tr valign="top">
                <td width="248"><div class="brand_img"><img src="images/brand5.jpg" width="226" height="108" /></div></td>
                <td class="td_b" style="padding:15px 40px;">
                	所有分类<br />
                    <a href="#" class="now">香水（10）</a><a href="#">彩妆套装（2）</a><a href="#">洁面（1）</a><a href="#">精华（1）</a><a href="#">化妆水（2）</a><a href="#">嫩肤（3）</a>
                </td>
              </tr>
            </table> -->
        	<div class="list_t">
            	<span class="fl list_or">
                	<a href="#" class="now">默认</a>
                    <a href="#">
                    	<span class="fl">销量</span>                        
                        <span class="i_up">销量从低到高显示</span>
                        <span class="i_down">销量从高到低显示</span>                                                     
                    </a>
                    <a href="#">
                    	<span class="fl">价格</span>                        
                        <span class="i_up">价格从低到高显示</span>
                        <span class="i_down">价格从高到低显示</span>     
                    </a>
                    <a href="#">新品</a>
                </span>
                	<!-- 导入taglib函数库 -->
                <span class="fr">共发现${fn:length(list) }件</span>
            </div>

            <div class="list_c">
            	
                <ul class="cate_list">
                <c:forEach items="${page.list }" var="product" >
                	<li>
                    	<div class="img"><a href="ProductServlet?id=${product.id }"><img src="files/${product.fileName }" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>${product.price }</span></font> &nbsp; <fmt:formatNumber type="number" value="${product.price/20 }" maxFractionDigits="0"/>R
                        </div>
                        <div class="name"><a href="ProductServlet?id=${product.id }">${product.name }</a></div>
                        <div class="carbg">
                        	<a href="javascript:addCollectProduct(${product.id })" class="ss">收藏</a>
                            <a href="javascript:addCar(${product.id },1)" class="j_car">加入购物车</a>
                        </div>
                    </li>
                </c:forEach>
                </ul>              
                <div class="pages">
                	<a href="BrandListServlet?action=${action }&currentPageNo=1&id=${id }&name=${name }" class="cur">首页</a>
                	<a href="BrandListServlet?action=${action }&currentPageNo=${page.currentPageNo-1 }&id=${id }&name=${name }" class="p_pre">上一页</a>
                	
                
                	<a href="BrandListServlet?action=${action }&currentPageNo=${page.currentPageNo+1 }&id=${id }&name=${name }" class="p_pre">下一页</a>
                	<a href="BrandListServlet?action=${action }&currentPageNo=${page.totalPageCount }&id=${id }&name=${name }" class="cur">末页</a>
                </div>
                
                
                
            </div>
        </div>
    </div>
 	<%@ include file="include/end.jsp" %>
    <!--Begin Footer Begin -->
   <!--  <div class="b_btm_bg bg_color">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>
              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b4.png" width="62" height="62" /></td>
                <td><h2>准时送达</h2>收货时间由你做主</td>
              </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
    	<dl>                                                                                            
        	<dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
        	<a href="#" class="b_sh1">新浪微博</a>            
        	<a href="#" class="b_sh2">腾讯微博</a>
            <p>
            服务热线：<br />
            <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="images/er.gif" width="118" height="118" /></div>
            <img src="images/ss.png" />
        </div>
    </div>    
    <div class="btmbg">
		<div class="btm">
        	备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
        </div>    	
    </div>
    End Footer End    
</div> -->

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
