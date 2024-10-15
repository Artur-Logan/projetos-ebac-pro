package mod5;

import exercicios.Exercicio1;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class Exercicio1Test {

    @Test
    public void testConstructor(){
        Exercicio1 exercicio1 = new Exercicio1();

        int a = 4;
        int b = 2;

        int somar = exercicio1.somar(a, b);
        int subtrair = exercicio1.subtrair(a, b);
        int multiplicar = exercicio1.multiplicar(a, b);
        int dividir = exercicio1.dividir(a, b);

        Assert.assertEquals(somar, 6);
        Assert.assertEquals(subtrair, 2);
        Assert.assertEquals(multiplicar, 8);
        Assert.assertEquals(dividir, 2);

        assertThrows(ArithmeticException.class, () -> {
            exercicio1.dividir(1, 0);
        });
    }
}
