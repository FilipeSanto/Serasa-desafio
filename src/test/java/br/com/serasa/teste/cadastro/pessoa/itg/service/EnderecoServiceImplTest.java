package br.com.serasa.teste.cadastro.pessoa.itg.service;

import br.com.serasa.teste.cadastro.pessoa.exception.EnderecoException;
import br.com.serasa.teste.cadastro.pessoa.itg.dto.EnderecoDTO;
import br.com.serasa.teste.cadastro.pessoa.model.endereco.DadosCepDTO;
import br.com.serasa.teste.cadastro.pessoa.service.impl.EnderecoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnderecoServiceImplTest {

    @Mock
    private ConsultaCepService consultaCepService;

    @InjectMocks
    private EnderecoServiceImpl enderecoService;

    @Test
    void shouldConsultCepSuccess() {
        String cep = "12345-678";
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setCep(cep);
        enderecoDTO.setBairro("Centro");
        enderecoDTO.setLocalidade("São Paulo");
        enderecoDTO.setEstado("SP");
        enderecoDTO.setLogradouro("Rua ABC");

        DadosCepDTO esperado = DadosCepDTO.builder()
                .cep(cep)
                .bairro("Centro")
                .cidade("São Paulo")
                .estado("SP")
                .logradouro("Rua ABC")
                .build();

        when(consultaCepService.consultaCep(cep)).thenReturn(enderecoDTO);

        DadosCepDTO resultado = enderecoService.buscaCep(cep);

        assertEquals(esperado.getCep(), resultado.getCep());
        assertEquals(esperado.getBairro(), resultado.getBairro());
        assertEquals(esperado.getCidade(), resultado.getCidade());
        assertEquals(esperado.getEstado(), resultado.getEstado());
        assertEquals(esperado.getLogradouro(), resultado.getLogradouro());

        verify(consultaCepService, times(1)).consultaCep(cep);
    }

    @Test
    void shouldConsultCepNotFound() {
        String cep = "12345-678";
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setCep(null);

        when(consultaCepService.consultaCep(cep)).thenReturn(enderecoDTO);

        Exception exception = assertThrows(EnderecoException.class, () -> enderecoService.buscaCep(cep));
        assertEquals("CEP não encontrado.", exception.getMessage());

        verify(consultaCepService, times(1)).consultaCep(cep);
    }

    @Test
    void shouldConsultCepException() {
        String cep = "12345-678";

        when(consultaCepService.consultaCep(cep)).thenThrow(new HttpClientErrorException(HttpStatusCode.valueOf(400)));

        Exception exception = assertThrows(EnderecoException.class, () -> enderecoService.buscaCep(cep));
        assertEquals("CEP não encontrado.", exception.getMessage());

        verify(consultaCepService, times(1)).consultaCep(cep);
    }

}