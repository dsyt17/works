using System;
using System.Collections.Generic;
using System.Text;

namespace lr1._1_cat_
{
    class cat { 

        //Конструктор

            public cat(int initial_age) {
                  its_age = initial_age;
                }

        //Деструктор

        ~cat() { }

            private int its_age;

            public cat() { 
                  its_age = 0; 
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

             }
}