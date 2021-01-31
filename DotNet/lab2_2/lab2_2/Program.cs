using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab2_2
{
    class faculty 
    {
        public string department;
        string name;
        int age;
        public faculty(string ddp)
        {
            department = ddp;
        }

        public string Name { get {return name; } set {
                name = value;
            } }
        public int Age 
        {
            get { return age; }
            set
            {
                age = value;
            }
        }
        public void display()
        {
            Console.WriteLine("Faculty Info:\nName:" + name + "\nAge:" + age + "\nDepartment:" + department + "\n\n");
        }
    }
    class student
    {
        public double cpi;
        string name;
        int age;
        public student(double dcpi)
        {
            cpi = dcpi;
        }

        public string Name
        {
            get { return name; }
            set
            {
                name = value;
            }
        }
        public int Age
        {
            get { return age; }
            set
            {
                age = value;
            }
        }
        public void display()
        {
            Console.WriteLine("Student Info:\nName:" + name + "\nAge:" + age + "\nCPI:" + cpi + "\n\n");
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            student s = new student(9.5);
            s.Name = Console.ReadLine();
            s.Age = Convert.ToInt32(Console.ReadLine());
            s.display();
            Console.ReadKey();
        }
    }
}
