# 📨 Email Dispatcher Microservice

Este microsserviço é responsável pelo processamento e envio de e-mails de forma assíncrona, integrando-se ao ecossistema **AWS** para garantir escalabilidade e confiabilidade.

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 4.0.2**
* **Spring Cloud AWS**: Integração nativa com serviços Amazon.
* **Amazon SES (Simple Email Service)**: Serviço para disparo de e-mails.
* **Maven**: Gerenciamento de dependências.

## 🏗️ Arquitetura

O fluxo de funcionamento do microsserviço segue o padrão orientado a eventos:
1.  Um produtor envia uma mensagem.
2.  Este microsserviço (Consumer) escuta a fila.
3.  Ao receber a mensagem, valida os dados e utiliza o **SES** para realizar o envio.

4.  ## 📋 Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Maven](https://maven.apache.org/)
* Uma conta ativa na **AWS** com um e-mail verificado no SES.
* Configuração do **AWS CLI** ou variáveis de ambiente com suas credenciais (`Access Key` e `Secret Key`).

## ⚙️ Configuração

Clone o repositório:
```bash
git clone [https://github.com/cheloakachelo/email-service.git]([https://github.com/cheloakachelo/email-service.git)
cd email-dispatcher
```

## Variáveis de Ambiente

Configure as pripriedades no application.properties e defina as seguintes variáveis de ambiente
* AWS_ACCESS_KEY - Sua chave de acesso AWS
* AWS_SECRET_KEY - Sua chave secreta AWS
* AWS_REGION - Região da AWS (ex: us-east-1)


## Endpoints

* POST - /api/sendemail
* JSON: 
```
{
  "to": "destinatario@email.com",
  "subject": "Assunto do E-mail",
  "body": "Conteúdo da mensagem"
}
```


