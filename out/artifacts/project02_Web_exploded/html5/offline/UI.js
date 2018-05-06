
/*UI.js 中的代码包含添加便签和删除便签的界面操作。

•添加便签
•用户点击“New Note”按钮，newNote 函数被调用。
•newNote 函数会弹出对话框，用户输入新便签内容。newNote 调用 add 函数。
•add 函数分别调用 addUIItem 和 addDataItem 添加页面元素和数据。addDataItem 代码将在后面列出。
•addUIItem 函数在页面列表中添加一项。并指明 ondblclick 事件的处理函数是 remove，使得双击操作可以删除便签。
•删除便签
•用户双击某便签时，调用 remove 函数。
•remove 函数分别调用 removeUIItem 和 removeDataItem 删除页面元素和数据。removeDataItem 将在后面列出。
•removeUIItem 函数删除页面列表中的相应项。*/




function newNote() 
 { 
    var title = window.prompt("New Note:"); 
    
    if (title) 
        add1(title); 
 } 
 
 function add1(title) 
 {  	
    // 在界面中添加
    jQuery("#list").append("<li id='"+title+"' ondblclick=remove1('"+title+")'>"+title+"</li>"); 
    // 在数据中添加
    addDataItem(title); 
 } 
 
 function remove1(title) 
 { 
    // 从界面中删除
    jQuery("#"+title).remove();
    // 从数据中删除
    removeDataItem(title); 
 } 

 function SyncWithServer() 
 { 
    // 如果当前是离线状态，不需要做任何处理
    if (navigator.onLine == false)return; 

    var i = 0; 
    // 和服务器同步添加操作
    var str = localStorage.getItem("toAdd"); 
    if(str != null) 
    { 
        var addItems = str.split(","); 
        
        for(i = 0; i<addItems.length; i++) 
        { 
            addDataItem(addItems[i]); 
        } 
        localStorage.removeItem("toAdd"); 
    } 

    // 和服务器同步删除操作
    str = localStorage.getItem("toRemove"); 
    if(str != null) 
    { 
        var removeItems = str.split(","); 
        for(i = 0; i<removeItems.length; i++) 
        { 
            removeDataItem(removeItems[i]); 
        } 
        localStorage.removeItem("toRemove"); 
    } 

    // 删除界面中的所有便签   
    jQuery("#list").html("");

    // 从服务器获取全部便签，并显示在界面中
    allItems=getServerItems(); 
    if(allItems != null) 
    { 
        var items = allItems.split(","); 
        for(i = 0; i<items.length; i++) 
        { 
            jQuery("#list").append("<li id='"+items[i]+"' ondblclick=remove1('"+items[i]+"')>"+items[i]+"</li>"); 
        } 
    } 
 }