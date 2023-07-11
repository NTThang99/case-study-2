package services;

import models.Book;
import models.Borrower;
import models.EPath;
import models.User;
import utils.Serializable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BorrowerService implements BasicCRUD<Borrower> {
    public static List<Borrower> listBorrowers;
    BookService bookService = new BookService();

    static {
        listBorrowers = (List<Borrower>) Serializable.deserialize(EPath.BORROWERS.getFilePath());
    }
    public List<Borrower> getBorrowers() {
        return listBorrowers;
}

    public static void save() {
        Serializable.serialize(listBorrowers, EPath.BORROWERS.getFilePath());
    }


    public Borrower getBorrowerBookDetail(int borrowerId) {
        for (Borrower borrower : listBorrowers) {
            if (borrower.getId() == borrowerId) {
                return borrower;
            }
        }
        return null;
    }
    public Borrower findById(int id){
        for (Borrower b: listBorrowers) {
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

//    public void confirmReturnBook(int borrowerID) {
//        Borrower borrower = findById(borrowerID);
//        Book book = bookService.getByID(borrower.getBookId());
//        book.setQuantity(book.getQuantity() + borrower.getQuantity());
//        bookService.update(book);
//        BookService.save();
//        listBorrowers.remove(borrower);
//        save();
//    }

    public void muonSach(int id, int userId, int bookId, int quantity ) {
        Borrower borrower = listBorrowers.stream()
                .filter( bor -> bor.getUserId() == userId && bor.getBookId() == bookId)
                .findFirst().orElse(null);
        if(borrower != null) {
            borrower.setQuantity(borrower.getQuantity() + quantity);
        } else {
            listBorrowers.add( new Borrower(id, userId, bookId, LocalDate.now(), LocalDate.now().plusDays(7) , quantity ));
        }
        update(borrower);
        save();
    }

    public void traSach(int id, int userId, int bookId, int quantity)  {
        Borrower borrower = listBorrowers.stream().filter(bor -> bor.getUserId() == userId && bor.getBookId()==bookId).findFirst().orElse(null);
        if (borrower != null) {
            if(borrower.getQuantity() - quantity <= 0) {
                listBorrowers.remove(borrower);
            } else {
                borrower.setQuantity(borrower.getQuantity() - quantity);
                update(borrower);
            }
        }
        save();
    }

//    public List<Borrower> displayBorrowers(User user) {
//        List<Borrower> listBorrowersByUser = new ArrayList<>();
//        listBorrowers = getBorrowers();
//        int userId = user.getId();
//        for (Borrower borrower : listBorrowers) {
//            if (userId == borrower.getUserId()) {
//                listBorrowersByUser.add(borrower);
//            }
//        }
//        return listBorrowersByUser;
//    }


    @Override
    public Borrower getByID(int id) {
        return listBorrowers
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Borrower> getAll() {
        return listBorrowers;
    }

    @Override
    public void create(Borrower borrower) {
        listBorrowers.add(borrower);

    }

    @Override
    public void update(Borrower obj) {
        for (Borrower borrower: listBorrowers
        ) {
            if(borrower.getId() == obj.getId()){
                borrower = obj;
                break;
            }
        }

    }

    @Override
    public void delete(int id) {
        listBorrowers.removeAll(listBorrowers.stream()
                .filter(b -> b.getId() == id).toList());

    }

    @Override
    public boolean isExist(int id) {
        Borrower borrower = listBorrowers.stream()
                .filter(b -> Objects.equals(b.getId(),id))
                .findFirst()
                .orElse(null);
        return borrower != null;
    }

}


