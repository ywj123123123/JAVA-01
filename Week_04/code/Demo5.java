
/**
 * @标题: Demo5.java
 * @包名： wenjie.ye.mqtest.test.zuoye
 * @功能描述：TODO
 * @作者： wenjie.ye
 * @创建时间： 2021年2月7日 下午5:54:05
 * @version v1.0
 */

package wenjie.ye.mqtest.test.zuoye;


 

public class Demo5 {
	private static   int result=0;
	
	public static void main(String[] args) throws InterruptedException {
		   Thread thread = new Thread(() -> {
	            result = 100;
	        });
		   
		   thread.start();
		   thread.sleep(3000);
		   while ( thread.isAlive()) {
			   result=100;
	       }
		   System.out.println(result);
	}

}
