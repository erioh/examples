package org.demenkov.apacheintegration;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface TestForMybatys {
    @Insert(("insert into people(firstName, lastName) values(#{firstName}, #{lastName})"))
    void insertPerson();

    @Select("select * from people")
    List<People> selectAllPeople();
}
