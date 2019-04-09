package top.study01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.study01.pojo.Filewarehouse;

import java.util.List;

public interface FilewarehouseMapper {

    @Insert("Insert into filewarehouse values (#{fid},#{uid},#{fname},#{fdate},#{fdesc},#{fpath},#{ispicture})")
    Integer save(Filewarehouse filewarehouse);
    @Select("select *  from filewarehouse where uid = #{param1}")
    List<Filewarehouse> FindFilesByUid(Integer uid);
}
