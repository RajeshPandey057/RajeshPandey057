using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace converterimpli
{
    class Program
    {
        public class usd
        {
            public decimal p;
            public static implicit operator usd(inr u)
            {
                return new usd() { p = u.p / (decimal)70.0 };
            }
        }
        public class inr
        {
            public decimal p;
            public static implicit operator inr(usd u)
            {
                return new inr() { p = (u.p * (decimal)70.0) };
            }
        }
        static void Main(string[] args)
        {
            usd win = new usd() { p = 1000000};
            inr winr = win;
            Console.WriteLine("You won:\t$"+win.p+ "\n\t\tRs." + winr.p);
            Console.ReadKey();
        }
    }
}
