using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace indexerApp
{
    class IndexedNames
    {
        public static int size = 10;
        private string[] namelist = new string[size];

        public IndexedNames()
        {
            for(int i = 0; i < size; i++)
            {
                namelist[i] = "NA";
            }
        }
        public string this[int index]
        {
            get
            {
                string temp;
                if(index>=0 && index <= size - 1)
                {
                    temp = namelist[index];
                }
                else
                {
                    temp = "";
                }
                return temp;
            }
            set
            {
                if(index >= 0 && index <= size - 1)
                {
                    namelist[index] = value;
                }
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            IndexedNames s1 = new IndexedNames();
            s1[0] = "Manav";
            s1[1] = "Naresh";
            s1[2] = "Prajapti";

            for(int i = 0; i < IndexedNames.size; i++)
            {
                Console.WriteLine(s1[i]);
            }
        }
    }
}
