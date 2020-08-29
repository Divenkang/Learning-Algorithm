package JAVA_Interface.compara;

// 记录Comparable and Comparator两个接口的差异

/**
 * 1.Comparable 是排序接口
 * 若一个类实现了Comparable接口，就意味着“该类支持排序”。
 * 即然实现Comparable接口的类支持排序，
 * 假设现在存在“实现Comparable接口的类的对象的List列表(或数组)”，
 * 则该List列表(或数组)可以通过 Collections.sort（或 Arrays.sort）进行排序。
 *
 * 此外，“实现Comparable接口的类的对象”可以用作“有序映射(如TreeMap)”中的键
 * 或“有序集合(TreeSet)”中的元素，而不需要指定比较器。
 *
 * Comparable 接口仅仅只包括一个函数，定义如下
 *  public interface Comparable<T>{
 *      public int compareTo(T o )
 *  }
 */


/**
 * 2.Comparator 是比较器接口
 * 若需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)；
 * 那么，我们可以建立一个“该类的比较器”来进行排序。这个“比较器”只需要实现Comparator接口即可。
 * public interface Comparator<T> {
 *
 *     int compare(T o1, T o2);
 *
 *     boolean equals(Object obj);
 * }
 *
 * 2.1若一个类要实现Comparator接口：它一定要实现compareTo(T o1, T o2) 函数，
 * 但可以不实现 equals(Object obj) 函数。为什么可以不实现 equals(Object obj) 函数呢？ 因为任何类，默认都是已经实现了equals(Object obj)的。
 * Java中的一切类都是继承于java.lang.Object，
 * 在Object.java中实现了equals(Object obj)函数；
 * 所以，其它所有的类也相当于都实现了该函数。
 *
 * 2.2 int compare(T o1, T o2) 是“比较o1和o2的大小”。返回“负数”，意味着“o1比o2小”；
 * 返回“零”，意味着“o1等于o2”；返回“正数”，意味着“o1大于o2”。
 *
 */



public class ble_tor {

}
