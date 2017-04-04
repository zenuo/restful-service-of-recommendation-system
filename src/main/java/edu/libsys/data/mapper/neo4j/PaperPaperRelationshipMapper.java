package edu.libsys.data.mapper.neo4j;

import edu.libsys.conf.Conf;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PaperPaperRelationshipMapper {
    @Results(
            {@Result(property = "id", column = "id")
            })

    @Select("MATCH p=(paper1:Paper {id:#{paperId}})-[r:`1`]->(paper2:Paper) RETURN paper2.id AS id ORDER BY paper2.weight DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendPaperIdListByPaperId(@Param("paperId") final int paperId);
}
