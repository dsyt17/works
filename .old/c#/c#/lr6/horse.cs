using System;
using System.Collections.Generic;
using System.Text;

namespace lr6
{
    enum type { HORSE, PEGAS };

    interface horse_interface
    {
        public int its_age { get; set; }
        public virtual void whinny()
        {
            Console.WriteLine("Whinny...\n");
        }
        public virtual void fly()
        {
            Console.WriteLine("Horses can't fly.\n");
        }

    }


    public class horse : horse_interface
    {
        public int its_age { get; set; }

        public horse()
        {
            Console.WriteLine("Horse constructor\n");
        }

        ~horse()
        {
            Console.WriteLine("Horse deconstructor\n");
        }

        public virtual void whinny()
        {
            Console.WriteLine("Whinny...\n");
        }

        public void gallop()
        {
            Console.WriteLine("Galloping....\n");
        }

        public virtual void fly()
        {
            Console.WriteLine("Horses can't fly.\n");
        }

    }
}
