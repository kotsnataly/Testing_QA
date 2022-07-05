## Автотесты для cайта https://geekbrains.ru/
<i>Этот проект написан в рамках обучения на курсе Тестировщик ПО.</i>
#### Используемые библиотеки
org.seleniumhq.selenium <br>
org.junit.jupiter  <br>
org.hamcrest <br>
io.github.bonigarcia <br>
org.projectlombok
#### Краткое описание классов проекта.
BasePageObject  - базовый класс c методом protected WebElement findElement() наследуется классом 
ContentBasePage с методами public ContentBasePage closedPopUp(),  public LeftNavigation getLeftNavigation(), public HeaderBlock getHeader(). <br>

Подклассы CoursePage, HomePage, SearchPage, TestPage - инстанцируют надкласс ContentBasePage + принимают в конструктор объекты для инициализации своих полей,
 и загружают соответствующую ссылку.<br>

AuthorizationPage - модель загрузки страницы с авторизацией на ней через метод public HomePage authorization(String login, String password)<br>

ContentNavigationCourseBlock - класс имитирующий нажатие <i>( public CoursePage clickTab(Tab tab)) </i> определённых ссылок на странице переданной через driver Object.<br>
HeaderBlock - определяет ссылки на некоторые элементы по CSS селектору на странице, проверяет тестируемую страницу на соответствующее имя, а также нажимает кнопку найденную по ее тексту.<br>
LeftNavigation - определяет ссылки на некоторые элементы по CSS селектору на странице, в левом фрейме навигации по сайту, нажимает на заданные кнопки.<br>
SearchTabsBlock - инициализирует пор CSS селектору поля для "нажатия" заданных при тесте навигационных ссылок.<br>

 ###Author
 Kots Natalia, kotsnat@gmail.com