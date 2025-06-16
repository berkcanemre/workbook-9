package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.CustomerDAO;
import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	private static ProductDAO productDAO;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

		// Get the ProductDAO bean (Spring handles creation)
		productDAO = context.getBean(ProductDAO.class);

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- PRODUCT MENU ---");
			System.out.println("1. List Products");
			System.out.println("2. Add Product");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Search Product by Name");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
				case 1:
					productDAO.getAll().forEach(System.out::println);
					break;
				case 2:
					System.out.print("Enter product ID: ");
					int id = Integer.parseInt(scanner.nextLine());
					System.out.print("Enter name: ");
					String name = scanner.nextLine();
					System.out.print("Enter category: ");
					String category = scanner.nextLine();
					System.out.print("Enter price: ");
					double price = Double.parseDouble(scanner.nextLine());
					productDAO.add(new Product(id, name, category, price));
					System.out.println("Product added.");
					break;
				case 3:
					System.out.print("Enter ID of product to update: ");
					int updateId = Integer.parseInt(scanner.nextLine());
					System.out.print("Enter new name: ");
					String newName = scanner.nextLine();
					System.out.print("Enter new category: ");
					String newCategory = scanner.nextLine();
					System.out.print("Enter new price: ");
					double newPrice = Double.parseDouble(scanner.nextLine());
					productDAO.update(new Product(updateId, newName, newCategory, newPrice));
					System.out.println("Product updated.");
					break;
				case 4:
					System.out.print("Enter product ID to delete: ");
					int deleteId = Integer.parseInt(scanner.nextLine());
					productDAO.delete(deleteId);
					System.out.println("Product deleted.");
					break;
				case 5:
					System.out.print("Enter name to search: ");
					String searchName = scanner.nextLine();
					Product found = productDAO.findByName(searchName);
					System.out.println(found != null ? found : "Product not found.");
					break;
				case 0:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice.");
			}

		} while (choice != 0);
	}
}