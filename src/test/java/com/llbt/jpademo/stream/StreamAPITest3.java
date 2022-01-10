package com.llbt.jpademo.stream;

import com.llbt.jpademo.entity.JpaStudent;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Stream的终止操作
public class StreamAPITest3 {

    //1、匹配与查找
    @Test
    public void test1(){
        //先创建一个集合
        List<JpaStudent> list = new ArrayList<>();
        list.add(new JpaStudent(1L,"张三"));
        list.add(new JpaStudent(2L,"李四"));
        list.add(new JpaStudent(4L,"王五"));
        list.add(new JpaStudent(7L,"赵雷"));
//        allMatch(Predicate p) --检查是否匹配所有元素，
//        练习：是否所有的员工年龄都大于18----------因为没有创建员工对象用id替代年龄
        boolean b = list.stream().allMatch(e -> e.getId() > 0);
        System.out.println(b);  //allMatch是所有的都是true他才是true


//        anyMatch(Predicate p) --检查是否至少匹配一个元素。练习：是否存在员工工资大于10000
        boolean anyMatch = list.stream().anyMatch(e -> e.getId() > 2);
        System.out.println(anyMatch);  //allMatch是所有的都是true他才是true


//        noneMatch（Predicate p） --检查是否没有匹配的元素，练习：是否存在员工姓雷---有就显示false，没有就true
        boolean b1 = list.stream().noneMatch(e -> e.getName().contains("雷"));
        System.out.println(b1);

//        findFirst --返回第一个元素
        Optional<JpaStudent> first = list.stream().findFirst();
        System.out.println(first);

//        findAny  --返回当前流中的任意元素
//        Optional<JpaStudent> any = list.stream().findAny(); --使用顺行流 可能一直是返回第一个，我们可以使用并行流
        Optional<JpaStudent> any = list.parallelStream().findAny();
        System.out.println(any);

    }

    @Test
    public void test2(){
        //先创建一个集合
        List<JpaStudent> list = new ArrayList<>();
        list.add(new JpaStudent(1L,"张三"));
        list.add(new JpaStudent(2L,"李四"));
        list.add(new JpaStudent(4L,"王五"));
        list.add(new JpaStudent(7L,"赵雷"));

        //        count     --返回流中的总个数
        long count = list.stream().count();
        System.out.println(count);

//        max(Comparator c) --返回流中最大值
//        练习返回最高工资
        Stream<Long> money = list.stream().map(e -> e.getId());
        Optional<Long> max = money.max(Long::compare);
        System.out.println(max);

//        min(Comparator c) --返回流中的最小值
//        练习：返回工资最低的员工
        Optional<JpaStudent> min = list.stream().min((e1, e2) -> Long.compare(e1.getId(), e2.getId()));
        System.out.println(min);


//        forEach(Consumer c )   --内部迭代
        list.stream().forEach(System.out::println);

//        也可以这样写，虽然都是forEach 但是主体是不一样的，这个是集合的遍历操作
        list.forEach(System.out::println);
    }

//    2、归约
    @Test
    public void test3(){
//        reduce(T identity, BinaryOperator) --可以将流中元素反复结合起来，到一个值，返回，返回T
//      练习1：计算1-10的自然数和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, Integer::sum); //0是初始值，计算为55 如果初始值是10 那么结果就是65
        System.out.println(reduce);


//        reduce（BinaryOperator） --可以将流中元素反复结合起来，得到一个值，返回Optional<T>
//        练习2：计算公式所有员工工资的总和
        //先创建一个集合
        List<JpaStudent> list2 = new ArrayList<>();
        list2.add(new JpaStudent(1L,"张三"));
        list2.add(new JpaStudent(2L,"李四"));
        list2.add(new JpaStudent(4L,"王五"));
        list2.add(new JpaStudent(7L,"赵雷"));

        Stream<Long> longStream = list2.stream().map(e -> e.getId());
        Optional<Long> sum = longStream.reduce(Long::sum);
        System.out.println(sum);

        //第二种写法
        Stream<Integer> integerStream = list2.stream().map(e -> e.getId().intValue());
        Optional<Integer> sum2 = integerStream.reduce((e1,e2) -> e1 + e2);
        System.out.println(sum2);




    }


    //    3、收集
    @Test
    public void test4(){
//      collect(Collector c) --将流转换为其他形式，接收一个Collector接口的实现，用于给
//        练习1： 查找工资大于6000的员工，结果返回一个List或者是Set
        //先创建一个集合
        List<JpaStudent> list2 = new ArrayList<>();
        list2.add(new JpaStudent(1L,"张三"));
        list2.add(new JpaStudent(2L,"李四"));
        list2.add(new JpaStudent(7L,"王五"));
        list2.add(new JpaStudent(8L,"赵雷"));

        List<JpaStudent> collect = list2.stream().filter(e -> e.getId() > 6).collect(Collectors.toList());

        collect.forEach(System.out :: println);

        System.out.println("*****************************");
        //如果我们需要返回一个Set的话
        Set<JpaStudent> set = list2.stream().filter(e -> e.getId() > 6).collect(Collectors.toSet());
        set.forEach(System.out :: println);

    }

}
