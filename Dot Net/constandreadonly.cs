using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace temp
{
    public class class1
    {
        public static int add(int i, int j)
        {
            i++;
            j++;
            return i + j;
        }
        public static int add_ref(ref int i,ref int j)
        {
            i++;
            j++;
            return i + j;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int i=3, j=4;
            Console.WriteLine("Numbers before passing to simple method:");
            Console.WriteLine("i:"+i+"j:"+j);
            int k = class1.add(i, j);
            Console.WriteLine("Numbers before passing to simple method:");
            Console.WriteLine("i:" + i + "j:" + j);
            Console.WriteLine("Numbers before passing to referance method:");
            Console.WriteLine("i:" + i + "j:" + j);
            k = class1.add_ref(ref i,ref j);
            Console.WriteLine("Numbers before passing to referance method:");
            Console.WriteLine("i:" + i + "j:" + j);
            Console.ReadKey();
        }
    }
}
