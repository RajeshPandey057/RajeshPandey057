using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace logicalAndOr
{
    class Program
    {
        int i;
        public static Program operator &(Program p1,Program p2)
        {
            WriteLine("In Bitwise AND");
            Program p3 = new Program();
            p3.i = p1.i & p2.i;
            return p3;
        }
        public static Program operator |(Program p1,Program p2)
        {
            WriteLine("In Bitwise OR");
            Program p3 = new Program();
            p3.i = p1.i | p2.i;
            return p3;
        }
        public static bool operator true(Program p1)
        {
            WriteLine("In True");
            return (p1.i != 0);
        }
        public static bool operator false(Program p1)
        {
            WriteLine("In False");
            return (p1.i == 0);
        }
        static void Main(string[] args)
        {
            Program p1 = new Program() { i = 1 };
            Program p2 = new Program() { i = 0 };
            Program v1 = p1 && p2;
            Program v2 = p1 || p2;
            WriteLine("p1 && p2 = {0}",v1.i);
            WriteLine("p1 || p2 = {0}",v2.i);
        }
    }
}
