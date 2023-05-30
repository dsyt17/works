using System;

namespace _4.Data
{
    class Program
    {
        static void Main(string[] args)
        {   
            data our_data = new data();

            our_data.CurDate();

            bool quit = false;

            while (!quit)
            {
                Console.Write("Выберите действие:\n(1) — Ввести дату \n(2) — Увеличить день на 1 \n(3) — Уменьшить день на 1 \n(4) — Добавить дни \n(5) — Текущая дата  \n(6) — Выход \nВыбор: ");
                switch (int.TryParse(Console.ReadLine(), out int newChoice) ? newChoice : 100)
                {
                    case 6:
                        quit = true;
                        break;
                    case 1:
                        Console.Clear();
                        our_data.EntDate();
                        break;
                    case 2:
                        Console.Clear();
                        our_data.increment();
                        our_data.GetDate();
                        break;
                    case 3:
                        Console.Clear();
                        our_data.decrement();
                        break;
                    case 4:
                        Console.Write("\nВведите число дней: ");
                        int num_days = Convert.ToInt32(Console.ReadLine());
                        Console.Clear();
                        our_data.AddDays(num_days);
                        break;
                    case 5:
                        Console.Clear();
                        our_data.CurDate();
                        break;
                    default:
                        Console.Clear();
                        our_data.CurDate();
                        continue;
                }

            }

            Console.ReadKey();
        }
    }
}
