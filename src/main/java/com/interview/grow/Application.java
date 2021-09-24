package com.interview.grow;

import com.interview.grow.dao.InMemoryDAOLayer;
import com.interview.grow.dao.model.Expense;
import com.interview.grow.model.EqualExpense;
import com.interview.grow.model.SplitType;
import com.interview.grow.model.User;
import com.interview.grow.service.ExpenseService;
import com.interview.grow.service.LookupService;
import com.interview.grow.utils.DemoUtility;

import java.util.ArrayList;
import java.util.List;


public class Application
{

    public static void main(String[] args)
    {
        InMemoryDAOLayer dao = new InMemoryDAOLayer();

        ExpenseService expenseService = new ExpenseService(dao);
        LookupService lookupService = new LookupService(dao);

        User userA = new User("A");
        User userB = new User("B");
        User userC = new User("C");

        List<User> users = new ArrayList<>();
        users.add(userA);
        users.add(userB);
        users.add(userC);

        //  EqualExpense requestOne = DemoUtility.createExpenseRequest(userA, 30000.0, "flatMates", users);

        expenseService.createExpense(userA, 30000.0, users, "flatMates", SplitType.EQUAL);
        expenseService.createExpense(userB, 30000.0, users, "flatMates", SplitType.EQUAL);
        expenseService.createExpense(userA, 60000.0, users, "flatMates", SplitType.EQUAL);

        List<User> usersTwo = new ArrayList<>();
        usersTwo.add(userA);
        usersTwo.add(userC);

        expenseService.createExpense(userA, 60000.0, usersTwo, "flatMatesTwo", SplitType.EQUAL);

        lookupService.showBalance(userA);

        lookupService.showBalance("flatMates");

        System.out.println("second group");

        lookupService.showBalance("flatMatesTwo");

    }
}
