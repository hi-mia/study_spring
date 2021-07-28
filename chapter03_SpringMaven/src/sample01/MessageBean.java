package sample01;

public interface MessageBean {
	public void showPrintBefore();
	public void viewPrintBefore(); //얘네들은 원하는 거 삽입 -> Pointcut임

	public void showPrintAfter();
	public void viewPrintAfter();

	public String showPrint();
	public void viewPrint();
	
	public void display(); //얘한테는 삽입X

	//여기까지 죄다 조인포인트
}
