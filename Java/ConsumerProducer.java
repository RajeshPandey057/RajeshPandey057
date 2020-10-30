
import java.util.Scanner;

class buffer {
    int info;
    volatile int flag = 0;
    volatile int turn = -1;

    synchronized public void put(int n, int t) {
        try {
            if (flag == 1)
                wait();
            flag = 1;
            info = n;
            turn = t;
            notifyAll();
        } catch (InterruptedException ie) {
        }
    }

    synchronized public void get(int t) throws InterruptedException {
        while (flag == 0)
            wait();
        while (turn != t) {
            wait();
        }
        flag = 0;
        System.out.println("" + info + " IS CONSUMED BY THREAD " + t);
        notifyAll();
    }
}

class producer extends Thread {
    buffer bref;

    producer(String name, buffer db) {
        super(name);
        bref = db;
        start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter number to produce:");
                int n = sc.nextInt();
                System.out.println("Enter turn:");
                int t = sc.nextInt();
                bref.put(n, t);
                sleep(1500);
            } catch (InterruptedException e) {
            }
        }
    }

}

class consumer extends Thread {
    buffer bref;
    int pt;

    consumer(String name, buffer db, int dt) {
        super(name);
        bref = db;
        pt = dt;
        start();
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                bref.get(pt);
            }
        } catch (InterruptedException e) {
        }
    }

}

class procon3 {
    public static void main(String[] args) {
        buffer bref = new buffer();
        producer p = new producer("producer", bref);
        consumer c1 = new consumer("consumer1", bref, 1);
        consumer c2 = new consumer("consumer1", bref, 2);
        consumer c3 = new consumer("consumer1", bref, 3);
        try {
            p.join();
            c1.interrupt();
            c1.join();
            c2.interrupt();
            c2.join();
            c3.interrupt();
            c3.join();
        } catch (InterruptedException ie) {
        }
    }
}
