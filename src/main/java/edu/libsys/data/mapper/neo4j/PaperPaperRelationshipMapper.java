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

    @Select("MATCH p=(paper1:P {id:#{paperId}})-[r:`1`]->(paper2:P) RETURN paper2.id AS id ORDER BY paper2.weight1 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendPaperIdListByPaperId1(@Param("paperId") final int paperId);

    @Select("MATCH p=(paper1:P {id:#{paperId}})-[r:`1`]->(paper2:P) RETURN paper2.id AS id ORDER BY paper2.weight2 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendPaperIdListByPaperId2(@Param("paperId") final int paperId);

    @Select("MATCH p=(paper1:P {id:#{paperId}})-[r:`1`]->(paper2:P) RETURN paper2.id AS id ORDER BY paper2.weight3 DESC LIMIT " + Conf.LIMIT_OF_QUERY + ";")
    List<Integer> getRecommendPaperIdListByPaperId3(@Param("paperId") final int paperId);
}
