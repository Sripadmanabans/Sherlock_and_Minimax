package sherlock_and_minimax;

import java.util.Scanner;

public class SherlockMiniMax 
{
	public static void swap(int ar[], int i, int j) 
	{
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	public static int partition(int ar[], int left, int right)
	{
		int pivotValue = ar[left];
		int pivotIndex = left;
		swap(ar, pivotIndex, right);
		int index = left;
		for(int i = left; i < right; i++)
		{
			if(ar[i] < pivotValue)
			{
				swap(ar, index, i);
				index++;
			}
		}
		swap(ar, index, right);
		return index;
	}
	
	public static void sort(int ar[], int l, int u) 
	{
		if(l < u)
		{
			int pivot = partition(ar, l, u);
			sort(ar, l, pivot - 1);
			sort(ar, pivot + 1, u);
		}
	}	
	
	public static int mini(int a[], int p) 
	{
		int l = 0;
		int u = a.length - 1;
		int mid = -1, min = -1;
		while(l <= u)
		{
			mid = ( l + u ) / 2;
			if(p > a[mid])
			{
				l = mid + 1;
			}
			if(p < a[mid])
			{
				u = mid - 1;
			}
			if(a[mid] == p)
			{
				return 0;
			}
		}
		if(mid < a.length - 1 && mid > 0)
		{
			min = Math.min(Math.abs(a[mid + 1] - p), Math.abs(a[mid] - p));
			min = Math.min(min, Math.abs(a[mid - 1] - p));
		}	
		if(mid == a.length - 1)
		{
			min = Math.min(Math.abs(a[mid] - p), Math.abs(a[mid - 1] - p));
		}
		if(mid == 0)
		{
			min = Math.min(Math.abs(a[mid] - p), Math.abs(a[mid + 1] - p));
		}
		return min;
	}
	
	public static void main(String args[]) 
	{
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = sr.nextInt();
		}
		int p = sr.nextInt();
		int q = sr.nextInt();
		sort(a, 0, a.length - 1);
		int min, value = p;
		min = mini(a, p);
		for(int i = p + 1; i <= q; i++)
		{
			int temp = mini(a, i);
			if(temp > min)
			{
				min = temp;
				value = i;
			}
		}
		System.out.println(value);
		sr.close();
	}
}
