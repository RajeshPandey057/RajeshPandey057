class student
{
    String name;
    int roll;
    int[] mar;

    student()
    {
        name="";
        roll=0;
        mar = new int[3];
       mar[0]=0;
       mar[1]=0;
       mar[2]=0;
    }
    student(String d_n,int r,int m1 ,int m2 ,int m3)
    {
        name = d_n;
        roll = r;
        mar=new int[3];
        mar[0] = m1;
        mar[1] = m2;
        mar[2] = m3;

    }
    void display()
    {
        System.out.println(""+name+" " + " With roll no: "+roll+"" + "\n marks are "+mar[0]);
    }
}
public class stud
{
    public static void main(String[] args) {
        student s1=new student();
        student s2 = new student("Rajesh", 057, 99, 98, 96);
        s1.display();
        s2.display();
    }
}