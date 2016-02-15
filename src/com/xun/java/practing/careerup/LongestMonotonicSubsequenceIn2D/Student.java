package com.xun.java.practing.careerup.LongestMonotonicSubsequenceIn2D;

/**
 * Created by cuixun on 2/14/16.
 */

/**
 * Entity class
 */
public class Student {
    String id;
    double gpa;
    int sat;
    public Student(){

    }

    public Student(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id.equals(student.id);

    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id);
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }
}
