package edu.libsys.data.mapper.neo4j;

import edu.libsys.conf.Conf;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookBookRelationshipMapper {
    @Results({
            @Result(property = "id", column = "id")
    })

    @Select("MATCH p=(book1:Book {id:#{bookId}})-[r:`0`]->(book2:Book) RETURN book2.id AS id ORDER BY book2.weight DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendBookListByBookId(@Param("bookId") final int bookId);
}
