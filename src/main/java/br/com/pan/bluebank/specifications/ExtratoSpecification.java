package br.com.pan.bluebank.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.pan.bluebank.dtos.filter.ExtratoFilter;
import br.com.pan.bluebank.models.Movimentacao;

@Component
public class ExtratoSpecification {

	public Specification<Movimentacao> movimentacoes(ExtratoFilter filter) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicateList = new ArrayList<>();
			 
			if (!ObjectUtils.isEmpty(filter.getContaId())) {
	 			Predicate origem = criteriaBuilder.equal(root.get("contaOrigem"), filter.getContaId());
				Predicate destino = criteriaBuilder.equal(root.get("contaDestino"), filter.getContaId());
				predicateList
					.add(criteriaBuilder.or(origem, destino));
			}

			if (!ObjectUtils.isEmpty(filter.getTipo())) {
				predicateList
					.add(criteriaBuilder.equal(root.get("tipo"), filter.getTipo()));
			}
			
			if (!ObjectUtils.isEmpty(filter.getDataMovimentacao())) {
				predicateList
						.add(criteriaBuilder.equal(root.get("dataMovimentacao"), filter.getDataMovimentacao()));
			}

			if (!ObjectUtils.isEmpty(filter.getInitialDataMovimentacao())) {
				predicateList
						.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataMovimentacao"), filter.getInitialDataMovimentacao()));
			}

			if (!ObjectUtils.isEmpty(filter.getFinalDataMovimentacao())) {
				predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("dataMovimentacao"), filter.getFinalDataMovimentacao()));
			}

			return criteriaBuilder.and(predicateList.toArray(x -> new Predicate[x]));
		};

	}
}
