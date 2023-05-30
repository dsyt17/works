using System;
using System.Collections.Generic;
using System.Text;

namespace lr6
{
    class square : rectangle
    {
        public square(int length, int width) : base(length, width)
        {
            if (GetLength() != GetWidth())
                Console.WriteLine("Not a square");
            else
            {
                this.length = length;
                this.width = width;
            }
        }

        public square(int value) : base(value)
        {
            this.length = value;
            this.width = value;
        }

        public override void Draw()
        {
            Console.WriteLine("Square");
            for (int i = 0; i < this.length; i++)
            {
                for (int j = 0; j < this.width; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
        }

        public override long GetPerim()
        {
            return 4 * GetLength();
        }

        ~square()
        {
            Console.WriteLine("Square deconstructor");
        }
    }
}
