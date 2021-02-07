
/**
 * @标题: CallableFutureTest.java
 * @包名： wenjie.ye.mqtest.test.zuoye
 * @功能描述：TODO
 * @作者： wenjie.ye
 * @创建时间： 2021年2月7日 下午5:44:57
 * @version v1.0
 */

package wenjie.ye.mqtest.test.zuoye;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Future;

 
public class Demo4 {
	 public static void main(String[] args) throws ExecutionException, InterruptedException {

	        Demo4 test = new Demo4();

	        

	        // 创建一个线程池

	        ExecutorService pool = Executors.newFixedThreadPool(2);

	        // 创建两个有返回值的任务

	        Callable c1 = test.new MyCallable("A");

	        Callable c2 = test.new MyCallable("B");


	        // 执行任务并获取Future对象

	        Future f1 = pool.submit(c1);

	        Future f2 = pool.submit(c2);


	        // 从Future对象上获取任务的返回值，并输出到控制台

	        System.out.println(">>>" + f1.get().toString());

	        System.out.println(">>>" + f2.get().toString());

	        // 关闭线程池

	        pool.shutdown();

	    }

	    class MyCallable implements Callable {

	        private String oid;

	        MyCallable(String oid) {

	            this.oid = oid;

	        }

	        public Object call() throws Exception {

	            return oid + "任务返回的内容";

	        }

	    }
}
