using System;
using System.Collections.Generic;
using System.Text;

namespace lr4
{
    class counter1
    {
        private int its_value;
        public counter1()
        {
            this.its_value = 0;
        }
        ~counter1()
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
        public void increment()
        {
            ++this.its_value;
        }
        public static counter1 operator ++(counter1 i)
        {
            i.its_value++;
            return i;
        }

    }
}
