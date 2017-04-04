package edu.libsys.data.mapper.neo4j;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PaperBookRelationshipMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "paperId", column = "paperId"),
            @Result(property = "bookId", column = "bookId")
    })

    @Select("SELECT paperId FROM PAPER_BOOK WHERE bookId=#{bookId} LIMIT 20")
    List<Integer> getRecommendPaperIdListByBookId(int bookId);

    @Select("SELECT bookId FROM PAPER_BOOK WHERE paperId=#{paperId} LIMIT 20")
    List<Integer> getRecommendBookIdListByPaperId(int paperId);
}
