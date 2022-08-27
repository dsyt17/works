using System;
using System.Collections.Generic;
using System.Text;

namespace lr4
{
    class rectangle2
    {
        private int its_width;
        private int its_length;
        public rectangle2()
        {
            this.its_width = 5;
            this.its_length = 6;
        }
        public rectangle2(int width, int lenght)
        {
            this.its_length = lenght;
            this.its_width = width;
        }
        public int Get_Width()
        {
            return this.its_width;
        }
        public int Get_Length()
        {
            return this.its_length;
        }

    }
}
