package com.xun.java.practing.leetcode;

import java.io.PrintWriter;

/**
 * Created by cuixun on 5/9/15.
 */
public class MyThread extends Thread{

        public static int x;
        public static int foo(int y)
        {
            return y * 2;
        }
    public static void aMethod() throws Exception
    {
        try /* Line 5 */
        {
            throw new Exception(); /* Line 7 */
        }
        finally /* Line 9 */
        {
            System.out.print("finally "); /* Line 11 */
        }
    }
    public static void main(String args[])
    {
        try
        {
            aMethod();
        }
        catch (Exception e) /* Line 20 */
        {
            System.out.print("exception ");
        }
        System.out.print("finished"); /* Line 24 */
    }
    /**
        public static void main(String [] args)
        {

            String s = "foo";
            Object o = (Object)s;
            if (s.equals(o))
            {
                System.out.print("AAA");
            }
            else
            {
                System.out.print("BBB");
            }
            if (o.equals(s))
            {
                System.out.print("CCC");
            }
            else
            {
                System.out.print("DDD");
            }
/**
                java.io.PrintWriter out = new PrintWriter(PrintWriter);
                new java.io.OutputStreamWriter(System.out,true);
                out.println("Hello");

            /**
            int x = 0;
            assert (x > 0) ? "assertion failed" : "assertion passed" ;
            System.out.println("finished");
            /**int z = 5;
            assert z > 0; /* Line 11
            assert z > 2: foo(z); /* Line 12
            if ( z < 7 )
                assert z > 4; /* Line 14

            switch (z)
            {
                case 4: System.out.println("4 ");
                case 5: System.out.println("5 ");
                default: assert z < 10;
            }

            if ( z < 10 )
                assert z > 4: z++; /* Line 22
            System.out.println(z);
            */
        //}
        /**
         * public static void main(String [] args)
         {
        int I = 0;
        outer:
        while (true)
        {
            I++;
            inner:
            for (int j = 0; j < 10; j++)
            {
                I += j;
                if (j == 3)
                    continue inner;
                break outer;
            }
            continue outer;
        }
        System.out.print(I);
         */
        /**System.out.println(I);
        MyThread t = new MyThread();
        t.start();
        System.out.print("one. ");
        t.start();
        System.out.print("two. ");
         */
    //}
    public void run()
    {
        System.out.print("Thread ");
    }
}
