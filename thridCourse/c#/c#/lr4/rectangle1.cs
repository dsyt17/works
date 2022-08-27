using System;
using System.Collections.Generic;
using System.Text;

namespace lr4
{
    class rectangle1
    {
        private int its_width;
        private int its_height;

        public rectangle1(int width, int height)
        {
            this.its_height = height;
            this.its_width = width;
        }
        ~rectangle1()
        {
            ;
        }
        public void Draw(int w, int h)
        {
            for (int x = 0; x < h; x++)
            {
                for (int y = 0; y < w; y++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
        }
        public void Draw()
        {
            Draw(its_width, its_height);
        }


    }
}
