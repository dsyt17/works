using System;
using System.Collections.Generic;
using System.Text;

namespace lr5
{

    class dog_overload : mammal
    {
        private breed its_breed;

        private string name;

        //Перегружаем конструкторы
        public dog_overload(breed its_breed)
        {
            this.its_breed = breed.golden;
        }

        public dog_overload(string name, int its_age, int its_weight, breed its_breed)
        {
            this.name = name;
            this.its_age = 3;
            this.its_weight = 7;
            this.its_breed = breed.golden;
        }

        public dog_overload()
        {

        }

        ~dog_overload() { }

        public breed GetBreed()
        {

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

        public string GetName()
        {
            return name;
        }

        public override string ToString()
        {
            return "Name: " + GetName().ToString() + ", Age: " + GetAge().ToString() + ", Weight: " + get_weight().ToString();
        }


    }
}
