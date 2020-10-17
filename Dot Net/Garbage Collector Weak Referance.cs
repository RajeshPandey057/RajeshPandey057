using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Garbage_Collector_Weak_Referance
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> l1 = new List<int>(100);
            WeakReference wr = new WeakReference(l1);
            Console.WriteLine("The Referane Is Alive:" + wr.IsAlive);
            List<int> l2=wr.Target as List<int>;
            GC.Collect();
            Console.WriteLine("The Referane Is Alive:"+wr.IsAlive);
            Console.WriteLine("The strong Referance Is Alive:" + l2.ToString());
            Console.ReadKey();
        }
    }
}
