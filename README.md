# java--spring-feature-toggle

projeto de estudo para criação do feature toggle FF4J com Java Spring, será utilizado o actuator para verificação da saude da aplicação é gerenciamento de credenciais separadas por ambiente

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
