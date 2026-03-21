package project_1;

import java.io.*;
import java.util.*;

public class Book {

    private String title;
    private String Author;
    private int ISBN;

    public Book() {
    }

    public Book(String title, String Author, int ISBN) {
        this.title = title;
        this.Author = Author;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public static int add(Book b) throws IOException {
        File file = new File("book.txt");
        FileWriter fw = new FileWriter(file, true);
        int found = 0;
        try (Scanner sc = new Scanner(new File("book.txt"))) {
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                ArrayList<String> sp = new ArrayList<>(Arrays.asList(s.split(",")));
                int id = Integer.parseInt(sp.get(2));
                if (b.getISBN() == id) {
                    found = 1;
                    System.out.println("Book is found!\nDetails: " + s);
                    return 0;
                }
            }
        }
        if (found == 0) {
            fw.append(b.toString() + "\n");
            fw.close();
            System.out.println("Added successfully!");
        }
        return 1;
    }

    public static int remove(int id) throws IOException {
        File file = new File("book.txt");
        ArrayList<String> allLines = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                allLines.add(sc.nextLine());
            }
        }

        boolean found = false;
        try (FileWriter fw = new FileWriter(file, false)) {
            for (String x : allLines) {
                String[] sp = x.split(",");
                if (Integer.parseInt(sp[2].trim()) == id) {
                    found = true;
                    continue;

                }
                fw.append(x + "\n");
            }
        }

        if (found) {
            System.out.println("delete book sucess!");
            return 1;
        } else {
            System.out.println("This book is not found try again");
            return 0;
        }
    }

    public static int search(int num) {
        int found = 0;
        try (Scanner sc = new Scanner(new File("book.txt"))) {
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                ArrayList<String> sp = new ArrayList<>(Arrays.asList(s.split(",")));
                int id = Integer.parseInt(sp.get(2));

                if (num == id) {
                    found = 1;
                    System.out.println("Book is found!\nDetails: " + s);
                    break;
                }
            }
            if (found == 0) {
                System.out.println("Book is not found!");
                return 0;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return 1;
    }

    public static void displayAll() {
        try (Scanner sc = new Scanner(new File("book.txt"))) {
            int count = 1;
            while (sc.hasNextLine()) {
                System.out.println(count + "-" + sc.nextLine());
                count++;
            }
        } catch (Exception e) {
            System.out.println("No books found or Error: " + e.getMessage());
        }
    }

    public static void clearAll() throws IOException {
        FileWriter fw = new FileWriter("book.txt", false);
        fw.close();
        System.out.println("All library data has been cleared!");
    }
    
    @Override
    public String toString() {
        return title + "," + Author + "," + ISBN;
    }
}
