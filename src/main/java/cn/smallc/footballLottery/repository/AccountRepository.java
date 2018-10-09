package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.Repository;
import cn.smallc.footballLottery.entity.account.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountRepository extends Repository<Account,IAccountRepository> {

    @Transactional
    public void transfer(){
        repository.transfer(90,1);
//        int i=1/0;
        repository.transfer(110,2);
    }

}
