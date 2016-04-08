import java.awt.Color;
import java.awt.Graphics;

public class Lasers {

    Medium m;

    /**
     * laser speed
     */
    public static int[] speed = {
    		200, 150, 120, 120, 100, 100, 140, 100, 150, 120, 150, 150
    };

    /**
     * laser rads
     */
    public static int[] rads = {
    		200, 200, 300, 300, 200, 150, 160, 160, 160, 200, 200, 300
    };

    /**
     * laser srate
     */
    public static int[] srate = {
    		8, 8, 10, 10, 8, 6, 8, 6, 10, 10, 10, 10
    };

    /**
     * laser damg
     */
    public static int[] damg = {
    		3, 2, 2, 3, 2, 1, 1, 2, 2, 2, 3, 7
    };

    public int ys(int i, int j) {
        if (j < 10) {
            j = 10;
        }
        return (j - m.focus_point) * (m.cy - i) / j + i;
    }

    public Lasers(Medium medium) {
        m = medium;
    }

    public void dt(Graphics graphics, int[] ints, int[] ints2, int[] ints3, int i, int j, int k, int l, int i1, int j1, int k1, int l2, int i2, int j2, int k2) {
        for (int l3 = 0; l3 < k1; ++l3) {
            if (l2 == 0) {
                ints[l3] += i - m.x;
                ints2[l3] += j - m.y;
                ints3[l3] += k - m.z;
            } else {
                ints[l3] = (int) ((double) ints[l3] + (double) (i - m.x) + (Math.random() * 50.0D - 25.0D));
                ints2[l3] = (int) ((double) ints2[l3] + (double) (j - m.y) + (Math.random() * 50.0D - 25.0D));
                ints3[l3] = (int) ((double) ints3[l3] + (double) (k - m.z) + (Math.random() * 50.0D - 25.0D));
            }
        }
        rot(ints, ints2, i - m.x, j - m.y, j1, k1);
        rot(ints2, ints3, j - m.y, k - m.z, i1, k1);
        rot(ints, ints3, i - m.x, k - m.z, l, k1);
        rot(ints, ints3, m.cx, m.cz, m.xz, k1);
        rot(ints2, ints3, m.cy, m.cz, m.zy, k1);
        int[] ints4 = new int[k1];
        int[] ints5 = new int[k1];
        boolean flag = false;
        for (int i3 = 0; i3 < k1; ++i3) {
            ints4[i3] = xs(ints[i3], ints3[i3]);
            ints5[i3] = ys(ints2[i3], ints3[i3]);
            if (ints5[i3] > 0 && ints5[i3] < m.h && ints4[i3] > 0 && ints4[i3] < m.w && ints3[i3] > 10) {
                flag = true;
            }
        }
        if (flag) {
            if (l2 != 0) {
                if (l2 == 1) {
                    i2 = 255;
                    j2 = 235;
                    k2 = 120;
                } else {
                    i2 = 255;
                    j2 = 220;
                    k2 = 111;
                }
            }
            graphics.setColor(new Color(i2, j2, k2));
            graphics.fillPolygon(ints4, ints5, k1);
        }
    }

    public void d(Graphics graphics, int i, int j, int k, int l, int i1, int j1, int k1, int l2) {
        byte b = 4;
        int[] ints = new int[b];
        int[] ints2 = new int[b];
        int[] ints3 = new int[b];
        if (i == 0) {
            b = 4;
            ints[0] = 3;
            ints2[0] = 3;
            ints3[0] = 0;
            ints[1] = -3;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = -3;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 3;
            ints2[3] = 3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, 0, b, l2, 200, 255, 240);
            b = 4;
            ints[0] = 0;
            ints2[0] = -3;
            ints3[0] = 0;
            ints[1] = 0;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = 0;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 0;
            ints2[3] = -3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, 0, b, l2, 200, 255, 240);
            b = 4;
            ints[0] = -3;
            ints2[0] = -3;
            ints3[0] = -100;
            ints[1] = -3;
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = 3;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 3;
            ints2[3] = -3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, 0, b, l2, 200, 255, 240);
        }
        if (i == 1) {
            b = 4;
            ints[0] = 20;
            ints2[0] = 0;
            ints3[0] = -10;
            ints[1] = -20;
            ints2[1] = 0;
            ints3[1] = -10;
            ints[2] = -30;
            ints2[2] = 0;
            ints3[2] = 30;
            ints[3] = 30;
            ints2[3] = 0;
            ints3[3] = 30;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 149, 255, 205);
            b = 3;
            ints[0] = 0;
            ints2[0] = 0;
            ints3[0] = 30;
            ints[1] = 0;
            ints2[1] = -3;
            ints3[1] = -10;
            ints[2] = 0;
            ints2[2] = 0;
            ints3[2] = -10;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 149, 255, 205);
            b = 4;
            ints[0] = -20;
            ints2[0] = 0;
            ints3[0] = -10;
            ints[1] = -20;
            ints2[1] = -3;
            ints3[1] = -10;
            ints[2] = 20;
            ints2[2] = -3;
            ints3[2] = -10;
            ints[3] = 20;
            ints2[3] = 0;
            ints3[3] = -10;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 0, 232, 215);
        }
        if (i == 2) {
            b = 4;
            ints[0] = -87 + (int) (Math.random() * 10.0D);
            ints2[0] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[0] = 30 + (int) (Math.random() * 50.0D - 25.0D);
            ints[1] = -93 - (int) (Math.random() * 10.0D);
            ints2[1] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[1] = 30 + (int) (Math.random() * 50.0D - 25.0D);
            ints[2] = -93 - (int) (Math.random() * 10.0D);
            ints2[2] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[2] = -100 + (int) (Math.random() * 50.0D - 25.0D);
            ints[3] = -87 + (int) (Math.random() * 10.0D);
            ints2[3] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[3] = -100 + (int) (Math.random() * 50.0D - 25.0D);
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 193, 224, 255);
            b = 4;
            ints[0] = -90;
            ints2[0] = -2;
            ints3[0] = 30;
            ints[1] = -90;
            ints2[1] = 2;
            ints3[1] = 30;
            ints[2] = -90;
            ints2[2] = 2;
            ints3[2] = -100;
            ints[3] = -90;
            ints2[3] = -2;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 240);
            b = 3;
            ints[0] = -90;
            ints2[0] = -2;
            ints3[0] = -100;
            ints[1] = -93;
            ints2[1] = 2;
            ints3[1] = -100;
            ints[2] = -87;
            ints2[2] = 2;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 240);
            b = 4;
            ints[0] = 87 - (int) (Math.random() * 10.0D);
            ints2[0] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[0] = 30 + (int) (Math.random() * 50.0D - 25.0D);
            ints[1] = 93 + (int) (Math.random() * 10.0D);
            ints2[1] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[1] = 30 + (int) (Math.random() * 50.0D - 25.0D);
            ints[2] = 93 + (int) (Math.random() * 10.0D);
            ints2[2] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[2] = -100 + (int) (Math.random() * 50.0D - 25.0D);
            ints[3] = 87 - (int) (Math.random() * 10.0D);
            ints2[3] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[3] = -100 + (int) (Math.random() * 50.0D - 25.0D);
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 193, 224, 255);
            b = 4;
            ints[0] = 90;
            ints2[0] = -2;
            ints3[0] = 30;
            ints[1] = 90;
            ints2[1] = 2;
            ints3[1] = 30;
            ints[2] = 90;
            ints2[2] = 2;
            ints3[2] = -100;
            ints[3] = 90;
            ints2[3] = -2;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 240);
            b = 3;
            ints[0] = 90;
            ints2[0] = -2;
            ints3[0] = -100;
            ints[1] = 93;
            ints2[1] = 2;
            ints3[1] = -100;
            ints[2] = 87;
            ints2[2] = 2;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 240);
        }
        if (i == 3) {
            int i2 = (int) (Math.random() * 100.0D);
            b = 4;
            ints[0] = 80;
            ints2[0] = 0;
            ints3[0] = -75;
            ints[1] = 40;
            ints2[1] = 0;
            ints3[1] = -50;
            ints[2] = 10 - i2;
            ints2[2] = 0;
            ints3[2] = 0;
            ints[3] = 80 + i2;
            ints2[3] = 0;
            ints3[3] = -30;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 200, 255);
            b = 3;
            ints[0] = 60;
            ints2[0] = 0;
            ints3[0] = 0;
            ints[1] = 60;
            ints2[1] = -3;
            ints3[1] = -60;
            ints[2] = 60;
            ints2[2] = 0;
            ints3[2] = -60;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 221, 255);
            b = 4;
            ints[0] = 40;
            ints2[0] = 0;
            ints3[0] = -50;
            ints[1] = 40;
            ints2[1] = -3;
            ints3[1] = -50;
            ints[2] = 80;
            ints2[2] = -3;
            ints3[2] = -75;
            ints[3] = 80;
            ints2[3] = 0;
            ints3[3] = -75;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 221, 255);
            i2 = (int) (Math.random() * 100.0D);
            b = 4;
            ints[0] = -80;
            ints2[0] = 0;
            ints3[0] = -75;
            ints[1] = -40;
            ints2[1] = 0;
            ints3[1] = -50;
            ints[2] = -10 + i2;
            ints2[2] = 0;
            ints3[2] = 0;
            ints[3] = -80 - i2;
            ints2[3] = 0;
            ints3[3] = -30;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 200, 255);
            b = 3;
            ints[0] = -60;
            ints2[0] = 0;
            ints3[0] = 0;
            ints[1] = -60;
            ints2[1] = -3;
            ints3[1] = -60;
            ints[2] = -60;
            ints2[2] = 0;
            ints3[2] = -60;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 221, 255);
            b = 4;
            ints[0] = -40;
            ints2[0] = 0;
            ints3[0] = -50;
            ints[1] = -40;
            ints2[1] = -3;
            ints3[1] = -50;
            ints[2] = -80;
            ints2[2] = -3;
            ints3[2] = -75;
            ints[3] = -80;
            ints2[3] = 0;
            ints3[3] = -75;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 221, 255);
        }
        if (i == 4) {
            b = 4;
            ints[0] = 3;
            ints2[0] = 3;
            ints3[0] = 0;
            ints[1] = -3;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = -3;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 3;
            ints2[3] = 3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, 0, b, l2, 255, 255, 177);
            b = 4;
            ints[0] = 0;
            ints2[0] = -3;
            ints3[0] = 0;
            ints[1] = 0;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = 0;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 0;
            ints2[3] = -3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, 0, b, l2, 255, 255, 177);
            b = 4;
            ints[0] = -3;
            ints2[0] = -3;
            ints3[0] = -100;
            ints[1] = -3;
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = 3;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 3;
            ints2[3] = -3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, 0, b, l2, 255, 255, 177);
        }
        if (i == 5) {
            b = 4;
            ints[0] = 11;
            ints2[0] = 3;
            ints3[0] = 0;
            ints[1] = 5;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = 5;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 11;
            ints2[3] = 3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 177);
            b = 4;
            ints[0] = 8;
            ints2[0] = -3;
            ints3[0] = 0;
            ints[1] = 8;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = 8;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 8;
            ints2[3] = -3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 177);
            b = 3;
            ints[0] = 8;
            ints2[0] = -3;
            ints3[0] = -100;
            ints[1] = 5;
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = 11;
            ints2[2] = 3;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 177);
            b = 4;
            ints[0] = -11;
            ints2[0] = 3;
            ints3[0] = 0;
            ints[1] = -5;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = -5;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = -11;
            ints2[3] = 3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 177);
            b = 4;
            ints[0] = -8;
            ints2[0] = -3;
            ints3[0] = 0;
            ints[1] = -8;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = -8;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = -8;
            ints2[3] = -3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 177);
            b = 3;
            ints[0] = -8;
            ints2[0] = -3;
            ints3[0] = -100;
            ints[1] = -5;
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = -11;
            ints2[2] = 3;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 177);
        }
        if (i == 6) {
            b = 4;
            ints[0] = 103;
            ints2[0] = 3;
            ints3[0] = -100;
            ints[1] = 97;
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = 97;
            ints2[2] = 3;
            ints3[2] = -200;
            ints[3] = 103;
            ints2[3] = 3;
            ints3[3] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 177, 255, 177);
            b = 4;
            ints[0] = 100;
            ints2[0] = -3;
            ints3[0] = -100;
            ints[1] = 100;
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = 100;
            ints2[2] = 3;
            ints3[2] = -200;
            ints[3] = 100;
            ints2[3] = -3;
            ints3[3] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 177, 255, 177);
            b = 3;
            ints[0] = 100;
            ints2[0] = -3;
            ints3[0] = -200;
            ints[1] = 97;
            ints2[1] = 3;
            ints3[1] = -200;
            ints[2] = 103;
            ints2[2] = 3;
            ints3[2] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 177, 255, 177);
            b = 4;
            ints[0] = -103;
            ints2[0] = 3;
            ints3[0] = -100;
            ints[1] = -97;
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = -97;
            ints2[2] = 3;
            ints3[2] = -200;
            ints[3] = -103;
            ints2[3] = 3;
            ints3[3] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 177, 255, 177);
            b = 4;
            ints[0] = -100;
            ints2[0] = -3;
            ints3[0] = -100;
            ints[1] = -100;
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = -100;
            ints2[2] = 3;
            ints3[2] = -200;
            ints[3] = -100;
            ints2[3] = -3;
            ints3[3] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 177, 255, 177);
            b = 3;
            ints[0] = -100;
            ints2[0] = -3;
            ints3[0] = -200;
            ints[1] = -97;
            ints2[1] = 3;
            ints3[1] = -200;
            ints[2] = -103;
            ints2[2] = 3;
            ints3[2] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 177, 255, 177);
        }
        if (i == 7) {
            b = 4;
            ints[0] = 10;
            ints2[0] = 0;
            ints3[0] = -50;
            ints[1] = -10;
            ints2[1] = 0;
            ints3[1] = -50;
            ints[2] = -10;
            ints2[2] = 0;
            ints3[2] = -100;
            ints[3] = 10;
            ints2[3] = 0;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 255, 255);
            b = 3;
            ints[0] = 0;
            ints2[0] = -10;
            ints3[0] = -50;
            ints[1] = 0;
            ints2[1] = 0;
            ints3[1] = -50;
            ints[2] = 0;
            ints2[2] = 0;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 175, 240, 255);
            b = 3;
            ints[0] = 0;
            ints2[0] = -10;
            ints3[0] = -50;
            ints[1] = -10;
            ints2[1] = 0;
            ints3[1] = -50;
            ints[2] = 10;
            ints2[2] = 0;
            ints3[2] = -50;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 175, 240, 255);
        }
        if (i == 8) {
            b = 4;
            ints[0] = 10;
            ints2[0] = 0;
            ints3[0] = 0;
            ints[1] = -10;
            ints2[1] = 0;
            ints3[1] = 0;
            ints[2] = -10;
            ints2[2] = 0;
            ints3[2] = -100;
            ints[3] = 10;
            ints2[3] = 0;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 255, 255);
            b = 3;
            ints[0] = 0;
            ints2[0] = -10;
            ints3[0] = 0;
            ints[1] = 0;
            ints2[1] = 0;
            ints3[1] = 0;
            ints[2] = 0;
            ints2[2] = 0;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 200, 200);
            b = 3;
            ints[0] = 0;
            ints2[0] = -10;
            ints3[0] = 0;
            ints[1] = -10;
            ints2[1] = 0;
            ints3[1] = 0;
            ints[2] = 10;
            ints2[2] = 0;
            ints3[2] = 0;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 200, 200);
        }
        if (i == 9) {
            b = 4;
            ints[0] = 69;
            ints2[0] = 3;
            ints3[0] = 0;
            ints[1] = 63;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = 63;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 69;
            ints2[3] = 3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 240, 255);
            b = 4;
            ints[0] = 66;
            ints2[0] = -3;
            ints3[0] = 0;
            ints[1] = 66;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = 66;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = 66;
            ints2[3] = -3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 240, 255);
            b = 3;
            ints[0] = 66;
            ints2[0] = -3;
            ints3[0] = -100;
            ints[1] = 63 - (int) (Math.random() * 30.0D);
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = 69 + (int) (Math.random() * 30.0D);
            ints2[2] = 3;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 177);
            b = 4;
            ints[0] = -69;
            ints2[0] = 3;
            ints3[0] = 0;
            ints[1] = -63;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = -63;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = -69;
            ints2[3] = 3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 240, 255);
            b = 4;
            ints[0] = -66;
            ints2[0] = -3;
            ints3[0] = 0;
            ints[1] = -66;
            ints2[1] = 3;
            ints3[1] = 0;
            ints[2] = -66;
            ints2[2] = 3;
            ints3[2] = -100;
            ints[3] = -66;
            ints2[3] = -3;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 240, 255);
            b = 3;
            ints[0] = -66;
            ints2[0] = -3;
            ints3[0] = -100;
            ints[1] = -63 + (int) (Math.random() * 30.0D);
            ints2[1] = 3;
            ints3[1] = -100;
            ints[2] = -69 - (int) (Math.random() * 30.0D);
            ints2[2] = 3;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 255, 240, 177);
        }
        if (i == 10) {
            b = 4;
            ints[0] = -8;
            ints2[0] = 0;
            ints3[0] = 56;
            ints[1] = -58;
            ints2[1] = 20;
            ints3[1] = 24;
            ints[2] = -55;
            ints2[2] = 20;
            ints3[2] = 0;
            ints[3] = -8;
            ints2[3] = 0;
            ints3[3] = 14;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 200, 255);
            b = 4;
            ints[0] = -8;
            ints2[0] = 0;
            ints3[0] = 14;
            ints[1] = -49;
            ints2[1] = -20;
            ints3[1] = -25;
            ints[2] = -45;
            ints2[2] = -20;
            ints3[2] = -45;
            ints[3] = -8;
            ints2[3] = 0;
            ints3[3] = -33;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 230, 230, 255);
            b = 4;
            ints[0] = 8;
            ints2[0] = 0;
            ints3[0] = 56;
            ints[1] = 58;
            ints2[1] = 20;
            ints3[1] = 24;
            ints[2] = 55;
            ints2[2] = 20;
            ints3[2] = 0;
            ints[3] = 8;
            ints2[3] = 0;
            ints3[3] = 14;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 200, 255);
            b = 4;
            ints[0] = 8;
            ints2[0] = 0;
            ints3[0] = 14;
            ints[1] = 49;
            ints2[1] = -20;
            ints3[1] = -25;
            ints[2] = 45;
            ints2[2] = -20;
            ints3[2] = -45;
            ints[3] = 8;
            ints2[3] = 0;
            ints3[3] = -33;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 230, 230, 255);
        }
        if (i == 11) {
            b = 4;
            ints[0] = -87 + (int) (Math.random() * 10.0D);
            ints2[0] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[0] = 30 + (int) (Math.random() * 50.0D - 25.0D);
            ints[1] = -93 - (int) (Math.random() * 10.0D);
            ints2[1] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[1] = 30 + (int) (Math.random() * 50.0D - 25.0D);
            ints[2] = -93 - (int) (Math.random() * 10.0D);
            ints2[2] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[2] = -100 + (int) (Math.random() * 50.0D - 25.0D);
            ints[3] = -87 + (int) (Math.random() * 10.0D);
            ints2[3] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[3] = -100 + (int) (Math.random() * 50.0D - 25.0D);
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 190, 190, 190);
            b = 4;
            ints[0] = -90;
            ints2[0] = -2;
            ints3[0] = 30;
            ints[1] = -90;
            ints2[1] = 2;
            ints3[1] = 30;
            ints[2] = -90;
            ints2[2] = 2;
            ints3[2] = -100;
            ints[3] = -90;
            ints2[3] = -2;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 230, 255);
            b = 3;
            ints[0] = -90;
            ints2[0] = -2;
            ints3[0] = -100;
            ints[1] = -93;
            ints2[1] = 2;
            ints3[1] = -100;
            ints[2] = -87;
            ints2[2] = 2;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 230, 255);
            b = 4;
            ints[0] = 87 - (int) (Math.random() * 10.0D);
            ints2[0] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[0] = 30 + (int) (Math.random() * 50.0D - 25.0D);
            ints[1] = 93 + (int) (Math.random() * 10.0D);
            ints2[1] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[1] = 30 + (int) (Math.random() * 50.0D - 25.0D);
            ints[2] = 93 + (int) (Math.random() * 10.0D);
            ints2[2] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[2] = -100 + (int) (Math.random() * 50.0D - 25.0D);
            ints[3] = 87 - (int) (Math.random() * 10.0D);
            ints2[3] = 2 + (int) (Math.random() * 20.0D - 10.0D);
            ints3[3] = -100 + (int) (Math.random() * 50.0D - 25.0D);
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 190, 190, 190);
            b = 4;
            ints[0] = 90;
            ints2[0] = -2;
            ints3[0] = 30;
            ints[1] = 90;
            ints2[1] = 2;
            ints3[1] = 30;
            ints[2] = 90;
            ints2[2] = 2;
            ints3[2] = -100;
            ints[3] = 90;
            ints2[3] = -2;
            ints3[3] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 230, 255);
            b = 3;
            ints[0] = 90;
            ints2[0] = -2;
            ints3[0] = -100;
            ints[1] = 93;
            ints2[1] = 2;
            ints3[1] = -100;
            ints[2] = 87;
            ints2[2] = 2;
            ints3[2] = -100;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 200, 230, 255);
            b = 4;
            ints[0] = 143;
            ints2[0] = 20;
            ints3[0] = -100;
            ints[1] = 137;
            ints2[1] = 20;
            ints3[1] = -100;
            ints[2] = 137;
            ints2[2] = 20;
            ints3[2] = -200;
            ints[3] = 143;
            ints2[3] = 20;
            ints3[3] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 180, 180, 180);
            b = 4;
            ints[0] = 140;
            ints2[0] = 17;
            ints3[0] = -100;
            ints[1] = 140;
            ints2[1] = 20;
            ints3[1] = -100;
            ints[2] = 140;
            ints2[2] = 20;
            ints3[2] = -200;
            ints[3] = 140;
            ints2[3] = 17;
            ints3[3] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 180, 180, 180);
            b = 3;
            ints[0] = 140;
            ints2[0] = 17;
            ints3[0] = -200;
            ints[1] = 137;
            ints2[1] = 20;
            ints3[1] = -200;
            ints[2] = 143;
            ints2[2] = 20;
            ints3[2] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 180, 180, 180);
            b = 4;
            ints[0] = -143;
            ints2[0] = 20;
            ints3[0] = -100;
            ints[1] = -137;
            ints2[1] = 20;
            ints3[1] = -100;
            ints[2] = -137;
            ints2[2] = 20;
            ints3[2] = -200;
            ints[3] = -143;
            ints2[3] = 20;
            ints3[3] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 180, 180, 180);
            b = 4;
            ints[0] = -140;
            ints2[0] = 17;
            ints3[0] = -100;
            ints[1] = -140;
            ints2[1] = 20;
            ints3[1] = -100;
            ints[2] = -140;
            ints2[2] = 20;
            ints3[2] = -200;
            ints[3] = -140;
            ints2[3] = 17;
            ints3[3] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 180, 180, 180);
            b = 3;
            ints[0] = -140;
            ints2[0] = 17;
            ints3[0] = -200;
            ints[1] = -137;
            ints2[1] = 20;
            ints3[1] = -200;
            ints[2] = -143;
            ints2[2] = 20;
            ints3[2] = -200;
            dt(graphics, ints, ints2, ints3, j, k, l, i1, j1, k1, b, l2, 180, 180, 180);
        }
    }

    public void rot(int[] ints, int[] ints2, int i, int j, int k, int l) {
        if (k != 0) {
            for (int i1 = 0; i1 < l; ++i1) {
                int j1 = ints[i1];
                int k1 = ints2[i1];
                ints[i1] = i + (int) ((float) (j1 - i) * RadicalMath.cos(k) - (float) (k1 - j) * RadicalMath.sin(k));
                ints2[i1] = j + (int) ((float) (j1 - i) * RadicalMath.sin(k) + (float) (k1 - j) * RadicalMath.cos(k));
            }
        }
    }

    public void gsmoke(Graphics graphics, int i, int j, int k, int l, int i1, int j1) {
        int[] ints = new int[8];
        int[] ints2 = new int[8];
        int[] ints3 = new int[8];
        ints[0] = -5 + (int) (Math.random() * 5.0D) - j1 * 2;
        ints2[0] = -12 + (int) (Math.random() * 12.0D) - j1 * 6;
        ints3[0] = -50;
        ints[1] = 5 - (int) (Math.random() * 5.0D) + j1 * 2;
        ints2[1] = -12 + (int) (Math.random() * 12.0D) - j1 * 6;
        ints3[1] = -50;
        ints[2] = 12 - (int) (Math.random() * 12.0D) + j1 * 6;
        ints2[2] = -5 + (int) (Math.random() * 5.0D) - j1 * 2;
        ints3[2] = -50;
        ints[3] = 12 - (int) (Math.random() * 12.0D) + j1 * 6;
        ints2[3] = 5 - (int) (Math.random() * 5.0D) + j1 * 2;
        ints3[3] = -50;
        ints[4] = 5 - (int) (Math.random() * 5.0D) + j1 * 2;
        ints2[4] = 12 - (int) (Math.random() * 12.0D) + j1 * 6;
        ints3[4] = -50;
        ints[5] = -5 + (int) (Math.random() * 5.0D) - j1 * 2;
        ints2[5] = 12 - (int) (Math.random() * 12.0D) + j1 * 6;
        ints3[5] = -50;
        ints[6] = -12 + (int) (Math.random() * 12.0D) - j1 * 6;
        ints2[6] = 5 - (int) (Math.random() * 5.0D) + j1 * 2;
        ints3[6] = -50;
        ints[7] = -12 + (int) (Math.random() * 12.0D) - j1 * 6;
        ints2[7] = -5 + (int) (Math.random() * 5.0D) - j1 * 2;
        ints3[7] = -50;
        if (j1 > 3) {
            j1 = 3;
        }
        dt(graphics, ints, ints2, ints3, i, j, k, l, i1, 0, 8, 0, 249 - j1 * 25, 251 - j1 * 25, 240 - j1 * 25);
    }

    public int xs(int i, int j) {
        if (j < 10) {
            j = 10;
        }
        return (j - m.focus_point) * (m.cx - i) / j + i;
    }

    public void hsmoke(Graphics graphics, int i, int j, int k, int l, int i1, int j1) {
        int[] ints = new int[8];
        int[] ints2 = new int[8];
        int[] ints3 = new int[8];
        ints[0] = -5 + (int) (Math.random() * 5.0D) - j1;
        ints2[0] = -12 + (int) (Math.random() * 12.0D) - j1 * 2;
        ints3[0] = -50;
        ints[1] = 5 - (int) (Math.random() * 5.0D) + j1;
        ints2[1] = -12 + (int) (Math.random() * 12.0D) - j1 * 2;
        ints3[1] = -50;
        ints[2] = 12 - (int) (Math.random() * 12.0D) + j1 * 2;
        ints2[2] = -5 + (int) (Math.random() * 5.0D) - j1;
        ints3[2] = -50;
        ints[3] = 12 - (int) (Math.random() * 12.0D) + j1 * 2;
        ints2[3] = 5 - (int) (Math.random() * 5.0D) + j1;
        ints3[3] = -50;
        ints[4] = 5 - (int) (Math.random() * 5.0D) + j1;
        ints2[4] = 12 - (int) (Math.random() * 12.0D) + j1 * 2;
        ints3[4] = -50;
        ints[5] = -5 + (int) (Math.random() * 5.0D) - j1;
        ints2[5] = 12 - (int) (Math.random() * 12.0D) + j1 * 2;
        ints3[5] = -50;
        ints[6] = -12 + (int) (Math.random() * 12.0D) - j1 * 2;
        ints2[6] = 5 - (int) (Math.random() * 5.0D) + j1;
        ints3[6] = -50;
        ints[7] = -12 + (int) (Math.random() * 12.0D) - j1 * 2;
        ints2[7] = -5 + (int) (Math.random() * 5.0D) - j1;
        ints3[7] = -50;
        if (j1 > 3) {
            j1 = 3;
        }
        dt(graphics, ints, ints2, ints3, i, j, k, l, i1, 0, 8, 0, 89 + j1 * 20, 91 + j1 * 20, 80 + j1 * 20);
    }
}
