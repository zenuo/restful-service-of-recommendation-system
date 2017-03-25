package edu.libsys.resource;

import edu.libsys.data.dao.BookDao;
import edu.libsys.entity.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("books")
@Produces({"application/x-javascript;charset=UTF-8", "application/json;charset=UTF-8"})
public class BookResource {

    //Book数据访问对象
    private final BookDao bookDao = new BookDao();

    //添加
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int addBook(final Book book) {
        return bookDao.addBook(book);
    }

    //删除
    @Path("{id:[0-9]*}")
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    public int deleteBook(@PathParam("id") final int id) {
        return bookDao.deleteBook(id);
    }

    //更新
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public int updateBook(final Book book) {
        return bookDao.updateBook(book);
    }

    //获得单个
    @Path("{id:[0-9]*}")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Book getBookById(@PathParam("id") final int id) {
        return bookDao.getBookById(id);
    }

    //获得多个
    @Path("get")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Book> getBookList(@QueryParam("page") final int page, @QueryParam("size") final int size) {
        return bookDao.getBookList(page, size);
    }

    //关键词查询
    @Path("search")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Book> getBookListBySearchTitle(@QueryParam("keyword") final String keyword) {
        return bookDao.getBookListBySearchTitle(keyword);
    }

}
