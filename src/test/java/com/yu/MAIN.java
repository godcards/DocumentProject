package com.yu;

import java.util.ArrayList;
import java.util.List;

public class MAIN {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("1");
        }
        for(int i=0;i< list.size();i++){
            System.out.print(list.get(i)+"\t");
        }
        System.out.println("改变前");
        list.set(0,"0");
        list.remove("1");
        list.add(1,"9");
        for(int i=0;i< list.size();i++){
            System.out.print(list.get(i)+"\t");
        }
        System.out.println(list.size());

//        System.out.println(animal.houseName());
//        myh m = new myh();
//        m.sout();
//        house h = new house();
//        h.sout();
    }
}
abstract class people{
    public abstract void sout();
}
class myh extends people {

    @Override
    public void sout() {
        for (;;){
            System.out.print("马育杭是tm的sb"+"\t");
        }
    }
}
interface animal{
    String name = "马育杭";
    void sout();
    static String houseName(){
        return house.name;
    }
}

class house implements animal{

    @Override
    public void sout() {
        for (;;){
            System.out.println("马育杭是tm的sb"+"\t");
        }
    }
}