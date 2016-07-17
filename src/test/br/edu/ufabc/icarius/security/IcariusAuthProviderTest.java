package br.edu.ufabc.icarius.security;

import br.edu.ufabc.icarius.IcariusApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by fcosta on 17/07/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IcariusApplication.class)
public class IcariusAuthProviderTest {
    @Autowired
    private IcariusAuthProvider authProvider;

    @Test
    public void adminAuthenticationOk() throws Exception {
        Authentication authentication = new UsernamePasswordAuthenticationToken("felipe.anchieta", "felipe");
        Authentication authenticate = authProvider.authenticate(authentication);
        assertTrue(authenticate.isAuthenticated());
    }

    @Test
    public void nullOrEmptyPassword() throws Exception {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken("felipe.anchieta", null);
            Authentication authenticate = authProvider.authenticate(authentication);
            assertFalse(authenticate.isAuthenticated());

            authentication = new UsernamePasswordAuthenticationToken("felipe.anchieta", "");
            authenticate = authProvider.authenticate(authentication);
            assertFalse(authenticate.isAuthenticated());
        } catch (AuthenticationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void nullOrEmptyUsername() {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(null, "1234");
            Authentication authenticate = authProvider.authenticate(authentication);
            assertFalse(authenticate.isAuthenticated());

            authentication = new UsernamePasswordAuthenticationToken("", "1234");
            authenticate = authProvider.authenticate(authentication);
            assertFalse(authenticate.isAuthenticated());
        } catch (AuthenticationException e) {
            assertTrue(true);
        }
    }
}