package edu.libsys.data.dao;

import edu.libsys.data.mapper.neo4j.BookBookRelationshipMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookBookRelationshipDao {
    public List<Integer> getRecommendBookList(final int bookId){
        List<Integer> integerList;
        try(SqlSession sqlSession = SqlSessionFactory.getNeo4jSqlSession()){
            BookBookRelationshipMapper bookBookRelationshipMapper =
                    sqlSession.getMapper(BookBookRelationshipMapper.class);
            integerList = bookBookRelationshipMapper.getRecommendBookListByBookId(bookId);
        }
        System.out.println("Got bookId:" + bookId + ", list size: " + integerList.size());
        //去重后返回
        return integerList;
    }
}
