package mod5;

import exercicios.Exercicio2;
import org.junit.Assert;
import org.junit.Test;

public class Exercicio2Test {

    @Test
    public void testConstructor(){

        int a = 2;
        int b = 3;
        int c = 4;

        long teste1 = Exercicio2.fatorial(a);
        long teste2 = Exercicio2.fatorial(b);
        long teste3 = Exercicio2.fatorial(c);

        Assert.assertEquals(2, teste1);
        Assert.assertEquals(6, teste2);
        Assert.assertEquals(24, teste3);

    }
}

