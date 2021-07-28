package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBean = new MessageBeanKo(); //1:1관계, 결합도 100%
		MessageBean messageBean = new MessageBeanKo();//결합도 낮추기, 부모 = 자식(모든 부모가 자식 클래스 참조하는 역할)
		messageBean.sayHello("Spring");
	}

}