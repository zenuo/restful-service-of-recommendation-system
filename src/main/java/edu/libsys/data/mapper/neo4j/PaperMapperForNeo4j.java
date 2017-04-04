package edu.libsys.data.mapper.neo4j;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

public interface PaperMapperForNeo4j {
    @Results({
            @Result(property = "id", column = "id")
    })

    @Update("MATCH (p:Paper {id:#{paperId}}) SET p.weight = p.weight + #{delta}")
    void addWeight(@Param("paperId") final int paperId, @Param("delta") final int delta);
}
