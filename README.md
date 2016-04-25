# Description

Public Java SDK for Pinterest's new API.

# Examples

- Construct a new Pinterest SDK
  - 
   ```java 
       final Pinterest pinterest = new Pinterest("<INSESRT_YOUR_PINTEREST_ACCESS_TOKEN>");
    ```
    
### Pin Retrieval Examples
    
- To get a Pin (with **all fields**) via a Pin ID:
  - 
   ```java 
      final PinResponse pin = pinterest.getPin("<INSESRT_PIN_ID>", new PinFields().setAll());
   ```
  - Example Pin ID:  `525091637782793357`
   
- To get a Pin with only **default fields** (URL, note, link, ID) set
  - 
  ```java
     final PinResponse pin = pinterest.getPin("<INSESRT_PIN_ID>");
  ```
  
- To get a Pin with only **link, created_at, and color** set
  - 
  ```java
     final PinResponse pin = pinterest.getPin("<INSESRT_PIN_ID>", new PinFields().setLink().setCreatedAt().setColor());
  ```
    
- To get all the Pins **from a board** with default fields
  - 
  ```java 
    final Pins pins = pinterest.getPinsFromBoard("<INSESRT_BOARD_NAME>");
  ```
  - Example board name:  `cdatarank/欲しいもの/`
    
- To get all the Pins **from a board** with **all fields**
  - 
  ```java 
     final Pins pins = pinterest.getPinsFromBoard("<INSESRT_BOARD_NAME>", new PinFields().setAll());
  ```
  
### Board Retrieval Examples
  
... more to come soon. (non-GET endpoints are currently in construction)

# Contributing

Found a bug? Have a suggestion? Feel free to send me PR or make an issue on the repo!
