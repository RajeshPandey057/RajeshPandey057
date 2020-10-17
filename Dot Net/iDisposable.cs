using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
namespace with_disposel
{
    class Program1:IDisposable
    {
        int i = 0;
        bool v = true;
        public virtual void Dispose(bool t)
        {
            WriteLine("Inside Dispose(bool)");
            if (v)
            {
                v = false;
                WriteLine("Release Unmanaged Resourses");
            }
            if (t)
            {
                WriteLine("Released Managed Resourses");
            }
        }
        public void Dispose()
        {
            WriteLine("Inside Dispose()");
            Dispose(true);
            GC.SuppressFinalize(this);
        }
        ~Program1()
        {
            WriteLine("Inside Finalizer");
            Dispose(false);
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            using (var p = new Program1()) ;
            ReadKey();
        }
    }
}
