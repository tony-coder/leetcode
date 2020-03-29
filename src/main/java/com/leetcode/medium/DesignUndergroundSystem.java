package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {

}

class UndergroundSystem {
    Map<Integer,Node1> mp;
    Map<String,Node2> ans;

    public UndergroundSystem() {
        mp=new HashMap<>();
        ans=new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        mp.put(id,new Node1(stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
        Node1 node1=mp.get(id);
        Node2 node2=ans.get(node1.startStation+stationName);
        if(node2!=null){
            ans.put(node1.startStation+stationName,new Node2(node2.sum+t-node1.t,node2.cnt+1));
        }else{
            ans.put(node1.startStation+stationName,new Node2(t-node1.t,1));
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        Node2 node=ans.get(startStation+endStation);
        return node.sum/node.cnt;
    }
}

class Node1{
    String startStation;
    int t;
    public Node1(String startStation,int t){
        this.startStation=startStation;
        this.t=t;
    }
}

class Node2{
    double sum;
    int cnt;
    public Node2(){
        this.sum=0.0;
        this.cnt=0;
    }

    public Node2(double sum,int cnt){
        this.sum=sum;
        this.cnt=cnt;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */