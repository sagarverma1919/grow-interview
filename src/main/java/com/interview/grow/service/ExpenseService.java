package com.interview.grow.service;

import static com.interview.grow.utils.DAOMapperUtils.createDAORequest;

import com.interview.grow.dao.DAO;
import com.interview.grow.model.Expense;
import com.interview.grow.model.SplitType;
import com.interview.grow.model.User;
import com.interview.grow.utils.MapperUtils;

import java.util.List;

public class ExpenseService
{

    private final DAO dao;

    public ExpenseService(DAO dao)
    {
        this.dao = dao;
    }

    public void createExpense(User paidBy, double amount, List<User> owes, String groupId, SplitType type)
    {
        Expense expense = MapperUtils.createExpense(paidBy, amount, owes, groupId, type);


        for(com.interview.grow.dao.model.Expense request: createDAORequest(expense))
        {
            dao.addExpense(request);
        }
    }
}
