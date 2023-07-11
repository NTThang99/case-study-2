package DAO;

import models.*;
import services.BookService;
import services.BorrowerService;
import utils.Serializable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Startup {
    public static void init(){
        if (BookService.listBooks.isEmpty()){
            initBooks();
        }
    }
    private static void initBooks() {
        Book book1 = new Book(1,"Thám tử lừng danh Conan",9, Category.NOVEL,"series manga trinh thám" ,"Aoyama Gōshō", Publisher.NHAXUATBANKIMDONG, Status.INSTOCK,LocalDate.of(2023,11,7));
        Book book2 = new Book(2,"Trạng Quỳnh",10, Category.COMICS,"bộ truyện tranh thiếu nhi nhiều tập của Việt Nam" ," Kim Khánh", Publisher.NHAXUATBANKIMDONG, Status.INSTOCK,LocalDate.of(2023,11,7));
        Book book3 = new Book(3,"Doraemon",15, Category.COMICS,"Hành trình của cậu bé tên là Nobita và nhóm bạn của cậu ấy" ," Motoo Abiko", Publisher.NHAXUATBANKIMDONG, Status.INSTOCK,LocalDate.of(2023,11,7));
        Book book4 = new Book(4,"OnePiece",15, Category.COMICS,"Hành trình của cậu bé tên là Luffy trên con đường trở thành vua hải tặc" ,"Oda Eiichiro", Publisher.NHAXUATBANVANHOC, Status.INSTOCK,LocalDate.of(2023,11,7));
        Book book5 = new Book(5,"Thủy hử",15, Category.NOVEL,"sự hình thành và những thành tích của 108 anh hùng Lương Sơn Bạc chống lại triều đình mục nát" ,"Thi Nại Am", Publisher.NHAXUATBANVANHOC, Status.INSTOCK,LocalDate.of(2023,11,7));
        List<Book> listBooks = new ArrayList<>();
        listBooks.add(book1);
        listBooks.add(book2);
        listBooks.add(book3);
        listBooks.add(book4);
        listBooks.add(book5);
        BookService.listBooks = listBooks;
        Serializable.serialize(listBooks,EPath.BOOKS.getFilePath());
    }

}
