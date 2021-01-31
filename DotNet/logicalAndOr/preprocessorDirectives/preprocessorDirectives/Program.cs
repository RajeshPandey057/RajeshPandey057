#define DEBUG
//#define RELEASE
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
namespace preprocessorDirectives
{
    class Program
    {
        static int j = 20;
        static int d = 10;
        public int X { get; set; }

        public static void PropA(ref Program p)
        {
            p.X = 2;
            p = new Program { X = 5 };
        }
        static void Main(string[] args)
        {
            /*#pragma warning disable 0219
            #if DEBUG
                        WriteLine("Debug is defined");
            #endif

            #if DEBUG && RELEASE
            #warning "Warning shown."
            #else

            #endif

            #region MyRegion

            int Morning = 0;
            int Afternoon = 1;
            int Evening = 2;

            #endregion

            #line 35
            #warning "Warning for line 35"*/

            Program p = new Program { X = 1 };
            PropA(ref p);
            WriteLine($"{p.X}");

            
            WriteLine(d);
           
            int j = 30;
            WriteLine(j);
            /*List<string> l1 = new List<string>() { "abc", "def" };
            List<string> l2 = new List<string>();
            l2 = l1;
            l2.Add("ghx");
            WriteLine(l2[2]);
            bool yn = ReferenceEquals(l1, l2);
            WriteLine("l1 and l2 are equal: {0} ", yn);
            int i = 4;
            int j = i;*/

        }
    }
}
