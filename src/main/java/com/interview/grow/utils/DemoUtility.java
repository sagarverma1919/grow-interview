package com.interview.grow.utils;

import static com.interview.grow.utils.MapperUtils.createSplits;

import com.interview.grow.model.EqualExpense;
import com.interview.grow.model.Expense;
import com.interview.grow.model.SplitType;
import com.interview.grow.model.User;

import java.util.List;

public class DemoUtility
{

    public static EqualExpense createExpenseRequest(User paidBy, double amount, String groupId, List<User> users)
    {
        EqualExpense request = new EqualExpense();

        request.setPaidBy(paidBy);
        request.setAmount(amount);
        request.setGroupId(groupId);
       // request.setUsers(createSplits(users, amount, SplitType.EQUAL));

        return request;
    }
}
