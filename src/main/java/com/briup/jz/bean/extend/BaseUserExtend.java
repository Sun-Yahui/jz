package com.briup.jz.bean.extend;

import java.util.List;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.Comment;

public class BaseUserExtend extends BaseUser{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Comment> comment;
	
	private List<AccountApply> accountApply;
	
	private List<AccountCustomer> accountCustomer;
	
	private List<AccountEmployee> accountEmployee;
	
	public List<AccountApply> getAccountApply() {
		return accountApply;
	}
	public void setAccountApply(List<AccountApply> accountApply) {
		this.accountApply = accountApply;
	}
	public List<AccountCustomer> getAccountCustomer() {
		return accountCustomer;
	}
	public void setAccountCustomer(List<AccountCustomer> accountCustomer) {
		this.accountCustomer = accountCustomer;
	}
	public List<AccountEmployee> getAccountEmployee() {
		return accountEmployee;
	}
	public void setAccountEmployee(List<AccountEmployee> accountEmployee) {
		this.accountEmployee = accountEmployee;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	

}
