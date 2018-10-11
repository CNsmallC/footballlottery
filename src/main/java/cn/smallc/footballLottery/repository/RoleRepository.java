package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.Repository;
import cn.smallc.footballLottery.entity.Role;
import cn.smallc.footballLottery.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public class RoleRepository extends Repository<Role,IRoleRepository> {

    public String getRoleNameByUsername(String username){
        return repository.getRoleNameByUsername(username);
    }

}
