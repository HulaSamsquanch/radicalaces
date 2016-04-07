import java.awt.Color;
import java.awt.Graphics;

public class Medium {
    boolean isun = false;

    SinCos cs = new SinCos();
    int focus_point = 400;
    int ground = 250;
    int er = 0;
    int eg = 0;
    int eb = 0;
    int jumping = 0;
    int cx = 250;
    int cy = 150;
    int cz = 50;
    int xz = 0;
    int zy = 0;
    int x = 3000;
    int y = -1000;
    int z = -2000;
    int w = 500;
    int h = 360;
    int tart = 0;
    int yart = -100;
    int zart = 0;
    int ztgo = 0;
    boolean td = false;
    int vxz = 0;
    int adv = -500;
    boolean vert = false;

    public int ys(final int i, int j) {
        if (j < 10) {
            j = 10;
        }
        return (j - focus_point) * (cy - i) / j + i;
    }

    public void infront(final ContO conto) {
        int i = conto.zy;
        int j;
        for (j = conto.xz; i > 360; i -= 360) {
            ;
        }
        while (i < 0) {
            i += 360;
        }
        if (i > 90 && i < 270) {
            tart += (180 - tart) / 3;
            yart += (100 - yart) / 3;
        } else {
            tart -= tart / 3;
            yart += (-100 - yart) / 3;
        }
        j += tart;
        if (i > 90) {
            i = 180 - i;
        }
        if (i < -90) {
            i = -180 - i;
        }
        final int k = conto.y + (int) ((conto.y + yart - conto.y) * cs.cos(conto.zy) - (conto.z + 800 - conto.z) * cs.sin(conto.zy));
        final int l = conto.z + (int) ((conto.y + yart - conto.y) * cs.sin(conto.zy) + (conto.z + 800 - conto.z) * cs.cos(conto.zy));
        final int i1 = conto.x + (int) (-(l - conto.z) * cs.sin(conto.xz));
        final int j1 = conto.z + (int) ((l - conto.z) * cs.cos(conto.xz));
        zy = i;
        xz = -(j + 180);
        x += (i1 - cx - x) / 3;
        z = (int) (z + (j1 - cz - z) / 1.5D);
        y = (int) (y + (k - cy - y) / 1.5D);
    }

    public void d(final Graphics graphics) {
        if (zy > 90) {
            zy = 90;
        }
        if (zy < -90) {
            zy = -90;
        }
        if (y > 0) {
            y = 0;
        }
        ground = 250 - y;
        int i = 70000;
        int j = 250;
        if (zy != 0) {
            j = cy + (int) ((250 - cy) * cs.cos(zy) - (70000 - cz) * cs.sin(zy));
            i = cz + (int) ((250 - cy) * cs.sin(zy) + (70000 - cz) * cs.cos(zy));
        }
        final int[] ints = new int[4];
        final int[] ints2 = new int[4];
        ints[0] = 0;
        ints2[0] = 0;
        ints[1] = w;
        ints2[1] = 0;
        ints[2] = w;
        ints2[2] = ys(j, i);
        if (ints2[2] > h) {
            ints2[2] = h;
        }
        ints[3] = 0;
        ints2[3] = ints2[2];
        if (ints2[2] > 0) {
            if (jumping != 0) {
                if (jumping == 3) {
                    ints2[2] = h;
                    ints2[3] = h;
                    graphics.setColor(new Color(240, 240, 240));
                    graphics.fillPolygon(ints, ints2, 4);
                }
            } else {
                if (!isun) {
                    graphics.setColor(new Color(159 + 52 * er, 180 + 56 * eg, 189 + 58 * eb));
                } else {
                    graphics.setColor(new Color(159 + 52 * er, 176 + 56 * eg, 191 + 58 * eb));
                }
                graphics.fillPolygon(ints, ints2, 4);
            }
        }
        ints[0] = -1;
        ints2[0] = ys(j, i);
        if (ints2[0] < 0) {
            ints2[0] = -1;
        }
        ints[1] = -1;
        ints2[1] = h;
        ints[2] = w;
        ints2[2] = h;
        ints[3] = w;
        ints2[3] = ints2[0];
        if (ints2[0] < h && jumping == 0) {
            if (!isun) {
                graphics.setColor(new Color(177 + 55 * er, 154 + 50 * eg, 120 + 44 * eb));
            } else {
                graphics.setColor(new Color(175 + 55 * er, 151 + 50 * eg, 112 + 44 * eb));
            }
            graphics.fillPolygon(ints, ints2, 4);
            ints[1] = -1;
            ints2[1] = ints2[0];
            ints[0] = -1;
            ints2[0] -= 3;
            ints[2] = w;
            ints2[2] = ints2[1];
            ints[3] = w;
            ints2[3] = ints2[0];
            if (!isun) {
                graphics.setColor(new Color(169 + 55 * er, 171 + 50 * eg, 160 + 44 * eb));
            } else {
                graphics.setColor(new Color(167 + 55 * er, 164 + 50 * eg, 151 + 44 * eb));
            }
            graphics.fillPolygon(ints, ints2, 4);
        }
        if (jumping != 0) {
            jumping += -1;
        }
    }

    public void watch(final ContO conto) {
        if (!td) {
            y = conto.y + (int) ((conto.y - 300 - conto.y) * cs.cos(conto.zy) - (conto.z + 3000 - conto.z) * cs.sin(conto.zy));
            final int i = conto.z + (int) ((conto.y - 300 - conto.y) * cs.sin(conto.zy) + (conto.z + 3000 - conto.z) * cs.cos(conto.zy));
            x = conto.x + (int) ((conto.x + 400 - conto.x) * cs.cos(conto.xz) - (i - conto.z) * cs.sin(conto.xz));
            z = conto.z + (int) ((conto.x + 400 - conto.x) * cs.sin(conto.xz) + (i - conto.z) * cs.cos(conto.xz));
            td = true;
        }
        short s = 0;
        if (conto.x - x - cx > 0) {
            s = 180;
        }
        final int j = -((int) (90 + s + Math.atan((double) (conto.z - z) / (double) (conto.x - x - cx)) / 0.017453292519943295D));
        short s2 = 0;
        if (conto.y - y - cy < 0) {
            s2 = -180;
        }
        final int k = (int) Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx));
        final int l = (int) (90 + s2 - Math.atan((double) k / (double) (conto.y - y - cy)) / 0.017453292519943295D);
        xz = j;
        zy += (l - zy) / 5;
        if ((int) Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx) + (conto.y - y - cy) * (conto.y - y - cy)) > 3500) {
            td = false;
        }
    }

    public void around(final ContO conto, final int i) {
        byte b = 1;
        if (i == 6000) {
            b = 2;
        }
        y = conto.y + adv;
        x = conto.x + (int) ((conto.x - i + adv * b - conto.x) * cs.cos(vxz));
        z = conto.z + (int) ((conto.x - i + adv * b - conto.x) * cs.sin(vxz));
        if (i == 6000) {
            if (!vert) {
                adv -= 10;
            } else {
                adv += 10;
            }
            if (adv < -900) {
                vert = true;
            }
            if (adv > 1200) {
                vert = false;
            }
        } else {
            if (!vert) {
                adv -= 2;
            } else {
                adv += 2;
            }
            if (adv < -500) {
                vert = true;
            }
            if (adv > 150) {
                vert = false;
            }
            if (adv > 300) {
                adv = 300;
            }
        }
        vxz += 2;
        if (vxz > 360) {
            vxz -= 360;
        }
        short s = 0;
        int j = y;
        if (j > 0) {
            j = 0;
        }
        if (conto.y - j - cy < 0) {
            s = -180;
        }
        final int k = (int) Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx));
        final int l = (int) (90 + s - Math.atan((double) k / (double) (conto.y - j - cy)) / 0.017453292519943295D);
        xz = -vxz + 90;
        zy += (l - zy) / 10;
    }

    public void left(final ContO conto) {
        final int i = conto.y;
        final int j = conto.x + (int) ((conto.x + 600 - conto.x) * cs.cos(conto.xz));
        final int k = conto.z + (int) ((conto.x + 600 - conto.x) * cs.sin(conto.xz));
        zy = 0;
        xz = -(conto.xz + 90);
        x = (int) (x + (j - cx - x) / 1.5D);
        z = (int) (z + (k - cz - z) / 1.5D);
        y = (int) (y + (i - cy - y) / 1.5D);
    }

    public void right(final ContO conto) {
        final int i = conto.y;
        final int j = conto.x + (int) ((conto.x - 600 - conto.x) * cs.cos(conto.xz));
        final int k = conto.z + (int) ((conto.x - 600 - conto.x) * cs.sin(conto.xz));
        zy = 0;
        xz = -(conto.xz - 90);
        x += (j - cx - x) / 3;
        z = (int) (z + (k - cz - z) / 1.5D);
        y = (int) (y + (i - cy - y) / 1.5D);
    }

    public void behinde(final ContO conto) {
        int i = conto.zy;
        int j;
        for (j = conto.xz; i > 360; i -= 360) {
            ;
        }
        while (i < 0) {
            i += 360;
        }
        if (i > 90 && i < 270) {
            tart += (180 - tart) / 3;
            yart += (100 - yart) / 4;
        } else {
            tart -= tart / 3;
            yart += (-100 - yart) / 4;
        }
        j += tart;
        if (i > 90) {
            i = 180 - i;
        }
        if (i < -90) {
            i = -180 - i;
        }
        final int k = conto.y + (int) ((conto.y + yart - conto.y) * cs.cos(conto.zy) - (conto.z - 600 - conto.z) * cs.sin(conto.zy));
        final int l = conto.z + (int) ((conto.y + yart - conto.y) * cs.sin(conto.zy) + (conto.z - 600 - conto.z) * cs.cos(conto.zy));
        final int i1 = conto.x + (int) (-(l - conto.z) * cs.sin(conto.xz));
        final int j1 = conto.z + (int) ((l - conto.z) * cs.cos(conto.xz));
        zy = -i;
        xz = -j;
        x += (i1 - cx - x) / 3;
        z = (int) (z + (j1 - cz - z) / 1.5D);
        y = (int) (y + (k - cy - y) / 1.5D);
    }
}
