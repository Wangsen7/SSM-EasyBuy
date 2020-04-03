<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="${ctx}/js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
        
    <script type="text/javascript" src="${ctx}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/menu.js"></script>    
        
	<script type="text/javascript" src="${ctx}/js/select.js"></script>
        
    <style>
    .td_bg img{
    white:35px;
    height:35px;
    }
    </style>
<title>尤洪</title>
</head>
<body>  
<!--Begin Header Begin-->
	<%@ include file="include/HTtop.jsp" %>

<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
    	
	<div class="m_content">
   		<%@ include file="include/HTleftM.jsp" %>
        
		<div class="m_right">
			<div class="mem_t">
            	我的业绩
            </div>
            <c:forEach var="list" items="${lists}">
            <table border="1" class="mem_tab" style="width:870px; text-align:center; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="th_bg1" colspan="6">用户名:${list.name}&nbsp;&nbsp;&nbsp;订单号:${list.dinhao}&nbsp;&nbsp;&nbsp;
                地址：${list.dizi}&nbsp;&nbsp;&nbsp;￥${list.price}</td>
              </tr>
               <tr>
                <td width="145" class="td_bg"></td>                     
                <td width="145">商品名称</td>
                <td width="145" class="td_bg">商品图片</td>
                <td width="145">商品数量</td>
                <td width="145" class="td_bg">商品总价</td>
                <td width="145"></td>
              </tr>  
              <c:forEach var="list1" items="${list.list}">
              <tr>
                <td width="145" class="td_bg"></td>                     
                <td width="145">${list1.spname}</td>
                <td width="145" class="td_bg"><img src="${ctx}/files/${list1.filename}" /></td>
                <td width="145">${list1.num}</td>
                <td width="145" class="td_bg">￥${list1.nuprice}</td>
                <td width="145"></td>
              </tr>  
              </c:forEach>
            </table>
            </c:forEach>

           <div class="pages">
            <a href="MemberUserServlet?currPageNo=${pagenews.currentPageNo-1}&action=quan">上一页</a></span>&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;<span><a href="MemberUserServlet?currPageNo=${pagenews.currentPageNo+1}&action=quan">下一页</a>
            </div>
        </div>
    </div>
    
    
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <div class="b_btm_bg b_btm_c">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="${ctx}/images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>

              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="${ctx}/images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="${ctx}/images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="${ctx}/images/b4.png" width="62" height="62" /></td>
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
            <div class="b_er_c"><img src="${ctx}/images/er.gif" width="118" height="118" /></div>
            <img src="${ctx}/images/ss.png" />
        </div>
    </div>    
    <div class="btmbg">
		<div class="btm">
        	备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="${ctx}/images/b_1.gif" width="98" height="33" /><img src="${ctx}/images/b_2.gif" width="98" height="33" /><img src="${ctx}/images/b_3.gif" width="98" height="33" /><img src="${ctx}/images/b_4.gif" width="98" height="33" /><img src="${ctx}/images/b_5.gif" width="98" height="33" /><img src="${ctx}/images/b_6.gif" width="98" height="33" />
        </div>    	
    </div>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
