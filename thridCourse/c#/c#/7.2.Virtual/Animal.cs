using System;
using System.Collections.Generic;
using System.Text;

namespace _2.Virtual
{
    interface print_animal_interface
    {
        public abstract void PrintAnimal();
    }

    interface ViviparousOrEggBearing
    {
        public abstract void Check();
        
    }

    abstract class Animal : print_animal_interface, ViviparousOrEggBearing
    {
        public abstract void PrintAnimal();
        
        public abstract void Check();
        
    }

}
