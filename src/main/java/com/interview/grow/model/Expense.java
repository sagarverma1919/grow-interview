package com.interview.grow.model;

import java.util.Date;
import java.util.List;

public abstract class Expense
{
    private String id;
    private User paidBy;
    private Date createDate;
    private double amount;
    private String groupId;
    private List<Split> users;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public User getPaidBy()
    {
        return paidBy;
    }

    public void setPaidBy(User paidBy)
    {
        this.paidBy = paidBy;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public List<Split> getUsers()
    {
        return users;
    }

    public void setUsers(List<Split> users)
    {
        this.users = users;
    }
}
