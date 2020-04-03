// JavaScript Document

var jq = jQuery.noConflict();
function add(){
	jq("#upda").show();
	jq("#type2").hide();
	jq("#type3").hide();
}

jq(function(){
	
	jq("#ty1").change(function(){
		var ty=jq(this).val();
		if(ty==1){
			jq("#type2").hide();
			jq("#type3").hide();		
		}else if(ty==2){
			jq("#type3").hide();
			jq("#type2").show();
			jq.getJSON("MemberUserServlet","action=seltype&parentId=0",function(data){
				var str="<option value=\"0\">请选择</option>";
				jq(data).each(function(i,obj){					
					str+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
				});
				jq("#ty2").html(str);
			});
		}else if(ty==3){
			jq("#type3").show();
			jq("#type2").show();
			jq.getJSON("MemberUserServlet","action=seltype&parentId=0",function(data){
				var str="<option value=\"0\">请选择</option>";
				jq(data).each(function(i,obj){					
					str+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
				});
				jq("#ty2").html(str);
			});
			
			jq("#ty2").change(function(){
				jq.getJSON("MemberUserServlet","action=seltype&parentId="+jq("#ty2").val(),function(data){
					var str="<option value=\"0\">请选择</option>";
					jq(data).each(function(i,obj){					
						str+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
					});
					jq("#ty3").html(str);
				});
				
			});
			
		}else{
			jq("#type2").hide();
			jq("#type3").hide();					
		}
		
		
	});
	
	
	
	jq("#updaform").submit(function(){
		    var type=jq("#ty1").val();
		    if(type==0){
		    alert("请选择分类级别！");
		    return false;
		    }else if(type==1){
		    var name=jq("#three").val();
		    if(name==""){
		    alert("请输入分类名称！");
		    return false;
		    }
		    var parentId=0;
		    var type1=type;
		    jq.post("ProductServlet","pro=tianjiafenlei&name="+name+"&parentId="+parentId+"&type1="+type1,function(data){
		    if(data=="0"){
		    	alert("添加失败");
		    }else{
		    	alert("添加成功");
			     location.href="MemberUserServlet?action=common";
		    }
		    });
		    }else if(type==2){
		    var name=jq("#three").val();
		    if(name==""){
		    alert("请输入分类名称！");
		    return false;
		    }
		    var parentId=jq("#ty2").val();;
		    var type1=type;
		    jq.post("ProductServlet","pro=tianjiafenlei&name="+name+"&parentId="+parentId+"&type1="+type1,function(data){
		    if(data=="0"){
		    alert("添加失败");
		    }else{
		     alert("添加成功");
		     location.href="MemberUserServlet?action=common";
		    }
		    });
		    }else if(type==3){
		    var name=jq("#three").val();
		    if(name==""){
		    alert("请输入分类名称！");
		    return false;
		    }
		    var parentId=jq("#ty3").val();;
		    var type1=type;
		    jq.post("ProductServlet","pro=tianjiafenlei&name="+name+"&parentId="+parentId+"&type1="+type1,function(data){
		    if(data=="0"){
		    alert("添加失败");
		    }else{
		     alert("添加成功");
		     location.href="MemberUserServlet?action=common";
		    }
		    });
		    }
		    }
	  );
})



	function show(id,name,type){	
		alert(type);
		if(type==1){
			jq("#type2").hide();
			jq("#type3").hide();
		}else if(type==2){		
			jq("#type3").hide();
			jq("#type2").show();
		}else if(type==3){		
			jq("#type3").show();
			jq("#type2").show();
		}		
	}