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
            if (p.i != 0)
            {
                Console.WriteLine("In False");
                return true;
            }
            else
                return false;
        }
    }
    class Program
    {
        
        
        static void Main(string[] args)
        {
            Program1 p1 = new Program1() { i = 0 };
            Program1 p2 = new Program1() { i = 3 };
            if(p1)
            {
                Console.WriteLine("Object p1:non zero");
            }
            else
            {
                Console.WriteLine("Object p1:zero");
            }
            if (p2)
            {
                Console.WriteLine("Object p2:non zero");
            }
            else
            {
                Console.WriteLine("Object p2:zero");
            }
            Console.ReadKey();
        }
    }
}
