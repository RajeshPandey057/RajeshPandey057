public class stackmain {
    public static void main(String[] s)
    {
        stack s1 = new stack();
        int i,j;
        for(i=0;i<s.length;i++)
        {
            if("push".equals(s[i]))
            {
                i++;
                j=Integer.parseInt(s[i]);
                s1.push(j);
            }
            else if("pop".equals(s[i]))
            {
                if(s1.tos>=0)
                    System.out.println("Value poped is: "+s1.pop());
                else 
                    System.out.println("Stack Underflowed!");
            }
        }
    }
}