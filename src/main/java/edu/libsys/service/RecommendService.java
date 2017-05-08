package edu.libsys.service;

import edu.libsys.data.dao.*;
import edu.libsys.entity.Book;
import edu.libsys.entity.Paper;
import edu.libsys.util.ListUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("recommend")
@Provider
@Produces({"application/x-javascript;charset=UTF-8", "application/json;charset=UTF-8"})
public class RecommendService {

    //Paper数据访问对象
    private final PaperDao paperDao = new PaperDao();
    //Book数据访问对象
    private final BookDao bookDao = new BookDao();

    /**
     * 获取图书资源
     *
     * @param id   编号
     * @param type 原物件类型
     * @return 图书列表
     */
    @Path("books")
    @GET
    public List<Book> getRecommendBookList(@QueryParam("id") final int id,
                                           @QueryParam("type") final String type,
                                           @QueryParam("weight") final int weight) {
        List<Book> bookList = null;
        if ("paper".equals(type)) {
            //根据论文ID获取图书推荐资源
            PaperBookRelationshipDao paperBookRelationshipDao = new PaperBookRelationshipDao();
            bookList = bookDao.getBookListByIdList(paperBookRelationshipDao.getRecommendBookIdListByPaperId(id));
        } else if ("book".equals(type)) {
            //根据图书ID获取图书推荐资源
            BookBookRelationshipDao bookBookRelationshipDao = new BookBookRelationshipDao();
            bookList = bookDao.getBookListByIdList(bookBookRelationshipDao.getRecommendBookList(id));
        }
        return ListUtil.deDupBookList(bookList);
    }

    /**
     * 获取论文资源
     *
     * @param id   物件编号
     * @param type 原物件类型
     * @return 论文列表
     */
    @Path("papers")
    @GET
    public List<Paper> getRecommendPaperList(@QueryParam("id") final int id,
                                             @QueryParam("type") final String type,
                                             @QueryParam("weight") final int weight) {
        List<Paper> paperList = null;
        if ("paper".equals(type)) {
            //根据论文ID获取论文推荐
            PaperPaperRelationshipDao paperPaperRelationshipDao = new PaperPaperRelationshipDao();
            paperList = paperDao.getPaperListByIdList(paperPaperRelationshipDao.getRecommendPaperIdList(id));
        } else if ("book".equals(type)) {
            //根据图书ID获取论文推荐
            PaperBookRelationshipDao paperBookRelationshipDao = new PaperBookRelationshipDao();
            paperList = paperDao.getPaperListByIdList(paperBookRelationshipDao.getRecommendPaperIdListByBookId(id));
        }
        return ListUtil.deDupPaperList(paperList);
    }
}
