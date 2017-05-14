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

    @Select("MATCH p=(book1:B {id:#{bookId}})-[r:`0`]->(book2:B) RETURN book2.id AS id ORDER BY book2.weight1 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendBookListByBookId1(@Param("bookId") final int bookId);

    @Select("MATCH p=(book1:B {id:#{bookId}})-[r:`0`]->(book2:B) RETURN book2.id AS id ORDER BY book2.weight2 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendBookListByBookId2(@Param("bookId") final int bookId);

    @Select("MATCH p=(book1:B {id:#{bookId}})-[r:`0`]->(book2:B) RETURN book2.id AS id ORDER BY book2.weight3 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendBookListByBookId3(@Param("bookId") final int bookId);
}
