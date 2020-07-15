package com.ruannunes.mapper;

import com.ruannunes.contract.dto.CustomerDTO;
import com.ruannunes.contract.dto.PaginatedResourceDTO;
import com.ruannunes.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description componente para mapear de maneira automatica o mapeamento de Entity e DTO de cliente
 */
@Component
public class CustomerMapper extends GenericMapper<Customer, CustomerDTO>{

}
