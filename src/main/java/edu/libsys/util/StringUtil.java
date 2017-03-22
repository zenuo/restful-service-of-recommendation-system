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

    //Return a string of given length.
    public static String getRandomString(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(CHAR_ARRAY[(int) (Math.random() * CHAR_ARRAY_LENGTH)]);
        }
        return stringBuffer.toString();
    }

    public static String getImageUrlByIsbn(String isbn) {
        final String API_URL = "https://api.douban.com/v2/book/isbn/";
        final String PRE_PATTERN = "\"image\":\"";
        final String MID_PATTERN = "(.*?)";
        final String POST_PATTERN = "\",\"binding\"";
        String imageUrl = "";
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
}
