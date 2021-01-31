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
            /*Here we put this into usin configuration manager releas mode instead of debug so that we can optimize our code, 
             If it is in debug mode than this Garbage collector won't collect this weak referance
             this would also result into bin folder having two folders one debug and one release both havin different sizes when you disassemble them*/
            Console.WriteLine("The Referane Is Alive:"+wr.IsAlive);
            Console.WriteLine("The strong Referance Is Alive:" + l2.ToString());
            Console.ReadKey();
        }
    }
}
