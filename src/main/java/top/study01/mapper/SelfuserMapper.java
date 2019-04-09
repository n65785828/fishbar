package top.study01.mapper;

import org.apache.ibatis.annotations.Select;
import top.study01.pojo.Selfuser;

public interface SelfuserMapper {

    @Select("select * from selfuser where username=#{username} and password=#{password}")
    Selfuser findUser(Selfuser selfuser);
}
