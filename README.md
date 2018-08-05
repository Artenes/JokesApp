# Android puns app

Android app that displays puns. Very useful indeed.

# Quick start

Clone the repository

````
git clone https://github.com/Artenes/JokesApp
````

And import the project in Android Studio.

Before running the app or the tests, run in the terminal

````
gradlew appengineRun
````

for this you must have installed the Google Cloud Endpoint Server in your machine.

# Features

- Uses Local Google Cloud Endpoint Server to retrieve the puns
- Has a Java library module to generate the puns (which is used by the GCE module)
- Has s Android library module that contains an activity to display a pun
- Has paid and free versions. The free versions display adds and the paid version don't. Each one had its own icon.
- Puns everywhere. In the code and in the commit messages.

# Credits

Puns were taken from [A giant list of puns post in reddit](https://www.reddit.com/r/dadjokes/comments/76jfme/a_giant_list_of_puns/)

# License

MIT License