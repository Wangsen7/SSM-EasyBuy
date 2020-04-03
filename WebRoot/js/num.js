// JavaScript Document


function addUpdate(jia){		
	var c = jia.parent().find(".n_ipt").val();
	c=parseInt(c)+1;	
	jia.parent().find(".n_ipt").val(c);
}

function jianUpdate(jian){    
	var c = jian.parent().find(".n_ipt").val();
	if(c==1){    
		c=1;    
	}else{    
		c=parseInt(c)-1;    
		jian.parent().find(".n_ipt").val(c);
	}
}    




var jq = jQuery.noConflict();
function addUpdate1(jia){		
	var c = jia.parent().find(".car_ipt").val();
	c=parseInt(c)+1;	
	jia.parent().find(".car_ipt").val(c);
	/*获取当前id*/
	var id=jia.parent().find("#id").val();
	addCar(id,1);
	
}
/*购物车页面的加*/
function addCar(id,num){
	jq.getJSON("ShoppingServlet","action=addCar&id="+id+"&num="+num,function(data){		
		if(data>0){			
			alert("添加成功");
			/*异步刷新购物车列表*/
			jq("#carOne").load("include/carOne.jsp");
			/*异步刷新右边购物车*/
			jq("#car").load("include/car.jsp");
		}else{
			alert("添加失败");
		}
	})
}
function jianUpdate1(jian){    
	var c = jian.parent().find(".car_ipt").val();
	if(c==1){    
		c=1;    
	}else{    
		c=parseInt(c)-1;    
		jian.parent().find(".car_ipt").val(c);
		/*获取当前id*/
		var id=jian.parent().find("#id").val();
		jianCar(id,1);
	}
}    
/*购物车页面的减*/
function jianCar(id,num){
	jq.getJSON("ShoppingServlet","action=jianCar&id="+id+"&num="+num,function(data){		
		if(data>0){			
			alert("减成功");
			/*异步刷新购物车列表*/
			jq("#carOne").load("include/carOne.jsp");
			/*异步刷新右边购物车*/
			jq("#car").load("include/car.jsp");
		}else{
			alert("减失败");
		}
	})
}