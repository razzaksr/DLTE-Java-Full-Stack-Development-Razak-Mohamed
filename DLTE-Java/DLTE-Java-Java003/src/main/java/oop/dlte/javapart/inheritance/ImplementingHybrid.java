package oop.dlte.javapart.inheritance;

import java.util.Arrays;

public class ImplementingHybrid {
    public static void main(String[] args) {
        Find find=new Find();
        find.spiralCopy();
        find.listAll();
        System.out.println(find.performBinary(7800));
        System.out.println(find.performBinary(12000));
    }
}

/*
Hybrid:

Hierarchy
Performing
ImplementingSingle
Span

Single
Span
Find    >> binarySearch
 */

class Find extends Span{
    public int performBinary(int desiredWorth){
        Arrays.sort(report);
        listAll();
        return search(desiredWorth,0,report.length-1);
    }
    int search(int desiredWorth,int start,int end){
        if(end>=start){
            int midPoint=start+(end-start)/2;
            if(report[midPoint]==desiredWorth){
                return midPoint;
            }
            else if(report[midPoint]<desiredWorth){
                return search(desiredWorth,midPoint+1,end);
            }
            else if(report[midPoint]>desiredWorth){
                return search(desiredWorth,start,midPoint-1);
            }
        }
        return -1;
    }
}