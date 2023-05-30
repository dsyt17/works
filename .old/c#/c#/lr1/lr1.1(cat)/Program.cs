using System;

namespace lr1._1_cat_
{
    class Program
    {
        static void Main(string[] args)
        {
            cat frisky = new cat();

            Console.WriteLine("frisky is " + frisky.get_age() + " years old");

            frisky.set_age(5);

            frisky.meow();

            Console.WriteLine("frisky is " + frisky.get_age() + " years old");

            frisky.meow();

            Console.ReadKey();
        }

    }
}
