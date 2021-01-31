using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practical3
{
    abstract public class Person
    {
        protected int age;
        protected string name;

        abstract public int Age
        {
            get;
            set;
        }
        abstract public string Name
        {
            get;
            set;
        }
        abstract public void getValue();
        abstract public void setValue();
    }
    public class Faculty : Person
    {
        string department;

        override public string Name
        {
            get { return name; }
            set { name = value; }
        }
        override public int Age
        {
            get { return age; }
            set { age = value; }
        }
        public string Dept
        {
            get { return department; }
            set { department = value; }
        }
        override public void setValue()
        {
            Console.WriteLine("Enter the Name of faculty: ");
            Name = Console.ReadLine();
            Console.WriteLine("Enter the Age of faculty: ");
            Age = int.Parse(Console.ReadLine());
            Console.WriteLine("Enter the Department of faculty: ");
            Dept = Console.ReadLine();
        }
        override public void getValue()
        {
            Console.WriteLine("The Faculty Name: " + Name);
            Console.WriteLine("The Faculty Age: " + Age);
            Console.WriteLine("The Faculty Department: " + Dept);
        }
    }
    public class Student : Person
    {
        float cpi;

        override public string Name
        {
            get { return name; }
            set { name = value; }
        }
        override public int Age
        {
            get { return age; }
            set { age = value; }
        }
        public float CPI
        {
            get { return cpi; }
            set { cpi = value; }
        }
        override public void setValue()
        {
            Console.WriteLine("Enter the Name of Student: ");
            Name = Console.ReadLine();
            Console.WriteLine("Enter the Age of Student: ");
            Age = int.Parse(Console.ReadLine());
            Console.WriteLine("Enter the CPI of Student: ");
            CPI = float.Parse(Console.ReadLine());
        }
        override public void getValue()
        {
            Console.WriteLine("The Faculty Name: " + Name);
            Console.WriteLine("The Faculty Age: " + Age);
            Console.WriteLine("The Faculty Department: " + CPI);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Person f1 = new Faculty();
            f1.setValue();
            f1.getValue();

            Person f2 = new Student();
            f2.setValue();
            f2.getValue();
        }
    }
}
