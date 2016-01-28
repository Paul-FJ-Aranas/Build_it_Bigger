Build it Bigger Joke Telling App

This app has multiple flavors and uses multiple libraries and Google Could Endpoints. The app consists
of four modules: a Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

* Free and paid flavors, and the build is set up to share code between them
* Factored reusable functionality into a Java library
* Factored reusable Android functionality into an Android library
* Configured a multi project build to compile the libraries and app
* Used the Gradle App Engine plugin to deploy a backend
* Configured an integration test suite that runs against the local App Engine development server

