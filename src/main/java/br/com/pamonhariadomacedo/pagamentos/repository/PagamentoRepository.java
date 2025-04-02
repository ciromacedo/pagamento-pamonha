package br.com.pamonhariadomacedo.pagamentos.repository;

import br.com.pamonhariadomacedo.pagamentos.model.EPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<EPagamento, Long> {

}
