package cn.huang.mybatis.test;

import cn.huang.mybatis.bean.Person;
import cn.huang.mybatis.dao.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * @Author: Yaking
 * @Date: 2019-07-13 11:25
 * @Describe:
 */
public class ParameterTest {
    public static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            try {
                Reader reader = Resources.getResourceAsReader(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    public void deletePerson() {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        personMapper.deletePerson(4);
        sqlSession.commit();
    }

    public void testPersonByNameAndGender() {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        /* 方式一：Person person = personMapper.getPersonByNameAndGender("lisi", "m");*/
        /* 方式二：Person person = personMapper.getPersonByNameAndGender(new Person("lisi","m"));*/
        /* 方式三： Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", "lisi");
        param.put("gender", "m");
        Person person = personMapper.getPersonByNameAndGender(param);*/
        Person person = personMapper.getPersonByNameAndGender("lisi", "m");
        System.out.println(person);
    }

    /*Mybatis的入参处理*/
    public void testCollection() {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        /*Person person = personMapper.getPersonByCollection(Arrays.asList(1, 2, 3));*/
        Person person = personMapper.getPersonByCollection(new int[]{1, 2, 3});
        System.out.println(person);
    }

    public void testForeach() {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> personLists = personMapper.getPersonByIds(new int[]{1, 2, 3});
        System.out.println(personLists);
    }

    /*添加多条数据*/
    public void processMybatisBatch() {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person("tom" + i, "email@" + i, "f");
            persons.add(person);
        }
        personMapper.addPersons(persons);
        sqlSession.commit();
    }

    public void testBatchForExecutor() {
        SqlSession sqlSession = this.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        for (int i = 0; i < 10000; i++) {
            personMapper.addPerson(new Person("tom", "tom@qq.com", "F"));
        }
        sqlSession.commit();
    }

    public static void main(String[] args) {
        /*new ParameterTest().deletePerson();*/
        /*new ParameterTest().testPersonByNameAndGender();*/
        new ParameterTest().testCollection();
        /*new ParameterTest().testForeach();*/
        /*new ParameterTest().processMybatisBatch();*/
        /*new ParameterTest().testBatchForExecutor();*/
    }
}
