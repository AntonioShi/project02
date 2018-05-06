package html5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class OfflineServlet extends HttpServlet {
	ArrayList<String> notes;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String result="ok";
		String jsonStr;
		Gson gson = new Gson();//google的json插件（能将java类的对象、数组转变成符合json格式的字符串，也能将符合json格式的字符串转换成为java类）
				
		if(type.equals("add")){
			notes.add(title);
			jsonStr=gson.toJson(result);
		}else if(type.equals("remove")){
			notes.remove(title);
			jsonStr=gson.toJson(result);	
		}else{
			jsonStr = gson.toJson(notes);
			
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(jsonStr);//将符合json格式的字符串传回给客户端
		out.flush();
		out.close();
	}


	public void init() throws ServletException {//在tomcat创建servlet对象时，该方法被自动调用一次
		notes=new ArrayList<String>();
		notes.add("myNote1"); 
		notes.add("myNote2");
	}

}
