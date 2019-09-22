## Introduction

Android app that demonstrates the process of taking a free app with banner ads (which always
display) and updating the code to use interstitial ads (which only display at certain times) and
provide a paid app flavor which does not show any ads.

## Overview

The resulting app contains four modules:
 * Java library - for supplying jokes
 * Android library - for displaying jokes in a consistent way
 * A Google Cloud Endpoint (GCE) - for retrieving jokes through an API
 * An initial Android Activity - for launching the joke display Activity (and coordinating ads)

## Getting started / Usage

The files for this project were built using Android Studio, so you will likely have the easiest
time duplicating the original behavior using the same.

1. First, clone this repository
   * `git clone https://github.com/munifrog/BuildItBigger.git`
1. Open this directory using Android Studio
1. Start the Google Cloud Endpoint using Gradle (instructions here using the side bar options)
   * _:backend_
   * _app engine standard environment_
   * _appengineStart_
1. Launch the app on an emulator
   * The _RetrieveJoke.java_ assumes the emulator IP address of `10.0.2.2`
1. When done, stop the Google Cloud Endpoint using Gradle
   * _:backend_
   * _app engine standard environment_
   * _appengineStop_

## License

This project started as a task within the [Udacity Android Developer Nanodegree Course](https://www.udacity.com/course/android-developer-nanodegree-by-google--nd801) 
and Udacity (or Google) owns the rights for the project idea.

While I personally prefer indirect sources for finding solutions to puzzles, you may learn from
what I have done, if that helps. Just be careful to avoid plagiarism if you are also taking this
course and looking for answers.

If, on the other hand, you want to build on what I have done, that is also welcome.