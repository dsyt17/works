using System;
using System.Collections.Generic;
using System.Text;

namespace _7._3.Rational
{
    class Rational
    {
        public int numerator, denominator, nod;

        public int numerator2, denominator2;


        //Основной конструктор
        public Rational(int numerator, int denominator)
        {
            numerator2 = numerator;
            denominator2 = denominator;

            if (numerator2 < 0)
            {
                numerator = -numerator;
                numerator2 = -numerator2;

                while (numerator != denominator)
                {
                    if (numerator > denominator)
                    {
                        numerator = numerator - denominator;
                    }
                    else
                    {
                        denominator = denominator - numerator;
                    }
                }

                nod = denominator;

                numerator2 = numerator2 / nod;
                denominator2 = denominator2 / nod;

                this.numerator = -numerator2;
                this.denominator = denominator2;
            }
            else
            {

                while (numerator != denominator)
                {
                    if (numerator > denominator)
                    {
                        numerator = numerator - denominator;
                    }
                    else
                    {
                        denominator = denominator - numerator;
                    }
                }

                nod = denominator;

                numerator2 = numerator2 / nod;
                denominator2 = denominator2 / nod;

                this.numerator = numerator2;
                this.denominator = denominator2;
            }
        }


        //Конструктор без параметров
        public Rational()
        {
            this.numerator = 0;
            this.denominator = 0;
        }

        public int GetNumerator()
        {
            return numerator2;
        }

        public int GetDenominator()
        {
            return denominator2;
        }


        //Оператор сложения
        public static Rational Sum(Rational a, Rational b)
        {
            Rational Sum = new Rational();

            int a1, a2, d;

            a1 = a.numerator * b.denominator;
            a2 = b.numerator * a.denominator;

            d = a.denominator * b.denominator;

            Sum.numerator = a1 + a2;
            Sum.denominator = d;

            return Sum;
        }

        //Перегрузка суммы
        public static Rational operator +(Rational a, Rational b)
        {
            return Rational.Sum(a, b);
        }


        //Оператор вычитания
        public static Rational Subtraction(Rational a, Rational b)
        {
            Rational Subtraction = new Rational();

            int a1, a2, d;

            a1 = a.numerator * b.denominator;
            a2 = b.numerator * a.denominator;

            d = a.denominator * b.denominator;

            Subtraction.numerator = a1 - a2;
            Subtraction.denominator = d;

            return Subtraction;
        }

        //Перегрузка вычитания
        public static Rational operator -(Rational a, Rational b)
        {
            return Rational.Subtraction(a, b);
        }


        //Оператор умножения
        public static Rational Multiply(Rational a, Rational b)
        {
            Rational Multiply = new Rational();
       
            Multiply.numerator = a.numerator * b.numerator;
            Multiply.denominator = a.denominator * b.denominator;

            return Multiply;
        }

        //Перегрузка умножения
        public static Rational operator *(Rational a, Rational b)
        {
            return Rational.Multiply(a, b);
        }


        //Оператор деления
        public static Rational Dividing(Rational a, Rational b)
        {
            Rational Dividing = new Rational();

            int tempBn, tempBd;
            tempBn = b.numerator;
            tempBd = b.denominator;
            b.numerator = b.denominator;
            b.denominator = tempBn;

            Dividing.numerator = a.numerator * b.numerator;
            Dividing.denominator = a.denominator * b.denominator;

            b.numerator = tempBn;
            b.denominator = tempBd;

            return Dividing;
        }

        //Перегрузка деления
        public static Rational operator /(Rational a, Rational b)
        {
            return Rational.Dividing(a, b);
        }


        //Сокращаем дробь(НОД)
        public void GetDivider(Rational r)
        {
            numerator2 = numerator;
            denominator2 = denominator;

            if(numerator2 < 0)
            {
                numerator = - numerator;
                numerator2 = - numerator2;

                while (numerator != denominator)
                {
                    if (numerator > denominator)
                    {
                        numerator = numerator - denominator;
                    }
                    else
                    {
                        denominator = denominator - numerator;
                    }
                }

                nod = denominator;

                numerator2 = numerator2 / nod;
                denominator2 = denominator2 / nod;

                this.numerator = - numerator2;
                this.denominator = denominator2;
            }
            else
            { 

                while (numerator != denominator)
                {
                    if (numerator > denominator)
                    {
                        numerator = numerator - denominator;
                    }
                    else
                    {
                        denominator = denominator - numerator;
                    }
                }

                nod = denominator;

                numerator2 = numerator2 / nod;
                denominator2 = denominator2 / nod;

                this.numerator = numerator2;
                this.denominator = denominator2;
            }
        }


        //Вид вывода дроби в консоли
        public override string ToString()
        {
            return String.Format("{0}/{1}", this.numerator, this.denominator);
        }

        //Вывод дроби
        public void Print(Rational r)
        {
            Console.WriteLine(r);
        }

        //Вывод числа
        public double PrintDouble(Rational r)
        {
            double number, n1, n2;
            n1 = r.numerator;
            n2 = r.denominator;
            number = n1 / n2;            
            return Math.Round(number, 3);
        }

    }
}
