package com.datastructure.array;

/**
 * 数组类，支持简单的增删改查功能，初始化固定大小，只支持int类型的元素
 */
public class Array1 {
    private int[] data;
    private int size;

    /**
     * 有参构造函数
     * @param capacity 数组容积
     */
    public Array1(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public Array1(){
        this(10);
    }

    /**
     * 获取数组当前的元素个数
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 获取数组的容积
     * @return
     */
    public int getCapacity(){
        return this.data.length;
    }

    /**
     * 向数组的指定位置添加元素
     * @param index 指定元素位置
     * @param e 添加的内容
     */
    public void add(int index, int e){
        if (size >= data.length){
            throw new IllegalArgumentException("添加失败，数组容积已满");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("添加失败，index不合法");
        }
        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向数组头部添加一个元素
     * @param e 添加的元素
     */
    public void addFirst(int e){
        this.add(0, e);
    }

    /**
     * 向数组尾部添加一个元素
     * @param e 要添加的元素
     */
    public void addLast(int e){
        this.add(size, e);
    }

    /**
     * 查看数组中是否包含某个元素
     * @param e 查询的元素
     * @return boolean
     */
    public boolean contains(int e){
        for (int i = 0; i < size; i++){
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 找到数组某个元素的位置，如果存在返回该位置，不存在返回-1
     * @param e
     * @return
     */
    public int find(int e){
        for (int i = 0; i < size; i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置的元素
     * @param index 指定位置
     * @return
     */
    public int remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed ! Index is illegal");
        }
        int res = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        return res;
    }

    /**
     * 删除数组中的第一个元素
     * @return
     */
    public int removeFirst(){
        return this.remove(0);
    }

    /**
     * 删除数组中指定元素
     * @param e
     */
    public void removeElement(int e){
        int index = this.find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder(String.format("Array1 size:%d  capacity:%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if (i != size - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 查询指定位置的元素
     * @param index 指定位置
     * @return
     */
    public int get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed ! Index is illegal");
        }
        return data[index];
    }

    /**
     * 更新指定位置的值
     * @param index 指定位置的元素
     * @param e 更新的内容
     */
    public void set(int index, int e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed! Index is illegal");
        }
        data[index] = e;
    }
}