package com.lesan.application.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.net.URL;

/**
 *
 */
public class JsonDemo {
    public static void main(String[] args) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("json/person.json");
        String file = resource.getFile();
        String json = readJsonFile(file);
        System.out.println(json);

        Person person = JSONObject.parseObject(json, Person.class);
        System.out.println(person);

        resource = Thread.currentThread().getContextClassLoader().getResource("json/persons.json");
        file = resource.getFile();
        json = readJsonFile(file);
        System.out.println(json);
        Resultlnfo resultlnfo = JSONObject.parseObject(json, Resultlnfo.class);
        Resultlnfo<Person> personResultlnfo = JSONObject.parseObject(json, new TypeReference<Resultlnfo<Person>>() {
        });
        for (Person p : personResultlnfo.getResult()) {
            System.out.println(p);
        }
        System.out.println(JSON.toJSONString(resultlnfo));

        resource = Thread.currentThread().getContextClassLoader().getResource("json/Students.json");
        file = resource.getFile();
        json = readJsonFile(file);
        System.out.println(json);
        Resultlnfo<Student> studentResultlnfo = JSONObject.parseObject(json, new TypeReference<Resultlnfo<Student>>() {
        });
        for (Student p : studentResultlnfo.getResult()) {
            System.out.println(p);
        }

    }

    //读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
