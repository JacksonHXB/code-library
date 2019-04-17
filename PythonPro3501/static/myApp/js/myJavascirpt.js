alert("引入自定义JS脚本！")

$(document).ready(function(){
	$("#btn").click(function(){
		$.ajax({
			type:"get",
			url:"/studentsinfo/",
			dataType:"json",
			success:function(data, status){
				console.log(data)
			}
		})
	});
})






















