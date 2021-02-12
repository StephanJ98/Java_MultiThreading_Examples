import java.util.ArrayList;

class MyThread extends Thread {
    public int name;

    MyThread(int idThread) {
        this.name = idThread;
    }

    public void run() {
        System.out.println("Hello you, starting!!! [Thread: " + name + " ]");
        // Demorar, esperar, dormir ...
        System.out.println("Hello you, this is the end!!! [Thread: " + name + " ]");
    }
}

class Hello {
    public static void main(String[] args) throws InterruptedException {
        int limit = 1;
        ArrayList<MyThread> threads = new ArrayList<>();
        long start = System.currentTimeMillis();
        
        System.out.println("Hello world, this is " + args[0]);
        if (args.length > 1) {
            limit = Integer.parseInt(args[1]);
        }
        for (int i = 0; i <= limit; i++) {
            threads.add(new MyThread(i));
            threads.get(i).start();
            threads.get(i).join();
        }
        
        System.out.println("Hello " + args[0] + ", this is the end!!!");
        System.out.println("Complete in " + (float)(System.currentTimeMillis() - start)/1000 + " seconds");
    }
}