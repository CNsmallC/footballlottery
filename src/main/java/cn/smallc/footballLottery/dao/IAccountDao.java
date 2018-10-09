package cn.smallc.footballLottery.dao;

import cn.smallc.footballLottery.entity.account.Account;

import java.util.List;

public interface IAccountDao {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountByID(int id);

    List<Account> findAccountList();

}
