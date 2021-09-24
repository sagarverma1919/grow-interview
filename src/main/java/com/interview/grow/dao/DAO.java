package com.interview.grow.dao;


import com.interview.grow.dao.model.Expense;
import com.interview.grow.model.User;

import java.util.List;

public interface DAO
{
    void addExpense(Expense request);

    List<Expense> getExpensesForUser(User user);

    List<Expense> getExpensesForGroup(String groupId);
}
