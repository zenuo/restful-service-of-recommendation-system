package edu.libsys.data.dao;

import edu.libsys.data.mapper.PaperPaperRelationshipMapper;
import edu.libsys.util.ListUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;
import java.util.List;

public class PaperPaperRelationshipDao {
    public List<Integer> getRecommendPaperIdList(final int paperId){
        List<Integer> integerList = new LinkedList<>();
        try(SqlSession sqlSession = SessionFactory.getSqlSession()){
            PaperPaperRelationshipMapper paperPaperRelationshipMapper =
                    sqlSession.getMapper(PaperPaperRelationshipMapper.class);
            integerList.addAll(paperPaperRelationshipMapper.getRecommendPaperIdList_01(paperId));
            integerList.addAll(paperPaperRelationshipMapper.getRecommendPaperIdList_02(paperId));
        }catch (Exception e){
            e.printStackTrace();
        }
        //Test
        System.out.println("Got paper:" + paperId);
        System.out.println("List are:");
        integerList.forEach(System.out::println);
        //去重后返回
        return ListUtil.dedupIntegerList(integerList);
    }
}
