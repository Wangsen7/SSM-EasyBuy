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
    <script type="text/javascript" src="${ctx }/js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="${ctx }/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx }/js/menu.js"></script>    
        
	<script type="text/javascript" src="${ctx }/js/select.js"></script>
    
	<script type="text/javascript" src="${ctx }/js/lrscroll.js"></script>
    
    <script type="text/javascript" src="${ctx }/js/iban.js"></script>
    <script type="text/javascript" src="${ctx }/js/fban.js"></script>
    <script type="text/javascript" src="${ctx }/js/f_ban.js"></script>
    <script type="text/javascript" src="${ctx }/js/mban.js"></script>
    <script type="text/javascript" src="${ctx }/js/bban.js"></script>
    <script type="text/javascript" src="${ctx }/js/hban.js"></script>
    <script type="text/javascript" src="${ctx }/js/tban.js"></script>
    
	<script type="text/javascript" src="${ctx }/js/lrscroll_1.js"></script>
    
    
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
            <div class="leftNav">
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
        	<!-- <li><a href="Index.html">首页</a></li>
            <li><a href="Food.html">美食</a></li>
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
<div class="i_bg bg_color">
	<div class="i_ban_bg">
		<!--Begin Banner Begin-->
    	<div class="banner">    	
            <div class="top_slide_wrap">
                <ul class="slide_box bxslider">
                    <li><img src="images/ban1.jpg" width="740" height="401" /></li>
                    <li><img src="images/ban1.jpg" width="740" height="401" /></li> 
                    <li><img src="images/ban1.jpg" width="740" height="401" /></li> 
                </ul>	
                <div class="op_btns clearfix">
                    <a href="#" class="op_btn op_prev"><span></span></a>
                    <a href="#" class="op_btn op_next"><span></span></a>
                </div>        
            </div>
        </div>
        <script type="text/javascript">
        //var jq = jQuery.noConflict();
        (function(){
            $(".bxslider").bxSlider({
                auto:true,
                prevSelector:jq(".top_slide_wrap .op_prev")[0],nextSelector:jq(".top_slide_wrap .op_next")[0]
            });
        })();
        </script>
        <!--End Banner End-->
        <div class="inews">
        	<div class="news_t">
            	<span class="fr"><a href="NewsListServlet">更多 ></a></span>新闻资讯
            </div>
            <ul>
            <c:forEach items="${newsList }" var="news">
            	<li><span>[ 特惠 ]</span><a href="NewsListServlet?action=news&id=${news.id }">${news.title }</a></li>
            </c:forEach>
            <!-- 	<li><span>[ 特惠 ]</span><a href="#">掬一轮明月 表无尽惦念</a></li>
            	<li><span>[ 公告 ]</span><a href="#">好奇金装成长裤新品上市</a></li>
            	<li><span>[ 特惠 ]</span><a href="#">大牌闪购 · 抢！</a></li>
            	<li><span>[ 公告 ]</span><a href="#">发福利 买车就抢千元油卡</a></li>
            	<li><span>[ 公告 ]</span><a href="#">家电低至五折</a></li> -->
            </ul>
            <div class="charge_t">
            	话费充值<div class="ch_t_icon"></div>
            </div>
            <form>
            <table border="0" style="width:205px; margin-top:10px;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td width="33">号码</td>
                <td><input type="text" value="" class="c_ipt" /></td>
              </tr>
              <tr height="35">
                <td>面值</td>
                <td>
                	<select class="jj" name="city">
                      <option value="0" selected="selected">100元</option>
                      <option value="1">50元</option>
                      <option value="2">30元</option>
                      <option value="3">20元</option>
                      <option value="4">10元</option>
                    </select>
                    <span style="color:#ff4e00; font-size:14px;">￥99.5</span>
                </td>
              </tr>
              <tr height="35">
                <td colspan="2"><input type="submit" value="立即充值" class="c_btn" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
  
    <div class="content mar_20">
    	<img src="images/mban_1.jpg" width="1200" height="110" />
    </div>
	<!--Begin 进口 生鲜 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">1F</span>
    	<span class="fl">${vos[2].productCategory.name }</span>  
    	              
        <span class="i_mores fr">
        <c:forEach items="${vos[2].vos }" var="vo">
        	<a href="BrandListServlet?id=${vo.productCategory.id }">${vo.productCategory.name }</a>&nbsp; &nbsp; &nbsp;
        </c:forEach>
       <!--  <a href="#">进口咖啡</a>&nbsp; &nbsp; &nbsp; <a href="#">进口酒</a>&nbsp; &nbsp; &nbsp; <a href="#">进口母婴</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜蔬菜</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜水果</a> -->
       </span>
    </div> 
    <div class="content">
    	<div class="fresh_left">
        	<div class="fre_ban">
            	<div id="imgPlay1">
                    <ul class="imgs" id="actor1">
                        <li><a href="#"><img src="images/fre_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/fre_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/fre_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prevf">上一张</div>
                    <div class="nextf">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
            	<c:forEach items="${vos[2].vos }" var="vo">
            		<a href="BrandListServlet?id=${vo.productCategory.id }">${vo.productCategory.name }</a>
        		</c:forEach>
                	<!-- <a href="#">进口水果</a><a href="#">奇异果</a><a href="#">西柚</a><a href="#">海鲜水产</a><a href="#">品质牛肉</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">进口酒</a><a href="#">进口奶粉</a><a href="#">鲜活禽蛋</a> -->
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
        	<c:forEach items="${list1 }" var="product">
        		<li>
                	<div class="name"><a href="#"> ${product.name }</a></div>
                    <div class="price">
                    	<font>￥<span>${product.price }</span></font> &nbsp; <fmt:formatNumber type="number" value="${product.price/20 }" maxFractionDigits="0"/>  R
                    </div>
                    <div class="img"><a href="ProductServlet?id=${product.id }"><img src="${ctx }/files/${product.fileName }" width="185" height="155" /></a></div>
                </li>
        	</c:forEach>
            	
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/fre_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/fre_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
    </div>    
    <!--End 进口 生鲜 End-->
    <!--Begin 食品饮料 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">2F</span>
    	<span class="fl">${vos[1].productCategory.name }</span>                                
        <span class="i_mores fr">
        <c:forEach items="${vos[1].vos }" var="vo">
       		 <a href="BrandListServlet?id=${vo.productCategory.id }">${vo.productCategory.name }</a>&nbsp; &nbsp; |
        </c:forEach>
        <!-- <a href="#">咖啡</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">休闲零食</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">饼干糕点</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">冲饮谷物</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">营养保健</a> -->
        </span>
    </div>
    <div class="content">
    	<div class="food_left">
        	<div class="food_ban">
            	<div id="imgPlay2">
                    <ul class="imgs" id="actor2">
                        <li><a href="#"><img src="images/food_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/food_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/food_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prev_f">上一张</div>
                    <div class="next_f">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
            	 <c:forEach items="${vos[1].vos }" var="vo">
            	 	<a href="BrandListServlet?id=${vo.productCategory.id }">${vo.productCategory.name }</a>
       		 		
      			  </c:forEach>
                	<!-- <a href="#">饼干糕点</a><a href="#">休闲零食</a><a href="#">饮料果汁</a><a href="#">牛奶乳品</a><a href="#">冲饮谷物</a><a href="#">营养保健</a><a href="#">冲饮谷物</a><a href="#">营养保健</a> -->
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<c:forEach items="${list2 }" var="product">
        		<li>
                	<div class="name"><a href="#"> ${product.name }</a></div>
                    <div class="price">
                    	<font>￥<span>${product.price }</span></font> &nbsp; <fmt:formatNumber type="number" value="${product.price/20 }" maxFractionDigits="0"/>  R
                    </div>
                    <div class="img"><a href="ProductServlet?id=${product.id }"><img src="files/${product.fileName }" width="185" height="155" /></a></div>
                </li>
        	</c:forEach>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/food_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/food_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
    </div>    
    <!--End 食品饮料 End-->
    <!--Begin 个人美妆 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">3F</span>
    	<span class="fl">${vos[0].productCategory.name }</span>                                
        <span class="i_mores fr">
        <c:forEach items="${vos[0].vos}" var="vo2">
        	<a href="BrandListServlet?id=${vo2.productCategory.id }">${vo2.productCategory.name }</a>&nbsp; &nbsp; | &nbsp; &nbsp;
        </c:forEach>
       <!--  <a href="#">洗发护发</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">面膜</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">洗面奶</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">香水</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">沐浴露</a></span>                 -->
    </div>
    <div class="content">
    	<div class="make_left">
        	<div class="make_ban">
            	<div id="imgPlay3">
                    <ul class="imgs" id="actor3">
                        <li><a href="#"><img src="images/make_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/make_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/make_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prev_m">上一张</div>
                    <div class="next_m">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
            	<c:forEach items="${vos[0].vos}" var="vo2">
        			<a href="BrandListServlet?id=${vo2.productCategory.id }">${vo2.productCategory.name }</a>
       			 </c:forEach>
                	<!-- <a href="#">洗发护发</a><a href="#">牙刷牙膏</a><a href="#">面膜</a><a href="#">补水面膜</a><a href="#">香水</a><a href="#">面霜</a><a href="#">洗面奶</a><a href="#">脱毛膏</a><a href="#">沐浴露</a> -->
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<c:forEach items="${list3 }" var="product">
        		<li>
                	<div class="name"><a href="#"> ${product.name }</a></div>
                    <div class="price">
                    	<font>￥<span>${product.price }</span></font> &nbsp; <fmt:formatNumber type="number" value="${product.price/20 }" maxFractionDigits="0"/>  R
                    </div>
                    <div class="img"><a href="ProductServlet?id=${product.id }"><img src="files/${product.fileName }" width="185" height="155" /></a></div>
                </li>
        	</c:forEach>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/make_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/make_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
    </div>    
    <!--End 个人美妆 End-->
    <div class="content mar_20">
    	<img src="images/mban_1.jpg" width="1200" height="110" />
    </div>
    <!--Begin 母婴玩具 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">4F</span>
    	<span class="fl">${vos[3].productCategory.name }</span>                                
        <span class="i_mores fr">
        <c:forEach items="${vos[3].vos}" var="vo2">
        	<a href="BrandListServlet?id=${vo2.productCategory.id }">${vo2.productCategory.name }</a>&nbsp; &nbsp; | &nbsp; &nbsp;
        </c:forEach>
        </span>                               
    </div>
    <div class="content">
    	<div class="baby_left">
        	<div class="baby_ban">
            	<div id="imgPlay4">
                    <ul class="imgs" id="actor4">
                        <li><a href="#"><img src="images/baby_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/baby_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/baby_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prev_b">上一张</div>
                    <div class="next_b">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
            	 <c:forEach items="${vos[3].vos}" var="vo2">
            	 	<a href="BrandListServlet?id=${vo2.productCategory.id }">${vo2.productCategory.name }</a>
        			
      			  </c:forEach>
                	<!-- <a href="#">孕妈必备</a><a href="#">儿童玩具</a><a href="#">重装童鞋</a><a href="#">辅助食品</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">维生素</a><a href="#">重装童鞋</a><a href="#">辅助食品</a> -->
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<c:forEach items="${list4 }" var="product">
        		<li>
                	<div class="name"><a href="#"> ${product.name }</a></div>
                    <div class="price">
                    	<font>￥<span>${product.price }</span></font> &nbsp; <fmt:formatNumber type="number" value="${product.price/20 }" maxFractionDigits="0"/>  R
                    </div>
                    <div class="img"><a href="ProductServlet?id=${product.id }"><img src="files/${product.fileName }" width="185" height="155" /></a></div>
                </li>
        	</c:forEach>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/baby_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/baby_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
    </div>    
    <!--End 母婴玩具 End-->
    <!--Begin 家居生活 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">5F</span>
    	<span class="fl">${vos[4].productCategory.name }</span>                                
        <span class="i_mores fr">
        <c:forEach items="${vos[4].vos}" var="vo2">
        	<a href="BrandListServlet?id=${vo2.productCategory.id }">${vo2.productCategory.name }</a>&nbsp; &nbsp; |
        </c:forEach>
        </span>                                              
    </div>
    <div class="content">
    	<div class="home_left">
        	<div class="home_ban">
            	<div id="imgPlay5">
                    <ul class="imgs" id="actor5">
                        <li><a href="#"><img src="images/home_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/home_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/home_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prev_h">上一张</div>
                    <div class="next_h">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
            	<c:forEach items="${vos[4].vos}" var="vo2">
            		<a href="BrandListServlet?id=${vo2.productCategory.id }">${vo2.productCategory.name }</a>
        		</c:forEach>
                	<a href="#">床上用品</a><a href="#">家纺布艺</a><a href="#">餐具水具</a><a href="#">锅具厨具</a><a href="#">沙发</a><a href="#">书柜</a><a href="#">狗粮</a><a href="#">家装建材</a><a href="#">汽车用品</a>
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<c:forEach items="${list5 }" var="product">
        		<li>
                	<div class="name"><a href="#"> ${product.name }</a></div>
                    <div class="price">
                    	<font>￥<span>${product.price }</span></font> &nbsp; <fmt:formatNumber type="number" value="${product.price/20 }" maxFractionDigits="0"/>  R
                    </div>
                    <div class="img"><a href="ProductServlet?id=${product.id }"><img src="files/${product.fileName }" width="185" height="155" /></a></div>
                </li>
        	</c:forEach>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/home_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/home_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
    </div>    
    <!--End 家居生活 End-->
    <!--Begin 数码家电 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">6F</span>
    	<span class="fl">${vos[5].productCategory.name }</span>                                
        <span class="i_mores fr">
       <c:forEach items="${vos[5].vos}" var="vo2">
        	<a href="BrandListServlet?id=${vo2.productCategory.id }">${vo2.productCategory.name }</a>&nbsp; &nbsp; | &nbsp; &nbsp;
        </c:forEach>
        </span>                                               
    </div>
    <div class="content">
    	<div class="tel_left">
        	<div class="tel_ban">
            	<div id="imgPlay6">
                    <ul class="imgs" id="actor6">
                        <li><a href="#"><img src="images/tel_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/tel_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/tel_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prev_t">上一张</div>
                    <div class="next_t">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
            	 <c:forEach items="${vos[5].vos}" var="vo2">
            		 <a href="BrandListServlet?id=${vo2.productCategory.id }">${vo2.productCategory.name }</a>
       			 </c:forEach>
                	<!-- <a href="#">手机</a><a href="#">平板电脑</a><a href="#">空调</a><a href="#">合约机</a><a href="#">电风扇</a><a href="#">数码配件</a><a href="#">洗衣机</a><a href="#">电视</a><a href="#">充电器</a><a href="#">耳线</a> -->
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<c:forEach items="${list6 }" var="product">
        		<li>
                	<div class="name"><a href="#"> ${product.name }</a></div>
                    <div class="price">
                    	<font>￥<span>${product.price }</span></font> &nbsp; <fmt:formatNumber type="number" value="${product.price/20 }" maxFractionDigits="0"/>  R
                    </div>
                    <div class="img"><a href="ProductServlet?id=${product.id }"><img src="files/${product.fileName }" width="185" height="155" /></a></div>
                </li>
        	</c:forEach>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/tel_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/tel_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
    </div>    
    <!--End 数码家电 End-->
   
    <%@ include file="include/end.jsp" %>


</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
