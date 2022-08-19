package org.dao.register;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.register.Register;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoImplRegister implements DaoRegister{

	//agregado por mi
	@SessionTarget
	private Session session;
	
	@TransactionTarget
	private Transaction transaction;
	
	
	///autogenerado y lo de adentro escrito por mi
	@Override
	public void addRegister(Register register) {
		// TODO Auto-generated method stub
		try {
			session.saveOrUpdate(register);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception en DaoImplRegister.addRegister, línea 31: "+e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Register> listRegisters() {
		// TODO Auto-generated method stub
		List<Register> list= null;
		
		try {
			list=(List<Register>) session.createQuery("from Register").list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception en DaoImplRegister.listRegister, línea 45: "+e.getMessage());
		}
		return list;
		
	}

	@Override
	public Register getRegisterById(int id) {
		// TODO Auto-generated method stub
		Register register=null;
		
		try {
			register=(Register) session.get(Register.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception en DaoImplRegister.getRegisterById, línea 61: "+e.getMessage());
		}
		
		return register;
	}

	@Override
	public void deleteRegister(int id) {
		// TODO Auto-generated method stub
		Register register=null;
		
		try {
			register=(Register) session.get(Register.class, id);
			session.delete(register);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception en DaoImplRegister.deleteRegister, línea 77: "+e.getMessage());
		}
	}
}