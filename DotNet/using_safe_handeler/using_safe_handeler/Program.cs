using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using Microsoft.Win32.SafeHandles;
using System.IO;

namespace with_disposel
{
    class Program1 : IDisposable
    { 
        bool v = true;
        public FileStream fileStream; 
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
            
            Program1 p = new Program1() ;
            p.fileStream = new FileStream(@"d:\words.txt", FileMode.OpenOrCreate, FileAccess.ReadWrite, FileShare.None);
            p.fileStream.SafeFileHandle.Dispose();
            ReadKey();
        }
    }
}
