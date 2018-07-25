/**
 * An implementation of the MapADT interface using an AVL tree.
 * Empty trees are used to represent children that aren't present.
 * 
 * @author John Donaldson
 */

import java.util.*;

public class MyTreeMap<K extends Comparable<? super K>,V> 
implements MapADT<K,V> {

   K key;
   V value;
   MyTreeMap<K,V> left,right;
   int size;
   int height;
   
   private boolean debug = false;
   
   public V get(K searchKey) {
      V result;
      if(isEmpty()) result = null; 
      else if(key.compareTo(searchKey) == 0) result = value;
      else if(key.compareTo(searchKey) < 0) result = right.get(searchKey);
      else result = left.get(searchKey);
      return result;
   }
   
   // TODO - implement me too! - and add some comments
   public V put(K key, V value){
    V result;
    if(isEmpty()){
      this.key = key;
      this.value = value;
      this.left = new MyTreeMap<K,V>();
      this.right = new MyTreeMap<K,V>();
      this.height = 0;
      this.size = 1;
      result = null;
    }
    else if(this.key.compareTo(key) == 0){
      result = this.value;
      this.value = value;
    }
    else{
      if(this.key.compareTo(key) < 0)
        result = this.right.put(key,value);
      else
        result = this.left.put(key,value);
      if(Math.abs(left.height-right.height) > 1)
        restructure();
      setHeight();
      setSize();      
    }
    return result;
   }
     
   private void restructure() {

      MyTreeMap<K,V> a, b, c, t0, t1, t2, t3;
      
      if (left.height > right.height) {

         if (left.left.height > left.right.height) {

            if (debug) System.err.println("Single right rotation at: "+key);
            
            c = this;
            b = this.left;
            a = this.left.left;

            t0 = a.left;
            t1 = a.right;
            t2 = b.right;
            t3 = c.right;
         } else {

            if (debug) System.err.println("Double right rotation at: "+key);
            
            c = this;
            a = this.left;
            b = this.left.right;
            
            t0 = a.left;
            t1 = b.left;
            t2 = b.right;
            t3 = c.right;     
         }
      } else {
         if (right.right.height > right.left.height) {

            if (debug) System.err.println("Single left rotation at: "+key);
            
            a = this;
            b = this.right;
            c = this.right.right;

            t0 = a.left;
            t1 = b.left;
            t2 = c.left;
            t3 = c.right;
         } else {

            if (debug) System.err.println("Double left rotation at: "+key);
            
            a = this;
            c = this.right;
            b = this.right.left;
            
            t0 = a.left;
            t1 = b.left;
            t2 = b.right;
            t3 = c.right;
         }
      }
      
      
      MyTreeMap<K, V> newLeft = new MyTreeMap<K, V>(a.key,a.value,t0,t1);
      MyTreeMap<K, V> newRight = new MyTreeMap<K, V>(c.key,c.value,t2,t3);
      a.left = t0;
      a.right = t1;
      c.left = t2;
      c.right = t3;

      this.key = b.key;
      this.value = b.value;
      this.left = newLeft;
      this.right = newRight;
   }
   
   public MyTreeMap(){
      this(null,null,null,null);
      this.size = 0;
      this.height = -1;
   }
   
   protected MyTreeMap(K key, V value, MyTreeMap<K, V> left, MyTreeMap<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
      setHeight();
      setSize();
   }
   
   
   protected MyTreeMap(K key, V value) {
      this(key,value,new MyTreeMap<K,V>(), new MyTreeMap<K,V>());
      height = 0;
      size = 1;
   }
   
   public boolean isEmpty(){
      return left==null && right==null;
   } 
   
   public boolean isLeaf() {
      return !isEmpty() && left.isEmpty() && right.isEmpty();
   }
   
   private String toStringHelper(){
      StringBuilder sbuf = new StringBuilder();
      toStringHelper(sbuf);
      return sbuf.toString();
   }
   
   private void toStringHelper(StringBuilder sbuf) {
      if(isEmpty())
         return;
      else {
         if(!left.isEmpty()) {
            left.toStringHelper(sbuf);
            sbuf.append(",");
         }
         sbuf.append( "("+key+":"+value+")" );
         if(!right.isEmpty()) {
            sbuf.append(",");
            right.toStringHelper(sbuf);
         }
      }
   }
   
   public String toString(){
      return "[" + toStringHelper() + "]";
   }
   
   private void setHeight() {
      if (isEmpty()) 
         this.height = -1;
      else    
        this.height = 1+Math.max(left.height,right.height);
   }
   
   private void setSize(){
      if(isEmpty())
         this.size = 0;
      else
         this.size = 1+left.size+right.size;
   }
   
   public int size(){return this.size;}
   
   public int getHeight(){return this.height;}
   
   
   public Iterator<K> keys() {
      List<K> list = new LinkedList<K>();
      addKeysToList(list);
      return list.iterator();
   }
   
   private void addKeysToList(List<K> l) {
      if (!isEmpty()){
         this.left.addKeysToList(l);
         l.add(this.key);
         this.right.addKeysToList(l);
      }
   }
   
   public Iterator<Map.Entry<K, V>> entries() {
      List<Map.Entry<K,V>> list = new LinkedList<Map.Entry<K,V>>();
      addEntriesToList(list);
      return list.iterator();
   }
   
   private void addEntriesToList(List<Map.Entry<K, V>> list) {
      if (!isEmpty()){
         this.left.addEntriesToList(list);
         list.add(new AbstractMap.SimpleEntry<K,V>(key,value));
         this.right.addEntriesToList(list);
      }
   }    
}
