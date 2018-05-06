
/*包含添加便签、删除便签和与服务器同步等数据操作。其中用到了 navigator.onLine 属性、online 事件、DOM Storage 等 HTML5 新功能。

•添加便签：addDataItem
•通过 navigator.onLine 判断是否在线。
•如果在线，那么调用 addServerItem 直接把数据存储到服务器上。addServerItem 将在后面列出。
•如果离线，那么把数据添加到 localStorage 的“toAdd”项中。
•删除便签：removeDataItem
•通过 navigator.onLine 判断是否在线。
•如果在线，那么调用 removeServerItem 直接在服务器上删除数据。removeServerItem 将在后面列出。
•如果离线，那么把数据添加到 localStorage 的“toRemove”项中。
•数据同步：SyncWithServer
在 data.js 的最后一行，注册了 window 的 online 事件处理函数 SyncWithServer。当 online 事件发生时，SyncWithServer 将被调用。其功能如下。

•如果 navigator.onLine 表示当前离线，则不做任何操作。
•把 localStorage 中“toAdd”项的所有数据添加到服务器上，并删除“toAdd”项。
•把 localStorage 中“toRemove”项的所有数据从服务器中删除，并删除“toRemove”项。
•删除当前页面列表中的所有便签。
•调用 getServerItems 从服务器获取所有便签，并添加在页面列表中。getServerItems 将在后面列出。
*/




 function addDataItem(title) 
 { 
    if (navigator.onLine) // 在线状态
        addServerItem(title); 
    else {// 离线状态
        var str = localStorage.getItem("toAdd"); 
        
        if(str == null) 
            str = title; 
        else 
            str = str + "," + title; 
       
        localStorage.setItem("toAdd", str); 
    } 
 } 

 function removeDataItem(title) 
 { 
    if (navigator.onLine) // 在线状态
        removeServerItem(title); 
    else{ // 离线状态     
        var str = localStorage.getItem("toRemove"); 
        
        if(str == null) 
            str = title; 
        else 
            str = str + "," + title; 

        localStorage.setItem("toRemove", str); 
    } 
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

}