# pinterest

Public Java SDK for Pinterest's new API.

Some example uses are

- Construct a new Pinterest SDK
  - `final Pinterest pinterest = new Pinterest("<INSESRT_YOUR_PINTEREST_ACCESS_TOKEN>");`
- To get a Pin via a Pin ID:
  - `final PinResponse pin = pinterest.getPin("<INSESRT_PIN_ID>", new PinFields().setAll());`
  
... more to come soon. (non-GET endpoints are currently in construction)

Feel free to make an issue if you find any bugs or have a suggestion!  
