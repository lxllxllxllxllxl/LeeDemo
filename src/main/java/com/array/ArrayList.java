package com.array;

import java.util.Arrays;

/**
 * @Author: lxl_a
 * @Date: 2020/11/19 11:08
 * @Description: 自定义ArrayList
 */
public class ArrayList implements List{

	transient Object[] dataStore;
	private int size;

	/**
	 * The maximum size of array to allocate.
	 * Some VMs reserve some header words in an array.
	 * Attempts to allocate larger arrays may result in
	 * OutOfMemoryError: Requested array size exceeds VM limit
	 */
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	/**
	 * Default initial capacity.
	 */
	private static final int DEFAULT_CAPACITY = 10;

	private static final Object[] EMPTY_ELEMENTDATA = {};

	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	public ArrayList(int initialCapacity) {
		if(initialCapacity>0) {
			this.dataStore = new Object[initialCapacity];
		} else if(initialCapacity==0) {
			this.dataStore = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+
					initialCapacity);
		}
	}

	public ArrayList() {
		this.dataStore = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	private String outOfBoundsMsg(int index) {
		return "Index: "+index+", Size: "+size;
	}

	private static int calculateCapacity(Object[] dataStore, int minCapacity) {
		if (dataStore == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			return Math.max(DEFAULT_CAPACITY, minCapacity);
		}
		return minCapacity;
	}

	@Override
	public int Size() {
		return size;
	}

	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	@Override
	public Object Get(int index) {
		rangeCheck(index);
		return dataStore[index];
	}

	@Override
	public void Set(int index, Object newval) {
		rangeCheck(index);
		dataStore[index] = newval;
	}

	@Override
	public void Insert(int index, Object newval) {
		rangeCheck(index);
		dataStore = Arrays.copyOf(dataStore,size+1);
		System.arraycopy(dataStore,index,dataStore,index+1,size-index);
		dataStore[index] = newval;
		size++;
	}

	@Override
	public void Append(Object newval) {
		int minCapacity = calculateCapacity(dataStore,size+1);
		if (minCapacity-dataStore.length>0) {
			grow(minCapacity);
		}
		dataStore[size++] = newval;
	}

	//扩容
	private void grow(int minCapacity) {
		int oldCapacity = dataStore.length;
		int newCapacity = oldCapacity+ (oldCapacity >> 1);
		if (newCapacity<minCapacity) {
			newCapacity = minCapacity;
		}
		dataStore = Arrays.copyOf(dataStore,newCapacity);
	}

	@Override
	public ArrayList Clear() {
		dataStore = new Object[DEFAULT_CAPACITY];
		size = 0;
		return this;
	}

	@Override
	public void Delete(int index) {
		rangeCheck(index);
		if (index==size-1) {
			dataStore= Arrays.copyOf(dataStore,index);
		} else {
			while (index<size-1) {
				dataStore[index] = dataStore[index+1];
				index++;
			}
			dataStore= Arrays.copyOf(dataStore,size-1);
		}
		size--;
	}
}
