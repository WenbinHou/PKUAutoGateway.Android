package com.a.a;

import java.security.Provider;

class e extends Provider {
    public e() {
        super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
        put("SecureRandom.SHA1PRNG", d.class.getName());
        put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
    }
}
