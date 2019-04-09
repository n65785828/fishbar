package top.study01.service;

import top.study01.pojo.Filewarehouse;

import java.util.List;

public interface FilewarehouseService {
    Integer save(Filewarehouse filewarehouse);

    List<Filewarehouse> FindFilesByUid(Integer uid);
}
