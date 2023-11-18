# Rotas backend

Documento voltado a demonstrar a utilização do backend Gymapi da ByteLearn Technology localizado na <br> `url:` https://back-gymapi.onrender.com/

# Usuário

**Criar** usuário:
> Método: `POST`
> Url: https://back-gymapi.onrender.com/api/user

Inserir com _body_ no formato:
```json
 {
  "login": "string",
  "password": "string"
 }
```
<br>

**Listar todos** os usuários:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/user

Retorna lista de usuários em formato:
```json
 {
  "id": key,
  "login": "string",
 }
```
<br>

**Listar por ID**:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/user/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/user/1"_

Retorna:
```json
 {
  "id": key,
  "login": "string",
  "password": "string"
 }
```
<br>

**Alterar** usuário:
> Método: `PUT`
> Url: https://back-gymapi.onrender.com/api/user/id

Inserir com _body_ no formato:
```json
 {
  "login": "string",
  "password": "string"
 }
```
<br>

**Deletar** usuário:
> Método: `DELETE`
> Url: https://back-gymapi.onrender.com/api/user/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/user/1"_
<br>

## Status

**Criar** status:
> Método: `POST`
> Url: https://back-gymapi.onrender.com/api/status

Inserir com _body_ no formato:
```json
 {
  "description": "string"
 }
```
<br>

**Listar todos** os status:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/status

Retorna lista de status em formato:
```json
 {
  "id": key,
  "description": "string"
 }
```
<br>

**Listar por ID**:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/user/status/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/status/1"_

Retorna:
```json
 {
  "id": key,
  "description": "string"
 }
```
<br>

**Alterar** status:
> Método: `PUT`
> Url: https://back-gymapi.onrender.com/api/status/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/status/1"_

Inserir com _body_ no formato:
```json
 {
  "description": "string"
 }
```
<br>

**Deletar** status:
> Método: `DELETE`
> Url: https://back-gymapi.onrender.com/api/status/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/status/1"_
<br>

## Plano

**Criar** plano:
> Método: `POST`
> Url: https://back-gymapi.onrender.com/api/plan

Inserir com _body_ no formato:
```json
 {
  "description": "string",
  "price": "double"
 }
```
<br>

**Listar todos** os planos:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/plan

Retorna lista dos planos em formato:
```json
 {
  "id": key,
  "description": "string",
  "price": "double"
 }
```
<br>

**Listar por ID**:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/user/plan/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/plan/1"_

Retorna:
```json
 {
  "id": key,
  "description": "string",
  "price": "double"
 }
```
<br>

**Alterar** plano:
> Método: `PUT`
> Url: https://back-gymapi.onrender.com/api/plan/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/plan/1"_

Inserir com _body_ no formato:
```json
 {
  "description": "string",
  "price": "double"
 }
```
<br>

**Deletar** plano:
> Método: `DELETE`
> Url: https://back-gymapi.onrender.com/api/plan/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/plan/1"_
<br>

## Financeiro

**Criar** financeiro:
> Método: `POST`
> Url: https://back-gymapi.onrender.com/api/finance

Inserir com _body_ no formato:
```json
 {
  "payday": "date",
  "planMonths": "int"
 }
```
<br>

**Listar todos** os financeiros:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/finance

Retorna lista dos financeiros em formato:
```json
 {
  "id": key,
  "payday": "date",
  "planMonths": "int"
 }
```
<br>

**Listar por ID**:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/user/finance/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/finance/1"_

Retorna:
```json
 {
  "id": key,
  "payday": "date",
  "planMonths": "int"
 }
```
<br>

**Alterar** financeiro:
> Método: `PUT`
> Url: https://back-gymapi.onrender.com/api/finance/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/finance/1"_

Inserir com _body_ no formato:
```json
 {
  "payday": "date",
  "planMonths": "int"
 }
```
<br>

**Deletar** plano:
> Método: `DELETE`
> Url: https://back-gymapi.onrender.com/api/finance/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/finance/1"_
<br>

## Matrícula

**Criar** matrícula:
> Método: `POST`
> Url: https://back-gymapi.onrender.com/api/enrolled

Inserir com _body_ no formato:
```json
 {
  "name": "string",
  "phone": "string",
  "cpf": "string",
  "email": "string",
  "plan_id": "long",
  "status_id": "long",
  "user_id": "long",
  "finance_id": "long"
 }
```
<br>

**Listar todas** as matrículas:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/enrolled

Retorna lista das matrículas em formato:
```json
 {
  "id": key,
  "name": "string",
  "phone": "string",
  "cpf": "string",
  "email": "string",
  "plan": {
    "id": key,
    "description": "string",
    "price": "double"
  },
  "status": {
    "id": key,
    "description": "string"
  },
  "finance": {
    "id": key,
    "payday": "date",
    "planMonths": "int"
   }
 }
```
<br>

**Listar por ID**:
> Método: `GET`
> Url: https://back-gymapi.onrender.com/api/user/enrolled/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/enrolled/1"_

Retorna:
```json
 {
  "id": key,
  "name": "string",
  "phone": "string",
  "cpf": "string",
  "email": "string",
  "plan": {
    "id": key,
    "description": "string",
    "price": "double"
  },
  "status": {
    "id": key,
    "description": "string"
  },
  "finance": {
    "id": key,
    "payday": "date",
    "planMonths": "int"
   }
 }
```
<br>

**Alterar** matrícula:
> Método: `PUT`
> Url: https://back-gymapi.onrender.com/api/enrolled/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/enrolled/1"_

Inserir com _body_ no formato:
```json
 {
  "name": "string",
  "phone": "string",
  "cpf": "string",
  "email": "string",
  "plan_id": "long",
  "status_id": "long",
  "user_id": "long",
  "finance_id": "long"
 }
```
<br>

**Deletar** matrícula:
> Método: `DELETE`
> Url: https://back-gymapi.onrender.com/api/enrolled/id

Inserir o ID desejado na final da URL. 
_Ex.: "/api/enrolled/1"_
