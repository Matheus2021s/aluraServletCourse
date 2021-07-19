package br.com.mariah.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static Long chaveSequencial = 1L;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		empresa.setCnpj("123");
		Banco.empresas.add(empresa);	

		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caellum");
		empresa2.setCnpj("123");
		Banco.empresas.add(empresa2);	
		
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.empresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public void remove(Long id) {
		Iterator<Empresa> it = empresas.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (id.equals(empresa.getId())) {
				it.remove();
			}
		}
	}

	public Empresa encontraPorId(Long id) {
		Iterator<Empresa> it = empresas.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (id.equals(empresa.getId())) {
				return empresa;
			}
		}
		throw new IllegalArgumentException("Empresa de id "+id+" não encontrada!");
	}

	public void atualiza(Empresa emp) {
		Iterator<Empresa> it = empresas.iterator();
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId().equals(emp.getId())) {
				empresas.remove(empresa);
				empresas.add(emp);
			}
		}
	}
}



