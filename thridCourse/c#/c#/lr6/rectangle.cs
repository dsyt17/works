using System;
using System.Collections.Generic;
using System.Text;

namespace lr6
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

        public rectangle(int value)
        {
            this.length = value;
            this.width = value;
        }

        public override long GetArea() 
        { 
            return this.length * this.width; 
        }

        public override long GetPerim()
        {
           return 2 * (this.length + this.width);
        }

        public int GetLength()
        {
            return this.length;
        }

        public int GetWidth() 
        {
            return this.width; 
        }

        public override void Draw()
        {
            Console.WriteLine("Rect");
            for (int i = 0; i < this.length; i++)
            {
                for (int j = 0; j < this.width; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
        }

        ~rectangle()
        {
            Console.WriteLine("Rectangle deconstructor");
        }

    }
}
