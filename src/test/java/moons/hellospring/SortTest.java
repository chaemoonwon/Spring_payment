package moons.hellospring;

import moons.hellospring.sort.Sort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    Sort sort;

    //각 테스트를 실행하기 전
    @BeforeEach
    void beforeEach() {
        sort = new Sort();
        System.out.println(this);
    }

    @Test
    void sort() {
        // 실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));
        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b","aa"));
    }

    @Test
    void sort3Items() {
        // 실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));
        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b","aa","ccc"));
    }

    @Test
    void sortAlreadySorted() {
        // 실행
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));
        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b","aa","ccc"));
    }


}
