<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
        			你好，请<a href="login.jsp">登录</a>&nbsp; 
        		</c:when>
        		<c:otherwise>
        			你好,${user.userName }&nbsp; <c:if test="${user.type==1 }"><a href="MemberUserServlet?action=user" style="color:#ff4e00;">后台管理</a>&nbsp;|&nbsp;
        				
        			</c:if>
        		</c:otherwise>
        	</c:choose>
        	<a href="login.jsp">切换用户</a>
        	<a href="MemberUserServlet?action=wodei">我的订单</a>&nbsp;|
        	<a href="regist.jsp" style="color:#ff4e00;">免费注册</a>&nbsp;|       
        	</span>
        	<span class="ss">
            	<div class="ss_list">
                	<a href="#">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="collect.jsp">我的收藏夹</a></li>                           
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
			var value=$(".s_ipt").val();
			var flag=true;
			if(value==""||value==null){
				alert("请填写要查询的信息");
				flag=false;
			}
			return flag;
		})
	})
</script>
<div class="top">
    <div class="logo"><a href="Index.html"><img src="images/logo.png" /></a></div>
    <div class="search">
    	<form method="post" action="BrandListServlet?action=search">
        	<input type="text" value="" class="s_ipt" name="name"/>
            <input type="submit" value="搜索" class="s_btn" />
        </form>                      
        <span class="fl"><a href="BrandListServlet?action=search1&name=香水" >香水</a><a href="BrandListServlet?action=search1&name=牛奶">牛奶</a><a href="BrandListServlet?action=search1&name=美食">美食</a><a href="BrandListServlet?action=search1&name=蛋糕">蛋糕</a><a href="BrandListServlet?action=search1&name=日用品">日用品</a><a href="BrandListServlet?action=search1&name=连衣裙">连衣裙</a></span>
    </div>
    <div class="i_car" id="car">
    	<%@ include file="car.jsp" %>
    </div>
</div>
