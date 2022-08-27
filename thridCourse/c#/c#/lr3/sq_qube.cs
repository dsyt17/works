using System;
using System.Collections.Generic;
using System.Text;

namespace lr1._1_cat_
{
    class sq_qube
    {
        public static Tuple<int, int> sq_qube_return(int num)
        {
            return Tuple.Create(num * num, num * num * num);
        }

    }
}
