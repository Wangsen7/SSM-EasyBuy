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
    
    <script type="text/javascript" src="${ctx }/js/select.js"></script>
    
    <script type="text/javascript" src="${ctx }/js/num.js">
    	var jq = jQuery.noConflict();
    </script>        
    <script type="text/javascript" src="${ctx }/js/shade.js"></script>
   
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
    	<img src="images/img2.jpg" />        
    </div>
      <!-- <form action="OrderServlet" method="post"> -->
    <!--Begin 第二步：确认订单信息 Begin -->
    <div class="content mar_20">
    	<div class="two_bg">
        	<div class="two_t">
            	<span class="fr"><a href="CaoOneServlet">修改</a></span>商品列表
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="550">商品名称</td>             
                <td class="car_th" width="150">购买数量</td>
                <td class="car_th" width="130">小计</td>
                <td class="car_th" width="140">返还积分</td>
              </tr>
             <c:forEach items="${shoppingCar.list }" var="shoppingCarItem">
             	 <tr>
	                <td>
	                    <div class="c_s_img"><img src="${ctx }/files/${shoppingCarItem.product.fileName }" width="73" height="73" /></div>
	                    ${shoppingCarItem.product.name }
	                </td>              
	                <td align="center">${shoppingCarItem.num }</td>
	                <td align="center" style="color:#ff4e00;">￥${shoppingCarItem.num*shoppingCarItem.product.price }</td>
	                <td align="center"><fmt:formatNumber value="${shoppingCarItem.num*shoppingCarItem.product.price/20 }" type="number" maxFractionDigits="0"></fmt:formatNumber>R</td>
              </tr>
             </c:forEach>
             
            
              <tr>
                <td colspan="5" align="right" style="font-family:'Microsoft YaHei';">
                    商品总价：￥${shoppingCar.sum }； 返还积分 <fmt:formatNumber type="number" maxFractionDigits="0" value="${shoppingCar.sum/20 }"></fmt:formatNumber>R  
                </td>
              </tr>
            </table>
          
            <div class="two_t">
            	<span class="fr"><a href="#">修改</a></span>收货人信息
            </div>
            
       <form action="CarThreeServlet?pro=qeire&zong=${shoppingCar.sum+15}" method="post">
            <table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">           
              <tr>                   
                <td class="p_td"><a href="#">填写地址</a></td>
                <td><input type="text" name="address" /></td>            
              
               <!--  <td class="p_td" width="160">电子邮件</td>
                <td width="395">12345678@qq.com</td> -->
              </tr>
             <!--  <tr>
                <td class="p_td">详细信息</td>
                <td>四川省成都市武侯区</td>
                <td class="p_td">邮政编码</td>
                <td>6011111</td>
              </tr>
              <tr>
                <td class="p_td">电话</td>
                <td></td>
                <td class="p_td">手机</td>
                <td>18600002222</td>
              </tr>
              <tr>
                <td class="p_td">标志建筑</td>
                <td></td>
                <td class="p_td">最佳送货时间</td>
                <td></td>
              </tr> -->
            </table>

            
            <div class="two_t">
            	配送方式
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="80"></td>
                <td class="car_th" width="200">名称</td>
                <td class="car_th" width="370">订购描述</td>
                <td class="car_th" width="150">费用</td>
                <td class="car_th" width="135">免费额度</td>
                <td class="car_th" width="175">保价费用</td>
              </tr>
              <tr>
              	<td align="center"><input type="checkbox" name="ch" checked="checked" /></td>
                <td align="center" style="font-size:14px;"><b>申通快递</b></td>
                <td>江、浙、沪地区首重为15元/KG，其他地区18元/KG，续重均为5-6元/KG， 云南地区为8元</td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center">不支持保价</td>
              </tr>
              <tr>
              	<td align="center"><input type="checkbox" name="ch" /></td>
                <td align="center" style="font-size:14px;"><b>城际快递</b></td>
                <td>运费固定</td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center">不支持保价</td>
              </tr>
              <tr>
              	<td align="center"><input type="checkbox" name="ch" /></td>
                <td align="center" style="font-size:14px;"><b>邮局平邮</b></td>
                <td>运费固定</td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center">不支持保价</td>
              </tr>
              <tr>
              	<td colspan="6">
                	<span class="fr"><label class="r_rad"><input type="checkbox" name="baojia" /></label><label class="r_txt">配送是否需要保价</label></span>
                </td>
              </tr>
            </table> 
            
            <div class="two_t">
            	支付方式
            </div>
            <ul class="pay">
                <li>余额支付<div class="ch_img"></div></li>
                <li class="checked">银行亏款/转账 <div class="ch_img"></div></li>
                <li>货到付款<div class="ch_img"></div></li>
                <li>支付宝<div class="ch_img"></div></li>
            </ul>
            
            <div class="two_t">
            	商品包装
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="80"></td>
                <td class="car_th" width="490">名称</td>
                <td class="car_th" width="180">费用</td>
                <td class="car_th" width="180">免费额度</td>
                <td class="car_th" width="180">图片</td>
              </tr>
              <tr>
              	<td align="center"><input type="checkbox" name="pack" checked="checked" /></td>
                <td><b style="font-size:14px;">不要包装</b></td>
                <td align="center">￥0.00</td>
                <td align="center">￥0.00</td>
                <td align="center"></td>
              </tr>
              <tr>
              	<td align="center"><input type="checkbox" name="pack" /></td>
                <td><b style="font-size:14px;">精品包装</b></td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center"><a href="#" style="color:#ff4e00;">查看</a></td>
              </tr>
            </table> 
            
            <div class="two_t">
            	祝福贺卡
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="80"></td>
                <td class="car_th" width="490">名称</td>
                <td class="car_th" width="180">费用</td>
                <td class="car_th" width="180">免费额度</td>
                <td class="car_th" width="180">图片</td>
              </tr>
              <tr>
              	<td align="center"><input type="checkbox" name="wish" checked="checked" /></td>
                <td><b style="font-size:14px;">不要贺卡</b></td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center"></td>
              </tr>
              <tr>
              	<td align="center" style="border-bottom:0; padding-bottom:0;"><input type="checkbox" name="wish" /></td>
                <td style="border-bottom:0; padding-bottom:0;"><b style="font-size:14px;">祝福贺卡</b></td>
                <td align="center" style="border-bottom:0; padding-bottom:0;">￥15.00</td>
                <td align="center" style="border-bottom:0; padding-bottom:0;">￥0.00</td>
                <td align="center" style="border-bottom:0; padding-bottom:0;"><a href="#" style="color:#ff4e00;">查看</a></td>
              </tr>
              <tr valign="top">
              	<td align="center"></td>
                <td colspan="4">
                	<span class="fl"><b style="font-size:14px;">祝福语：</b></span>
                    <span class="fl"><textarea class="add_txt" style="width:860px; height:50px;"></textarea></span>
                </td>
              </tr>
            </table> 
            
            <div class="two_t">
            	其他信息
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="145" align="right" style="padding-right:0;"><b style="font-size:14px;">使用红包：</b></td>
                <td>
                	<span class="fl" style="margin-left:50px; margin-right:10px;">选择已有红包</span>
                    <select class="jj" name="city">
                      <option value="0" selected="selected">请选择</option>
                      <option value="1">50元</option>
                      <option value="2">30元</option>
                      <option value="3">20元</option>
                      <option value="4">10元</option>
                    </select>
                    <span class="fl" style="margin-left:50px; margin-right:10px;">或者输入红包序列号</span>
                    <span class="fl"><input type="text" value="" class="c_ipt" style="width:220px;" />
                    <span class="fr" style="margin-left:10px;"><input type="submit" value="验证红包" class="btn_tj" /></span>
                </td>
			  </tr>
              <tr valign="top">
                <td align="right" style="padding-right:0;"><b style="font-size:14px;">订单附言：</b></td>
                <td style="padding-left:0;"><textarea class="add_txt" style="width:860px; height:50px;"></textarea></td>
              </tr>
              <tr>
              	<td align="right" style="padding-right:0;"><b style="font-size:14px;">缺货处理：</b></td>
                <td>
                	<label class="r_rad"><input type="checkbox" name="none" checked="checked" /></label><label class="r_txt" style="margin-right:50px;">等待所有商品备齐后再发</label>
                    <label class="r_rad"><input type="checkbox" name="none" /></label><label class="r_txt" style="margin-right:50px;">取下订单</label>
                    <label class="r_rad"><input type="checkbox" name="none" /></label><label class="r_txt" style="margin-right:50px;">与店主协商</label>
                </td>
              </tr>
            </table>
            
            <table border="0" style="width:900px; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr>
                <td align="right">
                	该订单完成后，您将获得 <font color="#ff4e00">${shoppingCar.sum/20 }</font> 积分 ，以及价值 <font color="#ff4e00">￥0.00</font> 的红包 <br />
                    商品总价: <font color="#ff4e00">￥${shoppingCar.sum }</font>  + 配送费用: <font color="#ff4e00">￥15.00</font>
                </td>
              </tr>
              <tr height="70">
                <td align="right">
                	<b style="font-size:14px;">应付款金额：<span style="font-size:22px; color:#ff4e00;">￥${shoppingCar.sum+15}</span></b>
                </td>
              </tr>
              <tr height="70">
                <td align="right">
                <input  type="submit" value="购买商品"/>
                <!-- <img src="images/btn_sure.gif" /> --></td>
              </tr>
            </table>
        	
        </div>
    
    
          </form>
    </div>
	<!--End 第二步：确认订单信息 End-->
    
  
   <%@ include file="include/end.jsp" %>


        <!--  </form> -->
</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
