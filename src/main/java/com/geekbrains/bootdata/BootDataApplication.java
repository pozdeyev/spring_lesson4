package com.geekbrains.bootdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDataApplication {
	// Домашнее задание:
	// 0. Нужно перейти на Spring Boot + Spring Data //ок
	// 1. Перейти на сущности 'Товар' //ок
	// 2. Добавить уровень service //Репозиторий - это уровень доступа к данным.
	// Контроллер - это веб уровень.
	// Сервис - это бизнес логика, которую мы получаем из веб уровня и уровня доступа данных.
	// 3. Сделать главную страницу с отображением всех товаров //ок
	// 4. Над таблицей сделать форму с возможностью запонения // ок


	public static void main(String[] args) {
		SpringApplication.run(BootDataApplication.class, args);
	}
}
