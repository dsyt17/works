using System;
using System.Collections.Generic;
using System.Text;

namespace _7._9.Matrix
{
    class Matrix
    {
        // Скрытые поля
        private int n;
        private int[,] mass;

        // Конструкторы матрицы
        public Matrix() { }
        public int N
        {
            get { return n; }
            set { if (value > 0) n = value; }
        }

        public Matrix(int n)
        {
            this.n = n;
            mass = new int[this.n, this.n];
        }
        public int this[int i, int j]
        {
            get
            {
                return mass[i, j];
            }
            set
            {
                mass[i, j] = value;
            }
        }

        // Ввод матрицы с клавиатуры
        public void WriteMat()
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    Console.WriteLine("Введите элемент матрицы {0}:{1}", i + 1, j + 1);
                    mass[i, j] = Convert.ToInt32(Console.ReadLine());
                }
            }
        }

        // Вывод матрицы
        public void ReadMat()
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    Console.Write(mass[i, j] + "\t");
                }
                Console.WriteLine();
            }
        }


        // Умножение матрицы А на матрицу Б
        public static Matrix umn(Matrix a, Matrix b)
        {
            Matrix resMass = new Matrix(a.N);
            for (int i = 0; i < a.N; i++)
                for (int j = 0; j < b.N; j++)
                    for (int k = 0; k < b.N; k++)
                        resMass[i, j] += a[i, k] * b[k, j];

            return resMass;
        }


        // перегрузка оператора умножения
        public static Matrix operator *(Matrix a, Matrix b)
        {
            return Matrix.umn(a, b);
        }

        // Метод вычитания матрицы Б из матрицы А
        public static Matrix razn(Matrix a, Matrix b)
        {
            Matrix resMass = new Matrix(a.N);
            for (int i = 0; i < a.N; i++)
            {
                for (int j = 0; j < b.N; j++)
                {
                    resMass[i, j] = a[i, j] - b[i, j];
                }
            }
            return resMass;
        }

        // Перегрузка оператора вычитания
        public static Matrix operator -(Matrix a, Matrix b)
        {
            return Matrix.razn(a, b);
        }

        public static Matrix Sum(Matrix a, Matrix b)
        {
            Matrix resMass = new Matrix(a.N);
            for (int i = 0; i < a.N; i++)
            {
                for (int j = 0; j < b.N; j++)
                {
                    resMass[i, j] = a[i, j] + b[i, j];
                }
            }
            return resMass;
        }

        // Перегрузка сложения
        public static Matrix operator +(Matrix a, Matrix b)
        {
            return Matrix.Sum(a, b);
        }

        ~Matrix()
        {
            
        }
    }
}
