package hackaton.bank.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hackaton.bank.api.entity.Cuenta;
import jakarta.transaction.Transactional;

public interface RepoCuenta extends JpaRepository<Cuenta, Integer>{
	
	//DEFINICION DE NUESTROS METODOS
	@Query(value="SELECT * FROM cuenta WHERE status = :status", nativeQuery = true)
	List<Cuenta> findByStatus(@Param("status") Integer status);
	
	@Query(value="SELECT * FROM cuenta WHERE id_cuenta = :id_cuenta", nativeQuery = true)
	Cuenta findByIdCuenta(@Param("id_cuenta") Integer id_cuenta);
	
	@Query(value="INSERT INTO cuenta (nombre_cliente,saldo) VALUES(:nombre_cliente, :saldo)", nativeQuery = true)
	Cuenta createCuenta(@Param("nombre_cliente") String nombre_cliente, @Param("saldo") Double saldo);
	
	@Transactional
    @Modifying
	@Query(value="UPDATE cuenta SET nombre_cliente=:nombre_cliente, saldo=:saldo WHERE id_cuenta= :id_cuenta", nativeQuery = true)
	Cuenta updateCuenta(@Param("id_cuenta") Integer id_cuenta, @Param("nombre_cliente") String nombre_cliente, @Param("saldo") Double saldo);
	
	
	

}
