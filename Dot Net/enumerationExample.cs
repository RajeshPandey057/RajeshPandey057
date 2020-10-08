using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
namespace greetings
{
    public enum TimeOfDay
    {
        Morning,Afternoon,Evening
    }
    class Program
    {
        static void Main(string[] args)
        {
            TimeSpan now = DateTime.Now.TimeOfDay;
            TimeSpan morning = new TimeSpan(0,0,0);
            TimeSpan afternoon = new TimeSpan(11,59,59);
            TimeSpan evening = new TimeSpan(16,0,0);
            if (now >morning && now < afternoon)
            {
                WriteLine("Good Morning");
            }
            else if(now > afternoon && now < evening)
            {
                WriteLine("Good Afternoon");
            }
            else
            {
                WriteLine("Good Evning");
            }
            ReadKey();
        }
    }
}
