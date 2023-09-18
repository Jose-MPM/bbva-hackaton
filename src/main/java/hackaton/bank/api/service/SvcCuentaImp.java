package hackaton.bank.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackaton.bank.api.entity.Cuenta;
import hackaton.bank.api.repository.RepoCuenta;


@Service
public class SvcCuentaImp implements SvcCuenta {
	
	@Autowired
	RepoCuenta repo;

	@Override
	public List<Cuenta> getCuentas() {
		return repo.findByStatus(1);
	}

	@Override
	public Cuenta getCuenta(Integer id_cuenta) {
		return repo.findByIdCuenta(id_cuenta);
	}

	@Override
	public String createCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		Cuenta cuentaSaved = repo.findByIdCuenta(cuenta.getId_cuenta());
		if (cuentaSaved == null) {
			return "La cuenta ha sido creada";
		}
		return "La cuenta existe";
		
	}

	@Override
	public String updateCuenta(Integer id_cuenta, Cuenta cuenta) {
		Cuenta cuentaSaved = repo.findByIdCuenta(cuenta.getId_cuenta());
		if (cuentaSaved == null) {
			return "La cuenta que quiere actualizar no existe";
		}
		repo.updateCuenta(id_cuenta, cuenta.getNombre_cliente(), cuenta.getSaldo());
		return "La cuenta existe y se ha actualizado";
	}

}
