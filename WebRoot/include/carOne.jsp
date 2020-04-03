<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- 购物车条目列表页 -->
<table border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0" cellpadding="0">
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
                    <!-- 	隐藏传当前id -->
                    <input type="hidden" value="${shoppingCarItem.product.id }" id="id"/>
                	<input type="text" value="${shoppingCarItem.num }" name="num" id="num" class="car_ipt" />  
                    <input type="button" value="" onclick="addUpdate1(jq(this));" class="car_btn_2" />
                </div>
            </td>
            <td align="center" style="color:#ff4e00;">￥${shoppingCarItem.product.price*shoppingCarItem.num } </td>
            <td align="center"><fmt:formatNumber type="number" value="${shoppingCarItem.product.price*shoppingCarItem.num/20 }" maxFractionDigits="0"/> R</td>
            <td align="center"><a onclick="ShowDiv('MyDiv','fade')" <c:set  var="index" value="${status.index }"></c:set>>删除</a>&nbsp; &nbsp;<a href="javascript:addCollectProduct(${shoppingCarItem.product.id })">加入收藏</a></td>
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
            	<a href="IndexServlet"><img src="images/buy1.gif" /></a>&nbsp; &nbsp; <a href="CarTwoServlet"><img src="images/buy2.gif" /></a>
            </td>
          </tr>
        </table>