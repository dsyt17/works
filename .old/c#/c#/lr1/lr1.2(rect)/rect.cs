using System;
using System.Collections.Generic;
using System.Text;

namespace lr1._2_rect_
{
    class rect {

        public rect(int top, int left, int bottom, int right) {

            itsTop = top;
            itsLeft = left;
            itsBottom = bottom;
            itsRight = right;

            itsUpperLeft.SetX(left);
            itsUpperLeft.SetY(top);

            itsUpperRight.SetX(right);
            itsUpperRight.SetY(top);

            itsLowerLeft.SetX(left);
            itsLowerLeft.SetY(bottom);

            itsLowerRight.SetX(right);
            itsLowerRight.SetY(bottom);
            }

        private point itsUpperLeft = new point();
        private point itsUpperRight = new point();
        private point itsLowerLeft = new point();
        private point itsLowerRight = new point();

        private int itsTop, itsLeft, itsBottom, itsRight;

        public int GetTop() {
            return itsTop;
            }

        public int GetLeft() {
            return itsLeft;
            }

        public int GetBottom() {
            return itsBottom;
            }

        public int GetRight() {
            return itsRight;
            }

        public int GetArea() {
            int Width = itsRight - itsLeft;
            int Height = itsTop - itsBottom;
            return (Width * Height);
            }

        public point GetUpperLeft() {
            return itsUpperLeft;
            }

        public point GetLowerLeft() {
            return itsLowerLeft;
            }

        public point GetUpperRight() {
            return itsUpperRight;
            }

        public point GetLowerRight() {
            return itsLowerRight;
            }

        public void SetUpperLeft(point Location) {
            itsUpperLeft = Location;
            }
        public void SetLowerLeft(point Location) {
            itsLowerLeft = Location;
            }
        public void SetUpperRight(point Location) {
            itsUpperRight = Location;
            }
        public void SetLowerRight(point Location) {
            itsLowerRight = Location;
            }

        public void SetTop(int top) {
            itsTop = top;
            }
        public void SetLeft(int left) {
            itsLeft = left;
            }
        public void SetBottom(int bottom) {
            itsBottom = bottom;
            }
        public void SetRight(int right) {
            itsRight = right;
            }

    }
}
