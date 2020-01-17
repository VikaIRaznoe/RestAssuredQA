Здесь находится описание проектов. Тестирование API с помощью RestAssured.
***
ExampleRestAssured 
=====================
Первый тест URL-запроса.В качестве подопытного используется сайт https://swapi.co
###
ExampleRestAssured2 
=====================
В этом примере мы уже можем управлять тестовыми данными и тестовыми запросами.
###
1)Используя класс Constans и класс TestConfig мы управляем тестовыми данными.
2)В классе FirstTest,в методе myFirstTest() цифра 1 в двойных кавычках это параметр,который говорит,что мы хотим получить данные по человеку с номером - 1.
3)Параметр /people берется из класса Constans, раздел Actions.
4)В TestConfig устанавливается константы,например server name - server  - это доманное имя(SWAPI_URL).Значения констант берутся из класса Constans.
5)Метод setUp из класса TestConfig будет выполняться перед каждым тестом.
6)класс FirstTest расширяет возможности класса TestConfig.

ExampleRestAssured3
=====================
В этом примере рассматривается логирование(описание шагов теста)
###
1)В классе FirstTest добавлено логирование - log()
!Можем залогировать все - all()
!Можем залогировать Url - uri()
!Можем залогировать параметры,которые передаем - params()
!Метод ifValidationFails() - если запрос падает,то логируем данные,которые передали на сервер

Пример использования all()
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/logirovanie.png)
2)Логирование ответа - метод mySecondTest()
###
У нас отображается: 
###
1)наш запрос
###
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/logirovanie_2.png)
2)Content
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/logorovanie_3.png)
