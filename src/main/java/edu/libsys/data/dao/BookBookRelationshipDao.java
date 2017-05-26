package edu.libsys.data.dao;

import edu.libsys.data.mapper.neo4j.BookBookRelationshipMapper;
import edu.libsys.util.ListUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class BookBookRelationshipDao {
    public List<Integer> getRecommendBookList(final int bookId, final int weight) {
        List<Integer> integerList = new ArrayList<>();
        try (SqlSession sqlSession = SqlSessionFactory.getNeo4jSqlSession()) {
            BookBookRelationshipMapper bookBookRelationshipMapper =
                    sqlSession.getMapper(BookBookRelationshipMapper.class);
            if (weight == 1) {
                integerList = bookBookRelationshipMapper.getRecommendBookListByBookId1(bookId);
            } else if (weight == 2) {
                integerList = bookBookRelationshipMapper.getRecommendBookListByBookId2(bookId);
            } else if (weight == 3) {
                integerList = bookBookRelationshipMapper.getRecommendBookListByBookId3(bookId);
            }
        }
        //删除列表中存在的复本
        integerList.remove(new Integer(bookId));
        //去重后返回
        return ListUtil.deDupIntegerList(integerList);
    }
}
