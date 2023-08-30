package com.scaziti.desafio1;

import com.scaziti.desafio1.entities.Order;
import com.scaziti.desafio1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {
	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int code = scan.nextInt();
		double basicPrice = scan.nextDouble();
		double discount = scan.nextDouble();

		Order order = new Order(code, basicPrice, discount);
		System.out.println("Order code: " + order.getCode());
		System.out.printf("Order total: R$ %.2f", orderService.total(order));
	}
}
