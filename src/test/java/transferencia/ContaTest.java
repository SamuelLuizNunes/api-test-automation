package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente samuel;
    Cliente bruno;
    Conta contaSamuel;
    Conta contaBruno;

    @BeforeEach
    void setUp() {
        samuel = new Cliente("Samuel Nunes", "33322288811", "558887776");
        bruno = new Cliente("Bruno Morais", "99988877766", "996667778");

        contaSamuel = new Conta("6322", "29832-0", 1000, samuel);
        contaBruno = new Conta("2263", "30784-2", 2000, bruno);
    }

    @Test
    public void realizarTransacao(){
        contaSamuel.realizarTransferencia(500, contaBruno);
        assertEquals(500, contaSamuel.getSaldo());
        assertEquals(2500, contaBruno.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida(){
        boolean resultado = contaSamuel.realizarTransferencia(2000, contaBruno);
        assertFalse(resultado);
    }

    @Test
    public void validarNomeCliente(){
        String nomeCliente = contaSamuel.getCliente().getNome();
        assertEquals("Samuel Nunes", nomeCliente);
    }

    @Test
    public void validarAgencia(){
        String agencia = contaSamuel.getAgencia();
        assertEquals("6322", agencia);
    }

    @Test
    public void validarNumeroConta(){
        String numeroConta = contaSamuel.getNumeroConta();
        assertEquals("29832-0", numeroConta);
    }

    @Test
    public void validaCPF(){
        String cpf = samuel.getCpf();
        assertEquals("33322288811", cpf);
    }

    @Test
    public void validaRG(){
        String rg = contaSamuel.getCliente().getRg();
        assertEquals("558887776", rg);
    }
}