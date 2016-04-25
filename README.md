## Description

Public Java SDK for Pinterest's new API.

## Examples

- Construct a new Pinterest SDK
  - 
   ```java 
       final Pinterest pinterest = new Pinterest("<INSESRT_YOUR_PINTEREST_ACCESS_TOKEN>");
    ```
    
- To get a Pin (with all possible fields) via a Pin ID:
  - 
   ```java 
      final PinResponse pin = pinterest.getPin("<INSESRT_PIN_ID>", new PinFields().setAll());
   ```
   
- To get a Pin with only default fields (URL, note, link, ID) set
  - 
  ```java
     final PinResponse pin = pinterest.getPin("<INSESRT_PIN_ID>");
  ```
    
- To get all the Pins from a board with default fields
  - 
  ```java 
    final Pins pins = pinterest.getPinsFromBoard("<INSESRT_BOARD_NAME>");
  ```
    
- To get all the Pins from a board with all fields
  - 
  ```java 
     final Pins pins = pinterest.getPinsFromBoard("<INSESRT_BOARD_NAME>", new PinFields().setAll());
  ```
  
... more to come soon. (non-GET endpoints are currently in construction)

## Contributing

Found a bug? Have a suggestion? Feel free to send me PR or make an issue on the repo!
