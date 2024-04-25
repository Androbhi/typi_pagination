# Json placeholder typi code API implementation woth pagimation support

How to run the project?

Download and Install the latest android studio from https://developer.android.com/studio
Clone the project and open it from the android studio
Once the code is compiled successfully, run the code to test.


**What this project is about?**
This project is using Json placeholder typi code API to get the data and paginate. 
Using LRU caching for store and retrieving object. Addded 500ms delay to mack the heavy opertion on each object. 
The total process time of all the paginated item will not be addition of all time, as all the operations are running asynchrounously.

**What's the project structure?**
This project is built on MVVM architecture.

**Tech stacks used**
Kotlin
Compose
MVVM
Dagger Hilt
Retrofit
LRU memory caching
