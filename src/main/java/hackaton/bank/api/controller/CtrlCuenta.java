package hackaton.bank.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackaton.bank.api.entity.Cuenta;
import hackaton.bank.api.service.SvcCuenta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cuenta")
public class CtrlCuenta { // ProductoRestController
	
	@Autowired
	SvcCuenta svc;
	
	/**
	 * Regresa una lista con todos las cuentas.
	 * @return una lista con todos las cuentas.
	 */
	@GetMapping()
	public ResponseEntity<List<Cuenta>> getCuentas(){
		//List cuentas = new ArrayList(); 
		return new ResponseEntity<>(svc.getCuentas(), HttpStatus.OK);
		//return null;
	}
	
	/**
	 * Regresa una cuenta dado su id
	 * @return una cuenta.
	 */
	@GetMapping("/{id_cuenta}")
	public ResponseEntity<Cuenta> getCuenta(@PathVariable int id_cuenta){
		Cuenta cuenta = new Cuenta("Jose Manuel", 1000.0);
		return new ResponseEntity<>(cuenta, HttpStatus.OK);
		//return null;
	}
	
	@PostMapping
	public ResponseEntity<String> createCuenta(@Valid @RequestBody Cuenta cuenta, BindingResult bindingResult){
		Cuenta new_cuenta = new Cuenta("Jose Manuel", 1000.0);
		String message ="";
		if(bindingResult.hasErrors()) {
			message = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new ResponseEntity<>(message , HttpStatus.BAD_REQUEST);
		}
		//CODIGO CORRESPONDIENTE PARA LA INSERSION EN LA BASE
		message = "Cuenta creada";
		return new ResponseEntity<>(message, HttpStatus.OK);
		//return null;
	}
	
	// TO update
	@PutMapping("/{id_cuenta}")
	public ResponseEntity<String> updateCuenta(@PathVariable int id_cuenta, @Valid @RequestBody Cuenta cuenta, BindingResult bindingResult){
		Cuenta new_cuenta = new Cuenta("Jose Manuel", 1000.0);
		String message ="";
		if(bindingResult.hasErrors()) {
			message = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new ResponseEntity<>(message , HttpStatus.BAD_REQUEST);
		}
		//CODIGO CORRESPONDIENTE PARA LA INSERSION EN LA BASE
		message = "Cuenta actualizada";
		return new ResponseEntity<>(message, HttpStatus.OK);
		//return null;
	}
	
	
}
