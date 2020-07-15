package com.ruannunes.contract;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description interface para representar Uma Api generica para outras apis implementarem ela e aumentar mantenibilidade de codigos posteriores
 */

public interface GenericApi<C,U, V> {
	
	ResponseEntity<Void> save(@Valid @RequestBody final C dto);
	
	ResponseEntity<?> findAll();

	ResponseEntity<?> find(@PathVariable final  Long id) ;
	
	ResponseEntity<?> update(@Valid @RequestBody final U dto, @PathVariable final Long id);

	ResponseEntity<?> delete(@PathVariable final Long id);

	ResponseEntity<?> findPaginate(@SpringQueryMap @Valid final V filters);

}
