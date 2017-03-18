package edu.libsys.resource;

import edu.libsys.data.dao.BookDao;
import edu.libsys.entity.Book;

import javax.ws.rs.*;

@Path("books")
@Produces({"application/x-javascript;charset=UTF-8", "application/json;charset=UTF-8"})
public class BookResource {

    //Book数据访问对象
    BookDao bookDao = new BookDao();

    @Path("{id:[0-9]*}")
    @GET
    public Book getBookById(@PathParam("id") final int marRecId) {
        final Book book = bookDao.getBookByMarcRecId(marRecId);
        return book;
    }

    @Path("{id:[0-9]*}")
    @GET
    public int deleteBookById(@PathParam("id") final int marRecId) {
        int result = 0;
        if (bookDao.deleteBook(marRecId) == 1) {
            result = 1;
        }
        return result;
    }
}
