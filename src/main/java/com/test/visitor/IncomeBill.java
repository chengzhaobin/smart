package com.test.visitor;

import java.util.Arrays;

public class IncomeBill extends AbstractBill{

	public IncomeBill(double amount, String item) {
		super(amount, item);
	}
	public void accept(Viewer viewer) {
		 if (viewer instanceof AbstractViewer) {
	            ((AbstractViewer)viewer).viewIncomeBill(this);
	            return;
	        }
		viewer.viewAbstractBill(this);
	}
	public static int sort(int[] a) {
		int index=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]<a[index]) 
				index=i;
		}
		return a[index];
	}
	
	public static void sort1(int[] numbers) {
		 int size = numbers.length, temp;   
	        for (int i = 0; i < size; i++) {   
	            int k = i;   
	            for (int j = size - 1; j > i; j--) {   
	                if (numbers[j] < numbers[k])   
	                    k = j;   
	            }   
	            temp = numbers[i];   
	            numbers[i] = numbers[k];   
	            numbers[k] = temp;   
	        }   
	}
public static void main(String[] args) {
	int[] a=new int[] {3,8,1,7,5,3,9,4};
	sort2(a);
	for(int i=0;i<a.length;i++) {
		System.out.println(a[i]);
	}
}
public static void sort2(int a[]) {
	int size=a.length,tmp;
	for(int i=0;i<size;i++) {
		int k=i;
		for(int j=size-1;j>i;j--) {
			if(a[j]>a[k]) {
				k=j;
			}
		}
		tmp=a[i];
		a[i]=a[k];
		a[k]=tmp;
	}
	Arrays.sort(a);
}

}
