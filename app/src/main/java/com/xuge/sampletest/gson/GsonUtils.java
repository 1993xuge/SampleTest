package com.xuge.sampletest.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xuge.sampletest.gson.bean.Person;
import com.xuge.sampletest.gson.bean.User;
import com.xuge.sampletest.gson.bean.news.HomeNewsBean;
import com.xuge.sampletest.retrofit.bean.BookResponse;

import java.util.List;

public class GsonUtils {
    public static final void main(String[] args) {
//        toJson();
//        fromJson();
//        arrayFromJson();

        bookFromJson();
//        newsFromJson();
    }

    private static void listFromJson() {
//Json数组 转为 List
        Gson gson = new Gson();
        String jsonArray = "[\"https://github.com/leavesC\",\"https://www.jianshu.com/u/9df45b87cfdf\",\"Java\",\"Kotlin\",\"Git\",\"GitHub\"]";
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {
        }.getType());
        System.out.println("\nJson数组 转为 List: ");
        for (String string : stringList) {
            System.out.println(string);
        }
        //List 转为 Json数组
        jsonArray = gson.toJson(stringList, new TypeToken<List<String>>() {
        }.getType());
        System.out.println("\nList 转为 Json数组: ");
        System.out.println(jsonArray);

    }

    private static void arrayFromJson() {
        //Json数组 转为 字符串数组
        Gson gson = new Gson();
        String jsonArray = "[\"https://github.com/leavesC\",\"https://www.jianshu.com/u/9df45b87cfdf\",\"Java\",\"Kotlin\",\"Git\",\"GitHub\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        System.out.println("Json数组 转为 字符串数组: ");
        for (String string : strings) {
            System.out.println(string);
        }
        //字符串数组 转为 Json数组
        jsonArray = gson.toJson(strings, String[].class);
        System.out.println("\n字符串数组 转为 Json数组: ");
        System.out.println(jsonArray);
    }

    private static void fromJson() {
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"sunny\",\"age\":24}";
        User user = gson.fromJson(jsonString, User.class);
        System.out.println("name = " + user.name + "   age = " + user.age);

        String jsonStringPerson = "{\"personName\":\"sunny\",\"personAge\":24, \"sex\":false}";
        Person person = gson.fromJson(jsonStringPerson, Person.class);
        System.out.println("name = " + person.getName() + "   age = " + person.getAge() + "   sex = " + person.isSex());

        String jsonStringPerson2 = "{\"pm\":\"sunny1\",\"personAge\":24, \"sex\":false}";
        Person person2 = gson.fromJson(jsonStringPerson2, Person.class);
        System.out.println("name = " + person2.getName() + "   age = " + person2.getAge() + "   sex = " + person2.isSex());
    }

    private static void toJson() {
        Gson gson = new Gson();

        // 基本数据类型
        String jsonNumber = gson.toJson(100); // 100
        String jsonBoolean = gson.toJson(false); // false
        String jsonString = gson.toJson("String"); //"String"
        System.out.println(jsonNumber);

        // 引用类型
        User user = new User("xiaowang", 12);
        String jsonUser = gson.toJson(user);
        // {"name":"xiaowang","age":12}
        System.out.println(jsonUser);

        Person person = new Person("Tom", 10, false);
        System.out.println(gson.toJson(person));
    }

    private static void bookFromJson() {
        Gson gson = new Gson();
        BookResponse bookResponse = gson.fromJson(Constants.book, BookResponse.class);
        System.out.println(bookResponse.getSubtitle());
    }

    private static void newsFromJson() {
        Gson gson = new Gson();
        HomeNewsBean homeNewsBean = gson.fromJson(Constants.news, HomeNewsBean.class);
        System.out.println(homeNewsBean.getShowapi_res_body().getPagebean().getContentlist().get(0).getTitle());
    }
}
