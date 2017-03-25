package edu.libsys.data.dao;

import edu.libsys.data.mapper.BookMapper;
import edu.libsys.entity.Book;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class BookDao implements Serializable {
    public Book getBookById(final int id) {
        Book book = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            book = bookMapper.getBookById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> getBookListByIdList(final List<Integer> integerList) {
        List<Book> bookList = new LinkedList<>();
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            for (Integer anIntegerList : integerList) {
                bookList.add(bookMapper.getBookById(anIntegerList));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public int addBook(final Book book) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.addBook(book);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int updateBook(final Book book) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.updataBook(book);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int deleteBook(final int marcRecId) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.deleteBook(marcRecId);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int countBook() {
        int count = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            count = bookMapper.countBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Book> getBookListBySearchTitle(final String keyWord) {
        List<Book> bookList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookList = bookMapper.getBookListBySearchTitle(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public List<Book> getBookListBySearchAuthor(final String keyWord) {
        List<Book> bookList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookList = bookMapper.getBookListBySearchAuthor(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public List<Book> getBookList(final int page, final int size) {
        List<Book> bookList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookList = bookMapper.getBookList(page, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public int likeCountPlusOne(final int id) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.likeCountPlusOne(id);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int disLikeCountPlusOne(final int id) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.disLikeCountPlusOne(id);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
