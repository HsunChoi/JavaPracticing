package com.xun.java.practing.careerup.LongestMonotonicSubsequenceIn2D;

import java.util.*;

/**
 * Created by cuixun on 2/14/16.
 */
public class LongestMonotonicSubsequenceIn2D {


    public static void main(String[] args) {
        LongestMonotonicSubsequenceIn2D demo = new LongestMonotonicSubsequenceIn2D();
        demo.displayDemo();
    }


    public void displayDemo() {
        DatabaseSimulation db = new DatabaseSimulation();
        Student[] students = db.getStudentsInfo();
        /**
         * Get the gpa order, from large to small,
         * Print the students' id by order
         * record the indexes in map.
         */
        Arrays.sort(students, Comparators.getLargeToSmallGPAComparator());
        printStudentsGpa(students);
        Map<Student, Integer> map = new HashMap<>();
        for (int i = 0; i < students.length; i++) {
            map.put(students[i], i);
        }
        /**
         * Get the sat order, from small to large.
         * Print the students' id by order
         */
        Arrays.sort(students, Comparators.getSmallToLargeSATComparator());
        printStudentsSat(students);
        /**
         * Sort student by max index of gpaIndex and satIndex, indexSum(gpaIndex + satIndex)
         */
        Queue<StudentBuffer> queue = getMonotomicQueue(students, map);
        /**
         * Remove elements which do not satisfy the order in two dimension.
         */
        List<Student> studentList = optimize(queue);
        /**
         * Print out the result sequence
         */
        printStudentMonotonic(studentList);


    }

    public Queue<StudentBuffer> getMonotomicQueue(Student[] students, Map<Student, Integer> map) {
        Queue<StudentBuffer> queue = new PriorityQueue<>(new BufferComparator());
        for (int i = 0; i < students.length; i++) {
            StudentBuffer studentBuffer = new StudentBuffer(students[i]);
            studentBuffer.gpaIndex = map.get(students[i]);
            studentBuffer.satIndex = i;
            studentBuffer.indexSum = studentBuffer.gpaIndex + studentBuffer.satIndex;
            map.put(students[i], map.get(students[i]) + i);
            queue.offer(studentBuffer);
        }
        return queue;
    }


    List<Student> optimize(Queue<StudentBuffer> queue) {
        List<Student> list = new ArrayList<>();
        StudentBuffer firstBuffer = queue.poll();
        int minSATIndex = firstBuffer.satIndex;
        int minGPAIndex = firstBuffer.gpaIndex;
        list.add(firstBuffer.student);
        while (!queue.isEmpty()) {
            firstBuffer = queue.poll();
            if (firstBuffer.gpaIndex > minGPAIndex && firstBuffer.satIndex > minSATIndex) {
                list.add(firstBuffer.student);
                minGPAIndex = firstBuffer.gpaIndex;
                minSATIndex = firstBuffer.satIndex;
            }
        }

        return list;
    }


    void printStudentsGpa(Student[] students) {
        System.out.print("Students GPA from large to small: ");
        for (Student s : students) {
            System.out.print(s.getId()
//                    + ":" + s.getGpa()
                    + " ");
        }
        System.out.println();
    }

    void printStudentsSat(Student[] students) {
        System.out.print("Students SAT from small to large: ");
        for (Student s : students) {
            System.out.print(s.getId()
//                    + ":" + s.getSat()
                    + " ");
        }
        System.out.println();
    }

    void printStudentMonotonic(List<Student> list) {
        System.out.print("Students monotonic subsequence in 2D: ");
        for (Student s : list) {
            System.out.print(s.getId() + " ");
        }
        System.out.println();
    }

}


class StudentBuffer {
    public int indexSum;
    public Student student;
    public int gpaIndex;
    public int satIndex;


    public StudentBuffer() {
    }

    public StudentBuffer(Student student) {
        this.student = student;
    }
}


/**
 * Three Aspects have to be considered.
 * 1, The max index of each student, smaller in front of the larger.
 * 2, The Index Sum of each student, smaller in front of the larger.
 * 3, The difference between gpaIndex and satIndex, smaller in front of the larger.
 */
class BufferComparator implements Comparator<StudentBuffer> {
    @Override
    public int compare(StudentBuffer s1, StudentBuffer s2) {
        int maxS1 = s1.gpaIndex > s1.satIndex ? s1.gpaIndex : s1.satIndex;
        int maxS2 = s2.gpaIndex > s2.satIndex ? s2.gpaIndex : s2.satIndex;
        if(maxS1 < maxS2){
            return -1;
        }
        if (maxS1 > maxS2){
            return 1;
        }
        if (s1.indexSum < s2.indexSum) {
            return -1;
        }
        if (s1.indexSum > s2.indexSum) {
            return 1;
        }
        return Math.abs(s1.gpaIndex - s1.satIndex) - Math.abs(s2.gpaIndex - s2.satIndex);
    }
}