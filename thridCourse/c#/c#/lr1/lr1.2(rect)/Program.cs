using System;

namespace lr1._2_rect_
{
    class Program
    {
        static void Main(string[] args)
        {
            
            rect MyRectangle = new rect(100, 20, 50, 70);
            int Area = MyRectangle.GetArea();

            Console.WriteLine("Rectangle coordinates: " +
            "A(" + MyRectangle.GetUpperRight().GetX() + "," + MyRectangle.GetUpperRight().GetY() + "), " +
            "B(" + MyRectangle.GetUpperLeft().GetX() + "," + MyRectangle.GetUpperLeft().GetY() + "), " +
            "C(" + MyRectangle.GetLowerRight().GetX() + "," + MyRectangle.GetLowerRight().GetY() + "), " +
            "D(" + MyRectangle.GetLowerLeft().GetX() + "," + MyRectangle.GetLowerLeft().GetY() + ");");

            Console.WriteLine("Area: " + Area);

            Console.ReadKey();
        }
    }
}
