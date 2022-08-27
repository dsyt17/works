using System;
using System.Collections.Generic;
using System.Text;

namespace _2.Virtual
{
    class Platypus : Animal
    {
        public Platypus()
        {

        }

        public override void PrintAnimal()
        {
            Console.WriteLine("Platypus draw");
        }

        public override void Check()
        {
            Console.WriteLine("It is an egg-bearing animal");
        }

    }
}
