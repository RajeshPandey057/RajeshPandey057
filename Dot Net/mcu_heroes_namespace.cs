using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mcu_heroes_namespace
{
    class mcu_heroes
    {
        string[] name;
        string[] powers;
        public mcu_heroes()
        {
            name = new string[4] { "Ironman","Thor","Hulk","Scarlet Witch"};
            powers = new string[5] { "Rich", "God OF Thunder", "Always Angry", "Chaos Magic", "Hero Not Found..!" };
        }
        public string this[int i]
        {
            get=>name[i];
            set=>name[i] = value;
        }
        public string this[string arg]
        {
            get
            {
                int i,d=4;
                for(i=0;i<4;i++)
                {
                    if(name[i]==arg)
                    {
                        d = i;
                    }
                }
                return powers[d];
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            mcu_heroes mh = new mcu_heroes();
            Console.WriteLine("Enter Name of hero:");
            string strg = Console.ReadLine();
            Console.WriteLine("Powers of "+strg+" :"+mh[strg]);
            Console.ReadKey();
        }
    }
}
