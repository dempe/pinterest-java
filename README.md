# Description

Public Java SDK for Pinterest's new API.

# Maven

```xml
<dependency>
    <groupId>com.chrisdempewolf</groupId>
    <artifactId>pinterest-sdk</artifactId>
    <version>1.6</version>
</dependency>
```

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
  - Example Pin ID:  `525091637782793357` from URL: `https://www.pinterest.com/pin/525091637782793357/`
   
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
  
- To get **your own** Pins (with **all fields**):
  - 
    ```java 
    final Pins pins = pinterest.getMyPins(new PinFields().setAll());
    pins.forEach(pin -> {System.out.println(pin);});
    ```
    
- To get all the Pins **from a board** with default fields
  - 
    ```java 
    final Pins pins = pinterest.getPinsFromBoard("<INSESRT_BOARD_NAME>");
    ```
  - Example board name:  `cdatarank/欲しいもの/` from URL:  `https://www.pinterest.com/cdatarank/欲しいもの/`
    
- To get all the Pins **from a board** with **all fields**
  - 
    ```java 
    final Pins pins = pinterest.getPinsFromBoard("<INSESRT_BOARD_NAME>", new PinFields().setAll());
    ```
  
- **Paging** through Pin responses
  - 
    ```java
    Pins pins = pinterest.getPinsFromBoard(BOARD_NAME);
    while (pins.getNextPage() != null) {
        pins = pinterest.getNextPageOfPins(pins.getNextPage());
    }
    ```
  
### Board Retrieval Examples

-  To get info about a particular Board with **default** fields:
  - 
    ```java
    final BoardResponse boardResponse = pinterest.getBoard("<INSESRT_USERNAME_NAME>", "<INSESRT_BOARD_NAME>");
    final Board board = boardResponse.getBoard();
    ```
  - Example username: `cdatarank`; example Board name: `欲しいもの`
    from URL:  `https://www.pinterest.com/cdatarank/欲しいもの/`

-  To get info about a particular Board with **all** fields:
  - 
    ```java
    final BoardResponse boardResponse = pinterest.getBoard("<INSESRT_USERNAME_NAME>", "<INSESRT_BOARD_NAME>", new BoardFields().setAll());
    final Board board = boardResponse.getBoard();
    ```
  
... more to come soon. (non-GET endpoints are currently in construction)

# Contributing

Found a bug? Have a suggestion? Feel free to send me PR or make an issue on the repo!
