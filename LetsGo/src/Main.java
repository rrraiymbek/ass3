import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ResultSet resultSet = null;
    public static void main(String[] args) {
        System.out.println("Welcome, to my book store!");
        Bookstore bookstore = new Bookstore();
        Order order = new Order();
        while(true){
            printAction();
            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Good bye!");
                    System.exit(1);
                    break;
                case 1:
                    bookstore.listBooks(resultSet);
                    break;
                case 2:
                    System.out.println("Enter id");
                    int id = sc.nextInt();
                    Book book = bookstore.buyBook(id);
                    if(book == null)
                        System.out.println("Sorry, we do not have this book");
                    else {
                        System.out.println("Added");
                        order.addBook(book);
                    }
                    break;
                case 3:
                    System.out.println(order.getOrder());
                    break;
            }
        }
    }
    private static void printAction(){
        System.out.println("PRESS [1] TO LIST ALL BOOKS");
        System.out.println("PRESS [2] TO BUY BOOK");
        System.out.println("PRESS [3] TO SHOW ORDER");
        System.out.println("PRESS [0] TO EXIT");
    }
}