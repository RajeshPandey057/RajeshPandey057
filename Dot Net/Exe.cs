using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using constandreadonly;
namespace constandreadonlymain
{
    class Program
    {
        static void Main(string[] args)
        {
            Class1 c1 = new Class1();
            Console.WriteLine($"Constant:{Class1.c}\nReadOnly:{c1.r}");
            Console.ReadKey();
        }
    }
}
