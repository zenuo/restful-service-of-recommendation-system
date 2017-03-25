package edu.libsys.data.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javax.ws.rs.QueryParam;
import java.util.List;

public interface BookBookRelationshipMapper {
    @Results({
            @Result(property = "bookId_1", column = "bookId_1"),
            @Result(property = "bookId_2", column = "bookId_2")
    })

    @Select("SELECT bookId_1 WHERE bookId_2=#{bookId}")
    List<Integer> getRecommendBookList_01(@QueryParam("bookId") final int bookId);

    @Select("SELECT bookId_2 WHERE bookId_1=#{bookId}")
    List<Integer> getRecommendBookList_02(@QueryParam("bookId") final int bookId);
}
