public class stack {
    int tos;
    int[] a = new int[10];
    stack()
    {
        tos=-1;
    }
    void push(int n)
    {
        if(tos>10)
            System.out.println("Stack Overflowed!");
        else
            a[++tos]=n;
    }
    int pop()
    {
        return a[tos--];
    }
}
