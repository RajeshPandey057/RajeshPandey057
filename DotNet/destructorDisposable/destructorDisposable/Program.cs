using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace destructorDisposable
{
    class Program: IDisposable
    {
        int i;
        public Program()
        {
            i = 0;
        }
        ~Program()
        {
            WriteLine("In Destructor");
            //Dispose(false);
        }
        public void Dispose()
        {
            Dispose(true);
        }
        public void Dispose(bool t)
        {
            //GC.SuppressFinalize(this);
            WriteLine("In Dispose, Suppress Finalizer");
            WriteLine("Release Unmanaged Code");
            if (t) WriteLine("Release Managed Code");
        }
        static void Main(string[] args)
        {
            Program p1 = new Program();
            p1.Dispose();
        }
    }
}
