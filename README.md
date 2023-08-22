# weatherStatus

The Application helps in getting weatherstatus of particular city requested.

Used **MVVM** pattern, following  Seperation of Concerns principle by segregating UI and business logic .

Contains 3 main folders:

View : Contain Mainactivity dealing with getting city name entered by user and pass to viewmodel. Subscribes to viewmodel Data.

ViewModel : acts as mediator , containg business logic . shares updates to View through Observables(**Livedata**).

Model: contains code relating API call using retrofit.

**RecycerView** is used to show requested city weather .

For Network Call used **Retrofit** .

For asynchronous Programming used **Coroutines** and **flows**.
