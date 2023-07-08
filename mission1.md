## 1차 미션

<br>

**Basic Mission**

> 1. 사람을 나타내는 `Person` 인터페이스를 정의하고,
>2. 사람을 구현하는 추상 클래스 `AbstractPerson` 을 구현한 다음,
> 3. `AbstractPerson` 을 확장하는 `Student` 와 `Lecturer` 클래스를 각각 만들어보세요.
> 
> ### 세부 조건
>
> 1. `Person` 인터페이스는 사람을 나타내는 인터페이스로서, `void speak()` 함수를 가지고 있습니다. `Person` 인터페이스의 구현체는 `speak` 함수를 통해 자신의 정보를 출력합니다.
>2. `AbstractPerson` 추상 클래스는 사람이라면 공통적으로 가지는 정보, 기능 등을 구현하기 위한 클래스 입니다. 이름, 나이 정보 등을 가지고 있으며, `speak` 함수도 사용할 수 있습니다.
> 3. `Student` 와 `Lecturer` 는 `AbstractPerson` 을 extend 하며, `speak` 함수를 사용할 때 자신의 이름과 학생인지, 강사인지를 이야기해줍니다.

- `Person` - interface

  ```java
  public interface Person {
      void speak();
  }
  ```

- `AbstractPerson` - abstract class

  ```java
  public abstract class AbstractPerson implements Person {
    //abstract class를 상속받는 클래스들이 공통으로 가지는 속성 정의
      private String name;
      private int age;
  
      @Override
      public void speak() {
          System.out.println("이름: " + name);
      }
  
    //해당 클래스의 객체를 만들 때, name과 age가 주어졌을 때 해당 객체를 만들도록 constructor
      public AbstractPerson(String name, int age) {
          this.name = name;
          this.age = age;
      }
  }
  ```

- `Student`

  ```java
  public class Student extends AbstractPerson{
      @Override
      public void speak() {
        //자신이 상속받은 부모 객체의 함수 호출
          super.speak();
          System.out.println("학생입니다.");
      }
  
      public Student(String name, int age) {
        //자신이 상속받은 부모 객체의 constructor 사용
          super(name, age);
      }
  }
  ```

- `Lecturer` 

  ```java
  public class Lecturer extends AbstractPerson{
      @Override
      public void speak() {
          super.speak();
          System.out.println("강사입니다.");
      }
  
      public Lecturer(String name, int age) {
          super(name, age);
      }
  }
  ```

- `Main`

  ```java
  import java.util.ArrayList;
  import java.util.List;
  
  public class Main {
      public static void main(String[] args) {
          Student student = new Student("여다영", 23);
          Lecturer lecturer = new Lecturer("요다영", 30);
  
          //서로 다른 class의 객체가, 같은 인터페이스를 사용하므로, 같은 변수 리스트에 담을 수 있다.
          List<Person> people = new ArrayList<>();
          people.add(student);
          people.add(lecturer);
  
          for(Person person: people) {
              person.speak();
          }
      }
  }
  ```


<br>

**Challenge Mission**

> 1. Java 클래스 중 `ArrayList`, `LinkedList`, `Vector`, `HashSet` 를 찾아봅시다. 클래스들의 공통점을 살펴보세요.
> 2. 위에서 언급한 클래스들은 전부 여러 객체를 들고있을 수 있습니다. 이 클래스가 가지고 있는 `item` 을 형식을 맞춰 출력하는 함수를 작성해 봅시다.
>
> ### 세부 조건
>
> 1. 출력은 아래와 같은 형식으로 작성합니다.
>
>    ```
>    idx item
>    0   Item 1
>    1   Item 2
>    
>    ...
>    
>    n   Item n
>    ```
>
> 2. `Item n` 부분은 클래스의 Item (또는 Element)를 `String`으로 전환했을때의 값으로 나오면 됩니다.
>
> 3. Item이 없으면 `No Elements` 라고 출력합니다.

- ArrayList, LinkedList, Vector, HashSet

  - 넷의 공통점은 Collection 일종이다.
  - Collection은 Iterable의 일종이다.
  - ArrayList, LinkedList, Vector - List (순서가 있는 데이터의 집합, 중복을 허용)
  - HashSet - Set (순서가 없는 데이터의 집합, 중복을 허용하지 않음)

- `ChallengeMain`

  ```java
  package challenge;
  
  import Basic.Lecturer;
  import Basic.Person;
  import Basic.Student;
  
  import java.util.*;
  
  public class ChallengeMain {
      public static void main(String[] args) {
          Student student = new Student("여다영", 23);
          Lecturer lecturer = new Lecturer("요다영", 30);
  
          List<Person> people = new LinkedList<>();
          people.add(student);
          people.add(lecturer);
  
          printItems(people);
  
      }
  
      //class가 가지고 있는 item을 형식에 맞게 출력하는 함수
      public static <T> void printItems(Iterable<T> iterable) {
          Iterator<T> iterator = iterable.iterator();
          if(!iterator.hasNext()) {
              System.out.println("No Elements");
              return;
          }
  
          //StringBuilder: 부분 문자열들을 원하는 시점에서 합칠 수 있도록 해줌
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("idx\t\titem\n");
          for(int i = 0; iterator.hasNext(); i++) {
              T item = iterator.next();
              stringBuilder.append(
                      String.format("%d\t\t%s\n", i, item.toString()));
          }
  
          System.out.println(stringBuilder);
  
      }
  }
  ```

  

