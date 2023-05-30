using System;
using System.Collections.Generic;
using System.Text;

namespace lr1._1_cat_
{
    class cat3_4
    {
        private int its_age;
        public cat3_4()
        {
            Console.WriteLine("Simple cat constructor");
            this.its_age = 3;
        }

        public cat3_4(cat3_4 cat3_4)
        {
            Console.WriteLine("Simple cat copy constructor");
        }

        ~cat3_4()
        {
            Console.WriteLine("Destructor");
        }

        public int Get_Age() 
        { 
            return this.its_age; 
        }

        public void Set_Age(int age) 
        { 
            this.its_age = age; 
        }




    }
}
