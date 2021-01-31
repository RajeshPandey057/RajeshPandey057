//#undef DEBUG
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
namespace preproccesingderectives
{

    class Program
    {
        static void Main(string[] args)
        {
            WriteLine("Wellcome To:");
            #region Mode
#if DEBUG
            WriteLine("Debug mode...!");
#warning "In Debug Mode"
#else
            WriteLine("Release Version...:)");
#endif
            #endregion
            ReadKey();
        }
    }
}
