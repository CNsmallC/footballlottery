package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.IRepository;
import cn.smallc.footballLottery.entity.User;
import cn.smallc.footballLottery.entity.account.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserRepository extends IRepository<User>{

    String getPasswordByUsername(@Param("username") String username);

}
