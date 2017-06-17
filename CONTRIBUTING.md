# Contributing

Found a bug? Have a suggestion? Feel free to send me PR or make an issue on the repo!

### Commits
I base my commit message format off [THIS POST](https://chris.beams.io/posts/git-commit/).

But here is an excerpt taken from that post highlighting the main points...

7 Rules of Commit Messages:

1. Separate subject from body with a blank line
2. Limit the subject line to 50 characters
3. Capitalize the subject line
4. Do not end the subject line with a period
5. Use the imperative mood in the subject line
6. Wrap the body at 72 characters
7. Use the body to explain what and why vs. how


### Tests

I currently have two types of tests: unit tests and system tests (STests).  The unit tests should _never_ fail.  The system tests are hitting live data, so they break often.  I plan to add some mocked out integration tests soon as a middle ground.

To run the system tests, put your Pinterest access token in the root of this repo in a file called `.access_token`.
