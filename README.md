  
# D287 – JAVA FRAMEWORKS
## Rebecca Webb 
### Student ID: 011309828


### C.

*Customize the HTML user interface for your customer’s application. The user interface should include the
shop name, the product names, and the names of the parts.*
```
mainscreen.html 
 line 14: changed title text
 line 16: added background color to body
 line 19: changed heading text
 line 21: changed heading text
 line 33: added background and border color to table header
 line 42: added background color to table rows
 line 53: changed heading text
 line 69: added background and border color to table header 
 line 78: added background color to table rows
```

### D.

*Add an “About” page to the application to describe your chosen customer’s company to web viewers and
include navigation to and from the “About” page and the main screen.*
```
aboutPage.html created (src> main> resources > templates) 
 line 26-28: navigation to mainscreen.html (Home) 
 
MainScreenControllerr.java
 line 56-59: added GetMapping for aboutPage
 
mainscreen.html
 line 90-92: added navigation to aboutPage.html
```

### E.

*Add a sample inventory appropriate for your chosen store to the application. You should have five parts
and five products in your sample inventory and should not overwrite existing data in the database.*
```
BootStrapData.java
 line 3: import InhousePart
 line 7: import InhousePartRepository
 line 32: declare InhousePartRepository
 line 35, 39: added inhousePartRepository to constructor to be implemented
 line 63: defined conditional to add objects to inhouseParts if inhousePartRepository is empty
 line 64-109: created objects, set values, and added objects to inhousePartRepository 
 line 112: defined conditional to add objects to outsourcedParts if outsourcedPartRepository is empty
 line 113- 152: created objects, set values, and added objects to outsourcedPartRepository 
 line 154-161: create lists and print outsourcedParts and inhouseParts to console
 line 171: defined conditional to add objects to products if productRepository is empty
 line 172-187: created product objects, set values, and added objects to productRepository
 
application.properties
 line 6: added "WebbDatabase_1" to database URL
```

### F.
*Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following
parameters:  
• The “Buy Now” button must be next to the buttons that update and delete products.  
• The button should decrement the inventory of that product by one.It should not affect the inventory
of any of the associated parts.  
• Display a message that indicates the success or failure of a purchase.*
```
mainscreen.html
 line 85: added Buy Now button with link to display failure or success message

created failure.html to display failure message with link to return to mainscreen

created success.html to display success message with link to return to mainscreen

addProductController.java
 line 134-162: added mapping for buyProduct
 line 141: declares inv varibale to check conditional of product inventory value
 line 144-147: conditional to return failure.html if inv is 0
 line 148-161: conditional to return success.html if inv is greater than 0 and decrements inventory of the product,
                set and save the new value of the product inventory
```

### G.
*Modify the parts to track maximum and minimum inventory by doing the following:  
• Add additional fields to the part entity for maximum and minimum inventory.  
• Modify the sample inventory to include the maximum and minimum fields.  
• Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory
so the user can set the maximum and minimum values.  
• Rename the file the persistent storage is saved to.  
• Modify the code to enforce that the inventory is between or at the minimum and maximum value.*
```
mainscreen.html
 line 38-39: added column headers for min and max inventory
 line 48-49: added table data for min and max inventory
 
Part.java 
 line 4: import ValidInventory from validators
 line 23: added ValidInventory annotation
 line 33-36: created min and max inventory variables
 line 99-114: added getter and setters for min and max inventory

bootStrapData.java
 line 70-71, 81-82, 92-93, 104-105, 115-116, 130-131, 142-143, 154-155, 166-167: set min and max inventory for each part
 
application.properties
 line 6: renamed database url to end with "WebbDatabase_1.3" updated versions of database will be written as "WebbDatabase_x.x"
         

InhousePartForm.html
 line 16, 18, 21, 24: added text before input boxes to clarify what each input on the form is asking for
 line 26-30: added min and max inventory fields to the form
 line 32-37: added div to display message if inventory value is outside of the min and max range
             to prevent it from updating the inventory value to an invalid amount
 
OutsourcedPartForm.html
 line 17, 19, 22, 31: added text before inputs to clarify what each input on the form is asking for
 line 25-30: added min and max inventory fields to the form
 line 33-38: added div to display message if inventory value is outside of the min and max range
             to prevent it from updating the inventory value to an invalid amount
 
created class InventoryValidator.java 

created interface ValidInventory.java  
```

### H.

*Add validation for between or at the maximum and minimum fields. The validation must include the
following:  
• Display error messages for low inventory when adding and updating parts if the inventory is less than
the minimum number of parts.  
• Display error messages for low inventory when adding and updating products lowers the part
inventory below the minimum.  
• Display error messages when adding and updating parts if the inventory is greater than the maximum.*
```
Product.java
 line 4, 23: add/ import validator @ValidMaxProducts
 
EnufPartsValidator.java
 line 37-41: added conditional to display error message for low parts inventory 

created MaxProductsValidator.java

created ValidMaxProducts.java

application.properties
 line 6: renamed database url to end with "WebbDatabase_2.1"
```

### I.

*Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.*
```
PartTest.java
 line 161-166: added test for minimum inventory value
 line 168-173: added test for maximum inventory value
 
```
### J.

*Remove the class files for any unused validators in order to clean your code.*
```
Deleted class: 
 DeletePartValidator.java 
Deleted associated interface:  
 ValidDeletePart.java 
 
Part.java 
 line 3: removed import for validator ValidDeletePart 
 line 19: removed annotation for ValidDelete Part 
 
```