package com.briup.jz.dao;

import com.briup.jz.bean.AccountSystem;
import com.briup.jz.bean.AccountSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountSystemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    long countByExample(AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int deleteByExample(AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int insert(AccountSystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int insertSelective(AccountSystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    List<AccountSystem> selectByExample(AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    AccountSystem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int updateByExampleSelective(@Param("record") AccountSystem record, @Param("example") AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int updateByExample(@Param("record") AccountSystem record, @Param("example") AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int updateByPrimaryKeySelective(AccountSystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int updateByPrimaryKey(AccountSystem record);
}