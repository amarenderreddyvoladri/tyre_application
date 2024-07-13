package com.edubridge.tyre_application;

import java.util.List;
import java.util.Scanner;


import com.edubridge.tyre_application.dao.TyreDao;
import com.edubridge.tyre_application.dao.TyreDaoImpl;
import com.edubridge.tyre_application.model.Tyre;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		TyreDao dao = new TyreDaoImpl();

		Scanner sc = new Scanner(System.in);
 
		while (true) {
			System.out.println("\nMY  CONTACT APP");
			System.out.println("----------------");
			System.out.println("1. ADD TYRE");
			System.out.println("2. VIEW TYRE");			
			System.out.println("3. GET TYRE(using Id)");
			System.out.println("4. SEARCH TYRE(using Name)");
			System.out.println("5. UPDATE TYRE");
			System.out.println("6. DELETE TYRE");
			System.out.println("7. DELETE ALL TYRE");
			System.out.println("8. TRUNCATE TYRE");
			System.out.println("9. DESCRIBE TYRE");
			System.out.println("0. EXIT");

			System.out.println("PLEASE CHOOSE OPTION  : ");
			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.println("AddContact()");
				System.out.println("Enter the Tyre ID : ");
				int id = sc.nextInt();
				System.out.println("Enter the Tyre Name : ");
				String brand = sc.next();
				System.out.println("Enter the Tyre Color : ");
				String color = sc.next();
				System.out.println("Enter the Tyre Price : ");
				int price = sc.nextInt();

				Tyre newTyre = new Tyre();
				newTyre.setId(id);
				newTyre.setBrand(brand);
				newTyre.setColor(color);
				newTyre.setPrice(price);

				int status = dao.addTyre(newTyre);
				if (status >= 1) {
					System.out.println("New Tyre is Added Successfully!");
				} else {
					System.out.println("New Tyre Addition Failed!");
				}

				break;

			case 2:
				System.out.println("getAllContacts()");
				List<Tyre> tyres = dao.getAllTyres();
				if (tyres.size() != 0) {
					for (Tyre t : tyres) {
						System.out.println(t.getId() + "\t" + t.getBrand() + "\t" + t.getColor() + "\t" + t.getPrice());
					}
				} else {
					System.out.println("No Tyres Exist!!");
				}
				break;

			case 3: // System.out.println("search contact using ID");

				System.out.println("Please Enter Tyre ID to search record : ");
				int searchTyreId = sc.nextInt();
				Tyre tyre = dao.getTyre(searchTyreId);
				if (tyre != null) {
					{
						System.out.println(tyre.getId() + "\t" + tyre.getBrand() + "\t" + tyre.getColor() + "\t"
								+ tyre.getPrice());
					}
				} else {
					System.out.println("No tyres found");
				}
				break;

			case 4: // System.out.println("get contact using Name");

				System.out.println("Please Enter Tyre BRAND to get tyre details : ");
				String searchBrand = sc.next();

				Tyre tyre1 = dao.searchTyre(searchBrand);
				if (tyre1 != null) {
					{
						System.out.println(tyre1.getId() + "\t" + tyre1.getBrand() + "\t" + tyre1.getColor()
								+ "\t" + tyre1.getPrice());
					}
				} else {
					System.out.println("No tyres found");
				}
				break;
				
			case 5:
				System.out.println("Please Enter the ID to UPDATE the Record in Tyre Table : ");
				int existId = sc.nextInt();
				Tyre existingTyre = dao.getTyre(existId);
				System.out.println("ExistingContact : " + existingTyre);
				System.out.println(existingTyre.getPrice());

				if (existingTyre != null) {

					System.out.println("Enter New Brand : ");
					String newBrand = sc.next();

					System.out.println("Enter New Color : ");
					String newColor = sc.next();

					System.out.println("Enter New Price : ");
					int newPrice = sc.nextInt();

					existingTyre.setBrand(newBrand);
					existingTyre.setColor(newColor);
					existingTyre.setPrice(newPrice);

					int updateQueryStatus = dao.updateTyre(existingTyre);
					System.out.println("Status of Update : " + updateQueryStatus);

					if (updateQueryStatus >= 1) {
						System.out.println("Tyre Record Updated Successsfully!!");
					} else {
						System.out.println("Tyre Record update Failed!!");
					}
				}
//    				else {
//    					System.out.println("Contact Not Found!!");
//    				}s

				break;
				
			case 6:
				System.out.println("Please Enter the ID to DELETE the Record from Tyre Table : ");
				int get_id = sc.nextInt();

				Tyre get_Tyre = dao.getTyre(get_id);

				if (get_Tyre != null) {

					int updatedQueryStatus = dao.deleteTyre(get_Tyre);

					if (updatedQueryStatus >= 1) {
						System.out.println("Tyre Record Deleted Successsfully!!");
					} else {
						System.out.println("Tyre Record deletion Failed!!");
					}
				} else {
					System.out.println("Record Details Not Found with the requested ID From Tyre Table!");
				}

				break;
				
			case 7:
				System.out.println("Caution : \"Complete Table Will Be Removed!\"");
				System.out.println("Are you sure to DELETE Tyre table! \nReply With \"Y\" or \"y\" : ");
				String req = sc.next();
				if (req.toLowerCase().equals("y")) {

					int updatedQueryStatus = dao.deleteAllTyres();

					if (updatedQueryStatus >= 1) {
						System.out.println("Tyre Table Deleted Successsfully!!");
					} else {
						System.out.println("Tyre Table deletion Failed!!");
					}
				}
				else {
					System.out.println("Request For Table Deletion Stopped!!");
				}

				// System.out.println("Please Enter the ID to DELETE ALL the Record from Contact
				// Table : ");
				// int exit = in.nextInt();
				// if(exit == 404) {
				// continue;
				// }
				break;
				
			case 8:
				System.out.println("Caution : \"Table Data Will Be Erased Completely!\"");
				System.out.println("Are you sure to TRUNCATE Tyre table! \nReply With \"Y\" or \"y\" : ");
				String reply = sc.next();
				if (reply.toLowerCase().equals("y")) {

					int updatedQueryStatus = dao.truncateTyre();

					if (updatedQueryStatus >= 1) {
						System.out.println("Tyre Table Truncated Successsfully!!");
					} else {
						System.out.println("Tyre Table truncate Failed!!");
					}
				}
				else {
					System.out.println("Request For Table Truncation Stopped!!");
				}

				// System.out.println("Please Enter the ID to DELETE ALL the Record from Contact
				// Table : ");
				// int exit = in.nextInt();
				// if(exit == 404) {
				// continue;
				// }
				break;

			default:
				System.out.println("Please select Proper Option from [1,2,3,4,5,6,7,8,9,0] only!");

			}
		}
	}
}
