package com.interview.grow.utils;

import com.interview.grow.model.EqualExpense;
import com.interview.grow.model.EqualSplit;
import com.interview.grow.model.Expense;
import com.interview.grow.model.Split;
import com.interview.grow.model.SplitType;
import com.interview.grow.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperUtils
{


    public static Expense createExpense(User paidBy, double amount, List<User> owes, String groupId, SplitType type)
    {
        switch (type)
        {
            case EQUAL:
                EqualExpense expense = new EqualExpense();
                expense.setAmount(amount);
                expense.setCreateDate(new Date());
                expense.setPaidBy(paidBy);
                expense.setGroupId(groupId);
                expense.setUsers(createSplits(paidBy,owes, amount, type));

                return expense;
            default: return null;
        }
    }

    public static List<Split> createSplits(User paidBy, List<User> owes, double amount, SplitType type)
    {

        switch (type)
        {
            case EQUAL:
                List<Split> splits = new ArrayList<>();
                double individualAmount = amount/owes.size();

                for(User user: owes)
                {
                    if(paidBy.getUserId().equals(user.getUserId()))
                    {
                        splits.add(new EqualSplit(user, amount - individualAmount));
                    }
                    else
                    {
                        splits.add(new EqualSplit(user, -individualAmount));
                    }
                }
                return splits;
            default:
                return null;
        }
    }
}
