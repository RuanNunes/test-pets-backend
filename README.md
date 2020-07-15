# Api Rest para Test de backend PETS

# Desafio

````html
DESENVOLVEDOR BACKEND

História:
Eu cliente preciso de APIs REST para que possa integrar meus sistemas com outros parceiros.
Inicialmente, precisamos de APIs de integrações para:
 Cadastro
 Edição
 Exclusão
 Visualização
Das entidades do meu sistema:
 Cliente
 Pet
Requisitos técnicos:
- A persistência com o banco de dados deve ser utilizado o Hibernate;
- A arquitetura deve ser implementado em MPV ou MVVM;
- O framework utilizado deve ser o Spring-boot;
Requisitos de entrega:
- O código deve ser armazenado em um repositório GIT (como github)
- As chaves de acesso não devem ser armazenadas no repositório (.gitignore)
Informação adicional:
- O banco de dados deve ser modelado por você e hospedado em algum lugar para que possamos utilizar
as APIs;
Se você tiver problemas para a implementação das APIs, sinta-se à vontade para perguntar, sugerir e
pedir ajuda. No mundo real as pessoas de um time de desenvolvimento conversam e trocam
experiências. Pedir ajuda e perguntar não é eliminatório. Não existe limite de tempo para a entrega desse
projeto, contudo a velocidade de entrega é importante. Este projeto pode ser desenvolvido em poucas
horas. Quanto mais rápido você conseguir entregá-lo melhor. Sinta-se à vontade para incluir outras
funcionalidades e usar as bibliotecas que preferir.
````
# requirements


# install docker and docker-compose
- [install docker](https://hub.docker.com/?overlay=onboarding&step=download)  
- [install docker-compose](https://docs.docker.com/compose/install) 

# windows requirements
- [chocolatey](https://chocolatey.org/)
- [Java 14](https://chocolatey.org/packages/adoptopenjdk)
- [IDE](https://www.jetbrains.com/idea/download/#section=windows)
- [Lombook](https://projectlombok.org/setup/intellij)  

# mac requirements
- [brew](https://brew.sh/index_pt-br)
- [Java 14](https://mkyong.com/java/how-to-install-java-on-mac-osx/)
- [IDE](https://www.jetbrains.com/idea/download/#section=mac)
- [Lombook](https://projectlombok.org/setup/intellij)  

# RUN
-  {path project}/docker-compose up --build 

#Doc
- [open api](http://localhost:8080/swagger-ui.html)