 
 

package wenjie.ye.mqtest.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
 

public class Demo1  implements Callable<String>{
	
	
	@Override
	public String call() throws Exception {
		System.out.println("正在执行 ：   "+Thread.currentThread().getName());
		Thread.sleep(1000);
		return "子线程返回值";
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
     		 
     		Demo1 threadmy = new Demo1();
     		
     		FutureTask<String> task1 = new FutureTask<String>(threadmy);
     		
     		new Thread(task1, "Thread1 with return value").start();
     	 
     		 while(!task1.isDone()){
     			  System.out.println(task1.get());
     		 }
     		Thread.currentThread().stop();
     		 
	}
	

}
