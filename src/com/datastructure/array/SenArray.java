package com.datastructure.array;


/**
 *  高级数组类，支持简单的增删改查功能，初始化固定大小，只支持int类型的元素
 *  增加支持泛型
 *  增加扩容机制
 */
public class SenArray<E> {
    private E[] data;
    private int size;

    /**
     * 有参构造函数
     * @param capacity 数组容积
     */
    public SenArray(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public SenArray(){
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
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("添加失败，index不合法");
        }
        if (size == data.length){
            resize(data.length * 2);
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
    public void addFirst(E e){
        this.add(0, e);
    }

    /**
     * 向数组尾部添加一个元素
     * @param e 要添加的元素
     */
    public void addLast(E e){
        this.add(size, e);
    }

    /**
     * 查看数组中是否包含某个元素
     * @param e 查询的元素
     * @return boolean
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
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
    public int find(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
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
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed ! Index is illegal");
        }
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        E res = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return res;
    }

    /**
     * 删除数组中的第一个元素
     * @return
     */
    public E removeFirst(){
        return this.remove(0);
    }

    /**
     * 删除数组中指定元素
     * @param e
     */
    public void removeElement(E e){
        int index = this.find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder(String.format("PriArray size:%d  capacity:%d\n", size, data.length));
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
    public E get(int index){
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
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed! Index is illegal");
        }
        data[index] = e;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
