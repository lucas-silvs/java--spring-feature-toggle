# java--spring-feature-toggle

projeto de estudo para criação do feature toggle FF4J com Java Spring, será utilizado o actuator para verificação da saude da aplicação é gerenciamento de credenciais separadas por ambiente

## Sumário

1. [Enviar imagem docker para o Docker Hub](#enviar-imagem-docker-para-o-docker-hub)
2. [Ajustes JVM Docker para execução no Kubernetes](#ajustes-jvm-docker-para-execução-no-kubernetes)
3. [Referencias](#referencias)

## Enviar imagem docker para o Docker Hub

Para enviar a imagem, primeiro devemos seguir as etapas abaixo:

### 1. Logar no Docker Hub com o Docker

Primeiro devemos criar uma conta no Docker Hub e logar com o Docker no terminal:

```
docker login --username=nome_de_usuario
```

Logado, deve criar o repositório que será utilizado posteriormente nos proximos passos.

### 2. Criar imagem localmente

Primeiro devemos criar a imagem docker local com o comando abaixo:

```
docker build -t nome_da_imagem_local .
```

### 3. Criar Tag com a imagem local

Com a imagem gerada, devemos gerar uma tag da imagem. Para isso precisamos pegar o IMAGE_ID com o comando abaixo que lista as imagens disponivels no seu dispositivo:

```
docker image ls
```

Pegando o IMAGE_ID, conseguimos gerar a tag:

```
docker tag IMAGE_ID nome_do_usuario/nome_do_repositorio:versao_da_imagem
```

### 4. Enviar imagem para o Docker Hub

Com a imagem tageada corretamente, só resta envia-lá para o Docker Hub e ser utilizada publicamente:

```
docker push nome_do_usuario/nome_do_repositorio
```

## Ajustes JVM Docker para execução no Kubernetes
Para execução no Kubernetes, é necessário ajustar a JVM para utilizar os recursos disponiveis no pod da melhor forma, evitando problemas futuros e trazendo redução de custo e recurso necessário para execução da aplicação Java. Esse ajuste é feito nos parámetros da JVM informados no Dockerfile, assim ao criar a imagem Docker, os parámetros da JVM são aplicados. Abaixo está descrito cada flag utilizada no Dockerfile para execução da aplicação:

### -XX:+UseParallelGC
Flag utilizada para informar a JVM para utilizar o Garbage Collector paralelo, evitando alta alocação de memória durante a execução da aplicação

### -XX:ActiveProcessorCount
Flag utilizada para definir o número de CPU's que a JVM utilizará para calcular o tamanho do pool de threads para realizar as operações.

### -XX:MaxRAMPercentage
Flag utilizada para definir o tamanho total da memória Heap, o valor recebido é calculado a porcentagem da memória total disponivel no ambiente onde a aplicação está hospedada. Ex: 

```bash
    java \
    -XX:MaxRAMPercentage=75 \ #Foi definido o tamanho da memória Heap para 75% da memória total
    -jar app.jar
```


## Referencias

- [Docker](https://www.docker.com/)
- [FF4j](https://ff4j.github.io/)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Live Zup Insight - Ajuste da performance Java em Kubernetes por Bruno Borges](https://www.youtube.com/watch?v=uGt1WKZK__0)
