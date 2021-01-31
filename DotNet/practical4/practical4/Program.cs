using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practical4
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> s1 = new List<string>();
            int m = GC.GetGeneration(s1);
            Console.WriteLine("The first generation of string s1 : "+m);
            {
                int[] m1 = new int[10000];
                long m2 = GC.GetTotalMemory(false);
                Console.WriteLine("The memory before garbage collector called: " + m2);
                m1 = null;
            }
            GC.Collect();
            long m3 = GC.GetTotalMemory(false);
            Console.WriteLine("The memory after garbage collector called: " + m3);
            m = GC.GetGeneration(s1);
            Console.WriteLine("The second generation of string s1 : " + m);

            WeakReference s1_ref = new WeakReference(s1);
            GC.Collect();
            Boolean m4 = s1_ref.IsAlive;
            Console.WriteLine("s1_ref Is Alive : " + m4);
        }
    }
}
