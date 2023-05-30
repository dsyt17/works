using System;
using System.Collections.Generic;
using System.Text;

namespace lr6
{
    class shape
    {
        public shape()
        {
            Console.WriteLine("Shape constructor");
        }

        public virtual long GetArea()
        {
            return -1;
        }

        public virtual long GetPerim()
        {
            return -1;
        }

        public virtual void Draw() 
        { 

        }

        ~shape()
        {
            Console.WriteLine("Shape deconstructor");
        }

    }
}
