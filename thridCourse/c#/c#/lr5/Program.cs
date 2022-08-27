using System;

namespace lr5
{
  class Program
  {
    static void Main(string[] args)
    {
            //Задание 1
            Console.WriteLine("Задание 1\n");
            dog fido = new dog();
            fido.speak();
            fido.WagTail();
            Console.WriteLine("fido is " + fido.GetAge()+" years old\n");
            Console.WriteLine("===============================================");

            //Задание 2
            Console.WriteLine("Задание 2\n");
            dog_overload fido_overload = new dog_overload("fido", 5, 8, breed.doberman);
            Console.WriteLine("fido_overload is " + fido_overload.GetAge() + " years old\n");
            Console.WriteLine("fido_overload is " + fido_overload.get_weight() + " pounds weighs\n");
            Console.WriteLine("===============================================");

            //Задание 3
            Console.WriteLine("Задание 3\n");
            Console.WriteLine(fido_overload.ToString());
            Console.ReadKey();

        }
  }
}
