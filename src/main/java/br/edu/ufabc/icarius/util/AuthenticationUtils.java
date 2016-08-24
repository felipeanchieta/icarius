package br.edu.ufabc.icarius.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class AuthenticationUtils {
    public byte[] generateSha256(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ignore) {
        }
        assert messageDigest != null;
        return messageDigest.digest(password.getBytes());
    }
}
