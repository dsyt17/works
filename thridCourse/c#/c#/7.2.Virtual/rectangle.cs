using System;
using System.Collections.Generic;
using System.Text;

namespace _2.Virtual
{
    class rectangle : shape
    {
        internal int length;
        internal int width;
        public rectangle(int length, int width)
        {
            this.length = length;
            this.width = width;
        }

        public override long GetArea()
        {
            return this.length * this.width;
        }

        public override long GetPerim()
        {
            return 2 * (this.length + this.width);
        }

        public override void Draw()
        {
            Console.WriteLine("Rectangle draw");
           
        }

        public int GetLength()
        {
            return this.length;
        }

        public int GetWidth()
        {
            return this.width;
        }

        ~rectangle()
        {
           
        }

    }
}
