package edu.libsys.util;

import edu.libsys.entity.Book;
import edu.libsys.entity.Paper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {
    /**
     * 整数列表去重
     * http://stackoverflow.com/questions/27464781/creating-distinct-list-from-existing-list-in-java-7-and-8
     *
     * @param integerList 需要去重的整数列表
     * @return 去重后的证书列表
     */
    public static List<Integer> deDupIntegerList(List<Integer> integerList) {
        return integerList.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 根据isbn号对图书列表去重
     *
     * @param bookList 需要去重的图书列表
     * @return 去重后的图书列表
     */
    public static List<Book> deDupBookList(List<Book> bookList) {
        List<Book> resultBookList = new LinkedList<>();
        List<Long> isbnList = new LinkedList<>();
        for (int i = 0; i < bookList.size(); i++) {
            long isbn = Long.valueOf(bookList.get(i).getIsbn().replace("-", ""));
            if (!isbnList.contains(isbn)) {
                isbnList.add(isbn);
                resultBookList.add(bookList.get(i));
            }
        }
        return resultBookList;
    }

    /**
     * 根据paperId对论文列表去重
     *
     * @param paperList 需要去重的论文列表
     * @return 去重后的论文列表
     */
    public static List<Paper> deDupPaperList(List<Paper> paperList) {
        List<Paper> resultPaperList = new LinkedList<>();
        List<String> paperIdList = new LinkedList<>();
        for (int i = 0; i < paperList.size(); i++) {
            String paperId = paperList.get(i).getPaperId().replace(".nh", "");
            if (!paperIdList.contains(paperId)) {
                paperIdList.add(paperId);
                resultPaperList.add(paperList.get(i));
            }
        }
        return resultPaperList;
    }
}
