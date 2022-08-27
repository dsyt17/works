using System;
using System.Collections.Generic;
using System.Text;

namespace lr6
{
    interface bird_interface
    {
        public int its_weight { get; set; }
        public virtual void chirp()
        {
            Console.WriteLine("Chirp...\n");
        }
        public virtual void fly()
        {
            Console.WriteLine("I can fly!.\n");
        }
    }

    public class bird : bird_interface
    {
        public int its_weight { get; set; }

        public bird()
        {
            Console.WriteLine("Bird constructor\n");
        }

        ~bird()
        {
            Console.WriteLine("Bird deconstructor\n");
        }

        public virtual void chirp()
        {
            Console.WriteLine("Chirp...\n");
        }
        public virtual void fly()
        {
            Console.WriteLine("I can fly!.\n");
        }



    }
}
