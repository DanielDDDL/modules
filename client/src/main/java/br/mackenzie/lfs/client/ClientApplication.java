package br.mackenzie.lfs.client;

import br.mackenzie.lfs.anotherservice.AnotherServiceApplication;
import br.mackenzie.lfs.anotherservice.TodoItem;
import br.mackenzie.lfs.anotherservice.TodoItemRepository;
import br.mackenzie.lfs.service.Book;
import br.mackenzie.lfs.service.BookRepository;
import br.mackenzie.lfs.service.ServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TodoItemRepository todoItemRepository;

    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .parent(ClientApplication.class)
                .sources(ServiceApplication.class, AnotherServiceApplication.class)
                .run(args);
    }

    @Override
    public void run(String... strings) {

        Book book = new Book();
        book.setTitle("Book test");
        book.setAuthor("Author test");

        TodoItem todoItem = new TodoItem();
        todoItem.setTitle("Title test");
        todoItem.setDescription("Description test");

        bookRepository.saveAndFlush(book);
        todoItemRepository.saveAndFlush(todoItem);

    }
}
