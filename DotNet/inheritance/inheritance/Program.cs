using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace inheritance
{
    class a
    {
        public int i=0;
        public void Display()
        {
            Console.WriteLine("Parent");
        }
    }
    class b:a
    {
        public int j=0;
        public new void Display()
        {
            Console.WriteLine("Child");
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            a a1 = new b();
            a1.Display();
            Console.ReadKey();
        }
    }
}
