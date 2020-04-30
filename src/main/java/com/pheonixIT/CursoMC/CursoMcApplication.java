package com.pheonixIT.CursoMC;

import com.pheonixIT.CursoMC.repositories.*;
import com.pheonixIT.CursoMC.resources.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;



    public static void main(String[] args) {
        SpringApplication.run(CursoMcApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));


        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Boituva", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

        Cliente cli1 = new Cliente(null,"Maria Silva","magia@email.com","5165456465", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("99523099","30122000"));

        Endereco e1 = new Endereco(null,"Rua flores","300","apto 300","Jardim","40245636889",cli1,c1);
        Endereco e2 = new Endereco(null,"Rua flores","300","apto 300","Jardim","40245636889",cli1,c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

        clienteRepository.saveAll(Arrays.asList(cli1));

        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY HH:mm");

        Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
        Pedido ped2 = new Pedido(null,sdf.parse("10/10/2020"),cli1,e2);

        Pagamento pgto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
        ped1.setPagamento(pgto1);

        Pagamento pgto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2021 00:00"),null);
        ped2.setPagamento(pgto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1,ped2));

        pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));







    }
}
