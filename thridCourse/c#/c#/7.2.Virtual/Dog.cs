using System;
using System.Collections.Generic;
using System.Text;

namespace _2.Virtual
{
    class Dog : Animal
    {
        public Dog()
        {

        }

        public override void PrintAnimal()
        {
            Console.WriteLine("Dog draw");
        }

        public override void Check()
        {
            Console.WriteLine("It is a viviparous animal");
        }

    }
}
