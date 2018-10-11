package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.IRepository;
import cn.smallc.footballLottery.entity.Role;
import cn.smallc.footballLottery.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IRoleRepository extends IRepository<Role>{

    String getRoleNameByUsername(@Param("username")String username);

}
