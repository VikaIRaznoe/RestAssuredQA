Здесь находится описание проектов. Тестирование API с помощью RestAssured.
***
Для разграничения действий с ресурсами на уровне HTTP-методов и были придуманы следующие варианты:
###
	GET — получение ресурса
	POST — создание ресурса
	PUT — обновление ресурса
	DELETE — удаление ресурса
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
###
1)Когда мы делаем GET-запрос мы получаем код 200 - метод GET
###
2)Передача параметра в GET-запросе будет реализовываться с помощью queryParam
###
3)Дополнительный Path мы убираем,у нас его нет в запросе.Только базовый URL и параметр.

Тест успешно прошел.Отображается сам запрос,отображается  comments, postID
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/GET.png)
***
ExampleRestAssured5
=====================
В этом примере рассматривается отправка параметров запроса в теле запроса POST 
###
Метод postWithJson() - здесь отправка параметров в формате JSON.
###
Нам вернулось body и Content-Type,которые мы передали
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/POST_JSON_BODY.png)
***
Есть другой метод - postWithXML() .Если запустить его в таком виде
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/POST_XML_BODY.png)
***
,без изменений в классе TestConfig, то тест упадет,так как теперь у нас формат не JSON и будет ошибка
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/POST_XML_BODY_ERROR.png)
***
Поэтому вынесим настройки RequestSpecification из класса TestConfig.Здесь же в классе TestConfig создадим две спецификации, НО вне метода setUp()
***
ExampleRestAssured6
=====================
***Спецификации нужны,чтобы вынести общие признаки и общие проверки всех тестов в одно место.***
***
В этом примере рассматриватеся спецификация request для одного отдельного теста и для группы тестов.
Спецификации нужны,чтобы выносить общие признаки и общие проверки в одно место для всех тестов
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/TestConfig_RequestSpecification_Multipluy.png)
###
Вот сами тесты с BODY
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/POST_JSON-XML_BODY.png)
***
Итак,RequestSpecification нужен для определения спецификации Request как для одного отдельного теста,так и для группы тестов.
***
ExampleRestAssured7
=====================
В этом примере мы рассматриваем спецификацию Response для запроса GET
postWithJson() - пример использования такой спецификации
***
ExampleRestAssured8
=====================
В этом примере будем рассматривать "Проверка наличия определенного поля в ответе"
###
Для применения в ответах Assertions будем использовать Java-библиотеку Hamcrest
###
**Будем использовать API сайта Swapi**
###
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/BASE_PECIFICATION_SWAPI.png)
***
Для реализации работы с Assertions создадим в TestConfig спецификацию для SWAPI
Запустим тест
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_SWAPI_RUN2.png)
***
Увидим структуру - это Response,в котором шесть полей. Возьмем,например,поле "people"
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_SWAPI_STRUCTURE.png)
***
И можем выбрать поле,котрое хотим проверить. Модифицируем запрос.Мы хотим проверить поле “people”
Здесь мы ожидаем значение ключа "people" -  это URL: "https://swapi.co/api/people/",
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_SWAPI_RUN_MODIFY.png)
***
Запустим его и проверим,как тест отработает - Мы видим ответ с сервера - Response:
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/RUN_TEST_SWAPI_POSITIVE.png)
***
А вот так выглядит негативный тест,тоесть когда тест не отработал: Либо ошибка в коде,Либо в API
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/RUN_TEST_SWAPI_NEGATIVE.png)
***
Теперь напишем более сложную проверку
!Добавим Action - SWAPE_GET_PEOPLE в get
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/getSomeFieldInResponseWithIndexAssertion.png)
***
В ответе мы видим большой JSON
FIRST_TEST_MODIFY_RESPONSE
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_MODIFY_RESPONSE.png)
***
Давайте сделаем проверку поля count,что оно  имеет значение 87 и,например,name,что оно имеет значение Luke Skywalker и находится в results
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_COUNT.png)
***
Тест отработал корректно.
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_COUNT_RESULT.png)
***
Исправим значение ключа "people" с корректного на некорректный и получим вот такой результат работы теста.
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_COUNT_RESULT_NEGATIVE.png)
***
Тоесть либо нам дали некорректные данные,либо внесены и хранятся неверные данные.
Теперь сделаем "matcher" для поля name,котрое лежит в массиве results. Для этого нам нужны квадратные скобки.
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_NAME.png)
***
Тест отработал корректно. В результате мы видим большой JSON-объект
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/FIRST_TEST_NAME_RESULT.png)
***
Вот таким несложным способом можно организовать проверку полей и убедиться ,что запросы организованы верно.
***
ExampleRestAssured9
=====================
В этом примере будем рассматривать получение ответа и получение определенных параметров из ответа.
###
Для этого будем использольвать requestSpecificationforSwapiTests
Первый пример - Получение всего ответа с помощью функции Extract
Сам тест выглядит так:
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/TEST_JSON_STRING.png)
***
Результат выполнения теста:
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/TEST_JSON_STRING_RESULT2.png)
***
Далее реализуем пример получения всех кук(cookies) или одной куки
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/GET_ALL_COOKIES.png)
***
Далее,попробуем получить с помощью функции extract загаловки(headers)
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/GET_HEADERS.png)
***
Результат - Получение всех Headers
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/GET_ALL_HEADERS_RESULT.png)
***
Сам тест:
![screenshot of sample](https://github.com/VikaIRaznoe/RestAssuredQA/blob/master/Images/GET_HEADERS_TEST.png)
***
Вот таким несложным способом мы можем получать тело ответа,cookies,headers
