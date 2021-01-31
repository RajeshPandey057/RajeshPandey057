using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace temp
{
    public class box
    {
        public double h, w, l;
        public static box operator+(box b1,box b2) => new box(){h=b1.h+b2.h,w=b1.w+b2.w,l=b1.l+b2.l};
        public static bool operator>(box b1, box b2) =>   (b1.h*b1.w*b1.l) > (b2.h * b2.w * b2.l)  ;
        public static bool operator<(box b1, box b2) => b1.h * b1.w * b1.l < b2.h * b2.w * b2.l;
    }
    class Program
    {
        static void Main(string[] args)
        {
            box b1 = new box() { h=2,w=3,l=4};
            box b2 = new box() { h = 3, w = 4, l = 5 };
            box b3 = b1 + b2;
            if (b3 > b1)
                Console.WriteLine("box 3 has more volume");
            else
                Console.WriteLine("box 1 has more volume");
            Console.ReadKey();
        }
    }
}
