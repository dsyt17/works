using System;
using System.Collections.Generic;
using System.Text;

namespace lr4
{
    class counter2
    {
        private int its_value;
        public counter2()
        {
            this.its_value = 0;
        }
        ~counter2()
        {
            ;
        }
        public int Get_Its_Value()
        {
            return this.its_value;
        }
        public void Set_Its_Value(int x)
        {
            this.its_value = x;
        }
        public static counter2 operator ++(counter2 i)
        {
            return new counter2
            {
                its_value = i.its_value + 1
            };
        }


    }
}
