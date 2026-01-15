# 📞 RamaisCaixa

Sistema interno para **consulta e gerenciamento de ramais telefônicos** da empresa, desenvolvido com **Java 17, Spring Boot e Thymeleaf**, priorizando simplicidade, usabilidade e baixo custo de manutenção.

A aplicação permite que qualquer usuário visualize os ramais sem autenticação, enquanto **ações administrativas** (criar, editar e excluir) são protegidas por login.

---

## ✨ Funcionalidades

### 📋 Consulta pública
- Listagem completa de ramais
- Ordenação automática por **setor** e **nome**
- Visualização sem necessidade de login

### 🔍 Busca inteligente
- Busca por **setor** ou **nome**
- Busca por **ramal exato**
- Busca parcial e case-insensitive

### 🔐 Administração
- Autenticação simples via Spring Security
- Apenas usuários ADMIN podem:
    - cadastrar novos ramais
    - editar ramais existentes
    - excluir ramais
- Interface adapta-se automaticamente conforme o perfil do usuário

### 🎨 Interface
- Thymeleaf + Bootstrap
- Layout responsivo
- Fragmentos reutilizáveis
- UX simples para uso diário interno

---

## 🛠️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot**
    - Spring MVC
    - Spring Data JPA
    - Spring Security
- **Thymeleaf**
- **Bootstrap 5**
- **PostgreSQL**
- **Hibernate**
- **Maven**

---

## 🧱 Arquitetura

O projeto segue uma arquitetura **MVC clássica**, sem uso de REST API ou frameworks frontend modernos, pois o foco é:

- simplicidade
- facilidade de manutenção
- baixo acoplamento
- uso interno

### Camadas
- **Controller**: controle de fluxo e rotas
- **Service**: regras de negócio
- **Repository**: acesso a dados via JPA
- **View**: Thymeleaf + Bootstrap

---

## 🔐 Segurança

- Usuário ADMIN configurado via `InMemoryUserDetailsManager`
- Rotas administrativas protegidas no backend
- Botões administrativos visíveis apenas para ADMIN

---

## 🗄️ Banco de Dados

- **Desenvolvimento**: PostgreSQL via Docker
- **Produção**: PostgreSQL instalado diretamente no servidor

As entidades são persistidas automaticamente via JPA.

---

## 🚀 Deploy

A aplicação foi pensada para rodar como:
- **JAR standalone**
- **Servidor Linux (Debian)**
- Gerenciada via **systemd**
- Sem Docker em produção

---

## 📌 Objetivo do projeto

Este projeto foi desenvolvido para atender uma necessidade real de **uso interno**, priorizando:

- rapidez de acesso
- simplicidade para o usuário final
- facilidade de manutenção técnica
- ausência de complexidade desnecessária ou overenginnering

---

## 📄 Licença

Projeto de uso interno.  
Distribuição externa não prevista.
