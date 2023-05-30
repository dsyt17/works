using System;
using System.Collections.Generic;
using System.Text;

namespace lr5
{
    public enum breed { golden, cairn, dandie, shetland, doberman, lab };
    public class mammal
  {
    protected int its_age;
    protected int its_weight;

    public mammal()
    {
      its_age = 2; 
      its_weight = 5;
    }

        ~mammal() { }

    public void set_age(int age) 
    { 
      its_age = age; 
    }

    public int get_weight() 
    {
      return its_weight;
    }

    public void set_weight(int weight) 
    { 
      its_weight = weight; 
    }


    public int GetAge()
    {
      return its_age;
    }

    

     public void speak() {Console.WriteLine("mammal sound\n");}
     public void sleep() {Console.WriteLine("mammal sleep\n");}
        

    }
}
