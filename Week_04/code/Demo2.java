
/**
 * @标题: Demo2.java
 * @包名： wenjie.ye.mqtest.test.zuoye
 * @功能描述：TODO
 * @作者： wenjie.ye
 * @创建时间： 2021年2月7日 下午5:08:37
 * @version v1.0
 */

package wenjie.ye.mqtest.test.zuoye;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("rawtypes")
class  MyCallable implements Callable{
	
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return "MyCallable return";
	}
}


public class Demo2  {
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
	            ExecutorService executorService = Executors.newCachedThreadPool();
		        @SuppressWarnings({ "unchecked", "rawtypes" })
				Future future = executorService.submit(new MyCallable());
		        if(!future.isDone())
		           System.out.println("task has not finished!");
		         System.out.println(future.get());
	
	}
}
