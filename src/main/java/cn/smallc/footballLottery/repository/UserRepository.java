package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.Repository;
import cn.smallc.footballLottery.entity.User;
import cn.smallc.footballLottery.entity.account.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRepository extends Repository<User,IUserRepository> {

    public String getPasswordByUsername(String username){
        return repository.getPasswordByUsername(username);
    }


}
