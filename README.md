# Лабораторная работа 6

## Задание

Разработать 3 Pojo класса. Сделать из них таблицы с помощью Hibernate. Реализовать CRUD операции для каждого объекта.

## Разработка

### Структура проекта
```
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└──src
   └── main
      ├── docker
      │   ├── Dockerfile.jvm
      │   ├── Dockerfile.legacy-jar
      │   ├── Dockerfile.native
      │   └── Dockerfile.native-distroless
      ├── java
      │   └── ru
      │       └── ashcheulov
      │           ├── pojo
      │           │   ├── BasePojo.java
      │           │   ├── Book.java
      │           │   ├── Student.java
      │           │   └── Teacher.java
      │           ├── producers
      │           │   ├── BookProducer.java
      │           │   └── TeacherProducer.java
      │           ├── qualifiers
      │           │   ├── QBook.java
      │           │   └── QTeacher.java
      │           ├── resource
      │           │   ├── BookResource.java
      │           │   ├── StudentResource.java
      │           │   └── TeacherResource.java
      │           └── service
      │               ├── CRUDService.java
      │               └── StudentService.java
      └── resources
          ├── application.properties
          └── META-INF
              └── resources
                  └── index.html

```

## Результат разработки

В результате разработки были созданы Pojo классы 
[``Book``](/src/main/java/ru/ashcheulov/pojo/Book.java) 
[``Student``](/src/main/java/ru/ashcheulov/pojo/Student.java) 
[``Teacher``](/src/main/java/ru/ashcheulov/pojo/Teacher.java)

Resource 
[``BookResource``](/src/main/java/ru/ashcheulov/resource/BookResource.java) 
[``StudentResource``](/src/main/java/ru/ashcheulov/resource/StudentResource.java) 
[``TeacherResource``](/src/main/java/ru/ashcheulov/resource/TeacherResource.java) 



А так же generic интерфейс 
[``CRUDService``](/src/main/java/ru/ashcheulov/service/CRUDService.java)
, который описывает CRUD операции для `<T extends BasePojo>`.  

Так как в 
[``BookResource``](/src/main/java/ru/ashcheulov/resource/BookResource.java)
[``TeacherResource``](/src/main/java/ru/ashcheulov/resource/TeacherResource.java)
внедряются зависимости `CRUDService<Teacher>` и `CRUDService<Book>`, то были разработаны producers
[``BookProducer``](/src/main/java/ru/ashcheulov/producers/BookProducer.java)
[``TeacherProducer``](/src/main/java/ru/ashcheulov/producers/TeacherProducer.java), 
в которых сделаны реализации интерфейса [``CRUDService``](/src/main/java/ru/ashcheulov/service/CRUDService.java)


## Команда для запуска докер контейнера БД для лабы

```shell
docker run --name psql-lab6 -e POSTGRES_PASSWORD=123 -e POSTGRES_USER=root -p 5432:5432 -d postgres
```

https://hub.docker.com/_/postgres

## Работа выполнена

[Ащеулов Михаил ПИМ-21](https://github.com/VergiliusAW)

[Кравцов Тимофей ПИМ-21](https://vk.com/timofeykrav)