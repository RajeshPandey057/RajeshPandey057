using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class faculty
    {
        private string fname="chintan";

        public string department {
            get => $"{fname}";
            }
                
                
    }
    class Program
    {
        static void Main(string[] args)
        {
            faculty f = new faculty();
            
            Console.WriteLine(f.department);
            Console.ReadKey();
        }
    }
}
