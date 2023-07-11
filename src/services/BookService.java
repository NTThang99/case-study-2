package services;

import models.Book;
import models.EPath;
import utils.Serializable;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BookService implements BasicCRUD<Book> {
   public static List<Book> listBooks;
   static {
       listBooks = (List<Book>) Serializable.deserialize(EPath.BOOKS.getFilePath());
   }
   public BookService(){
   }
    public static void save() {
        Serializable.serialize(listBooks, EPath.BOOKS.getFilePath());
    }
    @Override
    public Book getByID(int id) {
        return listBooks
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> getAll() {
        return listBooks;
    }

    @Override
    public void create(Book book) {
        listBooks.add(book);
    }

    @Override
    public void update(Book obj) {
        for (Book book: listBooks
        ) {
            if(book.getId() == obj.getId()){
                book = obj;
                break;
            }
        }

    }

    @Override
    public void delete(int id) {
        listBooks.removeAll(listBooks.stream()
                .filter(b -> b.getId() == id).toList());
        save();
    }

    @Override
    public boolean isExist(int id) {
        Book book = listBooks.stream()
                .filter(b -> Objects.equals(b.getId(),id))
                .findFirst()
                .orElse(null);
        return book != null;
    }
}
