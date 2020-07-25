package com.daliy.gof.prototype;

/**
 * @author Lenovo
 * @date 2020/7/4 19:25
 * 原型模式：
 * 第一步，定义实现Cloneable接口的抽象类
 * 第二步，写实现类继承抽象类
 * 第三步，缓存起来可以克隆的实体，并提供获取方法，返回原实体的克隆版本
 * 说白了就是，内存中保留对象的缓存，每次获取时提供克隆版本。
 * 适用场景，初始化复杂对象或者需要多次查库，开销比较高时，使用原型模式快速创建对象。
 *
 * 思考：深浅克隆问题？
 * 浅克隆：基本类型和引用类型都是克隆值，而引用类型是地址，所以克隆前后对象，
 * 引用类型属性指向同一个对象；修改克隆后对象引用类型属性值时，会修改原始对象的值。
 *
 * 那么如何实现深克隆？
 * 1、重写clone方法实现
 * 2、通过序列化与反序列化实现
 */
public abstract class Shape implements Cloneable{
    private String id;
    public String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
