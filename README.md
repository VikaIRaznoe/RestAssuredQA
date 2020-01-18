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
1)наш запрос
***
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/logirovanie_2.png)
***
2)Content
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/logorovanie_3.png)
***
3)ifValidationFails() - нужно логировать,если ошибка
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/logirovanie_4.png)
***
ExampleRestAssured4
=====================
В этом примере рассматривается использование запроса Get с использованием GetParams
###
Для этого будем использовать новый API: JSONPlaceHolder-здесь доступно четырке метода отправки запроса: GET,POST,PUT,DELETE.
***
1)Когда мы делаем GET-запрос мы получаем код 200 - метод GET
***
2)Передача параметра в GET-запросе будет реализовываться с помощью queryParam
***
3)Дополнительный Path мы убираем,у нас его нет в запросе.Только базовый URL и параметр.

Тест успешно прошел.Отображается сам запрос,отображается  comments, postID
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/GET.png)

