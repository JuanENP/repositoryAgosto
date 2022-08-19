package org.dao.register;

import java.util.List;

import org.modelo.register.Register;

/*
 * Aquí no se programa, se agregan métodos a implementar
 * 
 * 
 * */
public interface DaoRegister {

	// todas las funciones crud
	public void addRegister(Register register);

	public List<Register> listRegisters();

	public Register getRegisterById(int id);

	public void deleteRegister(int id);
}