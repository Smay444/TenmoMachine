package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Principal;


@Component
public class JdbcAccountDao implements AccountDao{
    private final double STARTING_BALANCE = 1000;
    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account createAccount(int userId) {
        Account newAccount = null;

        String sql = "INSERT INTO account (user_id, balance)\n" +
                "VALUES (?, ?) RETURNING account_id;";
        try{
            int newAccountId = jdbcTemplate.queryForObject(sql, int.class, userId, STARTING_BALANCE);
            newAccount = getAccountById(newAccountId);
        }catch  (Exception ex){
            System.out.println("Unable to Create Account. Try Again");
        }
        return newAccount;
    }

    @Override
    public Account getAccountById(int id) {
        Account account = null;

        String sql = "select account_id, user_id, balance \n" +
                "from account\n" +
                "WhERE account_id = ?;";

        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
            if( result.next()){
                account = mapRowsToAccount(result);
            }
        }catch (Exception e){
            System.out.println("Something went wrong in getAccountById");
        }
        return account;
    }
    @Override
    public BigDecimal getBalance(int userId){


        String sql = "SELECT balance \n" +
                "FROM account\n" +
                "WHERE account_id = ?;";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{userId},
                    (rs, rowNum) -> new BigDecimal(rs.getDouble("balance")));
        } catch (DataAccessException e) {
            // Handle data access exceptions appropriately (e.g., log, throw custom exception)
            throw new RuntimeException("Error retrieving balance for user " + userId, e);
        }
    }
    public Account getAccountByUserId(int userId) {
        Account account = null;

        String sql = "select account_id, user_id, balance \n" +
                "from account\n" +
                "WhERE user_id = ?;";

        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
            if( result.next()){
                account = mapRowsToAccount(result);
            }
        }catch (Exception e){
            System.out.println("Something went wrong in getAccountByUserId");
        }
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        Account updatedAccount = null;

        String sql = "UPDATE account\n" +
                "SET balance = ?, user_id = ?\n" +
                "WHERE account_id = ?;";

        try {

            int numberOfRows = jdbcTemplate.update(sql, account.getBalance(), account.getUserId(), account.getAccountId());

            if (numberOfRows == 0){
                throw new Exception();
            } else {
                updatedAccount = getAccountById(account.getAccountId());
            }

        } catch (Exception e){
            System.out.println("Unable to update account");
        }

        return updatedAccount;
    }

    @Override
    public int deleteAccountById(int id) {
        int numberOfRows = 0;

        String sql = "DELETE \n" +
                "FROM account\n" +
                "WHERE account_id = ?;";

        try{
            numberOfRows = jdbcTemplate.update(sql, id);
        } catch (Exception ex){
            System.out.println("Unable to delete account");
        }

        return numberOfRows;
    }

    public Account mapRowsToAccount(SqlRowSet rowSet){
        Account account = new Account();
        account.setAccountId(rowSet.getInt("account_id"));
        account.setUserId(rowSet.getInt("user_id"));
        // Should only have one of these active, not sure which one will work
        //account.setBalanceDouble(rowSet.getDouble("balance"));
        account.setBalance(rowSet.getBigDecimal("balance"));

        return account;
    }
}
