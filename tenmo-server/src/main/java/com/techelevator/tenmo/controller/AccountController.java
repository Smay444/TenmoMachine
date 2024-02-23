package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.PermitAll;
import java.math.BigDecimal;
import java.security.Principal;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private UserDao userDao;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public Account getById(Principal principal){

        int getById = userDao.findIdByUsername(principal.getName());

        Account account = accountDao.getAccountByUserId(getById);

        if (account == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        } else {
            return account;
        }



    }

    @RequestMapping(path = "/balance", method = RequestMethod.GET)
    public ResponseEntity<BigDecimal> getBalance(@RequestParam("userId") int userId) {

        BigDecimal balance;
        try {
            balance = accountDao.getBalance(userId);
        } catch (DataAccessException e) {
            // Handle data access exceptions appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (balance == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}
