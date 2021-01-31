using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace overload_true
{
    class Program1
    {
        public int i;
    }
    class Program2
    {
        public int i;
        public static bool operator &(Program2 p1,Program1 p)
        {
            bool v1 = p.i == 0;
            bool v2 = p1.i == 0;
            return v1 & v2;
        }
        public static bool operator |(Program2 p1,Program1 p)
        {
            bool v1 = p.i == 0;
            bool v2 = p1.i == 0;
            return v1 | v2;
        }
        public static bool operator !(Program2 p1)
        {
            return (p1.i == 0);
        }
    }
    class Program
    {


        static void Main(string[] args)
        {
            Program1 p1 = new Program1() { i = 0 };
            Program2 p2 = new Program2() { i = 3 };
            if(p2 & p1)
            {
                Console.WriteLine("Both are non ZERO");
            }
            if(p2 | p1)
            {
                Console.WriteLine("Atleast one is non ZERO");
            }
            if(!p2)
            {
                Console.WriteLine("Negation of object p2 is non ZERO");
            }
            else
            {
                Console.WriteLine("Negation of object p2 is ZERO");
            }
            Console.ReadKey();
        }
    }
}
