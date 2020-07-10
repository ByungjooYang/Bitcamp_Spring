package sample02;

public class HelloSpring {
	public static void main(String[] args) {
		//MessageBeanKo messageBeanKo = new MessageBeanKo(); // 결합도 100% 1:1 관계.
		
		MessageBean messageBean = new MessageBeanKo(); //부모 -자식(다형성), 결합도 낮춤.
		messageBean.sayHello("Spring");
	}

}
