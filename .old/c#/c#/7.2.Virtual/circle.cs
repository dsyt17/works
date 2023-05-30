using System;
using System.Collections.Generic;
using System.Text;

namespace _2.Virtual
{ 
    class circle : shape
    {

        public double radius;

        public circle(double radius)
        {
            this.radius = radius;
        }

        public override long GetArea()
        {
            return (long)(3.1415926 * this.radius * this.radius);
        }

        public override long GetPerim()
        {
            return (long)(2 * 3.1415926 * this.radius);
        }

        public override void Draw()
        {
            Console.WriteLine("Circle draw");
        }

        ~circle()
        {

        }
    }
}
