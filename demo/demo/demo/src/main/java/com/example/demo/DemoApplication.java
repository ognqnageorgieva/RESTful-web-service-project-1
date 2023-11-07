package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // additional properties, getters, setters
}
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // additional properties, getters, setters
}
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    // additional properties, getters, setters
}
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String country;
    // additional properties, getters, setters
}
// Repository Interfaces
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            user.setName(updatedUser.getName());
            // update additional properties
            userRepository.save(user);
        }
        return user;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(updatedProduct.getName());
            // update additional properties
            productRepository.save(product);
        }
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setOrderNumber(updatedOrder.getOrderNumber());
            // update additional properties
            orderRepository.save(order);
        }
        return order;
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address updatedAddress) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            address.setStreet(updatedAddress.getStreet());
            address.setCity(updatedAddress.getCity());
            address.setCountry(updatedAddress.getCountry());
            // update additional properties
            addressRepository.save(address);
        }
        return address;
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
    }
}
