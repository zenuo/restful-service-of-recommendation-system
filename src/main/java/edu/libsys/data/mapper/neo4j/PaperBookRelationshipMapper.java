package edu.libsys.data.mapper.neo4j;

import edu.libsys.conf.Conf;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PaperBookRelationshipMapper {
    @Results({
            @Result(property = "id", column = "id")
    })

    @Select("MATCH p=(book:B {id:#{bookId}})-[r:`2`]-(paper:P) RETURN paper.id AS id ORDER BY paper.weight1 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendPaperIdListByBookId1(@Param("bookId") final int bookId);

    @Select("MATCH p=(book:B {id:#{bookId}})-[r:`2`]-(paper:P) RETURN paper.id AS id ORDER BY paper.weight2 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendPaperIdListByBookId2(@Param("bookId") final int bookId);

    @Select("MATCH p=(book:B {id:#{bookId}})-[r:`2`]-(paper:P) RETURN paper.id AS id ORDER BY paper.weight3 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendPaperIdListByBookId3(@Param("bookId") final int bookId);

    @Select("MATCH p=(paper:P {id:#{paperId}})-[r:`2`]-(book:B) RETURN book.id AS id ORDER BY book.weight1 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendBookIdListByPaperId1(@Param("paperId") final int paperId);

    @Select("MATCH p=(paper:P {id:#{paperId}})-[r:`2`]-(book:B) RETURN book.id AS id ORDER BY book.weight2 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendBookIdListByPaperId2(@Param("paperId") final int paperId);

    @Select("MATCH p=(paper:P {id:#{paperId}})-[r:`2`]-(book:B) RETURN book.id AS id ORDER BY book.weight3 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendBookIdListByPaperId3(@Param("paperId") final int paperId);
}
