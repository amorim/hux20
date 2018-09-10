package repo;

import model.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class _138Test {

    BaseProblem p;
    TestCase oracle;
    ByteArrayOutputStream fakeOut;

    @BeforeEach
    void sobe(RepetitionInfo repetitionInfo) {
        fakeOut = FakeStreamsUtil.byteArrayInstance();
        p = new _138(FakeStreamsUtil.testCaseInstance(repetitionInfo.getCurrentRepetition(), 138), new PrintStream(fakeOut));
        oracle = FakeStreamsUtil.loadTestCase(repetitionInfo.getCurrentRepetition(), 138);
    }


    @RepeatedTest(value = 2, name = "Caso de teste nº {currentRepetition}")
    void test() {
        p.solve();
        String[] out = fakeOut.toString().split("\r\n|\r|\n");
        int lenor = oracle.output.length;
        Pattern p = Pattern.compile("\r\n|\r|\n");
        for (int i = 0; i < out.length; i++) {
            if (i == lenor) {
                assertEquals(i + 1, out.length, "Atingiu o fim do oráculo, mas ainda existem linhas na saída.");
                assertTrue(p.matcher(out[i]).matches(), "Verificar quebra de linha no final do arquivo");
                break;
            }
            if (i == out.length - 1 && i != lenor - 1) {
                assertEquals(i + 1, lenor, "Atingiu fim da saída, mas ainda existem linhas no oráculo");
                assertTrue(p.matcher(oracle.output[i]).matches(), "Verificar quebra de linha no final do arquivo");
                break;
            }
            assertEquals(oracle.output[i], out[i], "A resposta do programa na linha " + (i+1) + " está errada.");
        }

    }

}

class _138_3_Test {

    @Test
    void testInvalidId() {
        _138 p = new _138(FakeStreamsUtil.testCaseInstance(3, 138), null);
        assertThrows(IllegalStateException.class, p::solve, "Não lançou exceção para um ID inválido");
    }
}
