package com.example.tareaspring2;

import com.example.tareaspring2.entities.Laptop;
import com.example.tareaspring2.entities.Ordenador;
import com.example.tareaspring2.repository.LaptopRepository;
import com.example.tareaspring2.repository.OrdenadorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TareaSpring2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TareaSpring2Application.class, args);
		OrdenadorRepository repositoryOrdenador = context.getBean(OrdenadorRepository.class);
		LaptopRepository    repositoryLaptop    = context.getBean(LaptopRepository.class);

		//creando ordenadores y laptops
		Ordenador ordenador1 = new Ordenador(null,"dragon","ASUS",1992);
		Laptop laptop1 = new Laptop(null,"RedDragon","HP",2022,1.1);
		//comprobamos
		System.out.println("cantidad de ordenadores: " + repositoryOrdenador.count());
		System.out.println("cantidad de laptops: " + repositoryLaptop.count());

		//almacenamos ordenadores y laptops
		repositoryOrdenador.save(ordenador1);
		repositoryLaptop.save(laptop1);
	}

}
