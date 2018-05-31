package com.yui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;





public class DemoTest3 {

	public static void main(String[] args)  {
		
	
		
	int[] m = {2,5,2,1,3,4,0,9,8,9,8,3,1,0};
	List<Integer> X = new ArrayList<>();
//	Collections.addAll(X, m);
//	System.out.println(sort_p(X,0,X.size()-1));
	//int[] c =sort_pA(m, 0, m.length-1);
	int[] c =quick_sort_ex(m,0, m.length-1);
	for(int x:c){
		System.out.println(x);
	}

	}
	
	// 归并
	public static  int[]  sort_pA(int[] A,int p,int r){
		if(p<r){
			int q=(p+r)>>1;
			sort_pA(A,p,q);
			sort_pA(A,q+1,r);
			sortA(A,p,q,r);
		}
		
		
		return A;
		
	}
	public static void sortA(int[] A,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] B = new int[n1];
		int[] C = new int[n2];
		for(int i=0;i<n1;i++){
			B[i] = A[p+i];
		}
		for(int i=0;i<n2;i++){
			C[i] = A[q+i+1];
		}
		int j=0;int k=0;
		for(int i =p;i<r+1;i++){
			if(k>=C.length||(j<B.length&&B[j]<=C[k])){
				A[i] = B[j];
				j++;
			}else if(j>=B.length||(k<C.length&&B[j]>C[k])){
				A[i] = C[k];
				k++;
			}
			
		}		
		
	}
	
	//冒泡
	
	public static int[] bubble_sort(int[] A) {
		
		for(int i=0;i<A.length-1;i++){
			
			for(int j=0;j<A.length-i-1;j++){
				if(A[j]>A[j+1]){
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
				
			}
		}
		return A;
		
	}
	
	
	
	//插入
	
	public static int[] insert_sort(int[] A) {
		
		for(int j=1;j<A.length;j++){
			
			int key = A[j];
			int i = j-1;
			while(i>=0&&A[i]>key){
				A[i+1]=A[i];
				i = i-1;
				
			}
			A[i+1]=key;
		}
		return A;
		
	}
	
	//选择
	
	public static int[] selection_sort(int[] A) {
		
	int temp = 0;   int min = 0;
	
	for(int i = 0;i<A.length;i++){
		temp=i;
		for(int j = i+1;j<A.length;j++){
			
			if(A[j]<A[temp]){
				
				temp = j;
				
			}
			
			
		}
		min = A[temp];
		A[temp] = A[i];
		A[i] = min;
		
	}
		return A;
		
	}
	
	//快速
	
	public static int[] quick_sort(int[] A,int start,int end) {
		if(start>=end){
			return A;
		}
		int B[]  = new int[end-start+1];
		int s = 0; int e = B.length-1;
		for(int i=start+1;i<end+1;i++){
			
			if(A[i]<A[start]){
				
				B[s] = A[i];
				s++;
			}else{
				B[e] = A[i];
				e--;
			}
		}
		B[s] = A[start];
		for(int i=0;i<B.length;i++){
			A[i+start]=B[i];
		}
		quick_sort(A,start,s+start-1);
		
		quick_sort(A,s+start+1,end);
		
		return A;
		
	}
	
	//快速  in-place
	
	public static int[] quick_sort_ex(int[] A,int start,int end) {
		if(start>=end){
			return A;
		}
		int pivot = A[end];
		int temp = 0;
		int i = start-1;
		for(int j=start;j<=end-1;j++){
			if(A[j]<=pivot){
				i = i + 1;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
			
		}
		temp = A[i+1];
		A[i+1] = A[end];
		A[end] = temp;
		
		quick_sort_ex(A,start,i);
		
		quick_sort_ex(A,i+2,end);
		
		return A;
		
	}
	
	
	
	
}
