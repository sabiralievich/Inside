### 1. Как скачать образ с репозитория Dockerhub:<br/>
а)  Залогиниться в Docker:<br/>
      docker login -u ‘username’<br/><br/>
б)  скачать образ на локальную машину:<br/>
docker pull sabiralievich/inside:backend<br/><br/>
![image](https://user-images.githubusercontent.com/84394882/143308680-4bc7f91f-6172-4f66-8b41-8ef13b892cdb.png)

  
### 2. Как запустить контейнер на локальной машине:<br/>
  а)  docker image ls (выведет список всех имеющихся образов на локальной машине. найти среди них образ **sabiralievich/inside   backend   _‘IMAGE ID’_**<br/>
  б)  docker run -p 8080:8080 ‘IMAGE ID’<br/>
  
  ![image](https://user-images.githubusercontent.com/84394882/143307700-d27753ed-b5a4-40da-b304-96c908f7fe6b.png)


### 3. В базу данных занесены следующие данные пользователей (для тестирования)<br/>
| name: **bulat** password: **password**<br/>
| name: **test1** password: **test1**<br/>

### 4. Для запросов в первый endpoint (авторизация) используется url: <br/>
http://localhost:8080/login<br/>

### 5. Для запросов во второй endpoint (работа с данными) используется url:<br/>
http://localhost:8080/postdata<br/>

### 6. Валидация входных данных не выполняется.<br/>

### Пример запроса на авторизацию:<br/>
![image](https://user-images.githubusercontent.com/84394882/143309097-995b7693-16e4-4d7d-9c73-be0f05b79dc7.png)

### Пример запроса на операцию с данными <br/>
(в заголовке указан токен, полученный на предыдущем шаге, в body - строка "message12"):<br/>
![image](https://user-images.githubusercontent.com/84394882/143309160-2e31b990-4f33-47f3-ba47-06c3c79ed3ce.png)

### Пример запроса с сообщением "history 10" <br/>
(контракт задачи – возврат 10 последних сообщений)<br/>
![image](https://user-images.githubusercontent.com/84394882/143309211-ce55dba7-e4db-4b5e-9f14-959bf96c8a1a.png)

### Пример запроса с токеном, отличным от того, что был получен на этапе авторизации<br/>
![image](https://user-images.githubusercontent.com/84394882/143309238-d660a64a-c190-43b2-a53f-53b7013a3670.png)










