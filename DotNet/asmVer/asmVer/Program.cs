using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

[assembly: AssemblyVersion("1.0.0.0")]
namespace asmVer
{
    class Program
    {
        static void Main(string[] args)
        {
            Assembly myasm = typeof(Program).Assembly;
            AssemblyName aname = myasm.GetName();
            Version v = aname.Version;
            WriteLine("Name is {0} and number is {1}", aname.Name, v);

            OperatingSystem os = Environment.OSVersion;
            Version os_v = os.Version;
            Version clr_v = Environment.Version;
            WriteLine("OS Version is {0} and CLR Version is {1}", os_v, clr_v);

            // Compare two versions of Assembly
            Assembly asm = Assembly.ReflectionOnlyLoadFrom(@"D:\College\SEM 6\16CP032_NET\Programs\indexerApp\indexerApp\bin\Debug\indexerApp.exe");
            AssemblyName n1 = asm.GetName();
            Version v1 = n1.Version;
            WriteLine("Enter the version number: ");
            string v2 = ReadLine();
            Version v3 = new Version(v2);
            WriteLine("The Versions of both assemblies are: {0}",v3.CompareTo(v1));
        }
    }
}
