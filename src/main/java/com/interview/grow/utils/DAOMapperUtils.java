package com.interview.grow.utils;

import com.interview.grow.dao.model.Expense;
import com.interview.grow.model.Split;

import java.util.ArrayList;
import java.util.List;

public class DAOMapperUtils
{


    public static List<Expense> createDAORequest(com.interview.grow.model.Expense expense)
    {
        List<Expense> request = new ArrayList<>();

        for(Split split : expense.getUsers())
        {
            Expense item = new Expense();
            item.setCreateDate(expense.getCreateDate());
            item.setAmount(split.getAmount());
            item.setGroupId(expense.getGroupId());
            item.setPaidBy(expense.getPaidBy());
            item.setOwes(split.getOwes());

            request.add(item);
        }

        return request;
    }
}
