package com.techelevator.tenmo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Account {

        @JsonProperty("account_id")
        private int accountId;
        @JsonProperty("user_id")
        private int userId;
        private BigDecimal balance;

        public Account() {
        }

        public Account(int accountId, int userId, double balance) {
            this.accountId = accountId;
            this.userId = userId;
            this.balance = BigDecimal.valueOf(balance);
        }

        public int getAccountId() {
            return accountId;
        }

        public int getUserId() {
            return userId;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

    }

