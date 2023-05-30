using System;

namespace lr4
{
    class Program
    {
        static void Main(string[] args)
        {
            //Задание 1
            Console.WriteLine("4.1:");
            rectangle1 rect = new rectangle1(25, 7);
            Console.WriteLine("Draw 1:");
            rect.Draw();
            Console.WriteLine("Draw 2:");
            Console.Write("enter a width: ");
            int w = Convert.ToInt32(Console.ReadLine());
            Console.Write("enter a length: ");
            int h = Convert.ToInt32(Console.ReadLine());
            rect.Draw(w, h); 
            Console.WriteLine("--------------------------------------------------");

            //Задание 2
            Console.WriteLine("4.2:");
            rectangle2 rect1 = new rectangle2();
            Console.WriteLine("rect1 width: " + rect1.Get_Width());
            Console.WriteLine("rect1 length: " + rect1.Get_Length());
            Console.Write("enter a width: ");
            int w1 = Convert.ToInt32(Console.ReadLine());
            Console.Write("enter a length: ");
            int h1 = Convert.ToInt32(Console.ReadLine());
            rectangle2 rect2 = new rectangle2(w1, h1);
            Console.WriteLine("rect2 width: " + rect2.Get_Width());
            Console.WriteLine("rect2 length: " + rect2.Get_Length());
            Console.WriteLine("--------------------------------------------------");

            //Задание 3
            Console.WriteLine("4.3:");
            counter1 i = new counter1();
            Console.Write("enter a initial counter value: ");
            int c = Convert.ToInt32(Console.ReadLine());
            i.Set_Its_Value(c);
            Console.WriteLine("Value of counter is " + i.Get_Its_Value());
            i.increment();
            Console.WriteLine("Value of counter is " + i.Get_Its_Value());
            ++i;
            Console.WriteLine("Value of counter is " + i.Get_Its_Value());
            Console.WriteLine("--------------------------------------------------");

            //Задание 4
            Console.WriteLine("4.4:");
            counter2 i2 = new counter2();
            Console.WriteLine("Value of counter is " + i2.Get_Its_Value());
            i2++;
            Console.WriteLine("Value of counter is " + i2.Get_Its_Value());
            ++i2;
            Console.WriteLine("Value of counter is " + i2.Get_Its_Value());

            counter2 a2 = new counter2();
            a2 = ++i2;
            Console.WriteLine("Value of a is " + a2.Get_Its_Value());
            Console.WriteLine("Value of counter is " + i2.Get_Its_Value());

            a2 = i2++;
            Console.WriteLine("Value of a is " + a2.Get_Its_Value());
            Console.WriteLine("Value of counter is " + i2.Get_Its_Value());
            Console.WriteLine("--------------------------------------------------");

            //Задание 5
            Console.WriteLine("4.5:");
            int a3 = 2;
            counter3 var1 = new counter3(a3);
            counter3 var2 = new counter3(5);
            counter3 var3 = new counter3();
            var3 = var1 + var2;
            Console.WriteLine("var1 = " + var1.Get_Its_Value());
            Console.WriteLine("var2 = " + var2.Get_Its_Value());
            Console.WriteLine("var3 = " + var3.Get_Its_Value());
            Console.ReadKey();
        }

    }
    
}
