package practice.sk47kt.singleton;

public class StatefulService {

    //private int price; // 상태유지 필드

    public int order(String name,int price){
        System.out.println("name = " + name + "price = " + price);
        //this.price = price; //문제사항
        return price;
    }

    /*public int getPrice(){
        return price;
    }*/
}
