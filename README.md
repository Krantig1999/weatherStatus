# weatherStatus

The Application helps in getting weatherstatus of particular city requested.

Used **MVVM** pattern, following  Seperation of Concerns principle by segregating UI and business logic .

Contains 3 main folders:

View : Contain Mainactivity dealing with getting city name entered by user and pass to viewmodel. Subscribes to viewmodel Data.

ViewModel : acts as mediator , containg business logic . shares updates to View through Observables(**Livedata**).

Model: contains code relating API call using retrofit.

**RecycerView** is used to show requested city weather .

**RecyclerView** :It is a powerful UI widget provided by the Android SDK that's used to display large sets of data in a scrollable list or grid format where items can be recycled, improving performance.


For Network Call used **Retrofit** .

**Retrofit**: It is a popular open-source library for Android that simplifies the process of making network requests to a REST API. Retrofit streamlines the process of sending and receiving data over the network by abstracting away many of the complexities involved.


For asynchronous Programming used **Coroutines** and **flows**.

**Coroutines** are a lightweight concurrency framework for Kotlin that allow you to write asynchronous code in a sequential and structured manner.

**Flows** are a reactive stream-based library built on top of coroutines. They allow you to handle sequences of values emitted over time in a reactive programming style, similar to RxJava.



