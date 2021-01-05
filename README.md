# java-extensions

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.javalaboratories/java-extensions/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.javalaboratories/java-extensions)

This is a library of utilities to encourage functional programming in Java, particularly for Java-8 developers but not
 exclusively. With inspiration from functional programming articles and languages like Haskell and Scala, new monads and
 enhancements to existing ones have been introduced. This page provides a brief description of the objects in the library,
  but it is encouraged to review the javadoc documentation for additional information and examples. 

### Maven Central Repository
The library is now available for download from Maven Central Repository. In the POM file add the maven dependency 
configuration below:
```
        <dependency>
          <groupId>org.javalaboratories</groupId>
          <artifactId>java-extensions</artifactId>
          <version>1.0.3-RELEASE</version>
        </dependency>
```
### Either
`Either` class is a container, similar to the `Maybe` and `Optional` classes, that represents one of two possible values
(a disjoint union). Application and/or sub-routines often have one of two possible outcomes, a successful completion or
a failure, and so it is common to encapsulate these outcomes within an `Either` class. Convention dictates there is a 
`Left` and `Right` sides; "left" considered to be the "unhappy" outcome, and the "right" as the "happy" outcome or path.
So rather than a method throwing an exception, it can return an `Either` implementation that could be either a `Left` 
or a `Right` object, and thus allowing the client to perform various operations and decide on the best course of action.
In the example, the `parser.readFromFile` method returns an `Either` object, but notice the concise `client` code and 
readability and how it neatly manages both "unhappy" and "happy" outcomes.
```
        // Client code using parser object.
        String string = parser.readFromFile(file)
                .flatMap(parser::parse)
                .map(jsonObject::marshal)
                .fold(Exception::getMessage,s -> s);
        ...
        ...
        // Parser class (partial implementation)
        public class Parser {
            public Either<Exception,String> readFromFile(File file) {
            try {
                ...
                return Either.right(fileContent)
            } catch (FileNotFoundException e) {
                return Either.left(e);
            }
        }
```
Provided implementations of the `Either` are right-biased, which means operations like `map`,`flatMap` and others have 
no effect on the `Left` implementation, such operations return the "left" value unchanged.

### EventBroadcaster
`EventBroadcaster` class has the ability to notify its `subscribera` of events they are interested in. It is a partial
implementation of the `Observer Design Pattern`. To complete the design pattern, implement the `EventSubscriber` 
interface and subclass `AbstractEvent` class for defining custom events or use the out-of-the-box `Event` objects in the
 `CommonEvents` class. It is recommended to encapsulate the `EventBroadcaster` object within a class considered to be 
 observable. 
```
        public class DownloadEvent extends AbstractEvent {
            public static final DOWNLOAD_EVENT = new DownloadEvent();
            public DownloadEvent() { super(); }
        }

        public class News implements EventSource {
            private EventPublisher<String> publisher;
            
            public News() {
                publisher = new EventBroadcaster<>(this);
            }

            public void addListener(EventSubscriber subscriber, Event... captureEvents) {
                publisher.subscribe(subscriber,captureEvents);
            }

            public void download() {
                ...
                ...
                publisher.publish(DOWNLOAD_EVENT,"Complete");
                ...             
            }
        }
        ...
        ...
        public class NewsListener implements EventSubscriber<String> {
            public notify(Event event, String value) {
                logger.info ("Received download event: {}",value);
            }
        }
        ...
        ...
        public class NewsPublisherExample {
            public static void main(String args[]) {
                News news = new News();
                NewsListener listener1 = new NewsListener();
                NewsListener<String> listener2 = (event,state) -> logger.info("Received download event: {}",state);

                news.addListener(listener1,DOWNLOAD_EVENT);
                news.addListener(listener2,DOWNLOAD_EVENT);

                news.download();
            }
        }
```
The `EventBroadcaster` class is thread-safe, but for additional information on this and associated classes, please refer
 to the javadoc details.

### Floadgate, Torrent

### Handlers
Handlers class provides a broad set of wrapper methods to handle checked exceptions within lambda expressions. Lambdas 
are generally short and concise, but checked exceptions can sometimes cause the lambda expression to look unwieldy. 
This class has many useful methods that compliment common functional interfaces. Each method wraps the function object 
into a function that transforms the checked exception to a `RuntimeException` object.

For example, here is an example of a method performing file input/output:
```
        public void writeFile(String file) throws IOException {
            ...
        }
 
        // Common technique is to handle the checked exception within the lambda expression :-
        
        Consumer<String> consumer = s -> {
            try {
                writeFile(s)
            } catch (IOException e) {
                ...
            }
        }
 
        // But using the Handlers class, the expression becomes :-
 
        Consumer<String> consumer = Handlers.consumer(s -> writeFile(s));
```
### Holder
`Holder` class is a simple container, which is generally useful for mutating values within a lambda expression -- the
holder object is an effectively final object allowing its contents to be mutated.
```
        Holder<Integer> base = Holders.writableHolder(220);
        
        List<Long> values = Arrays.asList(10,20,30)       
        
        values.stream()
            .forEach(n -> base.set(base.get() + n));
        
        System.out.println(base.get());
``` 
`Holders` utility class can create several implementations of `Holder` objects, including a thread-safe and a read-only
implementations. 
### Maybe
The library introduces `Maybe` class, which is a "drop-in" replacement for `Optional`. It has features that are only 
available in the `Optional` class in Java-11/13 but it also includes new features. For example, the following is possible:
```
    Maybe<Person> person = people.findById(10983);
    
    person.forEach(System.out::println);    
    
    ...
    
    person.ifPresentOrElse(System.out::println, () -> System.out.println("Person not found"))
    
    ...
    
    List<Person> list = person.toList();
```
Similarly, there are `NullableInt`,`NullableLong` and `NullableDouble` for `int`,`long` and `double` types respectively.
### Promise
The `Promise` object is a lightweight abstraction of the `CompletableFuture` object, the inspiration of which came from 
the JavaScript's Promise object behaviour. This implementation provides an easily understood API for asynchronous 
submission of tasks encapsulated as `Action` objects with comprehensive exception management. The example below 
demonstrates the ability to perform I/O and transformation of data asynchronously, which is then output to the console 
in the main thread:
```
    Promise<String> promise = Promises
       .newPromise(PrimaryAction.of(() -> doLongRunningTask("Reading integer value from database")))
       .then(TransmuteAction.of(value -> "Value read from the database: "+value));
 
       String result = promise.getResult()
            .IfPresent(result -> System.out::println(result)); 
``` 
There's a lot more to discover about `Promise` objects -- review the source's Javadoc for details. 
### Reducers
`Reducers` are collectors but with a difference. Most of them return `Stream` objects, and so it is possible to continue
functional programming within a stream context. Many of the `Collectors` methods have been implemented in `Reducers` class, 
again as a possible "drop-in" replacement for `Collectors` class. `Reducers` also support a comprehensive set of statistical
calculations such as mean, median, mode, standard deviation and much more. Expect to see an expansion of statistical 
functions in this area over the coming days.  

```
        List<String> strings = Arrays.asList("9","7","5","76","2","40","101");

        strings.stream()
                .map(Integer::parseInt)
                .peek(n -> System.out.print(n+" "))
                .collect(Reducers.summingInt(Integer::valueOf))
                .findFirst()
                .ifPresent(n -> System.out.println("= "+n)); 

                
        Outputs: 9 7 5 76 2 40 101 = 240         
```
### StopWatch
StopWatch provides a convenient means for timings of methods. There are no explicit methods in the class to start and 
stop the timings, because these are naturally determined through the process of invoking the function that is currently
being timed. In other words, executing the function will start the `StopWatch` and when the function comes to a 
natural/unnatural conclusion, the `StopWatch` is automatically stopped. Number of instances of `StopWatch` is unlimited,
and so useful statistics are available of all the timed functions via the class' methods or via the `StopWatch.print()` 
method which prints pre-formatted data into a string. Every `StopWatch` instance has a unique name, which is useful when 
reviewing the statistics. Use the `StopWatch.time(Runnable)` or the `StopWatch.time(Consumer)` method to start the timings,
the latter is particularly useful for `Collection.forEach(Consumer)` and/or streams.
```
         StopWatch stopWatch = StopWatch.watch("methodOne");
         StopWatch stopWatch2 = StopWatch.watch("methodTwo");
 
         // This is a common usecase of the StopWatch
         stopWatch.time(() -> doSomethingMethod(1000));
 
         // Here is aother sceanario where the for each loop is measured.
         List<Integer> numbers = Arrays.asList(1,2,3,4);
    
         numbers.forEach(stopWatch2.time(n -> doSomethingMethod2(n)));
    
         // This command will print statistics for all StopWatch instances
         System.out.println(StopWatch.print());
    
         // Output :-
    
         Method                       Time (s)    %       Cycles Cycle Time(s)
         --------------------------------------------------------------------
         methodOne                00:00:00.504   8%            1 00:00:00.504
         methodTwo                00:00:01.451  92%            4 00:00:00.363

```
### Tuples
A tuple can be considered as a container of ordered elements of different types. Each element may not relate to each
other but collectively they have meaning. They are particularly useful for methods in that they enable them to 
return multiple values as a single tuple object, as well as passing several values to a method in a single argument(s).
The tuple has many abilities including `join`, `truncateAt`, `mapAt`, `match`,`toList`,`toMap` and much more. Another 
particularly useful feature of tuples is that they are immutable, making them thread-safe. Moreover, they all implement 
the `Iterable`, `Serializable`, and `Comparable` interfaces, allowing their contents can be traversed easily, sortable in 
collections and persistable. Here are some examples of usage:
```
        Tuple3<String,Integer,Integer> tupleEarth = of("Earth",7926,92955807);
        // tupleEarth: ("Earth",7926,92955807), diameter in miles, distance from Sun in miles

        tupleEarth.value2();
        // tupleEarth.value2(): 7926

        Tuple3<String,Integer,Integer> kmEarth = tupleEarth.mapAt2(t -> Math.round((t / (float) 0.621371)));
        // tupleEarth: ("Earth",12756,92955807), diameter in km

        Tuple5<String,Integer,Integer,String,Integer> tupleEarthMoon = tupleEarth.join(of("Moon",2159));
        // earthMoon: ("Earth",7926,92955807,"Moon",2159), joined moon, diameter of 2159

        Tuple2<Tuple3<String,Integer,Integer>,Tuple2<String,Integer>> tuplePlanetaryBodies = tupleEarthMoon.spliceAt4();
        // planetaryBodies: (("Earth",7926,92955807),("Moon",2159))

        tupleEarth = tuplePlanetaryBodies.value1();
        // tupleEarth: ("Earth",7926,92955807)

        Tuple3<String,Integer,Integer> tupleMoon = tuplePlanetaryBodies.value2().join(92900000);
        // tupleMoon: ("Moon",2159,92900000), added moon distance from Sun

        Tuple7<String,String,String,String,String,String,String> tupleCoordinates = tupleEarth
                .truncateAt2()
                .addAt1("Milky Way")
                .join(of("Europe","England","Blackfriars","London","EC2 1QW"));
        // tupleCoordinates: ("Milky Way","Earth","Europe","England","Blackfriars","London","EC2 1QW")

        List<?> list = tupleCoordinates.toList();
        // list: ["Milky Way","Earth","Europe","England","Blackfriars","London","EC2 1QW"]

        tupleEarth.match(allOf("^Earth$"),(a,b,c) -> logger.info("Earth's distance from Sun {}",c));
        // Outputs: "Earth's distance from Sun 92955807"
```

## Feedback
Development is ongoing. I have many ideas in the pipeline, and of course will consider your ideas and recommendations. 
If you encounter any bugs, please raise an issue(s).