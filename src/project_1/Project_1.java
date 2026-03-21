package project_1;

import java.io.IOException;
import java.util.*;

public class Project_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- Library Management System ---");
                System.out.println("1. Add New Book");
                System.out.println("2. Display All Books");
                System.out.println("3. Remove Book by ISBN");
                System.out.println("4. Search");
                System.out.println("5. Remove All");
                System.out.println("6.Exit");
                System.out.print("Enter your choice: ");

                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter ISBN: ");
                        int isbn = Integer.parseInt(sc.nextLine());
                        Book newBook = new Book(title, author, isbn);
                        while (Book.add(newBook) == 0) {
                            System.out.print("ISBN is repeated! Please enter a different ISBN: ");
                            isbn = Integer.parseInt(sc.nextLine());
                            newBook.setISBN(isbn);
                        }
                        break;

                    case "2":
                        Book.displayAll();
                        break;

                    case "3":
                        System.out.print("Enter ISBN to remove: ");
                        int n = Integer.parseInt(sc.nextLine());
                        while (Book.remove(n) == 0) {
                            System.out.print("Enter again ISBN to remove: ");
                            n = Integer.parseInt(sc.nextLine());
                        }
                        break;

                    case "4":
                        System.out.print("Enter ISBN to search: ");
                        int num = Integer.parseInt(sc.nextLine());
                        while (Book.search(num) == 0) {
                            System.out.print("Enter again ISBN to search: ");
                            num = Integer.parseInt(sc.nextLine());

                        }
                        break;
                    case "5":
                        Book.clearAll();
                        break;
                    case "6":
                        System.out.println("Exiting... Good luck with Syntecxhub!");
                        return;

                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (IOException ex) {
                System.getLogger(Project_1.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

        }

    }
}
