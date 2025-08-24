package pl.coderslab;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {

    private List<Book> books = new ArrayList<>();
    private Long nextBookId =11L;

    public MockBookService() {
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9780307454546", "The Girl with the Dragon Tattoo", "Stieg Larsson", "Knopf", "crime"));
        books.add(new Book(3L, "9780747532743", "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Bloomsbury", "fantasy"));
        books.add(new Book(4L, "9780061120084", "To Kill a Mockingbird", "Harper Lee", "Harper Perennial", "fiction"));
        books.add(new Book(5L, "9780307277671", "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "Harper", "history"));
        books.add(new Book(6L, "9780143118756", "Into the Wild", "Jon Krakauer", "Anchor Books", "travel"));
        books.add(new Book(7L, "9780553380163", "A Brief History of Time", "Stephen Hawking", "Bantam", "science"));
        books.add(new Book(8L, "9780060850524", "The Alchemist", "Paulo Coelho", "HarperOne", "fiction"));
        books.add(new Book(9L, "9780374533557", "Thinking, Fast and Slow", "Daniel Kahneman", "Farrar, Straus and Giroux", "psychology"));
        books.add(new Book(10L, "9781501124020", "It", "Stephen King", "Scribner", "horror"));
    }

    public List<Book> getBooks(){
        return books;
    }


    public Optional<Book> get(Long id) {
        return books.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst();
}

    public void add(Book book){
        book.setId(nextBookId);
        books.add(book);
        nextBookId += 1L;
    }

    public void delete(Long id){
        books.removeIf(b -> b.getId().equals(id));
    }

    //


    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.get(book.getId()).get());
            books.set(indexOf, book);
        }
    }



//    public void update(Long id, Book book){
//        books.stream()
//                .filter(b -> b.getId().equals(id)) // znajdź po ID
//                .findFirst()
//                .ifPresent(b -> {
//                    b.setTitle(book.getTitle());
//                    b.setAuthor(book.getAuthor());
//                    b.setIsbn(book.getIsbn());
//                    b.setPublisher(book.getPublisher());
//                    b.setType(book.getType());
//                });
//    }

}
