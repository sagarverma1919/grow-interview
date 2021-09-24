package com.interview.grow.dao;


import com.interview.grow.dao.model.Expense;
import com.interview.grow.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDAOLayer implements DAO
{
    private final Map<String, List<Expense>> userDictionary;
    private final Map<String, List<Expense>> groupDictionary;

    public InMemoryDAOLayer()
    {
        this.userDictionary = new HashMap<>();
        this.groupDictionary = new HashMap<>();
    }

    @Override
    public void addExpense(Expense request)
    {
        userDictionary.computeIfAbsent(request.getPaidBy().getUserId(), (key) -> new ArrayList<>()).add(request);

        if(!request.getOwes().getUserId().equals(request.getPaidBy().getUserId()))
        {
            userDictionary.computeIfAbsent(request.getOwes().getUserId(), (key) -> new ArrayList<>()).add(request);
        }
        groupDictionary.computeIfAbsent(request.getGroupId(), (key) -> new ArrayList<>()).add(request);
    }

    @Override
    public List<Expense> getExpensesForUser(User user)
    {
        return userDictionary.get(user.getUserId());
    }

    @Override
    public List<Expense> getExpensesForGroup(String groupId)
    {
        return groupDictionary.get(groupId);
    }
}
