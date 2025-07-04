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

# Code Examples

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
```
Output: 

```text
Product added to cart successfully
Product added to cart successfully
Product added to cart successfully
Product is expired

**Shippment notice**
2X Cheese  200.0g
1X Biscuits  700.0g
Total package weight 1.1 kg

**Checkout receipt**
2X Cheese  100
1X Biscuits  150
1X Scratch Card  50
---------------------
Subtotal: 400
Shipping Fees: 30
Amount: 430
```
## edge case 1 : "Insufficient balance"

```text
Product added to cart successfully
Product added to cart successfully
Product added to cart successfully
Product is expired

**Shippment notice**
2X Cheese  200.0g
2X Biscuits  700.0g
Total package weight 1.8 kg

**Checkout receipt**
2X Cheese  100
2X Biscuits  150
1X Scratch Card  50
---------------------
Subtotal: 550
Shipping Fees: 30
Amount: 580
Insufficient balance
```

## edge case 2 : "Quantity exceeded" :

```text
Product added to cart successfully
Quantity exceeded
Product added to cart successfully
Product is expired

**Shippment notice**
2X Cheese  200.0g
Total package weight 400.0 g

**Checkout receipt**
2X Cheese  100
1X Scratch Card  50
---------------------
Subtotal: 250
Shipping Fees: 30
Amount: 280
```
