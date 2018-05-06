package tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag extends BodyTagSupport{
	private static final long serialVersionUID = 1L;

	public HelloTag(){}
	
	public int doStartTag(){
		JspWriter out=this.pageContext.getOut();
		
		try {
			out.println("你好，世界！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Tag.SKIP_BODY;//忽略标签体的执行，直接执行doEndTag
	}
	
	public int doEndTag(){
		
		return Tag.EVAL_PAGE;//继续执行jsp剩余其它部分
	}
}
