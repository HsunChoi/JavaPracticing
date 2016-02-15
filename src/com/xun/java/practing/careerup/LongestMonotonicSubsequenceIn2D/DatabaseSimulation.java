package com.xun.java.practing.careerup.LongestMonotonicSubsequenceIn2D;

import java.util.Random;

/**
 * Created by cuixun on 2/14/16.
 */
public class DatabaseSimulation {

    public DatabaseSimulation() {
        System.out.println("Connecting the database...");
        System.out.println("Successful connecting...");
    }

    public Student[] getStudentsInfo(){
        Student[] students = new Student[20];
        Random r = new Random();
        int idGenerator = 1;
        for(int i = 0; i < students.length; i++){
            String id = Integer.toString(idGenerator);
            Student s = new Student(id);
            s.setGpa(2 + (double)r.nextInt(200) / 100);
            s.setSat(600 + r.nextInt(180) * 10);
            students[i] = s;
            idGenerator++;
        }
        return students;
    }
}
