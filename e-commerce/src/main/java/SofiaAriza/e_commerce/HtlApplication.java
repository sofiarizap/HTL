package SofiaAriza.e_commerce;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HtlApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtlApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(RepositorioCliente repositorioCliente){

		return (args) -> {
			Cliente sofia =new Cliente("sofia", "direccion","ciudad","email","clave","tel");
			System.out.println(sofia.getNombre());
			repositorioCliente.save(sofia);
	};}

}
