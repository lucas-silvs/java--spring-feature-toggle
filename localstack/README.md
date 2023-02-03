# DynamoDB Locastack + GUI

Nesse docker-compose está disponibilizado o Localstack para executar o DynamoDB local
e uma interface GUI para gerenciar o DynamoDB de forma mais amigavel.

Abaixo os comandos para executar o Dynamo e ativar o TTL:

- Subir LocalStack + GUI Docker:
```console
 docker compose up
```
- Criar tabela DynamoDB AWS CLI:

```console
aws dynamodb create-table \
    --table-name <Nome_Tabela> \
    --attribute-definitions \
        AttributeName=<Nome_Campo>,AttributeType=<Tipo_Campo> \
    --key-schema \
        AttributeName=<Nome_Campo_Chave>,KeyType=<Tipo_Campo_chave \
    --provisioned-throughput \
        ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --table-class STANDARD
```

- Ativar TTL DynamoDB:

```console
aws dynamodb update-time-to-live --table-name <Nome_tabela> --time-to-live-specification "Enabled=true, AttributeName=<nome_campo_ttl>" --endpoint-url=http://127.0.0.1:4566
```
- Verificar status TTL DynamoDB:

```console
aws dynamodb describe-time-to-live --table-name <Nome_tabela> --endpoint-url=http://127.0.0.1:4566
```

- Adicionar item na tabela via CLI DynamoDB:

```console
aws dynamodb put-item --table-name "<Nome_tabela>" --item '{"<Nome_Campo>": {"<Tipo_campo>": "<valor_campo>"}, "<nome_campo_ttl>": {"N": "<data_expiracao_epoch_time_TTL>"}}' --endpoint-url=http://127.0.0.1:4566
```

- Listar itens de uma tabela DynamoDB:

```console
aws dynamodb scan --table-name "<Nome_tabela>" --endpoint-url=http://127.0.0.1:4566

```


