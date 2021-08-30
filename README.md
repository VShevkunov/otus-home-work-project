По-умолчанию, запуск локально, chrome последней версии, 4 потока:
mvn clean test 

Опциональные парметры запуска, выбор браузера, его версия, адрес хаба для запуска в docker:

mvn -Dselenide.browser=firefox -Dselenide.browserVersion=90.0 -Dselenide.remote=http://localhost:4444/wd/hub clean test


Проект
Проектная работа от EPAM

Цель:

Задача для проекта: 
Необходимо построить фреймворк для автоматизации Е2Е тестирования сайта с обязательным тестовым покрытием. 
Что будем тестировать: Приложение https://events.epam.com/ предоставляет информацию о мероприятиях, которые проводит EPAM. 
Сайт позволяет посмотреть предстоящие/прошедшие мероприятия в разных городах, информацию о спикерах, докладах, календарь мероприятий. 

Требования к фреймворку:
1.	Java
2.	Maven/Gradle
3.	TestNG/Junit
4.	Allure
5.	Настроено логирование
6.	Реализована возможность кроссбаузерного тестирования и удаленного запуска тестов
7.	Реализована возможность параллельного запуска тестов
8.	Код проекта хранится в Git (важна частота и содержание коммитов)
9.	Для работы со страницами используется паттерн Page Object
10.	Код оформлен согласно Java Code Conventions, коментарии в стиле Javadoc приветствуются

*Дополнительно: Настроена интеграция с CI и запуск тестов по расписанию 
Разрешается подключение других библиотек, использование BDD подхода, Spring, Lombok


Обязательное тестовое покрытие:

1)Просмотр предстоящих мероприятий:

1. Пользователь переходит на вкладку events
2. На странице отображаются карточки предстоящих мероприятий. Количество карточек равно счетчику на кнопке Upcoming Events


2)Просмотр карточек мероприятий:

1. Пользователь переходит на вкладку events
2. Пользователь нажимает на Past Events
3. На странице отображаются карточки предстоящих мероприятий.
4. В карточке указана информация о мероприятии:
	язык
	название мероприятия
	дата мероприятия
	информация о регистрации
	список спикеров // Минимально достаточное - проверить одну карточку. В идеале все что отображаются.


3)Валидация дат предстоящих мероприятий:

1. Пользователь переходит на вкладку events
2. Пользователь нажимает на Upcoming Events
3. На странице отображаются карточки предстоящих мероприятий.
4. Даты проведения мероприятий больше или равны текущей дате (или текущая дата находится в диапазоне дат проведения)

4)Просмотр прошедших мероприятий в Канаде:

1. Пользователь переходит на вкладку events
2. Пользователь нажимает на Past Events
3. Пользователь нажимает на Location в блоке фильтров и выбирает Canada в выпадающем списке
4. На странице отображаются карточки прошедших мероприятий. Количество карточек равно счетчику на кнопке Past Events. Даты проведенных мероприятий меньше текущей даты.


5)Фильтрация докладов по категориям:
1. Пользователь переходит на вкладку Talks Library
2. Пользователь нажимает на More Filters
3. Пользователь выбирает: Category – Testing, Location – Belarus, Language – English, На вкладке фильтров
4. На странице отображаются карточки соответствующие правилам выбранных фильтров

6)Поиск докладов по ключевому слову:
1. Пользователь переходит на вкладку VIDEO - Talks Library
2. Пользователь вводит ключевое слово QA в поле поиска
3. На странице отображаются доклады, содержащие в названии ключевое слово поиска

*Дополнительно: Тестовое покрытие может быть расширено для функциональности фильтрации

