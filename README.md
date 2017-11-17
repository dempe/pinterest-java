# Description

Public Java/Kotlin SDK for [Pinterest's new API](https://developers.pinterest.com/docs/getting-started/introduction/).

# Maven

```xml
<dependency>
    <groupId>com.chrisdempewolf</groupId>
    <artifactId>pinterest-sdk</artifactId>
    <version>4.1.0</version>
</dependency>
```
Or check [Maven Central](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.chrisdempewolf%22%20AND%20a%3A%22pinterest-sdk%22) for a list of published artifacts.

### Versioning
This project uses [Semantic Versioning](http://semver.org/); `MAJOR.MINOR.PATCH`: X.Y.Z, such that X, Y, and Z are natural numbers where an update to X indicates a breaking (API) change, to Y indicates new, backwards-compatible features were added, and to Z indicates a bug was patched.  Please see the [Semantic Versioning website](http://semver.org/) for more information.

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

#### Available Fields
* `.withCounts()`
* `.withLink()`
* `.withMetadata()`
* `.withNote()`
* `.withURL()`
* `.withColor()`
* `.withAttribution()`
* `.withCreatedAt()`

#### Usage
    
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
List of parameters:

| Field         | Required      | Description   |
| ------------- | ------------- | ------------- |
| Pin ID        | Yes           | ID of Pin to update |
| Board         | No            | Board to post to  |
| Note          | No            | Pin's "note" or "description"  |
| Link          | No            | The URL to the the Pin |

(See the [Pinterest API documentation](https://developers.pinterest.com/docs/api/pins/?) for more info).

```java
final ResponseMessageAndStatusCode response = pinterest.patchPin("<PIN_ID>", 
                                                                "(optional)<BOARD>", 
                                                                "(optional)<NOTE>", 
                                                                "(optional)<LINK>");
```

To update a Pin's note:
```java
final ResponseMessageAndStatusCode response = pinterest.patchPin("<PIN_ID>", null, "<NOTE>", null);
```

### *Posting*
Currently, only POSTing via an image URL is supported.  Multi-part form and base64 encoded image uploading will be added soon.
```java
final ResponseMessageAndStatusCode response = pinterest.postPin("<BOARD>", "<NOTE>", "<IMG_URL>", "<LINK>");
```

### *Deleting*

All you need is the Pin ID and an access token with write access to the Pin question.
This method returns `true` if the Pin was successfully deleted; `false` otherwise. This `true`/`false` return pattern was adopted from [RestFB](http://restfb.com/).

```java
final boolean deleted = pinterest.deletePin("<PIN_ID>");
```
  
## Board Methods

### *Fetching*

#### Available Fields
* `.withCounts()`
* `.withCreatedAt()`
* `.withDescription()`
* `.withID()`
* `.withImage()`
* `.withName()`
* `.withURL()`

#### Usage

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
Note:  this method requires a _Board name_ not a _Board_ (see terminology section for more information).
```java
final String boardName = "foo";
final ResponseMessageAndStatusCode response = pinterest.postBoard(boardName, "<BOARD_DESCRIPTION>");
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

## User Methods

Note: user methods only work with the _authenticated_ user (i.e., the owner of the access token you used to initialize the Pinterest SDK).

### *Fetching*

#### Available Fields
* `.withBio()`
* `.withCounts()`
* `.withCretedAt()`
* `.withFirstName()`
* `.withImage()`
* `.withLastName()`
* `.withURL()`
* `.withUsername()`

#### Usage

##### _USER_

To get a user with the *default* fields:
```java
final User user = pinterest.getUser();
```

To get a user with *all* fields:
```java
final User user = pinterest.getUser(new UserFields().withAll());
```

To get a user with *first name* and *last name*:
```java
final User user = pinterest.getUser(new UserFields().withFirstName().withLastName());
```
##### _USER'S SUGGESTED BOARDS_

To get the user's list of suggested Boards (with *default* fields):
```java
final Boards boards = pinterest.getUserSuggestedBoards();
```

This method takes an optional `BoardFields` parameter (see the Board section above for more info).
```java
final Boards boards = pinterest.getUserSuggestedBoards(new BoardFields().withName());
```

##### _USER'S BOARDS_

Retrieving all of a user's Boards works the same way:
```java
final Boards boards = pinterest.getUserBoards(new BoardFields().withName());
```

##### _USER'S PINS_
Similarly, to retrieve a user's Pins:
```java
final Pins pins = pinterest.getUserPins();
```

Or...
```java
final Pins pins = pinterest.getUserPins(new PinFields().withCreatedAt());
```

##### _SEARCH USER'S PINS_
```java
final Pins pins = pinterest.searchUserPins("cucumber");
```

You can also optionally specify the fields you want returned:
```java
final Pins pins = pinterest.searchUserPins("cucumber", new PinFields().withNote());
```

*Paging* works the same for _all_ `Pins` responses, so:
```java
Pins pins = pinterest.searchUserPins("cucumber", new PinFields().withNote());
while (pins.getNextPage() != null) {
    pins = pinterest.getNextPageOfPins(pins.getNextPage());
}
```

#### _USER'S FOLLOWERS_

With default fields...
```java
final Users users = pinterest.getFollowers();
```

With select fields...
```java
final Users users = pinterest.getFollowers(new UserFields().withCounts().withBio());
```

Paginating...
```java
Users users = pinterest.getFollowers(new UserFields().withCounts().withBio());
while (users.getNextPage() != null) {
    users = pinterest.getNextPageOfUsers(users.getNextPage());
}
```

#### _FOLLOWERS' BOARDS_

With default fields...
```java
final Boards boards = pinterest.getFollowersBoards();;
```

With select fields...
```java
final Boards boards = pinterest.getFollowersBoards(new BoardFields().withName().withURL());
```

Paginating...
```java
Boards boards = pinterest.getFollowersBoards(new BoardFields().withName().withURL());
while (boards.getNextPage() != null) {
    boards = pinterest.getNextPageOfBoards(boards.getNextPage());
}
```

#### _FOLLOWING_

* With default fields...
```java
final Users users = pinterest.getFollowing();
```

* With select fields...
```java
final Users users = pinterest.getFollowing(new UserFields().withCounts().withBio());
```

* Paginating...
```java
Users users = pinterest.getFollowing(new UserFields().withCounts().withBio());
while (users.getNextPage() != null) {
    users = pinterest.getNextPageOfUsers(users.getNextPage());
}
```

##### _SEARCH USER'S BOARDS_
* With _default_ fields
```java
final Boards boards = pinterest.searchUserBoards("cucumber");
```

* With specific fields
```java
final Boards boards = pinterest.searchUserBoards("cucumber", new BoardFields().withName());
```

* *Paging* works the same for _all_ `Boards` responses, so:
```java
Boards boards = pinterest.searchUserBoards("cucumber", new BoardFields().withName());
while (boards.getNextPage() != null) {
    boards = pinterest.getNextPageOfBoards(boards.getNextPage());
}
```

### *Posting*

#### _FOLLOW BOARD_

```java
final ResponseMessageAndStatusCode resp = pinterest.followBoard("cdatarank/my-board");
assertEquals(200L, resp.getStatusCode());
```

#### _FOLLOW USER_

```java
final ResponseMessageAndStatusCode resp = pinterest.followUser("cdatarank");
if (resp.getStatusCode() != 200) {
    System.err.println(resp.getMessage());
}
```

### *Deleting*

#### _UNFOLLOW BOARD_

```java
final boolean unfollowed = pinterest.unfollowBoard("cdatarank/my-board");
```

#### _UNFOLLOW USER

```java
final boolean unfollowed = pinterest.unfollowUser("cdatarank");
```

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
- [x] GET `/v1/me/`
- [x] GET `/v1/me/boards/suggested/`
- [x] GET `/v1/me/boards/`
- [x] GET `/v1/me/pins/`
- [x] GET `/v1/me/search/boards/`
- [x] GET `/v1/me/search/pins/`
- [x] GET `/v1/me/followers/`
- [x] GET `/v1/me/following/boards/`
- [ ] GET `/v1/me/following/interests/`
- [x] GET `/v1/me/following/users/`
- [x] POST `/v1/me/following/boards/`
- [x] POST `/v1/me/following/users/`
- [x] DELETE `/v1/me/following/boards/<board>/`
- [x] DELETE `/v1/me/following/users/<user>/`

# Contributing

See [CONTRIBUTING.md](https://github.com/dempe/pinterest-java/blob/master/CONTRIBUTING.md).
