/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_visit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Mat Nguyen
 */
public class BFS_VISIT {
    int n;
    int m; // start
    int k; // end
    Set<Integer> V;
    Map<Integer, Set<Integer>> A;
    int[] p; // p[u] = v; 
    Queue<Integer> Q;
    int count; // số cạnh nhỏ nhất đi qua
    

    public BFS_VISIT(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BFS_VISIT bfs = new BFS_VISIT();
        bfs.input();
    }
    
    public void input(){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        p = new int[n + 1];
        V = new HashSet<Integer>();
        A = new HashMap<Integer, Set<Integer>>();   
        // new Queue
        Q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            V.add(a);
            A.put(a, new HashSet<Integer>());
        }
        int canh = 0;
        while(++canh != 0) {
            int u = in.nextInt();
            if(u == -1)
                break;
            else {
                int v = in.nextInt();
                A.get(u).add(v);
                A.get(v).add(u);
            }
        }
        BFS_visit();
    }
           
    public void BFS_visit(){
        for(int i = 1; i <= n; i++){
            p[i] = -1;
        }
        //p[m] = m;
        Q.add(m);
        while(Q.size() > 0){
            int u = Q.poll();
            for(int v: A.get(u)){ // duyet tat ca cac dinh ke cua u
                if(p[v] == -1){
                    p[v] = u;
                    if(v == k)
                        break;
                    Q.add(v);
                }
            }
            //count++;
        }
        if(p[k] == -1){
            System.out.println("Không tìm thấy đường đi");
        } else {
            printResult();
        }
    }
    public void printResult(){
        int x = k;
        System.out.print(x + " ");
        int len = 0;
        while(x != m){
            len++;
            x = p[x];
            System.out.print(x + " ");
        }
        System.out.println("");
        System.out.println(len + "");
       
    }
    
}
