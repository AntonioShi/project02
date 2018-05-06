
<%@ page contentType="text/html;charset=UTF-8" %>
<html> 
<head>
<title>显示时间</title>
</head>
<body bgcolor="#FFCCCC"> 
		<!-- tomcat目录\work\Catalina\localhost\项目名\包名，有Tomcat生成的jsp的.java和.class文件 --> 		
		<%@ include file = "header.jsp"%>
		<br>this is main content!<br>
		<%@ include file = "footer.jsp"%>

仅当include动作不能满足要求时，我们才应该使用include指令。（详情请见本页的源代码）<br><br><br><br>
include指令是<h1>编译阶段</h1>的指令，即include所包含的文件的内容是编译的时候插入到JSP文件中	<br><br><br><br>	
jsp:include动作是在主页面被请求时，将次级页面的 <h1>输出</h1>包含进来。		
<%-- JSP中include指令和include动作的区别 


　　include指令是编译阶段的指令，即include所包含的文件的内容是编译的时候插入到JSP文件中，JSP引擎在判断JSP页面未被修改，否则视为已被修改。由于被包含的文件是在编译时才插入的，因此如果只修改了include文件内容，而没有对JSP修改，得到的结构将不会改变，所以直接执行已经存在的字节码文件，而没有重新编译。因此对不经常变化的内容，用include指令是合适的，如果需要的内容是经常变化的，则需要动作元素<jsp:include>.下面将详细区分他们之间的不同


1.include指令
    include可以在JSP页面转换成Servlet之前，将JSP代码插入其中。它的主要优点是功能强大，所包含的代码可以含有总体上影响主页面的JSP构造，比如属性、方法的定义和文档类型的设定。它的缺点是难于维护只要被包含的页面发生更改，就得更改主页面，这是因为主页面不会自动地查看被包含的页面是否发生更改。

语法：<%@ include file="sample.jsp" %>

2.include动作
    jsp:include动作是在主页面被请求时，将次级页面的输出包含进来。尽管被包含的页面的输出中不能含有JSP，但这些页面可以是其他资源所产生的 结果。服务器按照正常的方式对指向被包含资源的URL进行解释，因而这个URL可以是Servlet或JSP页面。服务器以通常的方式运行被包含的页面， 将产生的输出放到主页面中，这种方式与RequestDispatcher类的include方法一致。它的优点是在被包含的页面发生更改时，无须对主页 面做出修改。它的缺点是所包含的是次级页面的输出，而非次级页面的实际代码，所以在被包含的页面中不能使用任何有可能在整体上影响主页面的JSP构造。

语法： <jsp:include page="sample.jsp" flush="true"> <jsp:param name="name" value="value"/> </jsp:include> 

   其中参数设置可以没有，如果没有参数设置，则必须采用<jsp:include page="sample.jsp" flush="true"/>形式

3. 使用include动作还是include指令？

　　使用include指令，如果被包含的文件发生改变，那么，用到它的所有Jsp页面都需要更新。

　　仅当include动作不能满足要求时，我们才应该使用include指令。

　　有 些开发人员认为include指令生成的代码执行起来比使用include动作的代码更快。尽管原则上由可能的确如此，但性能上的差异很小，以致难以测 量，同时，include动作在维护上的优势十分巨大，当两种方法都可以使用时，include动作几乎肯定是首选的方法。

　　对于文件包含，应该尽可能地使用include动作。仅在所包含的文件中定义了主页面要用到的字段或方法，或所包含的文件设置了主页面的响应报头时，才应该使用include指令。

既然include指令产生难以维护的代码，为什么人们还要使用它呢？
　　因为include指令更为强大。include指令允许所包含的文件中含有影响主页面的Jsp代码，比如响应报头的设置和字段、方法的定义。


例子：//subpage.jsp
<%! int num=0; %>
//mainpage.jsp
<html>
 <body>
  <%@ include file="subpage.jsp" %>
  <%= num %>
 </body>
</html>

当然使用include动作时这是不可能的，因为num变量未定义，主页面不能成功的转换成servlet。 --%>
			
</body>
</html> 