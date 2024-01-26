package pl.dudi.accountservice.infrastructure.database.dao;

import pl.dudi.accountservice.model.Customer;

public interface CustomerDAO {
    Customer addCustomerToDatabase(Customer customer);

    Customer findCustomer(int customerCode);
}
