package top.study01.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.study01.mapper.FilewarehouseMapper;
import top.study01.pojo.Filewarehouse;
import top.study01.service.FilewarehouseService;

import java.util.List;

@Service
public class FilewarehouseServiceImp implements FilewarehouseService {
    @Autowired
    private FilewarehouseMapper filewarehouseMapper;

    @Override
    public Integer save(Filewarehouse filewarehouse) {

        return filewarehouseMapper.save(filewarehouse);
    }

    @Override
    public List<Filewarehouse> FindFilesByUid(Integer uid) {

        return filewarehouseMapper.FindFilesByUid(uid);
    }
}
