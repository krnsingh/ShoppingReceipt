# ShoppingReceipt

This application print the grocery list along with the savings.

To run this application, follow these steps.
1) Clone the project from GitHub.
2) To create a executable jar file, execute `mvn clean package` from project directory.
3) Then execute `java -jar target/calculator-1.0-SNAPSHOT.jar` from the same directory and
this will print the receipt with already populated cart.

For Example
```coke -  £1.00
   coke -  £1.00
   coke -  £1.00
   apple -  £1.00
   tissues -  £1.60
   oranges -  £1.50
   SubTotal - 7.10
   Savings
   tissues2 for £1 -  £0.60
   coke3 for 2 -  £1.00
   Total - 5.50
```

To change the cart, go to `ReceiptApplication` class and modify `generateCartItems` and 
`generateOffersOnItems` methods and repeat steps 2 & 3 mentioned above.

## Brief explanation of code structure

Model Classes
* `Item` -> Represent shopping item with unique name and price.
* `CartItem` -> Contains `Item` and quantity which can be number or weight
* `ReceiptItem` -> Contains `label` and `amount`, thats for display purpose

Service/Component Classes
* `Offer` -> Interface that would be implement for new offers to calculate the savings.
`ThreeForTwo` and `TwoForOnePound` implementations has been provided.
* `ItemsOnOffer` -> This class keeps track of the relationship between `Item` & associated  `Offer`.
* `SavingsCalculator` -> Calculates the savings for a given List of `CartItem`.
* `ReceiptGenerator` -> Generate receipt in form of `List<String>` by taking `List<CartItem>` and  `ItemsOnOffer` as
input.




