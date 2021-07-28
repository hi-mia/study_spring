package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageBeanImpl implements MessageBean {
	//chapter02에서처럼 생성자/setter를 호출한 것이 아니다.
	//private @Value("사과") String fruit; // private String fruit = "사과";
	//private @Value("1000") int cost; // private int cost = 1000;
	//private @Value("5") int qty; // private int qty = 5;

	private String fruit;
	private int cost;
	private int qty;

   public MessageBeanImpl(@Value("사과") String fruit) {
	this.fruit = fruit;
	}
   
   @Autowired
   public void setCost(@Value("1000") int cost) {
	   this.cost = cost;
   }
   
   @Autowired
   public void setQty(@Value("5") int qty) {
	   this.qty = qty;
   }
	   
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