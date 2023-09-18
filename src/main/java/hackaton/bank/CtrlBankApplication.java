/**
 * Class that represent the bank init
 * 
 * @author Jose Manuel
 * @version 1.1
 * */

package hackaton.bank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Los controladores sirven para responder exponer endpoins
 * un cliente consume un endpoint a travez de una ruta 
 * */
@RestController
public class CtrlBankApplication {
	
	/* Para que deje de ser un simple metodo, hay que agregar el metodo del endpoint
	 * como: get, post, put, DeleteMapping
	 * La notacion puede no tener parametros, si la dejamos asi estamos diciendo que 
	 * se accedera a ese endpoint desde la ruta de localhost:8080
	 * Si le agregamos un parametro estaremos definiendo la ruta de acceso a ese metodo
	 * 
	 * */
	@GetMapping("/HelloBank")
	public String HelloBank() {
		return "Bienvenido al Banco";
	}
	
	
	
}
