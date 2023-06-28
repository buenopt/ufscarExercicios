package exerc4Test;

import exerc4.Mutante1;
import exerc4.Mutante2;
import exerc4.Mutante3;
import exerc4.Original;
import exerc4.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OriginalTest {
    private Original testeClasseMut;
    //private Mutante1 testeClasseMut;
    //private Mutante2 testeClasseMut;
    //private Mutante3 testeClasseMut;

    private Pessoa pessoa;

    @BeforeEach
    public void setup() {
        testeClasseMut = new Original();

        //Testes a serem efetuados!

        //testeClasseMut=new Mutante1();
        //testeClasseMut=new Mutante2();
        //testeClasseMut=new Mutante3();
    }



    @Test
    public void testDefinirFaixaEtariaCrianca() {
        pessoa = new Pessoa("João", 10);
        String resultado = testeClasseMut.definirFaixaEtaria(pessoa);
        Assertions.assertEquals("João eh crianca", resultado);
    }

    @Test
    public void testDefinirFaixaEtariaAdolescente() {
        pessoa = new Pessoa("Maria", 16);
        String resultado = testeClasseMut.definirFaixaEtaria(pessoa);
        Assertions.assertEquals("Maria eh adolescente", resultado);
    }

    @Test
    public void testDefinirFaixaEtariaAdulto() {
        pessoa = new Pessoa("Carlos", 30);
        String resultado = testeClasseMut.definirFaixaEtaria(pessoa);
        Assertions.assertEquals("Carlos eh adulto", resultado);
    }

    @Test
    public void testDefinirFaixaEtariaIdoso() {
        pessoa = new Pessoa("Ana", 75);
        String resultado = testeClasseMut.definirFaixaEtaria(pessoa);
        Assertions.assertEquals("Ana eh idoso", resultado);
    }

    @Test
    public void testDefinirFaixaEtariaIdadeInvalida() {
        pessoa = new Pessoa("Pedro", -5);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testeClasseMut.definirFaixaEtaria(pessoa));
    }
}
