package oop.dlte.javapart.inheritance;

import java.util.Arrays;

public class ImplementHierarchy {
    public static void main(String[] args) {
        Span span=new Span();
        span.spiralCopy();
        span.listAll();

        ImplementingSingle single=new ImplementingSingle();
        single.traverse();
        single.sumLocker();
    }
}

class Span extends Performing{
    /*
    lockers: 3
 -1   0     1     2
    34500,12000,80000   >>0
    4500,23000,10000    >>1
    7600,34000,12000    >>2

    spiral copy of inside out >> 23000,4500,7600,34000,12000,10000,80000,12000,34500
     */
    int[] report=new int[lockers.length*lockers[0].length];

    public void listAll(){
        Arrays.parallelSort(report,3,7);
        System.out.println(Arrays.toString(report));
    }

    public void spiralCopy(){
        int row=1, column=1, index=0;
        for(;column>=0;column--,index++){
            report[index]=lockers[row][column];// 1,1>>0 ; 1,0>>1 ; 1,-1
        }
        column++;// -1 >> 0
        row++;
        for(;column<lockers[row].length;column++,index++){
            report[index]=lockers[row][column];// 2,0>> 2; 2,1>>3; 2,2>>4; 2,3
        }
        column--;
        row--;
        for(;row>=0;row--,index++){
            report[index]=lockers[row][column];// 1,2>> 5; 0,2>>6; -1,2
        }
        row++;column--;
        for(;column>=0;column--,index++){
            report[index]=lockers[row][column];// 0,1 >> 7; 0,0 >> 8
        }
    }
}