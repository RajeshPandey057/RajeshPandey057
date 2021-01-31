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
        public static bool operator true(Program1 p)
        {
            if (p.i != 0)
                return true;
            else
                return false;
        }
        public static bool operator false(Program1 p)
        {
            if (p.i == 0)
            {
                Console.WriteLine("In False");
                return true;
            }
            else
                return false;
        }
        public static Program1 operator &(Program1 p1, Program1 p)
        {
            if (p1.i != 0 && p.i != 0)
                return new Program1() { i = 1 };
            else
                return new Program1() { i = 0 };
        }
        public static Program1 operator |(Program1 p1, Program1 p)
        {
            if (p1.i != 0 || p.i != 0)
                return new Program1() { i = 1 };
            else
                return new Program1() { i = 0 };
        }
    }
    class Program
    {


        static void Main(string[] args)
        {
            Program1 p1 = new Program1() { i = 0 };
            Program1 p2 = new Program1() { i = 3 };
            if (p1 && p2)
            {
                Console.WriteLine("Both of them are non-ZERO");
            }
            if(p1 || p2)
            {
                Console.WriteLine("Atleast one ofthem is non-ZERO");
            }
            Console.ReadKey();
        }
    }
}
