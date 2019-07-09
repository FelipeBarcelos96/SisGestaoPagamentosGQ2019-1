import com.hogwartsoftcomp.gestaopagamentos.business.AutorizadorPagamento;
import com.hogwartsoftcomp.gestaopagamentos.business.ProcessadorAutorizacao;
import com.hogwartsoftcomp.gestaopagamentos.model.Funcionario;
import com.hogwartsoftcomp.gestaopagamentos.model.Pagamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;





public class Teste {

    private Funcionario funcionario;
    private Pagamento pagamento;
    private ProcessadorAutorizacao processador;
	
	//inicialmente todos funcionarios estão disponíveis 
    public Teste() {
        processador = ProcessadorAutorizacao.getInstance();
       processador.add(new AutorizadorPagamento("Gerente imediato", 500));
      processador.add(new AutorizadorPagamento("Gerente geral", 1500));
       processador.add(new AutorizadorPagamento("Diretor financeiro", 5000));
       processador.add(new AutorizadorPagamento("Diretor geral", 15000));

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void teste1() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretario");
        this.pagamento = new Pagamento("CT01", 0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$0.01 foi autorizado pelo Gerente imediato.";
        assertEquals(resultado, resultadoEsperado);

    }
    
      @Test
    public void teste2() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT02", 0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$0.01 foi autorizado pelo Gerente geral.";
        assertEquals(resultado, resultadoEsperado);

    }
      @Test
    public void teste3() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT03", 0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$0.01 foi autorizado pelo Diretor financeiro.";
        assertEquals(resultado, resultadoEsperado);

    }
    
      @Test
    public void teste4() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT04", 0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$0.01 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
    
      @Test
    public void teste5() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT05", 0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento não aprovado";
        assertEquals(resultado, resultadoEsperado);

    }
    
    @Test
    public void teste6() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "auxiliar");
        this.pagamento = new Pagamento("CT06", 500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$500.0 foi autorizado pelo Gerente imediato.";
        assertEquals(resultado, resultadoEsperado);

    }
    
       @Test
    public void teste7() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT07", 500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$500.0 foi autorizado pelo Gerente geral.";
        assertEquals(resultado, resultadoEsperado);

    }
    
     @Test
    public void teste8() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT08",500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$500.0 foi autorizado pelo Diretor financeiro.";
        assertEquals(resultado, resultadoEsperado);

    }
    
      @Test
    public void teste9() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT09", 500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$500.0 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
       @Test
    public void teste10() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT10", 500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento não aprovado.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste11() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretario");
        this.pagamento = new Pagamento("CT011", 500.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$500.01 foi autorizado pelo Gerente geral.";
        assertEquals(resultado, resultadoEsperado);

    }
    
      @Test
    public void teste12() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT12", 500.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$500.01 foi autorizado pelo Gerente geral.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste13() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT13",500.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$500.01 foi autorizado pelo Diretor financeiro.";
        assertEquals(resultado, resultadoEsperado);

    }
    
       @Test
    public void teste14() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT14", 500.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$500.01 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
    
      @Test
    public void teste15() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT15", 500.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento não aprovado.";
        assertEquals(resultado, resultadoEsperado);

    }
     @Test
    public void teste16() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretario");
        this.pagamento = new Pagamento("CT016", 1500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$1500.0 foi autorizado pelo Gerente geral.";
        assertEquals(resultado, resultadoEsperado);

    }
     @Test
    public void teste17() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretario");
        this.pagamento = new Pagamento("CT017", 1500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$1500.0 foi autorizado pelo Gerente geral.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste18() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT18",1500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$1500.0 foi autorizado pelo Diretor financeiro.";
        assertEquals(resultado, resultadoEsperado);

    }
      @Test
    public void teste19() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT19", 1500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$1500.0 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
     @Test
    public void teste20() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT20", 1500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento não aprovado.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste21() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT21",1500.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$1500.01 foi autorizado pelo Diretor financeiro.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste22() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT22",1500.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$1500.01 foi autorizado pelo Diretor financeiro.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste23() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT23",1500.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$1500.01 foi autorizado pelo Diretor financeiro.";
        assertEquals(resultado, resultadoEsperado);

    }
     @Test
    public void teste24() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT24", 1500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$1500.0 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
    
    @Test
    public void teste25() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT25", 1500.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento não aprovado.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste26() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT26", 15000.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$15000.0 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
     @Test
    public void teste27() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT27", 15000.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$15000.0 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
     @Test
    public void teste28() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT28", 15000.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$15000.0 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
     @Test
    public void teste29() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT29", 15000.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento no valor de R$15000.0 foi autorizado pelo Diretor geral.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste30() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT30", 15000.0, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "Pagamento não aprovado.";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste31() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "auxiliar");
        this.pagamento = new Pagamento("CT31", 15000.01, data("02/07/2019"), funcionario);
        try {
            processador.processar(pagamento);
            String resultado = pagamento.getOcorrencias().get(0).getDescricao();
            String resultadoEsperado = "valor não pode ser autorizado";
            assertEquals(resultado, resultadoEsperado);
        } catch (IndexOutOfBoundsException ex) {
            assertEquals(true, true);
        }
    }
    @Test
        public void teste32() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretario");
        this.pagamento = new Pagamento("CT32", 15000.01, data("02/07/2019"), funcionario);
        try {
            processador.processar(pagamento);
            String resultado = pagamento.getOcorrencias().get(0).getDescricao();
            String resultadoEsperado = "valor não pode ser autorizado";
            assertEquals(resultado, resultadoEsperado);
        } catch (IndexOutOfBoundsException ex) {
            assertEquals(true, true);
        }
        }
        @Test
        public void teste33() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretario");
        this.pagamento = new Pagamento("CT33", 15000.01, data("02/07/2019"), funcionario);
        try {
            processador.processar(pagamento);
            String resultado = pagamento.getOcorrencias().get(0).getDescricao();
            String resultadoEsperado = "valor não pode ser autorizado";
            assertEquals(resultado, resultadoEsperado);
        } catch (IndexOutOfBoundsException ex) {
            assertEquals(true, true);
        }
        }
        @Test
        public void teste34() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "auxiliar");
        this.pagamento = new Pagamento("CT34", 15000.01, data("02/07/2019"), funcionario);
        try {
            processador.processar(pagamento);
            String resultado = pagamento.getOcorrencias().get(0).getDescricao();
            String resultadoEsperado = "valor não pode ser autorizado";
            assertEquals(resultado, resultadoEsperado);
        } catch (IndexOutOfBoundsException ex) {
            assertEquals(true, true);
        }
        }
        @Test
        public void teste35() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "Diretor geral");
        this.pagamento = new Pagamento("CT35", 15000.01, data("02/07/2019"), funcionario);
        try {
            processador.processar(pagamento);
            String resultado = pagamento.getOcorrencias().get(0).getDescricao();
            String resultadoEsperado = "valor não pode ser autorizado";
            assertEquals(resultado, resultadoEsperado);
        } catch (IndexOutOfBoundsException ex) {
            assertEquals(true, true);
        }

    }
        @Test
    public void teste36() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT36", 0.00, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor não pode ser autorizado.";
        assertEquals(resultado, resultadoEsperado);

    }
      @Test
    public void teste37() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT37", 0.00, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
      @Test
    public void teste38() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT38", 0.00, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
      @Test
    public void teste39() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT39", 0.00, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
      @Test
    public void teste40() throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT40", 0.00, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
	@Test
    public void teste41 ()throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT41", -0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
    public void teste42 ()throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT42", -0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
    @Test
     public void teste43
        ()throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT43", -0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
        @Test
      public void teste44
        ()throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT44", -0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
        @Test
       public void teste45
        ()throws ParseException {
        this.funcionario = new Funcionario("Fulano de Tal", "secretário");
        this.pagamento = new Pagamento("CT45", -0.01, data("02/07/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "valor inválido";
        assertEquals(resultado, resultadoEsperado);

    }
        @Test
        public void teste46
        ()throws ParseException {
        this.funcionario = new Funcionario("Fulano", "secretário");
        this.pagamento = new Pagamento("CT46", 500.0, data("19/06/2019"), funcionario);
        processador.processar(pagamento);
        String resultado = pagamento.getOcorrencias().get(0).getDescricao();
        String resultadoEsperado = "O Gerente imediato não pôde autorizar o pagamento pelo fato do mesmo estar vencido.";
        assertEquals(resultado, resultadoEsperado);

    }
    

   

   
    
  

    private Date data(String data) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.parse(data);
    }

}
