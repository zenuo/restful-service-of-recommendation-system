package edu.libsys.data.dao;

import edu.libsys.conf.Conf;
import edu.libsys.data.mapper.mariadb.PaperMapperForMariaDB;
import edu.libsys.data.mapper.neo4j.PaperMapperForNeo4j;
import edu.libsys.entity.Paper;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PaperDao implements Serializable {
    public Paper getPaperById(final int id) {
        Paper paper = null;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            paper = paperMapperForMariaDB.getPaperById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paper;
    }

    public List<Paper> getPaperListByIdList(final List<Integer> integerList) {
        List<Paper> paperList = new LinkedList<>();
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            for (Integer id : integerList) {
                if (id != 0) {
                    paperList.add(paperMapperForMariaDB.getPaperById(id));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public List<Paper> getPaperList(final int page, int size) {
        List<Paper> paperList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            paperList = paperMapperForMariaDB.getPaperList(page, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public List<Paper> getPaperListBySearchTitle(final String keyWord) {
        List<Integer> idList = JedisDao.search(1, keyWord);
        return getPaperListByIdList(idList);
    }

    public List<Paper> getPaperListBySearchIntro(final String keyWord) {
        List<Paper> paperList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            paperList = paperMapperForMariaDB.getPaperListBySearchIntro(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public List<Paper> getPaperListBySearchSearchWord(final String keyWord) {
        List<Paper> paperList = null;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            paperList = paperMapperForMariaDB.getPaperListBySearchSearchWord(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public int addPaper(final Paper paper) {
        int status = 0;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            paperMapperForMariaDB.addPaper(paper);
            status = 1;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int updatePaper(final Paper paper) {
        int status = 0;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            paperMapperForMariaDB.updatePaper(paper);
            status = 1;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int deletePaper(final int id) {
        int status = 0;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            paperMapperForMariaDB.deletePaper(id);
            status = 1;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int countPaper() {
        int count = 0;
        try (SqlSession sqlSession = SqlSessionFactory.getMariaDBSqlSession()) {
            PaperMapperForMariaDB paperMapperForMariaDB = sqlSession.getMapper(PaperMapperForMariaDB.class);
            count = paperMapperForMariaDB.countPaper();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 点赞论文，增加权重
     *
     * @param id     论文编号
     * @param weight 权重编号
     * @return 状态
     */
    public int updateALike(final int id, final int weight) {
        int status = 0;
        try (SqlSession sqlSession = SqlSessionFactory.getNeo4jSqlSession()) {
            PaperMapperForNeo4j paperMapperForNeo4j = sqlSession.getMapper(PaperMapperForNeo4j.class);
            if (weight == 1) {
                paperMapperForNeo4j.addWeight1(id, Conf.WEIGHT_OF_A_LIKE);
            } else if (weight == 2) {
                paperMapperForNeo4j.addWeight2(id, Conf.WEIGHT_OF_A_LIKE);
            } else if (weight == 3) {
                paperMapperForNeo4j.addWeight3(id, Conf.WEIGHT_OF_A_LIKE);
            }
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
