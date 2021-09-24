package com.interview.grow.service;

import com.interview.grow.dao.DAO;
import com.interview.grow.dao.model.Expense;
import com.interview.grow.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LookupService
{
    private final DAO dao;

    public LookupService(DAO dao)
    {
        this.dao = dao;
    }

    public void showBalance(User user)
    {
        List<Expense> expensesForUser = dao.getExpensesForUser(user);

        printBalance(expensesForUser, user.getUserId());
    }

    public void showBalance(String groupId)
    {
        List<Expense> expensesForGroup = dao.getExpensesForGroup(groupId);

        printBalance(expensesForGroup, groupId);
    }


    private void printBalance(List<Expense> expenses, String identifier)
    {
        Map<String, Double> balance = new HashMap<>();


        for(Expense expense: expenses)
        {
            String user = expense.getOwes().getUserId();
            balance.putIfAbsent(user, 0.0);
            balance.put(user, balance.get(user) + expense.getAmount());
        }

        balance.entrySet().forEach( item ->
            System.out.println(identifier + " "+  item.getKey() + " "  + "owes " + item.getValue())
        );
    }
}
