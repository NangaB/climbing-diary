# climbing-diary
Aplikacja do prowadzenie zapisu przejść skalnych dla wspinaczy - "Dziennik Wspinaczkowy".

- użyte technologie: Java, Spring Boot, Spring Security, Hibernate, Thymeleaf, JavaScript, BootStrap

Działanie:
- start: /home
- wspinacz(climber) rejrestruje sie w aplikacji
- wspinacz (climber) zapisuje drogę (rout) którą przeszedł (wybór spośród dostępnych dróg w danym regionie)
- wycena drogi(rate) zostaje przyjęta zgodnie z wyceną drogi przyjętą w aplikacji
- wspinacz może wyświetlić zestawienie wszystkich dotychczas zrobionych dróg
- wspinacz może zaktualizować swoje zestawienie (przycisk USUN)
- wspinacz może dodać notatkę dotyczącego swojego przejścia, cruxy itp.
- wspinacz może wyświetlić ranking wszystkich wspinaczy 
- każdy nowo rejestrujący się użystkownik(user) przypisywany jest jako wspinacz (user=climber)
- istnieje administrator aplikacji (admin), który ma dodatkowe uprawnienia - admin może dodać lub usunąć drogę (rout) do zestawianie wszystkich dróg
- admin może wyświetlić wszystkich zarejstrowanych wspinaczy, może też usunąc wspinacza
