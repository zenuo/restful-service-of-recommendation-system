package edu.libsys.data.dao;

import edu.libsys.data.mapper.PaperMapper;
import edu.libsys.entity.Paper;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PaperDao implements Serializable {
    public Paper getPaperById(final int id) {
        Paper paper = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            paper = paperMapper.getPaperById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paper;
    }

    public List<Paper> getPaperListByIdList(final List<Integer> integerList) {
        List<Paper> paperList = new LinkedList<>();
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            for (Integer anIntegerList : integerList) {
                paperList.add(paperMapper.getPaperById(anIntegerList));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public List<Paper> getPaperList(final int page, int size) {
        List<Paper> paperList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            paperList = paperMapper.getPaperList(page, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public List<Paper> getPaperListBySearchTitle(final String keyWord) {
        List<Paper> paperList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            paperList = paperMapper.getPaperListBySearchTitle(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public List<Paper> getPaperListBySearchIntro(final String keyWord) {
        List<Paper> paperList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            paperList = paperMapper.getPaperListBySearchIntro(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public List<Paper> getPaperListBySearchSearchWord(final String keyWord) {
        List<Paper> paperList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            paperList = paperMapper.getPaperListBySearchSearchWord(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public int addPaper(final Paper paper) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            paperMapper.addPaper(paper);
            status = 1;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int updatePaper(final Paper paper) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            paperMapper.updatePaper(paper);
            status = 1;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int deletePaper(final int id) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            paperMapper.deletePaper(id);
            status = 1;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int countPaper() {
        int count = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            PaperMapper paperMapper = sqlSession.getMapper(PaperMapper.class);
            count = paperMapper.countPaper();
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
