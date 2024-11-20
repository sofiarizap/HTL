package SofiaAriza.e_commerce;

import SofiaAriza.e_commerce.Models.Categoria;
import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Producto;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioProducto;
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
	public CommandLineRunner initData(RepositorioCliente repositorioCliente,
																		RepositorioProducto repositorioProducto ){

		return (args) -> {
			Cliente sofia =new Cliente("sofia", "direccion");
			repositorioCliente.save(sofia);
			Producto botas= new Producto("botas", 1000,10, "botas militares","files","canton norte", Categoria.BOTAS, Boolean.TRUE,Boolean.TRUE);
			repositorioProducto.save(botas);
			Producto maleta= new Producto("maleta", 1000,10, "botas militares","files","canton norte", Categoria.MORRALES, Boolean.TRUE,Boolean.TRUE);
			repositorioProducto.save(maleta);
			Producto chaqueta= new Producto("chaqueta", 1000,10, "botas militares","files","canton norte", Categoria.ROPA, Boolean.TRUE,Boolean.TRUE);
			repositorioProducto.save(chaqueta);
	};}

}
