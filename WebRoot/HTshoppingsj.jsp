<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
    <script type="text/javascript" src="${ctx}/js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="${ctx}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/menu.js"></script>    
        
	<script type="text/javascript" src="${ctx}/js/select.js"></script>
    
	<script type="text/javascript" src="${ctx}/js/lrscroll.js"></script>
    
    <script type="text/javascript" src="${ctx}/js/iban.js"></script>
    <script type="text/javascript" src="${ctx}/js/fban.js"></script>
    <script type="text/javascript" src="${ctx}/js/f_ban.js"></script>
    <script type="text/javascript" src="${ctx}/js/mban.js"></script>
    <script type="text/javascript" src="${ctx}/js/bban.js"></script>
    <script type="text/javascript" src="${ctx}/js/hban.js"></script>
    <script type="text/javascript" src="${ctx}/js/tban.js"></script>
    
	<script type="text/javascript" src="${ctx}/js/lrscroll_1.js"></script>
    <script>
    $(function(){
    var id1=$("#categoryLevel1Id").val();
    var id2=$("#categoryLevel2Id").val();
    var id3=$("#categoryLevel3Id").val();
    $.getJSON("ProductServlet","pro=tianjiafenleiid&parentId=0",function(date){
       var str="<option value=\"0\">请选择</option>";
       $(date).each(function(i,obj){
       if(id1==obj.id){
       str+="<option value=\""+obj.id+"\" selected=\"selected\">"+obj.name+"</option>";
       }else{
       str+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
       }
       });
       $("#fenlei1").html(str);
        if(id2!=""){
     var parentId=$("#fenlei1").val();
     $.getJSON("ProductServlet","pro=tianjiafenleiid&parentId="+parentId,function(date){
       var str="<option value=\"0\">请选择</option>";
       $(date).each(function(i,obj){
      if(id2==obj.id){
       str+="<option value=\""+obj.id+"\" selected=\"selected\">"+obj.name+"</option>";
       }else{
       str+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
       }
       });
       $("#fenlei2").html(str);
        if(id3!=""){
     var parentId=$("#fenlei2").val();
     $.getJSON("ProductServlet","pro=tianjiafenleiid&parentId="+parentId,function(date){
       var str="<option value=\"0\">请选择</option>";
       $(date).each(function(i,obj){
      if(id3==obj.id){
       str+="<option value=\""+obj.id+"\" selected=\"selected\">"+obj.name+"</option>";
       }else{
       str+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
       }
       });
       $("#fenlei3").html(str);
       });
     } 
       });
     }  
       });
    
     
    $("#fenlei1").change(function(){
      var parentId=$("#fenlei1").val();
     if(parentId=="0"){
     alert("请选择一级分类！");
     return false;
     }
       $.getJSON("ProductServlet","pro=tianjiafenleiid&parentId="+parentId,function(date){
       var str="<option value=\"0\">请选择</option>";
       $(date).each(function(i,obj){
       str+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
       });
       $("#fenlei2").html(str);
       });
      });
     
    $("#fenlei2").change(function(){
      var parentId=$("#fenlei2").val();
     if(parentId=="0"){
     alert("请选择一级分类！");
     return false;
     }
       $.getJSON("ProductServlet","pro=tianjiafenleiid&parentId="+parentId,function(date){
       var str="<option value=\"0\">请选择</option>";
       $(date).each(function(i,obj){
       str+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
       })
       $("#fenlei3").html(str);
       });
      }) 
    })
 
    </script>
    <style >
    #tupian img{
    width: 50px;
    height: 40px;
    }
    </style>
<title>尤洪</title>
</head>
<body>  
<!--Begin Header Begin-->
	<%@ include file="include/HTtop.jsp" %>
<!--End Header End--> 
<!--Begin Login Begin-->
<div class="m_content">
	<%@ include file="include/HTleftM.jsp" %>
<p id="klo"></p>
	<div>
		<div class="">
        	<input type="hidden" value="${product.categoryLevel1Id}" id="categoryLevel1Id"/>
        	<input type="hidden" value="${product.categoryLevel2Id}" id="categoryLevel2Id"/>
        	<input type="hidden" value="${product.categoryLevel3Id}" id="categoryLevel3Id"/>
        	
        	<c:if test="${product==null}">
              	<form action="ProductServlet?pro=shangpingtianjia"  enctype="multipart/form-data" method="post">
             </c:if>
        	<c:if test="${product!=null}">
              	<form action="ProductServlet?pro=xiougaitianjia2"  enctype="multipart/form-data" method="post">
             </c:if>
             <input type="hidden" value="${product.fileName}" name="fileName1"/>
        	<input type="hidden" value="${id}" name="shangpinid"/>
            <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr height="50" valign="top">
              	<td width="95">&nbsp;</td>
              </tr>
              
              <tr height="50" id="type2">
                <td align="right"><font color="#ff4e00"></font>&nbsp;一级分类&nbsp;</td>
                <td><select style="width: 100px;height: 25px" id="fenlei1" name="fenlei1">
                </select></td>
              </tr>
              <tr height="50" id="type3">
                <td align="right"><font color="#ff4e00"></font>&nbsp;二级分类 &nbsp;</td>
                <td><select style="width: 100px;height: 25px" id="fenlei2"  name="fenlei2">
                <option value="0">请选择</option>
                </select></td>
              </tr>
              <tr height="50" id="type3">
                <td align="right"><font color="#ff4e00"></font>&nbsp;三级分类 &nbsp;</td>
                <td><select style="width: 100px;height: 25px" id="fenlei3"  name="fenlei3">
                <option value="0">请选择</option>
                </select></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00"></font>&nbsp;商品名称 &nbsp;</td>
                <td><input name="name" type="text" value="${product.name}" class="" /></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00"></font>&nbsp;商品图片 &nbsp;</td>
                <td id="tupian"><c:if test="${product!=null}">
              	<img src="${ctx}/files/${product.fileName}"/>
              	</c:if><input name="fileName" type="file"  value=""/></td>
              </tr>
               <tr height="50">
                <td align="right"><font color="#ff4e00"></font>&nbsp;商品单价&nbsp;</td>
                <td><input name="price" type="text" value="${product.price}"  /></td>
              </tr>
               <tr height="50">
                <td align="right"><font color="#ff4e00"></font>&nbsp;商品库存 &nbsp;</td>
                <td><input name="stock" type="text" value="${product.stock}"/></td>
              </tr>
               <tr height="50">
                <td align="right"><font color="#ff4e00"></font>&nbsp;商品描述 &nbsp;</td>
                <td><input name="description" type="text" value="${product.description}" class="" /></td>
              </tr>
              <tr height="60">
              	<td>&nbsp;</td>
              	<c:if test="${product==null}">
              	<td><input type="submit" value="添加商品" class="log_btn" name="tijiao"/></td>
              	</c:if>
                <c:if test="${product!=null}">
              	<td><input type="submit" value="商品修改" class="log_btn" name="tijiao"/></td>
              	</c:if>
              </tr>
            </table>
            </form>
            
        </div>
    </div>
</div>


</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>

