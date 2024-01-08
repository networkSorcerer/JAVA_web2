package com.subject;

public class SubjectVO {
	private int no;
	private String s_num;
	private String s_name;
	private String deleteable;
	
	public SubjectVO() {}
	
	public SubjectVO(String s_num, String s_name) {
		this(0, s_num, s_name);
	}
	
	public SubjectVO(int no, String s_num, String s_name) {
		this.no = no;
		this.s_num = s_num;
		this.s_name = s_name;
	}
	
	public SubjectVO(int no, String s_num, String s_name, String deleteable) {
		super();
		this.no = no;
		this.s_num = s_num;
		this.s_name = s_name;
		this.deleteable = deleteable;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getS_num() {
		return s_num;
	}

	public void setS_num(String s_num) {
		this.s_num = s_num;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getDeleteable() {
		return deleteable;
	}

	public void setDeleteable(String deleteable) {
		this.deleteable = deleteable;
	}
	
	@Override
	public String toString () {
		return "SubjectVO [no= " + no + ", s_num=" + s_num + ", s_name" + ", deleteable=" +deleteable+"]"; 
	}
}
