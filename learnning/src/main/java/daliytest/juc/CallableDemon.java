package java.daliytest.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author gxr
 * @date 20191009
 */

public class CallableDemon {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<String> futureTask = new FutureTask(() -> {
			System.out.println("lambda 表达式.....");
			return "test2";
		});
		Thread thread = new Thread(futureTask);
		thread.start();
		System.out.println("返回值是：" + futureTask.get());
	}
}