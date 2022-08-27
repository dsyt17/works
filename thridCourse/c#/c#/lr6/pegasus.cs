using System;
using System.Collections.Generic;
using System.Text;

namespace lr6
{

    interface pegasus_interface : horse_interface, bird_interface
    {
        public new void fly()
        {
            Console.WriteLine("I can fly!\n");
        }
        public new void chirp()
        {
            whinny();
        }
    }

    public class pegasus : horse, pegasus_interface
    {
        public int its_weight { get; set; }
        public new int its_age { get; set; }

        public pegasus()
        {
            Console.WriteLine("Pegasus constructor\n");
        }

        ~pegasus()
        {
            Console.WriteLine("Pegasus deconstructor\n");
        }


        public override void fly()
        {
            Console.WriteLine("I can fly!\n");
        }

    }
}
