package tv.icntv.search.utils;/*
 * Copyright 2014 Future TV, Inc.
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.icntv.tv/licenses/LICENSE-1.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/11/14
 * Time: 11:34
 */
public class Pinyin4jUtils {
//    public static String getPinYinHeadChar(String str) {
//
//        String convert = "";
//        for (int j = 0; j < str.length(); j++) {
//            char word = str.charAt(j);
//            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
//            if (pinyinArray != null) {
//                convert += pinyinArray[0].charAt(0);
//            } else {
//                convert += word;
//            }
//        }
//        return convert;
//    }
//    public static String getPingYin(String src) {
//
//        char[] t1 = null;
//        t1 = src.toCharArray();
//        String[] t2 = new String[t1.length];
//        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
//
//        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
//        String t4 = "";
//        int t0 = t1.length;
//        try {
//            for (int i = 0; i < t0; i++) {
//                // 判断是否为汉字字符
//                if (java.lang.Character.toString(t1[i]).matches(
//                        "[\\u4E00-\\u9FA5]+")) {
//                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
//                    t4 += t2[0];
//                } else
//                    t4 += java.lang.Character.toString(t1[i]);
//            }
//            // System.out.println(t4);
//            return t4;
//        } catch (BadHanyuPinyinOutputFormatCombination e1) {
//            e1.printStackTrace();
//        }
//        return t4;
    }
//    public static void main(Str