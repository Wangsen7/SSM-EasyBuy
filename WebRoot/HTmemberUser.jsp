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
        
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
        
    
<title>易买网后台</title>
</head>
<body>  
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
    	<!--Begin 所在收货地区 Begin-->
    	<span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
        		<span class="fl">
        	<c:choose>
        		<c:when test="${empty user }">
        			你好，请<a href="login.jsp">登录</a>&nbsp; <a href="regist.jsp" style="color:#ff4e00;">免费注册</a>&nbsp;|&nbsp;
        		</c:when>
        		<c:otherwise>
        			你好,${user.userName }&nbsp; <c:if test="${user.type==1 }"><a href="MemberUserServlet" style="color:#ff4e00;">后台管理</a>&nbsp;|&nbsp;</c:if>
        		</c:otherwise>
        	</c:choose>
        	<a href="#">我的订单</a>&nbsp;|</span>
        	<span class="ss">
            	<div class="ss_list">
                	<a href="#">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">我的收藏夹</a></li>
                                <li><a href="#">我的收藏夹</a></li>
                            </ul>
                        </div>
                    </div>     
                </div>
                <div class="ss_list">
                	<a href="#">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<script>
	$(document).ready(function(){
		$("form").submit(function(){
			var value=$(".m_ipt").val();
			var flag=true;
			if(value==""||value==null){
				alert("请填写要查询的信息");
				flag=false;
			}
			return flag;
		})
	})
</script>
<%@ include file="include/HTtop.jsp" %>
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
   		<%@ include file="include/HTleftM.jsp" %>
		<div class="m_right">
            <p></p>		
            
			<div class="mem_t">
            	<span class="m_num fr" style="margin-top:15px;"><a href="MemberUserServlet?action=showUpdate">返回</a></span>用户列表
            </div>
            <table border="1" class="mem_tab" style="width:870px; text-align:center; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr style="background:#ff4e00;color:white">
                <td>用户名称</td>
                <td>真实姓名</td>
                 <td>性别</td>
                  <td>类型</td>
                <td colspan="2">操作</td>
                
              </tr>
              <c:forEach items="${userPage.list }" var="user">
              	
              	 <tr>
	                <td width="145 class="td_bg"><a href="">${user.loginName }</a></td>
	                <td width="145">${user.userName }</td>  
	                 <td width="145 class="td_bg">
		                 <c:choose>
		                 	<c:when test="${user.sex==1 }">男</c:when>
		                 	<c:otherwise>女</c:otherwise>
		                 </c:choose> 
	                  </td>
	                <td width="145">
	                	<c:choose>
		                 	<c:when test="${user.type==1 }">管理员</c:when>
		                 	<c:otherwise>用户</c:otherwise>
		                 </c:choose> 
	                </td>  
	                 <td width="145"><a href="MemberUserServlet?action=showUpdate&id=${user.id }">修改</a></td>  
	                  <td width="145"><a href="MemberUserServlet?action=delete&id=${user.id }">删除</a></td>  
           	  	 </tr>    
              	
              </c:forEach>
                    
            </table>
            <div class="pages">
            		<a <c:choose>
                			<c:when test="${empty sea }">href="MemberUserServlet?currentPageNo=1" class="p_pre"</c:when>
                				<c:otherwise>href="MemberUserServlet?action=search&currentPageNo=1&loginName=${loginName }" class="p_pre"</c:otherwise>
                		</c:choose>>首页</a>
                	<a 
                		<c:choose>
                			<c:when test="${empty sea }">href="MemberUserServlet?currentPageNo=${userPage.currentPageNo-1 }" class="p_pre"</c:when>
                				<c:otherwise>href="MemberUserServlet?action=search&currentPageNo=${userPage.currentPageNo-1 }&loginName=${loginName }" class="p_pre"</c:otherwise>
                		</c:choose>
                	 >上一页
            	 </a>
                	
                	
                	<a 
                	<c:choose>
                			<c:when test="${empty sea }">href="MemberUserServlet?currentPageNo=${userPage.currentPageNo+1 }" class="p_pre"</c:when>
                				<c:otherwise>href="MemberUserServlet?action=search&currentPageNo=${userPage.currentPageNo+1 }&loginName=${loginName }" class="p_pre"</c:otherwise>
                		</c:choose>
                	 >下一页</a>
                	 	<a <c:choose>
                			<c:when test="${empty sea }">href="MemberUserServlet?currentPageNo=${userPage.totalPageCount }" class="p_pre"</c:when>
                				<c:otherwise>href="MemberUserServlet?action=search&currentPageNo=${userPage.totalPageCount }&loginName=${loginName }" class="p_pre"</c:otherwise>
                		</c:choose>>末页</a>
                </div>
        </div>
    </div>
	<!--End 用户中心 End--> 
   <%@ include file="include/end.jsp" %>   
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>

