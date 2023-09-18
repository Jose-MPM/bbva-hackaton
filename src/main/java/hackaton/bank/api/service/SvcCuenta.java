package hackaton.bank.api.service;

import java.util.List;

import hackaton.bank.api.entity.Cuenta;

public interface SvcCuenta {
		
		List<Cuenta> getCuentas();
		Cuenta getCuenta(Integer id_cuenta);
		String createCuenta(Cuenta cuenta);
		String updateCuenta(Integer id_cuenta, Cuenta cuenta);
		//delete?
}
