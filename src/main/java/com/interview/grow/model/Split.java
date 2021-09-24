package com.interview.grow.model;

public abstract class Split
{
    private User owes;
    private double amount;

    public Split(User owes, double amount)
    {
        this.owes = owes;
        this.amount = amount;
    }

    public User getOwes()
    {
        return owes;
    }

    public void setOwes(User owes)
    {
        this.owes = owes;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }
}
