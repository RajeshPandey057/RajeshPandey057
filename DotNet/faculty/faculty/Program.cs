using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace faculty
{
    class faculty
    {
        string name;
        string departmenrt;
        int age;
        public faculty(string dname, int dage)
        {
            name = dname;
            age = dage;
        }
        public void setDepartment(string ddep)
        {
            departmenrt = ddep;
        }
        public void printInfo()
        {
            Console.WriteLine("Name:"+name+"\nAge:"+age+"\nDepartment:"+departmenrt+"\n\n");
        }
        public int getAge()
        {
            return age;
        }
        public string getName()
        {
            return name;
        }
        public string getDepartment()
        {
            return departmenrt;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            faculty[] f;
            Console.WriteLine("Enter number of faculty:");
            int n = Convert.ToInt32(Console.ReadLine());
            f = new faculty[n];
            int i;
            for (i = 0; i < n; i++)
            {
                Console.WriteLine("Enter name of faculty:");
                string fnmae = Console.ReadLine();
                Console.WriteLine("Enter age of faculty:");
                int fage = Convert.ToInt32(Console.ReadLine());
                f[i] = new faculty(fnmae, fage);
				Console.WriteLine("Enter department of faculty:");
                string dep = Console.ReadLine();
                f[i].setDepartment(dep);
            }
            for(i=0;i<n;i++)
            {
                f[i].printInfo();
            }
            Console.ReadKey();
        }
    }
}
