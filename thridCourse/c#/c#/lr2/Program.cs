using System;

namespace lr1._1_cat_
{
    class Program
    {
        static void Main(string[] args)
        {
            cat frisky = new cat();

            frisky.set_age(5);

            Console.WriteLine("frisky is " + frisky.get_age() + " years old");

            Console.WriteLine("frisky weighs " + frisky.get_weight() + " kg");

            cat frisky2 = new cat();

            frisky2.set_age(5);

            Console.WriteLine("frisky is " + frisky2.get_age() + " years old");

            Console.WriteLine("frisky weighs " + frisky2.get_weight() + " kg");

            Console.ReadKey();
        }

    }
}
