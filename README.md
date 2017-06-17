# Description

Public Java/Kotlin SDK for [Pinterest's new API](https://developers.pinterest.com/docs/getting-started/introduction/).

# Maven

```xml
<dependency>
    <groupId>com.chrisdempewolf</groupId>
    <artifactId>pinterest-sdk</artifactId>
    <version>1.17</version>
</dependency>
```
Or check [Maven Central](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.chrisdempewolf%22%20AND%20a%3A%22pinterest-sdk%22) for a list of published artifacts.

# Examples

## Quick Note on Terminology

The word "Board" on Pinterest can be somewhat confusing - does it refer to `<username/board_name>` or just the latter, `board_name` part?

Here, when I say _"board"_, I mean the `<username/board_name>` combination.  I will say _"board name"_ when I'm specifically refering to the name of the Board without the prepended username portion. I believe this is the approach Pinterest takes as well.

## Initialization

- Construct a new Pinterest SDK:
```java 
 final Pinterest pinterest = new Pinterest("<INSERT_YOUR_PINTEREST_ACCESS_TOKEN>");
```
    
## Pin Methods

### *Fetching*
    
- To get a Pin (with **all fields**) via a Pin ID:
  - Example Pin ID:  `525091637782793357`; from URL: `https://www.pinterest.com/pin/525091637782793357/`
```java 
final PinResponse pin = pinterest.getPin("<PIN_ID>", new PinFields().withAll());
```
   
- To get a Pin with **only default fields** (`url`, `note`, `link`, `id`) set:
```java
final PinResponse pin = pinterest.getPin("<PIN_ID>");
```
  
- To get a Pin with **only** `link`, `created_at`, and `color` set:
```java
final PinResponse pin = pinterest.getPin("<PIN_ID>", new PinFields().withLink().withCreatedAt().withColor());
```
  
- To get **your own** Pins (with **all fields**):
```java 
final Pins pins = pinterest.getMyPins(new PinFields().withAll());
pins.forEach(pin -> {System.out.println(pin);});
```
    
- To get all the Pins **from a board** with default fields:
  - Example Board:  `cdatarank/欲しいもの`; from URL:  `https://www.pinterest.com/cdatarank/欲しいもの/`
```java 
final Pins pins = pinterest.getPinsFromBoard("<BOARD>");
```
    
- To get all the Pins **from a board** with **all fields**:
```java 
final Pins pins = pinterest.getPinsFromBoard("<BOARD>", new PinFields().withAll());
```
  
- **Paging** through Pin responses:
```java
Pins pins = pinterest.getPinsFromBoard(BOARD);
while (pins.getNextPage() != null) {
    pins = pinterest.getNextPageOfPins(pins.getNextPage());
}
```

### *Updating*
```java
final ResponseMessageAndStatusCode response = pinterest.patchPin(
                                                                "<PIN_ID>", 
                                                                "(optional)<BOARD>", 
                                                                "(optional)<NOTE>", 
                                                                "(optional)<LINK>");
```

To update a Pin's note:
```java
final ResponseMessageAndStatusCode response = pinterest.patchPin(
                                                                "<PIN_ID>", 
                                                                null, 
                                                                "<NOTE>", 
                                                                null);
```

### *Posting*
Currently, only POSTing via an image URL is supported.  Multi-part form and base64 encoded image uploading will be added soon.
```java
final ResponseMessageAndStatusCode response = pinterest.postPin(
                                                            "<BOARD>",
                                                            "<NOTE>",
                                                            "<IMG_URL>",
                                                            "<LINK>");
```

### *Deleting*

All you need is the Pin ID and an access token with write access to the Pin question.
This method returns `true` if the Pin was successfully deleted; `false` otherwise. This `true`/`false` return pattern was adopted from [RestFB](http://restfb.com/).

```java
final boolean deleted = pinterest.deletePin("<PIN_ID>");
```
  
## Board Methods

### *Fetching*

-  To get info about a particular Board with **default** fields:
  - Example Board: `cdatarank/欲しいもの`
    from URL:  `https://www.pinterest.com/cdatarank/欲しいもの/`
```java
final BoardResponse boardResponse = pinterest.getBoard("<BOARD>");
final Board board = boardResponse.getBoard();
```

-  To get info about a particular Board with **all** fields:
```java
final BoardResponse boardResponse = pinterest.getBoard("<BOARD>", new BoardFields().withAll());
final Board board = boardResponse.getBoard();
```
- **Paging** through Board responses:
```java
Boards boards = pinterest.getMyBoards(new BoardFields().withAll());
while (boards.getNextPage() != null) {
    boards = pinterest.getNextPageOfBoards(boards.getNextPage());
}
```

### *Posting*
```java
final ResponseMessageAndStatusCode response = pinterest.postBoard("<BOARD>", "<BOARD_DESCRIPTION>");
```

### *Updating*
```java
final name = "newname"; // the _actual_ name of the board
final board = "<CURRENT_BOARD>";
final ResponseMessageAndStatusCode response = pinterest.patchBoard(board, name, description);
```

### *Deleting*
```java
final Boolean deleted = pinterest.deleteBoard("<BOARD>");
assertEquals(true, deleted);
```
... more to come soon.

# Coverage

- [x] GET `/v1/pins/<pin_id>`
- [x] GET `/v1/me/pins/<pin_id>`
- [x] GET `/v1/boards/<board_name>/pins/`
- [x] GET `/v1/me/boards/`
- [x] DELETE `/v1/pins/<pin_id>`
- [x] POST `/v1/pins/` (still missing multi-part form uploading and base64 encoded image URLs).
- [x] POST `/v1/boards/`
- [x] PATCH `/v1/pins/<pin_id>`
- [x] PATCH `/v1/boards/<board_name>`
- [x] DELETE `/v1/boards/<board_name>`
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

See [CONTRIBUTING.md](https://github.com/dempe/pinterest-java/blob/master/CONTRIBUTING.md).
