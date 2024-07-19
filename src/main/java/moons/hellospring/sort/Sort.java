package moons.hellospring.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public List<String> sortByLength(List<String> list) {
        list.sort((o1, o2) -> o1.length() - o2.length());
        return list;
    }
//    public static void main(String[] args) {
////        List<Integer> scores = Arrays.asList(5,7,9,1,2,3,5);  //숫자 정렬
//        List<String> scores = Arrays.asList("z","d","java");    //문자 정렬
////        Collections.sort(scores);
//        Collections.sort(scores, (o1, o2) -> o1.length() - o2.length());    //문자열의 길이가 긴 순서대로 정렬
//
//
//        for (String score : scores) {
//            System.out.println(score);
//        }
//    }
}
