package com.revature.list;

public class MyArrayList {
	int[] arrayList = new int[10];
	int sizeOfList = 0; //refers to the number of user added values
	//size of list will always refer to the next empty index of the array since
	//indexes start at 0, and size refers to the number of items in the list
	//ie. when their are 0 items in the list the next empty value is index 0

	public void add(int val) { //append a value to the end of the list
		//if the list is full, double its size
		if (sizeOfList == arrayList.length) {
			int[] tempList = arrayList.clone(); //save the current values
			arrayList = new int[arrayList.length * 2]; //double the size of the array
			for (int i = 0; i < sizeOfList; i++) { //add the values in the old list to the new list
				arrayList[i] = tempList[i];
			}
		}
		//add the new value to the list and increase the size
		arrayList[sizeOfList] = val;
		sizeOfList++;
	}

	public void set(int index, int val) { //set a value at a given index to the value specified
		if (index < 0 || index >= sizeOfList) return; //this should throw an IndexOutOfBoundsException
		arrayList[index] = val;
	}

	public void remove(int index) { //remove the value at the given index
		if (index < 0 || index >= sizeOfList) return; //this should throw an IndexOutOfBoundsException
		for (int i = 0, j = 0; i < sizeOfList; i++) {
			if (i != index) {
				arrayList[j] = arrayList[i];
				j++;
			}
		}
		sizeOfList--;
	}

	public int get(int index) { //return the value at the given index
		if (index < 0 || index >= sizeOfList) return -1; //this should throw an IndexOutOfBoundsException
		return arrayList[index];
	}

	@Override
	public String toString() { //return a string version of the list
		if (sizeOfList == 0) return "[]"; //this should throw an IndexOutOfBoundsException
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < sizeOfList-1; i++) {
			sb.append(arrayList[i] + ", ");
		}
		sb.append(arrayList[sizeOfList-1] + "]"); //add the last value without the space
		return sb.toString();
	}
}
