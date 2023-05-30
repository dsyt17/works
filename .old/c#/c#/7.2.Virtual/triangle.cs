using System;
using System.Collections.Generic;
using System.Text;

namespace _2.Virtual
{
 
    class triangle : shape
    {
        public int foundation { get; set; }
        public int height { get; set; }
        public int side { get; set; }

        public triangle(int foundation, int height)
        {
            this.foundation = foundation;
            this.height = height;
        }

        public triangle(int side)
        {
            this.side = side;
        }

        public virtual double GetArea()
        {
            double area;
            area = 0.5 * (this.foundation * this.height);
            return area;
        }

        public virtual double GetArea(int side)
        {
            return (this.side ^ 2 * (3 ^ 1 / 2)) / 4;
        }

        public override long GetPerim()
        {
            int _side;
            _side = ((this.foundation / 2) ^ 2 + this.height ^ 2) ^ (1 / 2);
            return _side*3;
        }

        public virtual long GetPerim(int side)
        {
            return side * 3;
        }

        public override void Draw()
        {
            Console.WriteLine("Triangle draw");
           

        }


    }
}
