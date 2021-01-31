using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace enumerationExample
{
    class Program
    {
        public enum TimeOfDay
        {
            Morning = 0,
            Afternoon = 1,
            Evening = 2
        }
        static void Main(string[] args)
        {
            DateTime v = DateTime.Now;
            TimeSpan v1 = v.TimeOfDay;
            TimeSpan m1 = new TimeSpan(0, 0, 0);
            TimeSpan m2 = new TimeSpan(12, 0, 0);
            TimeSpan m3 = new TimeSpan(17, 0, 0);
            TimeOfDay t2;
            if (v1>=m1 && v1<=m2)
            {
                t2 = (TimeOfDay)Enum.Parse(typeof(TimeOfDay), "morning", true);
                WriteLine("Good {0}, Welcome to Lab.",t2);
            }
            else if (v1 >= m2 && v1 <= m3)
            {
                t2 = (TimeOfDay)Enum.Parse(typeof(TimeOfDay), "afternoon", true);
                WriteLine("Good {0}, Welcome to Lab.",t2);
            }
            else if (v1 >= m3)
            {
                t2 = (TimeOfDay)Enum.Parse(typeof(TimeOfDay), "evening", true);
                WriteLine("Good {0}, Welcome to Lab.",t2);
            }
        }
    }
}
