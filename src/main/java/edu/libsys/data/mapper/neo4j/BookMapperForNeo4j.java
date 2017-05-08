package edu.libsys.data.mapper.neo4j;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

public interface BookMapperForNeo4j {
    @Results({
            @Result(property = "id", column = "id")
    })

    @Update("MATCH (b:Book {id:#{bookId}}) SET b.weight1 = b.weight1 + #{delta}")
    void addWeight1(@Param("bookId") final int bookId, @Param("delta") final int delta);

    @Update("MATCH (b:Book {id:#{bookId}}) SET b.weight2 = b.weight2 + #{delta}")
    void addWeight2(@Param("bookId") final int bookId, @Param("delta") final int delta);

    @Update("MATCH (b:Book {id:#{bookId}}) SET b.weight3 = b.weight3 + #{delta}")
    void addWeight3(@Param("bookId") final int bookId, @Param("delta") final int delta);
}
