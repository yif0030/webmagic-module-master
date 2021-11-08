package com.admin.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyMessageDigestPasswordEncoder extends BCryptPasswordEncoder {
    
    
    public MyMessageDigestPasswordEncoder(String algorithm) {
    
    }
}
