package edu.libsys.data.dao;

import edu.libsys.data.mapper.neo4j.PaperBookRelationshipMapper;
import edu.libsys.util.ListUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;

public class PaperBookRelationshipDao implements Serializable {

    public List<Integer> getRecommendPaperIdListByBookId(final int bookId, final int weight) {
        List<Integer> integerList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getNeo4jSqlSession()) {
            PaperBookRelationshipMapper paperBookRelationshipMapper =
                    sqlSession.getMapper(PaperBookRelationshipMapper.class);

            if (weight == 1) {
                integerList = paperBookRelationshipMapper.getRecommendPaperIdListByBookId1(bookId);
            } else if (weight == 2) {
                integerList = paperBookRelationshipMapper.getRecommendPaperIdListByBookId2(bookId);
            } else if (weight == 3) {
                integerList = paperBookRelationshipMapper.getRecommendPaperIdListByBookId3(bookId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //去重后返回
        return ListUtil.deDupIntegerList(integerList);
    }

    public List<Integer> getRecommendBookIdListByPaperId(final int paperId, final int weight) {
        List<Integer> integerList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getNeo4jSqlSession()) {
            PaperBookRelationshipMapper paperBookRelationshipMapper =
                    sqlSession.getMapper(PaperBookRelationshipMapper.class);

            if (weight == 1) {
                integerList = paperBookRelationshipMapper.getRecommendBookIdListByPaperId1(paperId);
            } else if (weight == 2) {
                integerList = paperBookRelationshipMapper.getRecommendBookIdListByPaperId2(paperId);
            } else if (weight == 3) {
                integerList = paperBookRelationshipMapper.getRecommendBookIdListByPaperId3(paperId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //去重后返回
        return ListUtil.deDupIntegerList(integerList);
    }
}
