package edu.libsys.data.mapper.mariadb;

import edu.libsys.entity.Paper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PaperMapperForMariaDB {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "paperId", column = "paperId"),
            @Result(property = "title", column = "title"),
            @Result(property = "searchWord", column = "searchWord"),
            @Result(property = "source", column = "source"),
            @Result(property = "url", column = "url"),
            @Result(property = "intro", column = "intro"),
            @Result(property = "likeCount", column = "likeCount"),
            @Result(property = "disLikeCount", column = "disLikeCount"),
            @Result(property = "field", column = "field"),
            @Result(property = "indexTerm", column = "indexTerm"),
            @Result(property = "author", column = "author")
    })

    @Select("SELECT id, paperId, title, searchWord, source, url, intro, likeCount, disLikeCount, field, indexTerm, author FROM PAPER WHERE id=#{id}")
    Paper getPaperById(final int id);

    @Select("SELECT id ,paperId, title, searchWord, source, url, intro, likeCount, disLikeCount, field, indexTerm, author FROM PAPER WHERE id>((#{page}-1)*#{size}) ORDER BY id ASC LIMIT #{size}")
    List<Paper> getPaperList(@Param("page") final int page, @Param("size") final int size);

    @Select("SELECT id ,paperId, title, searchWord, source, url, intro, likeCount, disLikeCount, field, indexTerm, author FROM PAPER WHERE title LIKE CONCAT('%',#{keyWord},'%') LIMIT 40")
    List<Paper> getPaperListBySearchTitle(final String keyWord);

    @Select("SELECT id ,paperId, title, searchWord, source, url, intro, likeCount, disLikeCount, field, indexTerm, author FROM PAPER WHERE intro LIKE CONCAT('%',#{keyWord},'%') LIMIT 20")
    List<Paper> getPaperListBySearchIntro(final String keyWord);

    @Select("SELECT id ,paperId, title, searchWord, source, url, intro, likeCount, disLikeCount, field, indexTerm, author FROM PAPER WHERE searchWord LIKE CONCAT('%',#{keyWord},'%') LIMIT 20")
    List<Paper> getPaperListBySearchSearchWord(final String keyWord);

    @Select("SELECT COUNT(*) FROM PAPER")
    int countPaper();

    @Insert("INSERT INTO PAPER(paperId, title, searchWord, source, url, intro, likeCount, disLikeCount, field, indexTerm, author) VALUES(#{paperId}, #{title}, #{searchWord}, #{source}, #{url}, #{intro}, #{likeCount}, #{disLikeCount}, #{field}, #{indexTerm}, #{author})")
    void addPaper(final Paper paper);

    @Update("UPDATE PAPER SET title=#{title}, searchWord=#{searchWord}, source=#{source}, url=#{url}, intro=#{intro}, likeCount=#{likeCount}, disLikeCount=#{disLikeCount}, field=#{field}, indexTerm=#{indexTerm}, author=#{author} WHERE id=#{id}")
    void updatePaper(final Paper paper);

    @Delete("DELETE FROM PAPER WHERE id={id}")
    void deletePaper(final int id);
}
