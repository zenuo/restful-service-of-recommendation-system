package edu.libsys.data.mapper.neo4j;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

public interface PaperMapperForNeo4j {
    @Results({
            @Result(property = "id", column = "id")
    })

    @Update("MATCH (p:P {id:#{paperId}}) SET p.weight1 = p.weight1 + #{delta}")
    void addWeight1(@Param("paperId") final int paperId, @Param("delta") final int delta);

    @Update("MATCH (p:P {id:#{paperId}}) SET p.weight2 = p.weight2 + #{delta}")
    void addWeight2(@Param("paperId") final int paperId, @Param("delta") final int delta);

    @Update("MATCH (p:P {id:#{paperId}}) SET p.weight3 = p.weight3 + #{delta}")
    void addWeight3(@Param("paperId") final int paperId, @Param("delta") final int delta);
}
