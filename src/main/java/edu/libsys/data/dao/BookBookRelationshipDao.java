package edu.libsys.data.dao;

import edu.libsys.data.mapper.BookBookRelationshipMapper;
import edu.libsys.util.ListUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class BookBookRelationshipDao {
    public List<Integer> getRecommendBookList(final int bookId){
        List<Integer> integerList = new LinkedList<>();
        try(SqlSession sqlSession = SessionFactory.getSqlSession()){
            BookBookRelationshipMapper bookBookRelationshipMapper =
                    sqlSession.getMapper(BookBookRelationshipMapper.class);
            integerList.addAll(bookBookRelationshipMapper.getRecommendBookList_01(bookId));
            integerList.addAll(bookBookRelationshipMapper.getRecommendBookList_02(bookId));
        }
        //Test
        System.out.println("Got bookId:" + bookId);
        System.out.println("List are:");
        integerList.forEach(System.out::println);
        //去重后返回
        return ListUtil.dedupIntegerList(integerList);
    }
}
