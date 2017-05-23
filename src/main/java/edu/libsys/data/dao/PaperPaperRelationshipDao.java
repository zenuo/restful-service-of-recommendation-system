package edu.libsys.data.dao;

import edu.libsys.data.mapper.neo4j.PaperPaperRelationshipMapper;
import edu.libsys.util.ListUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class PaperPaperRelationshipDao {
    public List<Integer> getRecommendPaperIdList(final int paperId, final int weight) {
        List<Integer> integerList = new ArrayList<>();
        try (SqlSession sqlSession = SqlSessionFactory.getNeo4jSqlSession()) {
            PaperPaperRelationshipMapper paperPaperRelationshipMapper =
                    sqlSession.getMapper(PaperPaperRelationshipMapper.class);

            if (weight == 1) {
                integerList = paperPaperRelationshipMapper.getRecommendPaperIdListByPaperId1(paperId);
            } else if (weight == 2) {
                integerList = paperPaperRelationshipMapper.getRecommendPaperIdListByPaperId2(paperId);
            } else if (weight == 3) {
                integerList = paperPaperRelationshipMapper.getRecommendPaperIdListByPaperId3(paperId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Test
        //System.out.println("Got paperId:" + paperId + ", list size: " + integerList.size());
        //去重后返回
        return ListUtil.deDupIntegerList(integerList);
    }
}
