using System;
using System.Collections.Generic;
using System.Text;

namespace _2.Virtual
{
    interface area_interface
    {

        public virtual long GetArea()
        {
            return -1;
        }

    }

    interface perim_interface
    {
        public virtual long GetPerim()
        {
            return -1;
        }

    }

    interface draw_interface
    {
        public virtual void Draw()
        {

        }
    }

    abstract class shape : area_interface, perim_interface, draw_interface
    {
        public int its_area { get; set; }

        public int its_perim { get; set; }

        public virtual long GetArea()
        {
            return its_area;
        }

        public virtual long GetPerim()
        {
            return its_perim;
        }

        public virtual void Draw()
        {

        }

    }
}
