package com.b.a.b.a;

import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class e {
    private static final Object c = new Object();
    private final Object a = new Object();
    private File b;
    private HashMap<File, f> d = new HashMap();

    public e(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.b = new File(str);
    }

    private File b() {
        File file;
        synchronized (this.a) {
            file = this.b;
        }
        return file;
    }

    private static File b(File file) {
        return new File(file.getPath() + ".bak");
    }

    public final b a(String str) {
        b bVar;
        Map map;
        FileInputStream fileInputStream;
        byte[] bArr;
        String str2;
        FileNotFoundException e;
        IOException e2;
        f fVar;
        Exception e3;
        File b = b();
        String str3 = str + ".xml";
        if (str3.indexOf(File.separatorChar) < 0) {
            File file = new File(b, str3);
            synchronized (c) {
                bVar = (f) this.d.get(file);
                if (bVar == null || bVar.d()) {
                    File b2 = b(file);
                    if (b2.exists()) {
                        file.delete();
                        b2.renameTo(file);
                    }
                    if (file.exists()) {
                        file.canRead();
                    }
                    if (file.exists() && file.canRead()) {
                        try {
                            InputStream fileInputStream2 = new FileInputStream(file);
                            XmlPullParser newPullParser = Xml.newPullParser();
                            newPullParser.setInput(fileInputStream2, null);
                            map = (HashMap) h.a(newPullParser, new String[1]);
                            try {
                                fileInputStream2.close();
                            } catch (XmlPullParserException e4) {
                                try {
                                    fileInputStream = new FileInputStream(file);
                                    bArr = new byte[fileInputStream.available()];
                                    fileInputStream.read(bArr);
                                    str2 = new String(bArr, 0, bArr.length, "UTF-8");
                                } catch (FileNotFoundException e5) {
                                    e5.printStackTrace();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                                synchronized (c) {
                                    if (bVar == null) {
                                        fVar = (f) this.d.get(file);
                                        if (fVar == null) {
                                            bVar = new f(file, map);
                                            this.d.put(file, bVar);
                                        }
                                    } else if (map != null) {
                                        synchronized (bVar) {
                                            bVar.a = map;
                                        }
                                    }
                                }
                                return bVar;
                            } catch (FileNotFoundException e6) {
                                e5 = e6;
                                e5.printStackTrace();
                                synchronized (c) {
                                    if (bVar == null) {
                                        fVar = (f) this.d.get(file);
                                        if (fVar == null) {
                                            bVar = new f(file, map);
                                            this.d.put(file, bVar);
                                        }
                                    } else if (map != null) {
                                        synchronized (bVar) {
                                            bVar.a = map;
                                        }
                                    }
                                }
                                return bVar;
                            } catch (IOException e7) {
                                e22 = e7;
                                e22.printStackTrace();
                                synchronized (c) {
                                    if (bVar == null) {
                                        fVar = (f) this.d.get(file);
                                        if (fVar == null) {
                                            bVar = new f(file, map);
                                            this.d.put(file, bVar);
                                        }
                                    } else if (map != null) {
                                        synchronized (bVar) {
                                            bVar.a = map;
                                        }
                                    }
                                }
                                return bVar;
                            } catch (Exception e8) {
                                e3 = e8;
                                e3.printStackTrace();
                                synchronized (c) {
                                    if (bVar == null) {
                                        fVar = (f) this.d.get(file);
                                        if (fVar == null) {
                                            bVar = new f(file, map);
                                            this.d.put(file, bVar);
                                        }
                                    } else if (map != null) {
                                        synchronized (bVar) {
                                            bVar.a = map;
                                        }
                                    }
                                }
                                return bVar;
                            }
                        } catch (XmlPullParserException e9) {
                            map = null;
                            fileInputStream = new FileInputStream(file);
                            bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            str2 = new String(bArr, 0, bArr.length, "UTF-8");
                            synchronized (c) {
                                if (bVar == null) {
                                    fVar = (f) this.d.get(file);
                                    if (fVar == null) {
                                        bVar = new f(file, map);
                                        this.d.put(file, bVar);
                                    }
                                } else if (map != null) {
                                    synchronized (bVar) {
                                        bVar.a = map;
                                    }
                                }
                            }
                            return bVar;
                        } catch (FileNotFoundException e10) {
                            FileNotFoundException fileNotFoundException = e10;
                            map = null;
                            e5 = fileNotFoundException;
                            e5.printStackTrace();
                            synchronized (c) {
                                if (bVar == null) {
                                    fVar = (f) this.d.get(file);
                                    if (fVar == null) {
                                        bVar = new f(file, map);
                                        this.d.put(file, bVar);
                                    }
                                } else if (map != null) {
                                    synchronized (bVar) {
                                        bVar.a = map;
                                    }
                                }
                            }
                            return bVar;
                        } catch (IOException e11) {
                            IOException iOException = e11;
                            map = null;
                            e22 = iOException;
                            e22.printStackTrace();
                            synchronized (c) {
                                if (bVar == null) {
                                    fVar = (f) this.d.get(file);
                                    if (fVar == null) {
                                        bVar = new f(file, map);
                                        this.d.put(file, bVar);
                                    }
                                } else if (map != null) {
                                    synchronized (bVar) {
                                        bVar.a = map;
                                    }
                                }
                            }
                            return bVar;
                        } catch (Exception e12) {
                            Exception exception = e12;
                            map = null;
                            e3 = exception;
                            e3.printStackTrace();
                            synchronized (c) {
                                if (bVar == null) {
                                    fVar = (f) this.d.get(file);
                                    if (fVar == null) {
                                        bVar = new f(file, map);
                                        this.d.put(file, bVar);
                                    }
                                } else if (map != null) {
                                    synchronized (bVar) {
                                        bVar.a = map;
                                    }
                                }
                            }
                            return bVar;
                        }
                    }
                    map = null;
                    synchronized (c) {
                        if (bVar == null) {
                            fVar = (f) this.d.get(file);
                            if (fVar == null) {
                                bVar = new f(file, map);
                                this.d.put(file, bVar);
                            }
                        } else if (map != null) {
                            synchronized (bVar) {
                                bVar.a = map;
                            }
                        }
                    }
                }
            }
            return bVar;
        }
        throw new IllegalArgumentException("File " + str3 + " contains a path separator");
    }
}
