// JavaScript Document

var jq = jQuery.noConflict();
function addCar(id,num){
	jq.getJSON("ShoppingServlet","action=addCar&id="+id+"&num="+num,function(data){		
		if(data>0){			
			alert("添加成功");
			jq("#car").load("include/car.jsp");
		}else{
			alert("添加失败");
		}
	})
}
function addCarInfo(id){
	var num=jq("#num").val();
	addCar(id,num);
}

function addCollectProduct(id){
	jq.getJSON("CollectProductServlet","id="+id,function(data){
		if(data>0){
			alert("收藏成功");
		}else{
			alert("已收藏")
		}
	})
}
