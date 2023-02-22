package comp2402a4;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class RyabkoTree implements PrefixStack {
        List<Integer> input_List;
        int n;
        long[] tree;

  public RyabkoTree() {

      n = 5000;
      tree = new long[n+1];
      input_List = new ArrayList<Integer>();

  }

  public void push(int x) {
      input_List.add(x);
      int index = input_List.size();

      if(index >= 5001 && n == 5000){

          n = 250000;
          System.out.println("n changed, now is " + n);
          long[] newtree = new long[n+1];

          for(int i = 0; i < input_List.size(); i++){
              int h = i + 1;
              while(h <= n){
                  newtree[h] += input_List.get(i);
                  h += h & (-h);
              }
          }

          tree = newtree;
          return;
      }
      else if(index >= 250001 && n == 250000){

          n = 1000000;
          System.out.println("n changed, now is " + n);
          long[] newtree = new long[n+1];

          for(int i = 0; i < input_List.size(); i++){
              int h = i + 1;
              while(h <= n){
                  newtree[h] += input_List.get(i);
                  h += h & (-h);
              }
          }

          tree = newtree;
          return;
      }
      else if(index >= 1000001 && n == 1000000){

          n = 2000000;
          System.out.println("n changed, now is " + n);
          long[] newtree = new long[n+1];

          for(int i = 0; i < input_List.size(); i++){
              int h = i + 1;
              while(h <= n){
                  newtree[h] += input_List.get(i);
                  h += h & (-h);
              }
          }

          tree = newtree;
          return;
      }
      else if(index >= 2000001 && n == 2000000){

          n = 4000000;
          System.out.println("n changed, now is " + n);
          long[] newtree = new long[n+1];

          for(int i = 0; i < input_List.size(); i++){
              int h = i + 1;
              while(h <= n){
                  newtree[h] += input_List.get(i);
                  h += h & (-h);
              }
          }

          tree = newtree;
          return;
      }

      while(index <= n){
          tree[index] += x;
          index += index & (-index);
      }

  }

  public int pop() {

    int index = input_List.size();
    int result = input_List.remove(input_List.size()-1);


    while(index <= n){
        tree[index] -= result;
        index += index & (-index);
    }
    return result;

  }


  public int get(int i) {
    return input_List.get(i);
  }


  public int set(int i, int x) {

      int pre_value = input_List.set(i,x);
      int index = i + 1;

      int val = x - pre_value;
      while(index <= n){
          tree[index] += val;
          index += index & (-index);
      }

      return pre_value;

  }

    public long prefixSum(int i) {
        long sum = 0;
        int index = i + 1;

        while(index>0){
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }

	public int size() {
	    return input_List.size();
	}

	public Iterator<Integer> iterator() {
        return input_List.iterator();
	}

}
