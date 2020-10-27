package chapter14;

public class v14_1 {
	public static void main(String[] args) throws InterruptedException{
		t2();
		
	}
	
	public static void t1() throws InterruptedException {
		while (!Thread.currentThread().isInterrupted()){
			System.out.println("当前线程:"+Thread.currentThread().getName());
			System.out.println("状态:"+Thread.currentThread().isInterrupted());
			Thread.sleep(1000);
		}
	}
	
	public static void t2() throws InterruptedException {
		Runnable r = () -> {
			Thread ct = Thread.currentThread();
			try{
				while (!ct.isInterrupted()){
					System.out.println("当前线程:" + ct.getName());
					System.out.println("状态:" + ct.isInterrupted());
					Thread.sleep(1000);
//					ct.interrupt();
				}
			}
			catch (InterruptedException e ){
				System.out.printf("线程%s睡眠中被中断\n" , ct.getName());
			}
			finally {
				System.out.printf("线程%s中断后状态:%s\n",ct.getName(), ct.isInterrupted());
			}
		};
		Thread t =new Thread(r);
		Thread mt = Thread.currentThread();
		t.start();
		mt.interrupt();
		mt.sleep(100);
		System.out.println(mt.getName());
		System.out.println("主进程结束");
	}

}
