import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Order {
        private int orderId;

        private List<Book> orderedBooks;
        private LocalDate orderDate;
        public Order(){
            orderedBooks = new ArrayList<>();
            orderDate = LocalDate.now();
        }
        // Getters
        public int getOrderId() {
            return orderId;
        }



        public List<Book> getOrderedBooks() {
            return orderedBooks;
        }

        public LocalDate getOrderDate() {
            return orderDate;
        }

        // Setters
        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }


        public void setOrderedBooks(List<Book> orderedBooks) {
            this.orderedBooks = orderedBooks;
        }

        public void setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
        }
        public void addBook(Book book){
            orderedBooks.add(book);
        }
        public String getOrder(){
            return orderId + ". " + "books: {"+ orderedBooks.toString() + "} " + orderDate+".";
        }
    }
