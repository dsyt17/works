using System;
using System.Collections.Generic;
using System.Text;

namespace lr6
{
    class circle : shape
    {
        private int radius;
        public circle(int radius)
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
            Console.WriteLine("Circle draw here");
        }
        ~circle()
        {
            Console.WriteLine("Circle deconstructor");
        }

    }
}
