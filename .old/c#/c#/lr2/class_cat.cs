using System;
using System.Collections.Generic;
using System.Text;

namespace lr1._1_cat_
{
    class cat { 
            public cat(int its_age) {
                  this.its_age = its_age;
                }

            private int its_age, its_weight;

             ~cat() { }

            public cat() { 
                  its_age = 0;
                  set_weight(1);
                }

            public int get_age() {
                  return its_age;
                }

            public void meow() { 
                  Console.WriteLine("Meow!");
               }

            public void set_age(int age) {
                  its_age = age; 
               }

            public void set_weight(int weight)
                  {
                    this.its_weight = weight;
                 }

            public int get_weight()
                 {
                     return this.its_weight;
                 }

    }
}