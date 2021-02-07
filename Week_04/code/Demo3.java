package wenjie.ye.mqtest.test.zuoye;

import java.util.concurrent.CountDownLatch;
 class Test {
	 public int test_methods(){
		return 100;
	 }
 }
public class Demo3 {
	static int i;
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		Test test_demo = new Test();
		for (int i = 0; i < 1; i++) {
			new Thread(() ->{
				
			  System.out.println(Thread.currentThread().getName());
			  int test  = test_demo.test_methods();
			  Demo3.i =test;
			 countDownLatch.countDown();
			},i+""+"号线程").start();
		}
		countDownLatch.await();
		System.out.println(Demo3.i);
	}
	
	
}
