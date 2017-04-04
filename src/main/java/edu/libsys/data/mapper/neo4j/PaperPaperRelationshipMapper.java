package edu.libsys.data.mapper.neo4j;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javax.ws.rs.QueryParam;
import java.util.List;

public interface PaperPaperRelationshipMapper {
    @Results({
            @Result(property = "paperId_1", column = "paperId_1"),
            @Result(property = "paperId_2", column = "paperId_2")
    })

    @Select("SELECT paperId_1 FROM PAPER_PAPER WHERE paperId_2=#{paperId} LIMIT 20")
    List<Integer> getRecommendPaperIdList_01(@QueryParam("paperId") final int paperId);

    @Select("SELECT paperId_2 FROM PAPER_PAPER WHERE paperId_1=#{paperId} LIMIT 20")
    List<Integer> getRecommendPaperIdList_02(@QueryParam("paperId") final int paperId);
}
