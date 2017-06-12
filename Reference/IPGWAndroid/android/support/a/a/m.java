package android.support.a.a;

import android.content.res.TypedArray;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import org.xmlpull.v1.XmlPullParser;

final class m extends o {
    int a = 0;
    float b = 0.0f;
    int c = 0;
    float d = 1.0f;
    int e;
    float f = 1.0f;
    float g = 0.0f;
    float h = 1.0f;
    float i = 0.0f;
    Cap j = Cap.BUTT;
    Join k = Join.MITER;
    float l = 4.0f;
    private int[] p;

    public m(m mVar) {
        super(mVar);
        this.p = mVar.p;
        this.a = mVar.a;
        this.b = mVar.b;
        this.d = mVar.d;
        this.c = mVar.c;
        this.e = mVar.e;
        this.f = mVar.f;
        this.g = mVar.g;
        this.h = mVar.h;
        this.i = mVar.i;
        this.j = mVar.j;
        this.k = mVar.k;
        this.l = mVar.l;
    }

    final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.p = null;
        if (i.a(xmlPullParser, "pathData")) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(2);
            if (string != null) {
                this.m = f.a(string);
            }
            this.c = i.a(typedArray, xmlPullParser, "fillColor", 1, this.c);
            this.f = i.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
            int a = i.a(typedArray, xmlPullParser, "strokeLineCap", 8);
            Cap cap = this.j;
            switch (a) {
                case 0:
                    cap = Cap.BUTT;
                    break;
                case 1:
                    cap = Cap.ROUND;
                    break;
                case 2:
                    cap = Cap.SQUARE;
                    break;
            }
            this.j = cap;
            a = i.a(typedArray, xmlPullParser, "strokeLineJoin", 9);
            Join join = this.k;
            switch (a) {
                case 0:
                    join = Join.MITER;
                    break;
                case 1:
                    join = Join.ROUND;
                    break;
                case 2:
                    join = Join.BEVEL;
                    break;
            }
            this.k = join;
            this.l = i.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
            this.a = i.a(typedArray, xmlPullParser, "strokeColor", 3, this.a);
            this.d = i.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
            this.b = i.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
            this.h = i.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
            this.i = i.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
            this.g = i.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
        }
    }
}
