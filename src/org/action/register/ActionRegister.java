package org.action.register;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.register.DaoImplRegister;
import org.dao.register.DaoRegister;
import org.modelo.register.Register;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionRegister extends ActionSupport implements ModelDriven<Register> {

	private Register register = new Register();// get set
	private DaoRegister dao = new DaoImplRegister();
	private List<Register> listRegisters = new ArrayList<Register>(); // g y s

	public String execute() {
		return SUCCESS;
	}

	public String addRegister() {
		dao.addRegister(register);
		return SUCCESS;
	}

	public String listRegister() {
		setListRegisters(dao.listRegisters());
		return SUCCESS;
	}

	
	/*
	 * HttpSevletRequest: permite recuperar el valor de un parametro en memoria
	 * */
	public String updateRegister() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
										//convierto a entero porque el método requiere un entero
		register = dao.getRegisterById(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}

	public String deleteRegister() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		dao.deleteRegister(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}

	@Override
	public Register getModel() {
		// TODO Auto-generated method stub
		return register;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public List<Register> getListRegisters() {
		return listRegisters;
	}

	public void setListRegisters(List<Register> listRegisters) {
		this.listRegisters = listRegisters;
	}
}