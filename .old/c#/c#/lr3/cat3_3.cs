using System;
using System.Collections.Generic;
using System.Text;

namespace lr1._1_cat_
{
    class cat3_3
    {
        public cat3_3()
        {
            Console.WriteLine("Simple cat constructor");
        }
        public cat3_3(cat3_3 cat3_3)
        {
            Console.WriteLine("Simple cat copy constructor");
        }
        ~cat3_3()
        {
            Console.WriteLine("Destructor");
        }

    }
}
