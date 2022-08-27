using System;
using System.Collections.Generic;
using System.Text;

namespace _4.Data
{
    class data
    {
        public static DateTime Now { get; }

        public int day;
        public int month;
        public int year;

        //Конструктор
        public data (int day, int month, int year)
        {
            this.day = day;
            this.month = month;
            this.year = year;

        }

        public data()
        {

        }

        //Деструктор
        ~data() { }

        public void SetDay(int day)
        {
            this.day = day;
            if (day > 31)
            {
                this.day = 31;
            }
            if (day < 0)
            {
                this.day = 1;
            }

        }

        public void SetMonth(int month)
        {
            this.month = month;   
            if (month > 12)
            {
                this.month = 12;
            }
            if (month < 0)
            {
                this.month = 1;
            }
        }

        public void SetYear(int year)
        {
            this.year = year;
            if (year < 0)
            {
                this.year = 0;
            }
        }

        public int GetYear()
        {
            return year;
        }

        public int GetMonth()
        {
            return month;
        }

        public int GetDay()
        {
            return day;
        }

        public void CurDate()
        {
            int currentDay = DateTime.Now.Day;
            int currentMonth = DateTime.Now.Month;
            int currentYear = DateTime.Now.Year;

            this.day = currentDay;
            this.month = currentMonth;
            this.year = currentYear;

            Console.WriteLine($"Текущая дата: {currentDay}.{currentMonth}.{currentYear}\n");
        }


        public void EntDate()
        {
            Console.Write("Введите день: ");
            int d = Convert.ToInt32(Console.ReadLine());
            Console.Write("Введите месяц: ");
            int m = Convert.ToInt32(Console.ReadLine());
            Console.Write("Введите год: ");
            int y = Convert.ToInt32(Console.ReadLine());

            this.day = d;
            if (day > 31)
            {
                this.day = 31;
            }
            if (day < 0)
            {
                this.day = 1;
            }

            this.month = m;
            if (month > 12)
            {
                this.month = 12;
            }
            if (month < 0)
            {
                this.month = 1;
            }

            this.year = y;
            if (year < 0)
            {
                this.year = 0;
            }

            GetDate();
        }
        public void increment()
        {
            ++this.day;

            //31 days
            if ((this.day > 31) && ((this.month == 1) || (this.month == 3) || (this.month == 5) || (this.month == 7) || (this.month == 8) || (this.month == 10) || (this.month == 12)))
            {
                this.day = 1;
                ++this.month;

                if (this.month > 12)
                {
                    this.month = 1;
                    ++this.year;
                }

            }

            //30 days
            if ((this.day > 30) && ((this.month == 4) || (this.month == 6) || (this.month == 9) || (this.month == 11)))
            {
                this.day = 1;
                ++this.month;

                if (this.month > 12)
                {
                    this.month = 1;
                    ++this.year;
                }

            }

            //28 feb
            if (this.day > 28 && this.month == 2 && this.year % 4 != 0)
            {
                this.day = 1;
                ++this.month;

                if (this.month > 12)
                {
                    this.month = 1;
                    ++this.year;
                }

            }

            //29 feb
            if (this.day > 29 && this.month == 2 && this.year % 4 == 0)
            {
                this.day = 1;
                ++this.month;

                if (this.month > 12)
                {
                    this.month = 1;
                    ++this.year;
                }

            }

        }

        public void decrement()
        {
            this.day = this.day - 1;

            //31 days (previous)
            if ((this.day < 1) && ((this.month == 1) || (this.month == 2) || (this.month == 4) || (this.month == 6) || (this.month == 8) || (this.month == 9) || (this.month == 11)))
                {
                this.day = 31;
                this.month = this.month - 1;

                if (this.month < 1)
                {
                    this.month = 12;
                    this.year = this.year - 1;
                }

            }

            //30 days (previous)
            if ((this.day < 1) && ((this.month == 5) || (this.month == 7) || (this.month == 10) || (this.month == 12)))
            {
                this.day = 30;
                this.month = this.month - 1;

                if (this.month < 1)
                {
                    this.month = 12;
                    this.year = this.year - 1;
                }

            }

            //28 feb
            if (this.day < 1 && this.month == 3 && this.year % 4 != 0)
            {
                this.day = 28;
                this.month = this.month - 1;
            }

            //29 feb
            if (this.day < 1 && this.month == 3 && this.year % 4 == 0)
            {
                this.day = 29;
                this.month = this.month - 1;
            }

            GetDate();
        }

        //Добавляем дни
        public void AddDays(int number)
        {
            for (int i = 0; i < number; i++)
            {
                increment();
            }
            GetDate();
        }

        public void GetDate()
        {
            Console.WriteLine($"Дата: {day}.{month}.{year}\n");
        }


        public static data operator ++(data day_p)
        {
            day_p.day++;
            return day_p;
        }

        public static data operator --(data day_p)
        {
            day_p.day--;
            return day_p;
        }

    }
}
