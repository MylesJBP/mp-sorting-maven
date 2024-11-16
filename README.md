# mp-sorting-maven

An exploration of sorting in Java.

Authors

* Myles Bohrer-Purnell
* Samuel A. Rebelsky (starter code)

Acknowledgements
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/readings/quicksort.html
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/eboards/eboard20-2.html
* _Forthcoming_.

This code may be found at <https://github.com/MylesJBP/mp-sorting-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.

Description of custom sorting algorithm
The custom sorting algorithm that I decided to *implement is Timesort. It operates by merging the concepts of mergesort and insertsort to sort an array of elements. It starts by breaking the original array into "runs", which size is determined by some constant "RUN", which in this algorithm is set to size 32, then uses insertion sort to sort each "run", merging them together using mergesort afterwards. That being said, the "merge" function is an implementation of mergesort and the "insertionsort" method is an implementaiton of insertionsort, similar to the one I made. That being said, it is an 0(nlogn) algorithm given its usage of the two algorithms. 

Notes on using Copilot (or other AI)
I used ChatGPT to help come up with the idea and code the Timesort algorithm. It was a fairly easy proccess. I first asked it "what is a more efficient sorting algorithm than nlogn (bad wording...)" at which point it gave me a set of algorithms such as bucket sort and pidgeonhole sort. I then asked it to wirte a java algorithm of pidgeonhole sort. However, I quickly realized that the written algorithm did not use a comparator, which led me to ask: "what is a more efficient sorting algorithm than nlogn that uses a comparator", leading me to find Timesort. I then asked it to write a Timesort algorithm in java, then subsequently ask for it to use generics in the code given that it initially wrote it under the assumption that the elements in the array were integers. Given this code, I had to fix the indentation and general styling of the code to fit class standards. I also did not include a testing method that was added by the AI in my code. Otherwise, I did not have to change anything. Overall, it was a very easy process. It was my first time using ChatGPT for anything, making it a very informative process on its interworkings.

_This section is optional_
