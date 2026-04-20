
//
//
/*a*/

/** doc */
/***
 * multi-line doc
 */

"a"
"a\"b"
"\n\t\r\\"
"emoji \uD83D\uDC64"
"hex \u0041"

'a'
'\"'
'\''
'\n'
'\u0041'

"""
a
"""
"""
a "quote" b
"""
"""
line 1
line 2
\tindented
"""
"""
value: %s
"""

@
@Override
@SuppressWarnings("unchecked")
@Deprecated(since = "21", forRemoval = false)

#
#

:
::
->

.
...
varargs(String... args)

0
0L
1l
1.0
1.0f
1.0F
1.0d
1.0D
1e3
1.0e-3
0xFF
0xff
0b1010
0123
1_000_000
0xCAFE_BABE
0b1010_0101
0x1.fp3

foo
foo()
foo(
foo.bar
foo.bar()
foo().bar()
this.foo()
super.foo()
TypeName.staticMethod()
list.stream().map(String::trim).toList()

true
false
null

int
long
double
float
boolean
char
byte
short
void
var

String
Object
Integer
Long
Double
Boolean
Math
System

package demo.test;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import static java.lang.Math.max;
import static java.lang.System.out;

public class Box<T> extends BaseBox implements AutoCloseable {
    private final T value;
    private static final int DEFAULT_SIZE = 16;
    public static final String NAME = "Box";

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static Box<String> of(String value) {
        return new Box<>(value);
    }

    @Override
    public void close() {
    }
}

final class Util {
    private Util() {
    }

    static int add(int a, int b) {
        return a + b;
    }
}

interface Named {
    String name();

    default String label() {
        return "Name: " + name();
    }

    static Named of(String s) {
        return () -> s;
    }
}

enum Color {
    RED,
    GREEN,
    BLUE
}

record User(long id, String name, boolean active) {
    public String display() {
        return name + " #" + id;
    }
}

sealed interface Shape permits Circle, Rect {
    double area();
}

final class Circle implements Shape {
    private final double r;

    Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }
}

final class Rect implements Shape {
    private final double w;
    private final double h;

    Rect(double w, double h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public double area() {
        return w * h;
    }
}

@interface Note {
    String value();
    int level() default 1;
}

class Demo {
    int field = 1;
    static String shared = "x";

    Demo() {
        this(1);
    }

    Demo(int value) {
        this.field = value;
    }

    void run() {
        int x = 1;
        long y = 2L;
        double z = 3.14;
        boolean ok = true;
        char ch = 'A';

        var text = "hello";
        var msg = """
                User: %s
                Id: %d
                """.formatted("Alice", 7);

        int[] arr = {1, 2, 3};
        String[][] grid = {{"a", "b"}, {"c", "d"}};

        List<String> items = List.of(" a ", "b ", " c");
        Map<String, Integer> map = Map.of("a", 1, "b", 2);

        if (x < 10 && ok) {
            System.out.println(text);
        } else if (x == 10) {
            System.out.println("ten");
        } else {
            System.out.println("other");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }

        for (String item : items) {
            System.out.println(item);
        }

        while (x < 5) {
            x++;
        }

        do {
            x--;
        } while (x > 0);

        switch (x) {
            case 0:
                System.out.println("zero");
                break;
            case 1, 2, 3:
                System.out.println("small");
                break;
            default:
                System.out.println("other");
        }

        int result = switch (text) {
            case "a" -> 1;
            case "b" -> 2;
            default -> 0;
        };

        Object obj = map;
        if (obj instanceof Map<?, ?> m && !m.isEmpty()) {
            System.out.println(m.get("a"));
        }

        try {
            mayThrow();
        } catch (IllegalStateException ex) {
            throw new RuntimeException("wrapped", ex);
        } finally {
            System.out.println("done");
        }

        Runnable r = () -> System.out.println("lambda");
        Named n = () -> "Bob";

        items.stream()
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .forEach(System.out::println);

        Box<String> box = new Box<>("value");
        String s = box.getValue();

        var anon = new Object() {
            int id = 7;
            String name() {
                return "anon";
            }
        };

        synchronized (this) {
            field++;
        }

        assert field >= 0 : "negative field";

        var c = Color.RED;
        var u = new User(1L, "Alice", true);
        Shape shape = new Circle(2.0);

        out.println(max(1, 2));
        out.println(result);
        out.println(n.label());
        out.println(u.display());
        out.println(shape.area());
        out.println(anon.name());
        out.println(s);
        out.println(ch);
        out.println(y + z);
        out.println(arr[0]);
        out.println(grid[0][1]);
        out.println(c);
    }

    private static void mayThrow() throws IllegalStateException {
        throw new IllegalStateException("x");
    }

    public static void main(String[] args) {
        new Demo().run();
    }
}

non-sealed class FutureExtension implements Shape {
    @Override
    public double area() {
        return 0;
    }
}

