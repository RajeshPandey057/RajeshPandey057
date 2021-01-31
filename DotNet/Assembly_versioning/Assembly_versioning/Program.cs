using System;
using static System.Console;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;
namespace Assembly_versioning
{
    class Program
    {
        static void Main(string[] args)
        {
            Assembly asm = Assembly.ReflectionOnlyLoadFrom(@"D:\Professional\Study\Dot Net\codes-20190317T104739Z-001\codes\Garbage Collector Dummy Variables\Garbage Collector Dummy Variables\bin\Debug\Garbage Collector Dummy Variables.exe");
            AssemblyName aname = asm.GetName();
            Version v = aname.Version;
            string v1 = ReadLine();
            Version v2 = new Version(v1);
            var t = v2.CompareTo(v);
            if (t == -1)
                WriteLine("Given is Small");
            else if (t == 0)
                WriteLine("Both are Equal");
            else
                WriteLine("Given is Bigger");
            ReadKey();
        }
    }
}
