package edu.libsys.test;

import edu.libsys.entity.Book;
import edu.libsys.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class BookListDeDupTest {
    public static void main(String[] args) {
        testBookListDeDup();
    }

    private static void testBookListDeDup() {
        Book b1 = new Book();
        b1.setId(1);
        b1.setIsbn("10-1a");

        Book b2 = new Book();
        b2.setId(2);
        b2.setIsbn("10-1a");

        Book b3 = new Book();
        b3.setId(3);
        b3.setIsbn("10-2");

        Book b4 = new Book();
        b4.setId(4);
        b4.setIsbn("10-2");

        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);

        List<Book> deduped = ListUtil.deDupBookList(bookList);
        deduped.forEach(System.out::println);
    }
}
