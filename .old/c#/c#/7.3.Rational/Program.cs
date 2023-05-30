using System;

namespace _7._3.Rational
{
    class Program
    {
        static void Main(string[] args)
        {
            int num, den;

            while (true)
            {
                Rational r1 = new Rational();
                Rational r2 = new Rational();

                Console.Write("Введите числитель первой дроби: ");
                r1.numerator = Convert.ToInt32(Console.ReadLine());
                Console.Write("Введите знаменатель первой дроби: ");
                r1.denominator = Convert.ToInt32(Console.ReadLine());

                Console.Write("Введите числитель второй дроби: ");
                r2.numerator = Convert.ToInt32(Console.ReadLine());
                Console.Write("Введите знаменатель второй дроби: ");
                r2.denominator = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("");

                Console.WriteLine("Введенные дроби: ");
                r1.GetDivider(r1);
                r2.GetDivider(r2);
                Console.WriteLine("1: " + r1 + "  |  {0} ", r1.PrintDouble(r1));
                Console.WriteLine("2: " + r2 + "  |  {0} ", r2.PrintDouble(r2));
                Console.WriteLine("");

                Rational r3 = new Rational();

                
                r3 = Rational.Sum(r1, r2);
                r3.GetDivider(r3);
                Console.WriteLine("Сложение:    "+ r1 +" + "+ r2 +" = "+ r3 + "  |  {0} ", r3.PrintDouble(r3));

                r3 = r1 - r2;
                r3.GetDivider(r3);
                Console.WriteLine("Вычитание:   " + r1 + " - " + r2 + " = " + r3 + "  |  {0} ", r3.PrintDouble(r3));

                r3 = r1 * r2;
                r3.GetDivider(r3);
                Console.WriteLine("Умножение:   " + r1 + " * " + r2 + " = " + r3 + "  |  {0} ", r3.PrintDouble(r3));

                Rational r4 = new Rational();
                r4 = r2;
                r3 = r1 / r2;
                r3.GetDivider(r3);
                Console.WriteLine("Деление:     " + r1 + " / " + r4 + " = " + r3 + "  |  {0} ", r3.PrintDouble(r3));
                Console.WriteLine("");
                Console.ReadLine();

            }
        }
    }
}
