package top.study01.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.study01.mapper.SelfuserMapper;
import top.study01.pojo.Selfuser;
import top.study01.service.SelfuserService;

@Service
public class SelfuserServiceImp implements SelfuserService {

    @Autowired
    private SelfuserMapper selfuserMapper;

    @Override
    public Selfuser findUser(Selfuser user) {
        Selfuser selfuser = selfuserMapper.findUser(user);
        return selfuser;
    }
}
