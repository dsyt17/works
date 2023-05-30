using System;
using System.Collections.Generic;
using System.Text;

namespace _7._1.Complex
{
    class Complex
    {

        public double Real, Imaginary;

        public Complex()
        {
            this.Real = 0.0;
            this.Imaginary = 0.0;
        }

        public static Complex Sum(Complex a, Complex b)
        {
            Complex Sum = new Complex();
            Sum.Real = a.Real + b.Real;
            Sum.Imaginary = a.Imaginary + b.Imaginary;
            return Sum;
        }

        public static Complex Multiply(Complex a, Complex b)
        {
            Complex Multiply = new Complex();
            Multiply.Real = a.Real * b.Real - a.Imaginary * b.Imaginary;
            Multiply.Imaginary = a.Imaginary * b.Real + a.Real * b.Imaginary;
            return Multiply;
        }

        public static Complex Subtract(Complex a, Complex b)
        {
            Complex Subtract = new Complex();
            Subtract.Real = a.Real - b.Real;
            Subtract.Imaginary = a.Imaginary - b.Imaginary;
            return Subtract;
        }

        public static Complex operator +(Complex a, Complex b)
        {
            return Complex.Sum(a, b);
        }

        public static Complex operator -(Complex a, Complex b)
        {
            return Complex.Subtract(a, b);
        }

        public static Complex operator *(Complex a, Complex b)
        {
            return Complex.Multiply(a, b);
        }

        public override string ToString()
        {
            return String.Format("{0} + {1}i", this.Real, this.Imaginary);
        }
      
        public void Print(Complex a)
        {
            Console.WriteLine(a);
        }

    }
}
