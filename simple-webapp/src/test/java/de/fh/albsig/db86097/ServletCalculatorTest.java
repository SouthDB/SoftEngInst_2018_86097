package de.fh.albsig.db86097;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServletCalculatorTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @BeforeAll
    public void initExternalResources() {
        // for example create entityManagerFacotory
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ServletTestFibonacci() throws Exception {
        Mockito.when(request.getParameter("mode")).thenReturn("fibonacci");
        Mockito.when(request.getParameter("n")).thenReturn("6");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        new ServletCalculator().doPost(request, response);

        verify(request, times(1)).getParameter("mode");
        assertTrue(stringWriter.toString().contains("Result = 8"));
    }

    @AfterEach
    public void clearDatabase() {
        // for example delete created entries
    }

    @AfterAll
    public void closeDatabase() {
        // for example close connection to database
    }
}
