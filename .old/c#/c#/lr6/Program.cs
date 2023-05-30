using System;

namespace lr6
{
    class Program
    {
        static void Main(string[] args)
        {
            //Задание 1

            Console.WriteLine("\n Задание 1.\n" +
                "=================================================\n");

            const int number_of_horses = 5;

            horse p_horse = new horse();

            var ranch = new horse[number_of_horses];

            int choice, i;

            for (i = 0; i < number_of_horses; i++)
            {
                Console.WriteLine("(1) - horse\n(2) - pegas\n");
                p_horse = (int.TryParse(Console.ReadLine(), out int value) ? value : 0) == 2 ? new pegasus() : new horse();
                ranch[i] = p_horse;
            }

            for (var j = 0; j < number_of_horses; j++)
            {
                ranch[j].fly();
            }

            //Задание 2

            Console.WriteLine("\n Задание 2.\n" +
                "=================================================\n");

            for (var j = 0; j < number_of_horses; j++)
            {
                Console.WriteLine($"ranch{j}");
                if (ranch[j] is pegasus pegas) pegas.fly();
                else Console.WriteLine("Just a horse.\n");
            }

            //Задание 3

            Console.WriteLine("\n Задание 3.\n" +
                "=================================================\n");

            const int num = 2;
            ranch = new horse[num];
            var aviary = new bird_interface[num];

            for (i = 0; i < num; i++)
            {
                Console.WriteLine("(1) — Horse | (2) — Pegas");
                p_horse = (int.TryParse(Console.ReadLine(), out int value) ? value : 0) == 2 ? new pegasus() : new horse();
                ranch[i] = p_horse;
            }

            for (i = 0; i < num; i++)
            {
                Console.WriteLine("(1) — Bird | (2) — Pegasus");
                if ((int.TryParse(Console.ReadLine(), out int value) ? value : 0) == 2)
                {
                    var p_bird = new pegasus();
                    aviary[i] = p_bird;
                }
                else
                {
                    var p_bird = new bird();
                    aviary[i] = p_bird;
                }
            }

            for (i = 0; i < num; i++)
            {
                Console.WriteLine();

                Console.WriteLine($"ranch[{i}]");
                ranch[i].whinny();

                Console.WriteLine();
            }

            for (i = 0; i < num; i++)
            {
                Console.WriteLine();

                Console.WriteLine($"Aviary[{i}]");
                aviary[i].chirp();
                aviary[i].fly();

                Console.WriteLine();
            }

            //Задание 4

            Console.WriteLine("\n Задание 4.\n" +
                "=================================================\n");

            bool fQuit = false;
            shape sp = new shape();

            while (!fQuit)
            {
                Console.Write("(1) — Circle (2) — Rectangle (3) — Square (4) — Quit: ");
                switch (int.TryParse(Console.ReadLine(), out int newChoice) ? newChoice : 100)
                {
                    case 4:
                        fQuit = true;
                        break;
                    case 1:
                        sp = new circle(5);
                        sp.Draw();
                        break;
                    case 2:
                        sp = new rectangle(5, 3);
                        sp.Draw();
                        break;
                    case 3:
                        sp = new square(11);
                        sp.Draw();
                        break;
                    default:
                        Console.WriteLine("Enter a number between 1 and 4");
                        continue;
                }

                if (!fQuit) sp.Draw();
            }

            Console.ReadLine();


        }


    }
}
