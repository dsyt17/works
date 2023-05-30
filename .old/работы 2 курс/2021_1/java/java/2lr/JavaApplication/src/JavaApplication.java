
import static java.lang.Math.sin;

class JavaApplication {

    public static float function(float x) {
        return (float) (1 + x + sin(2 * x));
    }

    public static float UseRectangleRule(float xmin, float xmax, int num_intervals)
    {
        float total_area = 0;
        float dx = (xmax-xmin) / num_intervals;
        float x = xmin;
        for (int i = 0; i < num_intervals; i++ )
        {
            total_area = total_area + dx * function(x);
            x += dx;
        }
        return total_area;
    }

    public static float UseTrapezoidRule(float xmin, float xmax, int num_intervals)
    {
        float total_area = 0;
        float dx = (xmax-xmin) / num_intervals;
        float x = xmin;
        for (int i = 0; i < num_intervals; i++)

        {
            total_area = total_area + dx * (function(x) + function(x + dx)) / 2;
            x += dx;
        }
        return total_area;

    }
    public static float AdaptiveMidpoint(float xmin, float xmax, int num_intervals, float maxpogresh)
    {
        float total_area = 0;
        float dx = (xmax-xmin) / num_intervals;
        float x = xmin;
        for (int i = 0; i < num_intervals; i++)
        {
            total_area = total_area + SliceArea(x, x + dx, maxpogresh);
            x += dx;
        }
        return total_area;
    }

    public static float SliceArea(float x1, float x2, float maxpogresh)
    {
        float y1 = function(x1);
        float y2 = function(x2);
        float xm = (x1 + x2) / 2;
        float ym = function(xm);
        float area12 = (x2 - x1) * (y1 + y2) / 2;
        float area1m = (xm - x1) * (y1 + ym) / 2;
        float aream2 = (x2 - xm) * (ym + y2) / 2;
        float area1m2 = area1m + aream2;
        float error = (area1m2 - area12) / area12;
        if (Math.abs(error) < maxpogresh)
        {
            return area1m2;
        }
        return SliceArea(x1, xm, maxpogresh) + SliceArea (xm, x2, maxpogresh);
    }

    public static void main(String[] args) {

        float xmin = 4, xmax = 8, maxpogresh = 0.01F, pogu = 27.69F;
        int num_intervals = 8;
        float UseRectangleRule = UseRectangleRule(xmin, xmax, num_intervals);
        float UseTrapezoidRule = UseTrapezoidRule(xmin, xmax, num_intervals);
        float AdaptiveMidpoint = AdaptiveMidpoint(xmin, xmax, num_intervals, maxpogresh);

        System.out.println("Начальная граница: "  + xmin + "\nКонечная граница: " + xmax);
        System.out.printf(" | Метод | Расчётное значение |  Погрешность  | Количество шагов ");
        System.out.printf( " \n | СВИ   |       " + "%.3f       | " +  "     нет      | " + "       %d\n", pogu, num_intervals);
        System.out.printf( " | МП    |       " + "%.3f " + "      | "  + " %.6f " + "   | " + "       %d\n", UseRectangleRule, pogu - UseRectangleRule,num_intervals);
        System.out.printf( " | МТ    |       " + "%.3f " + "      | " + " %.6f " + "   | " + "       %d\n", UseTrapezoidRule, pogu - UseTrapezoidRule,num_intervals);
        System.out.printf( " | АМТ   |       " + "%.3f " + "      | "  + " %.6f " + "   | " +  "       %d\n", AdaptiveMidpoint, pogu - AdaptiveMidpoint,num_intervals);
    }
}

