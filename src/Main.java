import DAO.Startup;
import models.Book;
import models.Borrower;
import services.BookService;
import services.BorrowerService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Startup.init();
        BookService bookService = new BookService();
        BookService.save();
        Book book = bookService.getByID(3);
        System.out.println(book.toString());
        BorrowerService borrowerService = new BorrowerService();
        BorrowerService.save();
        borrowerService.create(new Borrower(1,2,3, LocalDate.of(2023,7,11),LocalDate.of(2023,7,11),11));
        borrowerService.muonSach(2, 3, 4, 1);
        borrowerService.traSach(2,3,4,1);
        System.out.println(borrowerService.findById(1).getQuantity());


    }
}