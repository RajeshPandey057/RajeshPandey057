using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace GarbageCollector
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Int32> l1 = new List<int>(100);
            double gen=GC.GetGeneration(l1);
            Console.WriteLine("Genration of list is:"+gen);
            Console.WriteLine("Garbage collector called.\n\n\n");
            GC.Collect();
            gen = GC.GetGeneration(l1);
            Console.WriteLine("Genration of list is:" + gen);
            Console.WriteLine("Garbage collector called.\n\n\n");
            GC.Collect();
            gen = GC.GetGeneration(l1);
            Console.WriteLine("Genration of list is:" + gen);
            Console.ReadKey();
        }
    }
