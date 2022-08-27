using System;
using System.Collections.Generic;
using System.Text;

namespace lr4
{
    class counter3
    {
        private int its_value;
        public counter3()
        {
            this.its_value = 0;
        }
        ~counter3()
        {
            
        }
        public counter3(int initial_value)
        {
            this.its_value = initial_value;
        }
        public int Get_Its_Value()
        {
            return this.its_value;
        }
        public void Set_Its_Value(int x)
        {
            this.its_value = x;
        }
        public static counter3 operator +(counter3 i, counter3 rhs)
        {
            return new counter3
            {
                its_value = i.its_value + rhs.Get_Its_Value()
            };
        }

    }
}
