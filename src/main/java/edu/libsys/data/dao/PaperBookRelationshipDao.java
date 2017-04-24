package edu.libsys.data.dao;

import edu.libsys.data.mapper.neo4j.PaperBookRelationshipMapper;
import edu.libsys.util.ListUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;

public class PaperBookRelationshipDao implements Serializable {

    public List<Integer> getRecommendPaperIdListByBookId(final int bookId) {
        List<Integer> integerList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getNeo4jSqlSession()) {
            PaperBookRelationshipMapper paperBookRelationshipMapper =
                    sqlSession.getMapper(PaperBookRelationshipMapper.class);
            integerList =
                    paperBookRelationshipMapper.getRecommendPaperIdListByBookId(bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //去重后返回
        return ListUtil.deDupIntegerList(integerList);
    }

    public List<Integer> getRecommendBookIdListByPaperId(final int paperId) {
        List<Integer> integerList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getNeo4jSqlSession()) {
            PaperBookRelationshipMapper paperBookRelationshipMapper =
                    sqlSession.getMapper(PaperBookRelationshipMapper.class);
            integerList =
                    paperBookRelationshipMapper.getRecommendBookIdListByPaperId(paperId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //去重后返回
        return ListUtil.deDupIntegerList(integerList);
    }
}
