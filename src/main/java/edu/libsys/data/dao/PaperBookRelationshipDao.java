package edu.libsys.data.dao;

import edu.libsys.data.mapper.neo4j.PaperBookRelationshipMapper;
import edu.libsys.util.ListUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;

public class PaperBookRelationshipDao implements Serializable {

    public List<Integer> getRecommendPaperIdListByBookId(final int bookId) {
        List<Integer> integerList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperBookRelationshipMapper paperBookRelationshipMapper =
                    sqlSession.getMapper(PaperBookRelationshipMapper.class);
            integerList =
                    paperBookRelationshipMapper.getRecommendPaperIdListByBookId(bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Test
        System.out.println("Got bookId:" + bookId + ", list size: " + integerList.size());
        //去重后返回
        return ListUtil.dedupIntegerList(integerList);
    }

    public List<Integer> getRecommendBookIdListByPaperId(final int paperId) {
        List<Integer> integerList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperBookRelationshipMapper paperBookRelationshipMapper =
                    sqlSession.getMapper(PaperBookRelationshipMapper.class);
            integerList =
                    paperBookRelationshipMapper.getRecommendBookIdListByPaperId(paperId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Test
        System.out.println("Got paperId:" + paperId + ", list size: " + integerList.size());
        //去重后返回
        return ListUtil.dedupIntegerList(integerList);
    }
}
