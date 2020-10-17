using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace Indexers
{
    class Student
    {
        public int Id;
        private string name{
			get
			{
				return name;
			}
			set
			{
				name = value;
			}
		};
        private int[] sub = new int[3];
        public Student(int di,string dn)
        {
            Id = di;
            name = dn;
        }
        public int this[string subname]
        {
            get
            {
                if(subname.Equals("Maths"))
                {
                    return sub[0];
                }
                else if (subname.Equals("Physics"))
                {
                    return sub[1];
                }
                else
                {
                    return sub[3];
                }
            }
            set
            {
                if (subname.Equals("Maths"))
                {
                    sub[0] = value;
                }
                else if (subname.Equals("Physics"))
                {
                    sub[1] = value;
                }
                else
                {
                    sub[2] = value;
                }
            }
        }
        public string this[int did]
        {
            get
            {
                if(Id == did)
                {
                    return name;
                }
                else
                {
                    return "No Name Found";
                }
            }
            set
            {
                if (Id==did)
                {
                    name = value;
                }
                else
                {
                    Console.WriteLine("ID NOT FOUND");
                }
            }
        }
        public void display()
        {   Console.WriteLine("Id:"+Id+"\n"+"Name:"+name+"\n"+"Maths:"+sub[0]+"\n" + "Physics:" + sub[1] + "\n" + "Chem:" + sub[2] + "\n");
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Student[] s = new Student[2];
            s[0] = new Student(1,"Chintan");
            s[1] = new Student(2,"Monil");
            s[0]["Maths"] = 90;
            s[0]["Physics"] = 90;
            s[0]["Chem"] = 90;
            s[1]["Maths"] = 95;
            s[1]["Physics"] = 95;
            s[1]["Chem"] = 95;
            s[0].display();
            s[0][1] = "Chintan Rajput";
            Console.WriteLine("New Name is:"+s[0][1]);
            s[0].display();
        }
    }
}
