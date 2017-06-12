package android.support.a.a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region.Op;
import android.support.v4.g.a;

final class p {
    private static final Matrix j = new Matrix();
    float a;
    float b;
    float c;
    float d;
    int e;
    String f;
    final a<String, Object> g;
    private final Path h;
    private final Path i;
    private final Matrix k;
    private Paint l;
    private Paint m;
    private PathMeasure n;
    private int o;
    private final n p;

    public p() {
        this.k = new Matrix();
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 255;
        this.f = null;
        this.g = new a();
        this.p = new n();
        this.h = new Path();
        this.i = new Path();
    }

    public p(p pVar) {
        this.k = new Matrix();
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 255;
        this.f = null;
        this.g = new a();
        this.p = new n(pVar.p, this.g);
        this.h = new Path(pVar.h);
        this.i = new Path(pVar.i);
        this.a = pVar.a;
        this.b = pVar.b;
        this.c = pVar.c;
        this.d = pVar.d;
        this.o = pVar.o;
        this.e = pVar.e;
        this.f = pVar.f;
        if (pVar.f != null) {
            this.g.put(pVar.f, this);
        }
    }

    private void a(n nVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        nVar.a.set(matrix);
        nVar.a.preConcat(nVar.j);
        for (int i3 = 0; i3 < nVar.b.size(); i3++) {
            Object obj = nVar.b.get(i3);
            if (obj instanceof n) {
                a((n) obj, nVar.a, canvas, i, i2, colorFilter);
            } else if (obj instanceof o) {
                o oVar = (o) obj;
                float f = ((float) i) / this.c;
                float f2 = ((float) i2) / this.d;
                float min = Math.min(f, f2);
                Matrix matrix2 = nVar.a;
                this.k.set(matrix2);
                this.k.postScale(f, f2);
                float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
                matrix2.mapVectors(fArr);
                f2 = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
                float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
                float f3 = (fArr[3] * fArr[0]) - (fArr[1] * fArr[2]);
                f2 = Math.max(f2, hypot);
                f = 0.0f;
                if (f2 > 0.0f) {
                    f = Math.abs(f3) / f2;
                }
                if (f != 0.0f) {
                    oVar.a(this.h);
                    Path path = this.h;
                    this.i.reset();
                    if (oVar.a()) {
                        this.i.addPath(path, this.k);
                        canvas.clipPath(this.i, Op.REPLACE);
                    } else {
                        Paint paint;
                        m mVar = (m) oVar;
                        if (!(mVar.g == 0.0f && mVar.h == 1.0f)) {
                            hypot = (mVar.g + mVar.i) % 1.0f;
                            f3 = (mVar.h + mVar.i) % 1.0f;
                            if (this.n == null) {
                                this.n = new PathMeasure();
                            }
                            this.n.setPath(this.h, false);
                            float length = this.n.getLength();
                            hypot *= length;
                            f3 *= length;
                            path.reset();
                            if (hypot > f3) {
                                this.n.getSegment(hypot, length, path, true);
                                this.n.getSegment(0.0f, f3, path, true);
                            } else {
                                this.n.getSegment(hypot, f3, path, true);
                            }
                            path.rLineTo(0.0f, 0.0f);
                        }
                        this.i.addPath(path, this.k);
                        if (mVar.c != 0) {
                            if (this.m == null) {
                                this.m = new Paint();
                                this.m.setStyle(Style.FILL);
                                this.m.setAntiAlias(true);
                            }
                            paint = this.m;
                            paint.setColor(((((int) (((float) Color.alpha(mVar.c)) * mVar.f)) << 24) | (16777215 & mVar.c)));
                            paint.setColorFilter(colorFilter);
                            canvas.drawPath(this.i, paint);
                        }
                        if (mVar.a != 0) {
                            if (this.l == null) {
                                this.l = new Paint();
                                this.l.setStyle(Style.STROKE);
                                this.l.setAntiAlias(true);
                            }
                            paint = this.l;
                            if (mVar.k != null) {
                                paint.setStrokeJoin(mVar.k);
                            }
                            if (mVar.j != null) {
                                paint.setStrokeCap(mVar.j);
                            }
                            paint.setStrokeMiter(mVar.l);
                            paint.setColor(((((int) (((float) Color.alpha(mVar.a)) * mVar.d)) << 24) | (16777215 & mVar.a)));
                            paint.setColorFilter(colorFilter);
                            paint.setStrokeWidth((f * min) * mVar.b);
                            canvas.drawPath(this.i, paint);
                        }
                    }
                }
            }
        }
    }

    public final void a(Canvas canvas, int i, int i2) {
        a(this.p, j, canvas, i, i2, null);
    }
}
