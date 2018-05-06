package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		String fullPath=servletContext.getRealPath("/temp");//获取相对路径的绝对路径
		File repository = new File(fullPath);
		factory.setRepository(repository);//设置临时文件存放的文件夹
		String value="";
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解析request，将其中各表单元素和上传文件提取出来
		try {
			List<FileItem> items = upload.parseRequest(request);//items存放各表单元素
			
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {//遍历表单元素
			    FileItem item = iter.next();

			    if (item.isFormField()) {//非上传文件表单元素
			        String name = item.getFieldName();//获取表单元素的name属性
			        value = item.getString("UTF-8");//获取表单元素的值（一般是value属性）
			    } else {//上传文件		
			    	File uploadedFile = new File(servletContext.getRealPath("/uploadedfiles/"+item.getName()));
			        item.write(uploadedFile);//将临时文件转存为新文件保存（有同名文件，将被覆盖）
			        item.delete();//删除临时文件
			    }
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
			

		
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("文件已成功上传！同时上传的数据为："+value);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
