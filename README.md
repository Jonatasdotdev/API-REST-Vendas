# API REST para Vendas de Produtos Eletrônicos

## 📝 Descrição

API REST desenvolvida para um sistema de vendas de produtos eletrônicos, seguindo os princípios RESTful e arquitetura MVC. A API permite:

- Gerenciamento de produtos (CRUD)
- Registro de vendas
- Consulta de histórico de vendas
- Controle de estoque automático
- Aplicação de descontos progressivos

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database** (para desenvolvimento)
- **MySQL** (para produção - opcional)
- **Lombok** (para redução de boilerplate code)
- **Spring Validation** (para validação de dados)
- **SpringDoc OpenAPI** (para documentação da API)

## 📋 Requisitos

- JDK 17+
- Maven 3.8+
- Insomnia/Postman (para testar os endpoints)
- Opcional: Docker (para containerização)

## 🔌 Endpoints

### Produtos

| Método | Endpoint               | Descrição                              |
|--------|------------------------|----------------------------------------|
| GET    | `/products`            | Lista todos os produtos                |
| GET    | `/products/{id}`       | Obtém detalhes de um produto específico|
| POST   | `/products`            | Cria um novo produto                   |
| PUT    | `/products/{id}`       | Atualiza um produto existente          |
| DELETE | `/products/{id}`       | Remove um produto                      |

### Vendas

| Método | Endpoint               | Descrição                              |
|--------|------------------------|----------------------------------------|
| GET    | `/sales`               | Lista todas as vendas                  |
| POST   | `/sales`               | Registra uma nova venda                |

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/api-vendas-produtos.git
   cd api-vendas-produtos
   ```

2. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

3. Acesse a API em:
   ```
   http://localhost:8080
   ```

4. (Opcional) Acesse o H2 Console:
   ```
   http://localhost:8080/h2-console
   ```
   - JDBC URL: `jdbc:h2:mem:lojaonline`
   - User: `sa`
   - Password: (vazio)


## 📦 Exemplos de Requisições

### Criar Produto
```json
POST /products
{
    "name": "Smartphone XYZ",
    "price": 1999.90,
    "stockQuantity": 50
}
```

### Registrar Venda
```json
POST /sales
{
    "productId": 1,
    "quantity": 3
}
```

## 🧪 Regras de Negócio Implementadas

✔️ Validação de estoque suficiente antes da venda  
✔️ Preço do produto não pode ser negativo  
✔️ Quantidade vendida deve ser positiva  
✔️ Data da venda registrada automaticamente  
✔️ Descontos progressivos:  
   - 5% para compras acima de 10 unidades  
   - 10% para compras acima de 20 unidades  

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/example/apirestvendas/
│   │   ├── config/       # Configurações da aplicação
│   │   ├── controller/   # Controladores REST
│   │   ├── dto/          # Objetos de transferência de dados
│   │   ├── exception/    # Tratamento de exceções
│   │   ├── model/        # Entidades JPA
│   │   ├── repository/   # Repositórios Spring Data
│   │   ├── service/      # Lógica de negócios
│   │   └── util/         # Utilitários e mappers
│   └── resources/
│       ├── application.properties # Configurações
└── test/                  # Testes automatizados
```

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/awesome-feature`)
3. Commit suas mudanças (`git commit -m 'Add some awesome feature'`)
4. Push para a branch (`git push origin feature/awesome-feature`)
5. Abra um Pull Request

