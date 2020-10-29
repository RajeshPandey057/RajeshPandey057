
class commandline {
    public static void main(String[] args) {
        int k = 0, i, n = Integer.parseInt(args[0]);
        int a[];
        a = new int[n];
        for (i = 1; i < args.length; i++) {
            if (args[i].equals("push")) {
                a[k] = Integer.parseInt(args[++i]);
                k++;
                System.out.println("" + Integer.parseInt(args[i]) + "is pushed");
            } else {
                int temp = a[--k];
                System.out.println("" + temp + " is poped");
            }
        }
    }
}
