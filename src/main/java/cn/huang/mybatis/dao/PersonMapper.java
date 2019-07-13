package cn.huang.mybatis.dao;

        import cn.huang.mybatis.bean.Person;
        import org.apache.ibatis.annotations.Param;

        import java.util.Collection;
        import java.util.List;
        import java.util.Map;

/**
 * @Author: Yaking
 * @Date: 2019-07-13 9:51
 * @Describe:
 */
public interface PersonMapper {
    public void deletePerson(Integer id);

    /*方式一：public Person getPersonByNameAndGender(String username, String gender);*/
    /*方式二：public Person getPersonByNameAndGender(Person person);*/
    /*方式三：public Person getPersonByNameAndGender(Map<String,Object> param);*/
    public Person getPersonByNameAndGender(@Param("param1") String username, @Param("param2") String gender);

    /*Mybatis的入参处理 ：1.Collection(集合) 2.int[](数组)*/
    // public Person getPersonByCollection(Collection list);
    // public Person getPersonByCollection(int[] ids);
    public Person getPersonByCollection(@Param("test") int[] ids);

    /*查询为多条数据*/
    public List<Person> getPersonByIds(int[] ids);

    /*插入多条数据*/
    public int addPersons(@Param("persons") List<Person> person);

    public int addPerson(Person person);
}
