
//
//
/*a*/

"a"
"a\"b"
'a'
'a\'b'
`a`
`a\nb`
`a ${b}`
`a ${foo(bar)}`
`a\`b`

#
#

:
::
=>

.
..
...

@
@note

0
0.
0..1
0xFF
0b1010
1.0e-3
123n

foo
foo()
foo(
foo.bar
foo?.bar
foo?.()
foo()
foo => foo
(a, b) => a + b

true
false
null
undefined
NaN
Infinity

let x = 1;
const y = "hello";
var z = `value: ${x}`;

function add(a, b) {
    return a + b;
}

async function fetchUser(id) {
    await delay(10);
    return { id, ok: true };
}

class Box {
    constructor(value) {
        this.value = value;
    }

    getValue() {
        return this.value;
    }
}

const obj = {
    id: 1,
    name: "Alice",
    nested: {
        ok: true,
    },
};

const arr = [1, 2, 3];

if (x < 10) {
    console.log(add(x, 2));
} else {
    console.log("nope");
}

for (const item of arr) {
    console.log(item);
}

for (let i = 0; i < 3; i++) {
    console.log(i);
}

try {
    throw new Error("x");
} catch (err) {
    console.log(err.message);
}

const fn = (a, b) => {
    return a + b;
};

const summary = {
    id: obj.id,
    name: obj.name,
    text: `User: ${obj.name}`,
};

export default summary;

const msg = `👤 ${name} (${id})\n📧 ${email}\n🕒 ${lastLogin}\n`;

