/*•在服务器中添加一项：addServerItem
•在服务器中删除一项：removeServerItem
•返回服务器中存储的便签列表：getServerItems*/



function addServerItem(title) 
 { 
    // 在服务器中添加一项
	params={"title":title, "type":"add"};
	jQuery.ajax({
		async : false,
		type : "POST",  //提交类型
		url : "/project02/servlet/OfflineServlet",//提交网址
		data : params,//收集表单元素的数据
        dataType : "json",//服务器端返回数据的格式
        cache : false,//不缓存
		error : function(textStatus, errorThrown) {//ajax请求失败时执行（比如服务器关了）
			alert("系统ajax交互错误: " + textStatus);
		},
		success : function(data, textStatus) {	//ajax请求成功并接受到服务器返回信息，其中data中记录了服务器端返回的数据
			if(data=="ok")
				alert("向服务器成功添加："+title);
			else
				alert("向服务器成功添加失败！");
      	}
	});
 } 

 function removeServerItem(title) 
 { 
	    // 在服务器中删除一项
		params={"title":title, "type":"remove"};
		jQuery.ajax({
			async : false,
			type : "POST",  //提交类型
			url : "/project02/servlet/OfflineServlet",//提交网址
			data : params,//收集表单元素的数据
	        dataType : "json",//服务器端返回数据的格式
	        cache : false,//不缓存
			error : function(textStatus, errorThrown) {//ajax请求失败时执行（比如服务器关了）
				alert("系统ajax交互错误: " + textStatus);
			},
			success : function(data, textStatus) {	//ajax请求成功并接受到服务器返回信息，其中data中记录了服务器端返回的数据
				if(data=="ok")
					alert("从服务器成功删除："+title);
				else
					alert("从服务器成功删除失败！");
	      	}
		});
 } 

 function getServerItems() 
 { 
	    // 返回服务器中存储的便签列表
		result1=null;
		params={"type":"getAll"};
		jQuery.ajax({
			async : false,
			type : "POST",  //提交类型
			url : "/project02/servlet/OfflineServlet",//提交网址
			data : params,//收集表单元素的数据
	        dataType : "json",//服务器端返回数据的格式
	        cache : false,//不缓存
			error : function(textStatus, errorThrown) {//ajax请求失败时执行（比如服务器关了）
				alert("系统ajax交互错误: " + textStatus);
			},
			success : function(data, textStatus) {	//ajax请求成功并接受到服务器返回信息，其中data中记录了服务器端返回的数据
				result1=data.join();
	      	}
		});
		return result1;
 }