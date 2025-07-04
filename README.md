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
cart.addProduct(cheese, 2);        
cart.addProduct(biscuits, 1);      
cart.addProduct(scratchCard, 1);    
cart.addProduct(Milk, 1);    

// Perform checkout
manager.checkout(customer, cart);
```
Output: 

```text
Cheese added to cart successfully
Biscuits added to cart successfully
Scratch Card added to cart successfully
Milk is expired

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
Cheese added to cart successfully
Biscuits added to cart successfully
Scratch Card added to cart successfully
Milk is expired

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
Insufficient balance
```

## edge case 2 : "Quantity exceeded" :

```text
Cheese added to cart successfully
Biscuits added to cart successfully
Scratch Card added to cart successfully
Milk is expired
Biscuits Quantity exceeded

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
## edge case 3 : "Purchase same product twice causing quantity exceeding" : 
```java
//simulate costumer data
Customer customer = new Customer("Sherif",400);
Cart cart = customer.getCart();

// Add products to cart
cart.addProduct(cheese, 2);
cart.addProduct(biscuits, 2);
cart.addProduct(biscuits, 5);
cart.addProduct(scratchCard, 1);
cart.addProduct(Milk, 1);

manager.checkout(customer, cart);
```

```text
Cheese added to cart successfully
Biscuits added to cart successfully
Biscuits added to cart successfully
Scratch Card added to cart successfully
Milk is expired
Biscuits Quantity exceeded

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
