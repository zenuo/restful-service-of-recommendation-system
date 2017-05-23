package edu.libsys.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final char[] CHAR_ARRAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int CHAR_ARRAY_LENGTH = 62;

    /**
     * 返回指定长度的随机字符串
     *
     * @param length 返回的随机字符串长度
     * @return 随机字符串
     */
    public static String getRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomString.append(CHAR_ARRAY[(int) (Math.random() * CHAR_ARRAY_LENGTH)]);
        }
        return randomString.toString();
    }

    /**
     * 根据图书的isbn获取封面图片链接
     *
     * @param isbn 需要获取封面的图书的isbn
     * @return 图书封面的图片链接
     */
    public static String getImageUrlByIsbn(String isbn) {
        final String API_URL = "https://api.douban.com/v2/book/isbn/";
        final String PRE_PATTERN = "\"image\":\"";
        final String MID_PATTERN = "(.*?)";
        final String POST_PATTERN = "\",\"binding\"";
        String imageUrl;
        String line;
        StringBuffer json = new StringBuffer();
        try {
            //获得json内容
            URL url = new URL(API_URL + isbn);
            InputStream is = url.openConnection().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();
            //正则解析json
            Pattern pattern = Pattern.compile(PRE_PATTERN + MID_PATTERN + POST_PATTERN);
            Matcher matcher = pattern.matcher(json);
            matcher.find();
            imageUrl = matcher.group().replace(PRE_PATTERN, "").replace(POST_PATTERN, "").replace("\\", "").replace("mpic", "lpic");
        } catch (Exception e) {
            //e.printStackTrace();
            imageUrl = "https://img1.doubanio.com/f/shire/5522dd1f5b742d1e1394a17f44d590646b63871d/pics/book-default-large.jpg";
        }
        return imageUrl;
    }

    /**
     * 根据提供的字符穿，返回指定长度的字符串组成的字符串数组
     *
     * @param sourceString    源
     * @param subStringLength 子字符串长度
     * @return 指定长度的字符串组成的字符串数组
     */
    public static String[] getStringArrayBySubStringLength(String sourceString, int subStringLength) {
        //计算字符串长度
        final int arrayLength = (int) Math.ceil(sourceString.length() / (double) subStringLength);
        //是否有长度小于指定长度的子字符串
        final boolean isExistInsufficientLengthString = sourceString.length() % subStringLength != 0;
        //创建子字符串数组
        String[] stringArray = new String[arrayLength];
        //起始脚标
        int start = 0;
        //结束脚标
        int end = subStringLength;

        if (isExistInsufficientLengthString) {
            for (int i = 0; i < arrayLength - 1; i++) {
                stringArray[i] = sourceString.substring(start, end);
                start += subStringLength;
                end += subStringLength;
            }
            //获取长度不足的子字符串
            stringArray[arrayLength - 1] = sourceString.substring(start, sourceString.length());
        } else {
            for (int i = 0; i < arrayLength; i++) {
                stringArray[i] = sourceString.substring(start, end);
                start += subStringLength;
                end += subStringLength;
            }
        }
        return stringArray;
    }
}
