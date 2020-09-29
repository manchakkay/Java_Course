package com.manchakkay.cnc;

import java.util.ArrayList;
import java.util.Collections;

abstract class Course implements Comparable<Course> {
    abstract int getGroupsAmount();

    int students_amount;
    int group_size;

    @Override
    public int compareTo(Course second)
    {
        return Double.compare(this.getGroupsAmount(), second.getGroupsAmount());
    }

    @Override
    public boolean equals(Object second)
    {
        if (second == this) {
            return true;
        }
        if (second == null || second.getClass() != this.getClass()) {
            return false;
        }

        return false;
    }

    @Override
    public String toString()
    {
        return "(Students: " + this.students_amount + ", Groups: " + getGroupsAmount() + ")";
    }
}

class LittleGroups extends Course
{
    LittleGroups(int students)
    {
        this.students_amount = students;
        this.group_size = 10;
    }

    @Override
    int getGroupsAmount() {
        return (int)Math.ceil((double)students_amount / group_size);
    }

    @Override
    public String toString()
    {
        return "(Little - Students: " + this.students_amount + ", Groups: " + getGroupsAmount() + ")";
    }
}

class BigGroups extends Course
{
    BigGroups(int students)
    {
        this.students_amount = students;
        this.group_size = 25;
    }

    @Override
    int getGroupsAmount() {
        return (int)Math.ceil((double)students_amount / group_size);
    }

    @Override
    public String toString()
    {
        return "(Big - Students: " + this.students_amount + ", Groups: " + getGroupsAmount() + ")";
    }
}

class SemiGroups extends Course
{
    SemiGroups(int students)
    {
        this.students_amount = students;
    }

    @Override
    int getGroupsAmount() {
        int groups = 0;
        int students = students_amount;

        while (students > 0){
            students -= (10 * ((groups % 2)*1.5 + 1));
            groups++;
        }

        return groups;
    }

    @Override
    public String toString()
    {
        return "(Semi - Students: " + this.students_amount + ", Groups: " + getGroupsAmount() + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> List = new ArrayList<>();
        List.add(new LittleGroups(70));
        List.add(new BigGroups(90));
        List.add(new BigGroups(720));
        List.add(new SemiGroups(200));
        List.add(new SemiGroups(240));

        Collections.sort(List);
        System.out.println(List.toString());
    }
}