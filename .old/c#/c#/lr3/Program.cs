using System;

namespace lr1._1_cat_
{
    class Program
    {
        public static cat3_3 f1(cat3_3 the_cat)
        {
            Console.WriteLine("f1 returning");

            return the_cat;
        }
        public static cat3_3 f2(cat3_3 the_cat)
        {
            Console.WriteLine("f2 returning");

            return the_cat;
        }

        public static cat3_4 f3(cat3_4 the_cat)
        {
            Console.WriteLine("f3 returning");

            the_cat.Set_Age(5);

            Console.WriteLine("frisky is now " + the_cat.Get_Age() + " years old");

            return the_cat;
        }

        static void Main(string[] args)
        {
            //Задание 1

            cat frisky = new cat(3, 5);

            cat r_cat = frisky;

            Console.WriteLine("frisky is " + r_cat.get_age() + " years old");

            Console.WriteLine("frisky weighs " + r_cat.get_weight() + " kg");

            Console.WriteLine("\n");


            //Задание 2

            int sq_qube_num = 7;

            var itsnum = sq_qube.sq_qube_return(sq_qube_num);

            Console.WriteLine("Заданное число: " + sq_qube_num);

            Console.WriteLine("Квадрат этого числа: " + itsnum.Item1);

            Console.WriteLine("Куб  этого числа: " + itsnum.Item2);

            Console.WriteLine("\n");


            //Задание 3

            Console.WriteLine("Make a cat");

            cat3_3 new_frisky = new cat3_3();

            Console.WriteLine("Calling f1");

            f1(new_frisky);

            Console.WriteLine("Calling f2");

            f2(new_frisky);

            Console.WriteLine("\n");


            //Задание 4

            Console.WriteLine("Make a cat");

            cat3_4 new_new_frisky = new cat3_4();

            Console.WriteLine("frisky is " + new_new_frisky.Get_Age() + " years old.");

            int age = 4;

            new_new_frisky.Set_Age(age);

            Console.WriteLine("frisky is " + new_new_frisky.Get_Age() + " years old.");

            Console.WriteLine("Calling f3");

            f3(new_new_frisky);

            Console.WriteLine("frisky is " + new_new_frisky.Get_Age() + " years old.");

            Console.ReadKey();

        }

    }
}
