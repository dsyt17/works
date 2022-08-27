using System;

namespace _7._1.Complex
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                Complex c1 = new Complex();
                Complex c2 = new Complex();

                Console.Write("Введите целую часть первого комплексного числа: ");
                c1.Real = Convert.ToDouble(Console.ReadLine());
                Console.Write("Введите мнимую часть первого комплексного числа: ");
                c1.Imaginary = Convert.ToDouble(Console.ReadLine());
                Console.Write("Введите целую часть второго комплексного числа: ");
                c2.Real = Convert.ToDouble(Console.ReadLine());
                Console.Write("Введите мнимую часть второго комплексного числа: ");
                c2.Imaginary = Convert.ToDouble(Console.ReadLine());
                Console.WriteLine("");

                Console.WriteLine("Введенные комплексные числа: ");
                c1.Print(c1);
                c2.Print(c2);
                Console.WriteLine("");

                Console.WriteLine("Сложение:   {0} + {1}i", (c1 + c2).Real, (c1 + c2).Imaginary);
                Console.WriteLine("Умножение:  {0} + {1}i", (c1 * c2).Real, (c1 * c2).Imaginary);
                Console.WriteLine("Вычитание:  {0} + {1}i", (c1 - c2).Real, (c1 - c2).Imaginary);

                Console.ReadLine();

            }
        }
    }
}
