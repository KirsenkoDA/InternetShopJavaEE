package ru.andrew.test11;

import java.util.List;
import java.util.ArrayList;

public class Users
{
    private List<User> data = new ArrayList<User>();
    public Users()
    {
        data.add(new User(1, "Остап Бендер"     ));
        data.add(new User(2, "Киса Воробьянинов"));
    }
    public List<User> getData()
    {
        return data;
    }
    public void setData(List<User> data)
    {
        this.data = data;
    }
}