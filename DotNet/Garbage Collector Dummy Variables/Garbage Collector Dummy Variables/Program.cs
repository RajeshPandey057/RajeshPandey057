using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Garbage_Collector_Dummy_Variables
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> l1 = new List<int>(1000);
            Console.WriteLine("The Total memory consumed is:"+ GC.GetTotalMemory(false));
            l1 = null;
            Console.WriteLine("The Total memory consumed after NULL is:" + GC.GetTotalMemory(false));
            GC.Collect();
            Console.WriteLine("The Total memory consumed after Garbage Collector is called is:" + GC.GetTotalMemory(false));
            Console.ReadKey();
        }

    }
}
