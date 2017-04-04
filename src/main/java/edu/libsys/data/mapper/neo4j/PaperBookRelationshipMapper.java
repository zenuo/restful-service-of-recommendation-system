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

    @Select("MATCH p=(book:Book {id:#{bookId}})-[r:`2`]-(paper:Paper) RETURN paper.id AS id ORDER BY paper.weight DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendPaperIdListByBookId(@Param("bookId") final int bookId);

    @Select("MATCH p=(paper:Paper {id:#{paperId}})-[r:`2`]-(book:Book) RETURN book.id AS id ORDER BY book.weight DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendBookIdListByPaperId(@Param("paperId") final int paperId);
}
