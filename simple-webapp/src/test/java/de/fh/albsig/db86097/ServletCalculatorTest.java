package de.fh.albsig.db86097;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@TestInstance(value = Lifecycle.PER_CLASS)
public class ServletCalculatorTest {

    private StringWriter stringWriter;
    private PrintWriter writer;
    ServletCalculator servletCalculator;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @BeforeAll
    public void initVar() {
        MockitoAnnotations.initMocks(this);
        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
        this.servletCalculator = new ServletCalculator();
        System.out.println("hallo");
    }

    @BeforeEach
    public void setUp() throws IOException {
        Mockito.when(request.getParameter("mode")).thenReturn("fibonacci");
        Mockito.when(request.getParameter("n")).thenReturn("6");
        Mockito.when(response.getWriter()).thenReturn(writer);

    }

    @Test
    public void ServletTestFibonacci() throws Exception {
        servletCalculator.doPost(request, response);
        verify(request, times(1)).getParameter("mode");
        assertTrue(stringWriter.toString().contains("Result = 8"));
    }

    @AfterEach
    public void deInitVar() {
        this.stringWriter = null;
        this.writer = null;
    }

    @AfterAll
    public void closeDatabase() {
        // for example close connection to database or delete created Test Files
    }
}
