package bean;

public class PageParam {
	private Integer first;
	private Integer next;
	private Integer pre;
	private Integer last;
	private Integer now;
	private Integer totalPage;
	
	public Integer getNow() {
		return now;
	}
	public void setNow(Integer now) {
		this.now = now;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getNext() {
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public Integer getPre() {
		return pre;
	}
	public void setPre(Integer pre) {
		this.pre = pre;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	
	
}
