package testes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import trilha.back.financys.DTOs.DtoFiltro;
import trilha.back.financys.DTOs.LancamentoMapper;
import trilha.back.financys.Entitys.Lancamento;
import trilha.back.financys.Repositorys.LancamentoRepository;
import trilha.back.financys.Services.LancamentoService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TrilhaBackTestes {

    @Mock
    private LancamentoRepository lancamentoRepository;

    @Mock
    private LancamentoMapper lancamentoMapper;

    @Mock
    private DtoFiltro dtoFiltro;

    @InjectMocks
    private LancamentoService lancamentoService;

    @Test
    void deveRetornarListaVaziaQuandoNaoExistirDados() {

        Mockito.when(lancamentoRepository.findAll())
                .thenReturn(Collections.emptyList());

        var resultado = lancamentoService.listarTodosOrdenadosPorData();

        assertTrue(resultado.isEmpty());
    }

    @Test
    void deveRetornarListaQuandoExistirDados() {

        Lancamento lanc = new Lancamento();

        Mockito.when(lancamentoRepository.findAll())
                .thenReturn(List.of(lanc));

        Mockito.when(lancamentoMapper.toDto(Mockito.any()))
                .thenReturn(Mockito.mock(trilha.back.financys.DTOs.DtoLancamento.class));

        var resultado = lancamentoService.listarTodosOrdenadosPorData();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
    }


    @Test
    void deveRetornarApenasDadosDoFiltro() {

        LocalDate data = LocalDate.of(2025, 1, 10);
        Integer quantidade = 2;
        Boolean pago = true;

        Lancamento lanc = new Lancamento();
        lanc.setData(data);
        lanc.setQuantidade(quantidade);
        lanc.setPago(pago);

        Mockito.when(lancamentoRepository.findAll())
                .thenReturn(List.of(lanc));

        var lista = lancamentoService.buscarPorFiltro(data, quantidade, pago);

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
    }

    @Test
    void deveRetornarListaVaziaQuandoFiltroNaoEncontrar() {

        Mockito.when(lancamentoRepository.findAll())
                .thenReturn(Collections.emptyList());

        var lista = lancamentoService.buscarPorFiltro(
                LocalDate.now(),
                1,
                true
        );

        assertTrue(lista.isEmpty());
    }

}