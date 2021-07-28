package sample01;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
   @NonNull
   private String fruit;
   @Setter
   private int cost, qty;
   
   

//   public MessageBeanImpl(String fruit) {
//      super();
//      this.fruit = fruit;
//   }
//   
//   
//
//   public void setQty(int qty) {
//      this.qty = qty;
//   }
//
//
//   public void setCost(int cost) {
//      this.cost = cost;
//   }


   @Override
   public void sayHello() {
      System.out.println("과일명 : " + fruit +"\t단가 : " + cost + "\t개수 : " + qty);
   }
   @Override
   public void sayHello(String fruit, int cost) {
      System.out.println("과일명 : " + fruit +"\t단가 : " + cost + "\t개수 : " + qty);
      
   }
   @Override
   public void sayHello(String fruit, int cost, int qty) {
      System.out.println("과일명 : " + fruit +"\t단가 : " + cost + "\t개수 : " + qty);
      
   }
}