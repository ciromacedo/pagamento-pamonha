package br.com.pamonhariadomacedo.pagamentos.services;

import br.com.pamonhariadomacedo.pagamentos.dto.PagamentoDto;
import br.com.pamonhariadomacedo.pagamentos.model.EPagamento;
import br.com.pamonhariadomacedo.pagamentos.model.Status;
import br.com.pamonhariadomacedo.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public Page<PagamentoDto> obterTodos(Pageable paginacao){
        return repository
                .findAll(paginacao)
                .map(entidade -> modelMapper.map(entidade, PagamentoDto.class));
    }

    public PagamentoDto obterPorId(Long id){
        EPagamento entidade = repository.findById(id).orElseThrow( () -> new EntityNotFoundException());
        return modelMapper.map(entidade, PagamentoDto.class);
    }

    public PagamentoDto criarPagamento(PagamentoDto pagamentoDto){
        EPagamento entidade = modelMapper.map(pagamentoDto, EPagamento.class);
        entidade.setStatus(Status.CRIADO);
        repository.save(entidade);

        return modelMapper.map(entidade, PagamentoDto.class);
    }

    public PagamentoDto atualizarPagamento(Long id, PagamentoDto pagamentoDto){
        EPagamento entidade = modelMapper.map(pagamentoDto, EPagamento.class);
        entidade.setId(id);

        entidade = repository.save(entidade);
        return modelMapper.map(entidade, PagamentoDto.class);
    }

    public void excluirParamentos(Long id){
        repository.deleteById(id);
    }

}
