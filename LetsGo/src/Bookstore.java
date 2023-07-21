import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookstore {
    private Scanner sc = new Scanner(System.in);

    public void listBooks(ResultSet resultSet) {
        try (Connection conn = DBEngine.getConnection()) {
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM book");
            System.out.println("All available books: ");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                String isbn = resultSet.getString(4);
                String genre = resultSet.getString(5);
                int quantity = resultSet.getInt(6);
                System.out.printf("%d. title: %s; author: %s; isbn: %s; genre: %s; quantity: %d;\n", id, title, author, isbn, genre, quantity);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public Book buyBook(int choice) {
        Book selected = null;
        try (Connection conn = DBEngine.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE book_id = ?")) {

            preparedStatement.setInt(1, choice);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String author = resultSet.getString(3);
                    String isbn = resultSet.getString(4);
                    String genre = resultSet.getString(5);
                    int quantity = resultSet.getInt(6);
                    selected = new Book(id, title, author, isbn, genre, quantity);

                    // Update the quantity_available of the book
                    try (Statement updateStatement = conn.createStatement()) {
                        updateStatement.executeUpdate("UPDATE book SET quantity_available = quantity_available - 1 WHERE book_id = " + choice);
                        updateStatement.executeUpdate("DELETE FROM book WHERE quantity_available <= 0");
                    }
                } else {
                    System.out.println("Book with ID " + choice + " not found.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Connection failed...");
            ex.printStackTrace();
        }
        return selected;
    }

}
