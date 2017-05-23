package edu.libsys.service;

import edu.libsys.conf.Conf;
import edu.libsys.data.dao.BookDao;
import edu.libsys.entity.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("books")
@Provider
@Produces({"application/x-javascript;charset=UTF-8", "application/json;charset=UTF-8"})
public class BookService {

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
    public Book getBookById(@PathParam("id") final int id) {
        return bookDao.getBookById(id);
    }

    //获得多个
    @Path("get")
    @GET
    public List<Book> getBookList(@QueryParam("page") final int page, @QueryParam("size") final int size) {
        return bookDao.getBookList(page, size);
    }

    //关键词查询
    @Path("search")
    @GET
    public List<Book> getBookListBySearchTitle(@QueryParam("keyword") final String keyword) {
        //如果检索关键词超出长度，返回空
        if (keyword.length() > Conf.MAX_LENGTH_OF_SEARCH_KEYWORD) {
            return null;
        }
        return bookDao.getBookListBySearchTitle(keyword);
    }

}
