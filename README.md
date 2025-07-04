# Design 
- Interface implementation design
- used builder with the product class to ensure clean info.
- Make a usage of single responsibility of methods within every class
- Using Map data structure to be in the best time complexity possible for products searching 
- Implementing ShippableItem interface in ShippableProduct object to ensure grouping to all shippable product in the cart
- Abstracting the product class.
- customer object is immutable to ensure no conflict in changing data in runtime.

# Features
- add / remove product from cart
- prevent adding expired or out-of-stock products 
- checkout calculations 
- shipment notice for shippable items 
- interface-based shipping service

# Code Example

Here's how the system works in action:

```java
// Create a customer with a budget
Customer customer = new Customer("Sherif", 500);
Cart cart = customer.getCart();

// Add products to the cart
cart.addProduct(cheese, 2);         // Valid
cart.addProduct(biscuits, 1);       // Valid
cart.addProduct(scratchCard, 1);    // Valid (shippable item)
cart.addProduct(expiredMilk, 1);    // Will be rejected (expired)

// Perform checkout
manager.checkout(customer, cart);
