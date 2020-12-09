package com.bili.tool.lambda8;

import com.alibaba.fastjson.JSON;
import com.bili.tool.beans.Stu;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Stu> stus = new ArrayList<>();
    public static String str = "aaa,bbb,ccc";

    static {
        stus.add(new Stu(1, "mikle", 27, 180.0));
        stus.add(new Stu(2, "Lily", 26, 163.0));
        stus.add(new Stu(3, "lucy", 3, 103.0));
        stus.add(new Stu(4, "shary", 4, 102.0));
    }

    /**
     * jdk8 lambda表达式
     */
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println(stus);
        List<Integer> ids = stus.stream().map(Stu::getId).collect(Collectors.toList());
        System.out.println(ids);
        String namesStr = stus.stream().map(e -> e.getName()).collect(Collectors.joining(","));
        System.out.println(namesStr);
        Stu stu = stus.stream().filter(e -> e.getHeight() > 103.0).findAny().orElse(null);
        System.out.println(stu);
        List<NameAgeC> nacs = stus.stream().map(stu1 -> {
            NameAgeC nac = new NameAgeC(stu1.getName(), stu1.getAge());
            return nac;
        }).collect(Collectors.toList());
        System.out.println(nacs);
        stus.stream().forEach(e -> {
            System.out.println(e.getAge());
        });
        List<Integer> idA = ids.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum)).
                entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(idA);
        Map<Integer, String> idNameMap = stus.stream().collect(Collectors.toMap(Stu::getId, Stu::getName));
        System.out.println(idNameMap);
        Map<Boolean, List<Stu>> stuGroup = stus.stream().collect(Collectors.groupingBy(x -> x.getName().contains("i")));
        System.out.println(stuGroup);
        idNameMap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        List<String> strs = Splitter.on(",").splitToList(str);
        System.out.println(strs);
        List<List<Stu>> partition = Lists.partition(stus, 3);
        System.out.println(partition);
        String a = "  ";
        if (StringUtils.isNoneBlank(a)) {
            System.out.println("bbb");
            System.out.println(a);
        }
        ids.stream().filter(e -> e.equals(28)).findAny().ifPresent(x -> {
            System.out.println(x);
        });

        String randomU = UUID.randomUUID().toString().replace("-", "");
        System.out.println(randomU);

        StringBuilder sb = new StringBuilder("aaa");
        sb.insert(1,"bbb");
        System.out.println(sb.toString());
        String s = JSON.toJSONString(stus);
        System.out.println(s);
        List<Stu> bbb = JSON.parseArray(s,Stu.class);
        System.out.println("---------");
        System.out.println(bbb);
        System.out.println("====================");
        Map<String,Stu> targetMap = stus.stream().collect(Collectors.toMap(k->k.getName(),k->k,(k1,k2)->k1));
        System.out.println(targetMap);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class NameAgeC implements Serializable {
        public String name;
        public int age;
    }
}
