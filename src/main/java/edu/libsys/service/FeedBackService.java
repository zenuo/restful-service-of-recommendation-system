package edu.libsys.service;

import edu.libsys.data.dao.BookDao;
import edu.libsys.data.dao.PaperDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ext.Provider;

@Path("feedback")
@Provider
@Produces({"application/x-javascript;charset=UTF-8", "application/json;charset=UTF-8"})
public class FeedBackService {
    private final PaperDao paperDao = new PaperDao();
    private final BookDao bookDao = new BookDao();

    /**
     * 处理点赞，更新物件权重
     *
     * @param id   物件编号
     * @param type 物件类型
     * @return 状态
     */
    @Path("like")
    @GET
    public int like(@QueryParam("id") final int id,
                    @QueryParam("type") final String type,
                    @QueryParam("weight") final int weight) {
        int result = 0;
        if (type.equals("paper")) {
            result = paperDao.updateALike(id, weight);
        } else if (type.equals("book")) {
            result = bookDao.updateALike(id, weight);
        }
        return result;
    }
}
