package com.phoenixhell.test;

import com.phoenixhell.boot.MainApplication;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author phoenixhell
 * @create 2021/1/15 0015-下午 3:16
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 */
@DisplayName("junit5测试")
@SpringBootTest(classes = MainApplication.class)
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeAll
    static void BeforeAllTest(){
        System.out.println("---------所有测试开始--------");

    }

    @AfterAll
    static void AfterAllTest(){
        System.out.println("---------所有测试结束--------");
    }

    @BeforeEach
    void BeforeEachTest(){
        System.out.println("---------此次测试开始--------");
    }
    @AfterEach
    void AfterEachTest(){
        System.out.println("---------此次测试结束--------");
    }


    @DisplayName("测试1")
//    @RepeatedTest(5)
    @Tag("tag")
//    @Timeout(3)
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
//    @Disabled
    @Test
     void test1(){
        System.out.println("测试1");
        System.out.println(jdbcTemplate);
    }

    @DisplayName("断言")
    @Test
    void test2(){
        Assertions.assertEquals(1,2,"this a  error message");
    }


    @ParameterizedTest
    @DisplayName("参数化")
    @ValueSource(ints = {1,2,3,4,5})
    void test3(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("参数化")
    @MethodSource("stringProvider")
    void test4(String s){
        System.out.println(s);
    }
    static Stream<String> stringProvider(){
        return Stream.of("apple","banana");
    }
}
