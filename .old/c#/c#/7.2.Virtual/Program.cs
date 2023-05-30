using System;

namespace _2.Virtual
{
    class Program
    {
        static void Main(string[] args)
        {
            int choice1;
            int choice2;

            while (true)
            {
                Console.WriteLine("(1) - new shape\n" +
                                    "(2) - new animal");


                choice1 = Convert.ToInt32(Console.ReadLine());
                if (choice1 < 1 || choice1 > 2) { Console.Write("Enter numbers between 1-2\n"); }

                else
                {
                    switch (choice1)
                    {
                        case 1:
                            Console.Write("(1) - Circle\n(2) - Rectangle\n(3) - Triangle \n");
                            try
                            {
                                choice2 = Convert.ToInt32(Console.ReadLine());
                                if (choice2 < 1 || choice2 > 3) { Console.Write("Enter numbers between 1-3\n"); }
                                else
                                {
                                    switch (choice2)
                                    {

                                        case 1:
                                            Console.Write("Enter radius: ");
                                            double radius;
                                            try
                                            {
                                                radius = double.Parse(Console.ReadLine());
                                                if (radius > 0)
                                                {
                                                    circle circle = new circle(radius);
                                                    Console.Write("Circle with radius " + radius + "\n");
                                                    Console.Write($"Perimeter: " + circle.GetPerim() + "\n");
                                                    Console.Write($"Area: " + circle.GetArea() + "\n");
                                                    Console.Write("Print: \n");
                                                    circle.Draw();
                                                    Console.WriteLine();
                                                }
                                                else
                                                {
                                                    Console.Write("Radius must be > 0\n");
                                                }
                                            }
                                            catch
                                            {
                                                Console.Write("Radius must be > 0\n");
                                            }
                                            break;

                                        case 2:

                                            try
                                            {
                                                int length;
                                                int width;
                                                Console.Write("Enter length: ");
                                                length = int.Parse(Console.ReadLine());
                                                Console.Write("Enter width: ");
                                                width = int.Parse(Console.ReadLine());

                                                if (length > 0 & width > 0)
                                                {
                                                    rectangle rectangle = new rectangle(length, width);
                                                    Console.Write("Rectangle (" + length + "," + width + ")\n");
                                                    Console.Write($"Perimeter: " + rectangle.GetPerim() + "\n");
                                                    Console.Write($"Area: " + rectangle.GetArea() + "\n");
                                                    Console.Write("Print: \n");
                                                    rectangle.Draw();
                                                    Console.WriteLine();
                                                }
                                                else
                                                {
                                                    Console.Write("Enter correct length  and width\n");
                                                }
                                            }
                                            catch
                                            {
                                                Console.Write("Enter correct length  and width\n");
                                            }
                                            break;

                                        case 3:
                                            int triChoise;
                                            Console.Write("(1) - enter side\n(2) - enter foundation and height ");
                                            triChoise = int.Parse(Console.ReadLine());
                                            switch (triChoise)
                                            {

                                                case 1:
                                                    try
                                                    {
                                                        int side;
                                                        Console.Write("Enter side: ");
                                                        side = int.Parse(Console.ReadLine());
                                                        if (side > 0)
                                                        {
                                                            triangle triangle = new triangle(side);
                                                            Console.Write("Triangle with side " + side + "\n");
                                                            Console.Write($"Perimeter: " + triangle.GetPerim(side) + "\n");
                                                            Console.Write($"Area: " + triangle.GetArea(side) + "\n");
                                                            Console.Write("Print: \n");
                                                            triangle.Draw();
                                                            Console.WriteLine();
                                                        }
                                                        else
                                                        {
                                                            Console.Write("Enter correct side\n");
                                                        }
                                                    }
                                                    catch
                                                    {
                                                        Console.Write("Enter correct side\n");
                                                    }
                                                    break;
                                                case 2:
                                                    try
                                                    {
                                                        int foundation;
                                                        int height;
                                                        Console.Write("Enter foundation: ");
                                                        foundation = int.Parse(Console.ReadLine());
                                                        Console.Write("Enter height: ");
                                                        height = int.Parse(Console.ReadLine());
                                                        if (foundation > 0 & height > 0)
                                                        {
                                                            triangle triangle = new triangle(foundation, height);
                                                            Console.Write("Triangle with foundation" + foundation + " and " + height + " height\n");
                                                            Console.Write($"Perimeter: " + triangle.GetPerim() + "\n");
                                                            Console.Write($"Area: " + triangle.GetArea() + "\n");
                                                            Console.Write("Print: \n");
                                                            triangle.Draw();
                                                            Console.WriteLine();
                                                        }
                                                        else
                                                        {
                                                            Console.Write("Enter correct data\n");
                                                        }
                                                    }
                                                    catch
                                                    {
                                                        Console.Write("Enter correct data\n");
                                                    }
                                                    break;

                                            }
                                            break;
                                    }

                                }

                            }
                            catch
                            {

                            }

                            break;


                        case 2:
                            int choiseAnimal;
                            Console.Write("(1) - Dog\n(2) - Platypus\n");
                            choiseAnimal = int.Parse(Console.ReadLine());

                            switch (choiseAnimal)
                            {
                                case 1:

                                    Console.WriteLine("Dog: ");
                                    Dog dog = new Dog();
                                    dog.Check();
                                    dog.PrintAnimal();
                                    Console.WriteLine("");
                                    break;

                                case 2:
                                    Console.WriteLine("Platypus: ");
                                    Platypus platypus = new Platypus();
                                    platypus.Check();
                                    platypus.PrintAnimal();
                                    Console.WriteLine("");

                                    break;
                            }

                            break;


                    }


                }



            }
        }

    }
}
