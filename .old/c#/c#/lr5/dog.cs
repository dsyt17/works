using System;
using System.Collections.Generic;
using System.Text;

namespace lr5
{

  public class dog : mammal
  {
         private breed its_breed;
        
        public dog(breed its_breed)
        {
            this.its_breed = breed.golden;
        }

        public dog()
        {
            
        }

        ~dog() { }

        public breed GetBreed() {

            return its_breed;
        }

        public void SetBread(breed br)
        {
            its_breed = br;
        }

        public void WagTail()
        {
            Console.WriteLine("tail wadding\n");
        }

        public void BegForFood()
        {
            Console.WriteLine("begging for food\n");
        }

    }
}
