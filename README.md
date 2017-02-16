# Description

Public Java/Kotlin SDK for [Pinterest's new API](https://developers.pinterest.com/docs/getting-started/introduction/).

# Maven

```xml
<dependency>
    <groupId>com.chrisdempewolf</groupId>
    <artifactId>pinterest-sdk</artifactId>
    <version>1.9</version>
</dependency>
```

# Examples

### Initialization

- Construct a new Pinterest SDK:
```java 
 final Pinterest pinterest = new Pinterest("<INSERT_YOUR_PINTEREST_ACCESS_TOKEN>");
```
    
### Pin Methods

#### *Fetching*
    
- To get a Pin (with **all fields**) via a Pin ID:
  - Example Pin ID:  `525091637782793357`; from URL: `https://www.pinterest.com/pin/525091637782793357/`
```java 
final PinResponse pin = pinterest.getPin("<INSERT_PIN_ID>", new PinFields().setAll());
```
   
- To get a Pin with **only default fields** (`url`, `note`, `link`, `id`) set:
```java
final PinResponse pin = pinterest.getPin("<INSERT_PIN_ID>");
```
  
- To get a Pin with **only** `link`, `created_at`, and `color` set:
```java
final PinResponse pin = pinterest.getPin("<INSERT_PIN_ID>", new PinFields().setLink().setCreatedAt().setColor());
```
  
- To get **your own** Pins (with **all fields**):
```java 
final Pins pins = pinterest.getMyPins(new PinFields().setAll());
pins.forEach(pin -> {System.out.println(pin);});
```
    
- To get all the Pins **from a board** with default fields:
  - Example board name:  `cdatarank/欲しいもの/`; from URL:  `https://www.pinterest.com/cdatarank/欲しいもの/`
```java 
final Pins pins = pinterest.getPinsFromBoard("<INSERT_BOARD_NAME>");
```
    
- To get all the Pins **from a board** with **all fields**:
```java 
final Pins pins = pinterest.getPinsFromBoard("<INSERT_BOARD_NAME>", new PinFields().setAll());
```
  
- **Paging** through Pin responses:
```java
Pins pins = pinterest.getPinsFromBoard(BOARD_NAME);
while (pins.getNextPage() != null) {
    pins = pinterest.getNextPageOfPins(pins.getNextPage());
}
```

#### *Deleting*

All you need is the Pin ID and an access token with write access to the Pin question.
This method returns `true` if the Pin was successfully deleted; `false` otherwise.

```java
final boolean deleted = pinterest.deletePin("<INSERT_PIN_ID>");
```
  
### Board Methods

#### *Fetching*

-  To get info about a particular Board with **default** fields:
  - Example Board name: `cdatarank/欲しいもの`
    from URL:  `https://www.pinterest.com/cdatarank/欲しいもの/`
```java
final BoardResponse boardResponse = pinterest.getBoard("<INSERT_BOARD_NAME>");
final Board board = boardResponse.getBoard();
```

-  To get info about a particular Board with **all** fields:
```java
final BoardResponse boardResponse = pinterest.getBoard("<INSERT_BOARD_NAME>", new BoardFields().setAll());
final Board board = boardResponse.getBoard();
```
- **Paging** through Board responses:
```java
Boards boards = pinterest.getMyBoards(new BoardFields().setAll());
while (boards.getNextPage() != null) {
    boards = pinterest.getNextPageOfBoards(boards.getNextPage());
}
```

#### *Posting*
```java
final ResponseMessageAndStatusCode response = pinterest.postBoard("<BOARD_NAME>", "<BOARD_DESCRIPTION>");
```

#### *Updating*
```java
final name = "newname"; // the _actual_ name of the board
final boardName = "<YOUR_USERNAME>/<CURRENT_NAME_OF_BOARD>";
final ResponseMessageAndStatusCode response = pinterest.patchBoard(boardName, name, description);
```

#### *Deleting*
```java
final Boolean deleted = pinterest.deleteBoard("<YOUR_USERNAME>/<CURRENT_NAME_OF_BOARD>");
assertEquals(true, deleted);
```
... more to come soon.

# Coverage

- [x] GET `/v1/pins/<pin_id>`
- [x] GET `/v1/me/pins/<pin_id>`
- [x] GET `/v1/boards/<board_name>/pins/`
- [x] GET `/v1/me/boards/`
- [x] DELETE `/v1/pins/<pin_id>`
- [ ] POST `/v1/pins/`
- [ ] POST `/v1/boards/` -- completed; yet to be released
- [ ] PATCH `/v1/pins/<pin_id>`
- [ ] PATCH `/v1/boards/<board_name>` -- completed; yet to be released
- [ ] DELETE `/v1/boards/<board_name>` -- completed; yet to be released
- [ ] GET `/v1/me/`
- [ ] GET `/v1/me/boards/suggested/`
- [ ] GET `/v1/me/likes/`
- [ ] GET `/v1/me/search/boards/`
- [ ] GET `/v1/me/search/pins/`
- [ ] POST `/v1/me/following/boards/`
- [ ] POST `/v1/me/following/users/`
- [ ] GET `/v1/me/followers/`
- [ ] GET `/v1/me/following/boards/`
- [ ] GET `/v1/me/following/interests/`
- [ ] GET `/v1/me/following/users/`
- [ ] DELETE `/v1/me/following/boards/<board>/`
- [ ] DELETE `/v1/me/following/users/<user>/`

# Contributing

Found a bug? Have a suggestion? Feel free to send me PR or make an issue on the repo!

### Tests

To run the integration tests, put your Pinterest access token in the root of this directory in a file called `.access_token`.
